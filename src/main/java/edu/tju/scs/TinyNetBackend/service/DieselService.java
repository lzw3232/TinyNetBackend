package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.DieselMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Diesel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class DieselService {

    @Autowired
    protected DieselMapper dieselMapper;

    private boolean check(int id,String owner)
    {
        if(dieselMapper.selectByPrimaryKey(id)==null||!owner.equals(dieselMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject diesel, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        System.out.println(diesel);
        diesel.put("owner",username);
        diesel.remove("id");
        Diesel diesel1 = JSONObject.toJavaObject(diesel,Diesel.class);

        dieselMapper.insert(diesel1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject diesel, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Diesel diesel1 = JSONObject.toJavaObject(diesel,Diesel.class);
        if(!username.equals(diesel1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(diesel1.getId(),diesel1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        dieselMapper.updateByPrimaryKey(diesel1);
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

        Diesel diesel =dieselMapper.selectByPrimaryKey(id);

        if(diesel!=null){
            response.addData("data",diesel);
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
        dieselMapper.deleteByPrimaryKey(id);
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
        List<Diesel> diesellist;
        if(val==""){
            diesellist =dieselMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = dieselMapper.countB();
            response.addData("total",total);
        }
        else{
            diesellist =dieselMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = dieselMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",diesellist);

        return new ErrorReport(0,"success",response);

    }

}
