package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.NuclearMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Nuclear;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 22:36 18/12/12.
 */
@Slf4j
@Service
public class NuclearService {

    @Autowired
    protected NuclearMapper nuclearMapper;

    private boolean check(int id,String owner)
    {
        if(nuclearMapper.selectByPrimaryKey(id)==null||!owner.equals(nuclearMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject nuclear, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        nuclear.put("owner",username);
        nuclear.remove("id");
        Nuclear nuclear1 = JSONObject.toJavaObject(nuclear, Nuclear.class);

        nuclearMapper.insert(nuclear1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject nuclear, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Nuclear nuclear1 = JSONObject.toJavaObject(nuclear,Nuclear.class);
        if(!username.equals(nuclear1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(nuclear1.getId(),nuclear1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        nuclearMapper.updateByPrimaryKey(nuclear1);
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

        Nuclear nuclear =nuclearMapper.selectByPrimaryKey(id);

        if(nuclear!=null){
            response.addData("data",nuclear);
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
        nuclearMapper.deleteByPrimaryKey(id);
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
        List<Nuclear> nuclearlist;
        if(val==""){
            nuclearlist =nuclearMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = nuclearMapper.countB();
            response.addData("total",total);
        }
        else{
            nuclearlist =nuclearMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = nuclearMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",nuclearlist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
