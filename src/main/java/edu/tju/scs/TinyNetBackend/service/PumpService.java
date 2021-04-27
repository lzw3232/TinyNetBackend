package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.PumpMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Pump;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class PumpService {

    @Autowired
    protected PumpMapper pumpMapper;

    private boolean check(int id,String owner)
    {
        if(pumpMapper.selectByPrimaryKey(id)==null||!owner.equals(pumpMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject pump, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        pump.put("owner",username);
        pump.remove("id");
        Pump pump1 = JSONObject.toJavaObject(pump,Pump.class);

        pumpMapper.insert(pump1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject pump, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Pump pump1 = JSONObject.toJavaObject(pump,Pump.class);
        if(!username.equals(pump1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(pump1.getId(),pump1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        pumpMapper.updateByPrimaryKey(pump1);
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

        Pump pump =pumpMapper.selectByPrimaryKey(id);

        if(pump!=null){
            response.addData("data",pump);
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
        pumpMapper.deleteByPrimaryKey(id);
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
        List<Pump> pumplist;
        if(val==""){
            pumplist =pumpMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = pumpMapper.countB();
            response.addData("total",total);
        }
        else{
            pumplist =pumpMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = pumpMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",pumplist);

        return new ErrorReport(0,"success",response);

    }

}
