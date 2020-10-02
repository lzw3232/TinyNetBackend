package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Plate_heatMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Plate_heat;
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
public class Plate_heatService {

    @Autowired
    protected Plate_heatMapper plate_heatMapper;

    private boolean check(int id,String owner)
    {
        if(plate_heatMapper.selectByPrimaryKey(id)==null||!owner.equals(plate_heatMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject plate_heat, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        plate_heat.put("owner",username);
        plate_heat.remove("id");
        Plate_heat plate_heat1 = JSONObject.toJavaObject(plate_heat, Plate_heat.class);

        plate_heatMapper.insert(plate_heat1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject plate_heat, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Plate_heat plate_heat1 = JSONObject.toJavaObject(plate_heat,Plate_heat.class);
        if(!username.equals(plate_heat1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(plate_heat1.getId(),plate_heat1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        plate_heatMapper.updateByPrimaryKey(plate_heat1);
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

        Plate_heat plate_heat =plate_heatMapper.selectByPrimaryKey(id);

        if(plate_heat!=null){
            response.addData("data",plate_heat);
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
        plate_heatMapper.deleteByPrimaryKey(id);
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
        List<Plate_heat> plate_heatlist;
        if(val==""){
            plate_heatlist =plate_heatMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = plate_heatMapper.countB();
            response.addData("total",total);
        }
        else{
            plate_heatlist =plate_heatMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = plate_heatMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",plate_heatlist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
