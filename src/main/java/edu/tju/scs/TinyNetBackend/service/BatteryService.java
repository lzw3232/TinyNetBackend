package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.BatteryMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseObjectData;
import edu.tju.scs.TinyNetBackend.model.po.Battery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 22:36 18/12/12.
 */
@Slf4j
@Service
public class BatteryService {

    @Autowired
    protected BatteryMapper batteryMapper;

    private boolean check(int id,String owner)
    {
        if(batteryMapper.selectByPrimaryKey(id)==null||!owner.equals(batteryMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject battery, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        battery.put("owner",username);
        battery.remove("id");
        Battery battery1 = JSONObject.toJavaObject(battery,Battery.class);

        batteryMapper.insert(battery1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject battery, String token)
    {
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Battery battery1 = JSONObject.toJavaObject(battery,Battery.class);
        System.out.println(battery1);
        if(!username.equals(battery1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(battery1.getId(),battery1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        batteryMapper.updateByPrimaryKey(battery1);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport select(String token,int id)
    {
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);

        ResponseData response =new ResponseData();
        response.addData("token",new_token);

        if(!check(id,username)){
            return new ErrorReport(31,"id no exist",response);
        }

        Battery battery =batteryMapper.selectByPrimaryKey(id);

        if(battery!=null){
            response.addData("data",battery);
            return new ErrorReport(0,"success",response);
        }
        else{
            return new ErrorReport(11,"id not found",response);
        }
    }

    public ErrorReport delete(String token,int id)
    {
        System.out.println("delete");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);

        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        if(!check(id,username)){
            return new ErrorReport(31,"id no exist",response);
        }
        batteryMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport list(String token,int pi, int ps,String val)
    {
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        List<Battery> batterylist;
        if(val==""){
            batterylist =batteryMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = batteryMapper.countB();
            response.addData("total",total);
        }
        else{
            batterylist =batteryMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = batteryMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",batterylist);

        return new ErrorReport(0,"success",response);

    }
}
