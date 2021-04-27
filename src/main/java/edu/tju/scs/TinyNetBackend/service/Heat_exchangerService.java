package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Heat_exchangerMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Heat_exchanger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Heat_exchangerService {

    @Autowired
    protected Heat_exchangerMapper heat_exchangerMapper;

    private boolean check(int id,String owner)
    {
        if(heat_exchangerMapper.selectByPrimaryKey(id)==null||!owner.equals(heat_exchangerMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject heat_exchanger, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        heat_exchanger.put("owner",username);
        heat_exchanger.remove("id");
        Heat_exchanger heat_exchanger1 = JSONObject.toJavaObject(heat_exchanger,Heat_exchanger.class);

        heat_exchangerMapper.insert(heat_exchanger1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject heat_exchanger, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Heat_exchanger heat_exchanger1 = JSONObject.toJavaObject(heat_exchanger,Heat_exchanger.class);
        if(!username.equals(heat_exchanger1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(heat_exchanger1.getId(),heat_exchanger1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        heat_exchangerMapper.updateByPrimaryKey(heat_exchanger1);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport select(String token,int id)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);

        ResponseData response =new ResponseData();
        response.addData("token",new_token);

        if(!check(id,username)){
            return new ErrorReport(31,"id no exist",response);
        }

        Heat_exchanger heat_exchanger =heat_exchangerMapper.selectByPrimaryKey(id);

        if(heat_exchanger!=null){
            response.addData("data",heat_exchanger);
            return new ErrorReport(0,"success",response);
        }
        else{
            return new ErrorReport(11,"id not found",response);
        }
    }

    public ErrorReport delete(String token,int id)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        System.out.println("delete");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);

        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        if(!check(id,username)){
            return new ErrorReport(31,"id no exist",response);
        }
        heat_exchangerMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport list(String token,int pi, int ps,String val)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        List<Heat_exchanger> heat_exchangerlist;
        if(val==""){
            heat_exchangerlist = heat_exchangerMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = heat_exchangerMapper.countB();
            response.addData("total",total);
        }
        else{
            heat_exchangerlist = heat_exchangerMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = heat_exchangerMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",heat_exchangerlist);

        return new ErrorReport(0,"success",response);

    }

}
