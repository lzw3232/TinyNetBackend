package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Residual_heatMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Residual_heat;
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
public class Residual_heatService {

    @Autowired
    protected Residual_heatMapper residual_heatMapper;

    private boolean check(int id,String owner)
    {
        if(residual_heatMapper.selectByPrimaryKey(id)==null||!owner.equals(residual_heatMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject residual_heat, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        residual_heat.put("owner",username);
        residual_heat.remove("id");
        Residual_heat residual_heat1 = JSONObject.toJavaObject(residual_heat, Residual_heat.class);

        residual_heatMapper.insert(residual_heat1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject residual_heat, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Residual_heat residual_heat1 = JSONObject.toJavaObject(residual_heat,Residual_heat.class);
        if(!username.equals(residual_heat1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(residual_heat1.getId(),residual_heat1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        residual_heatMapper.updateByPrimaryKey(residual_heat1);
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

        Residual_heat residual_heat =residual_heatMapper.selectByPrimaryKey(id);

        if(residual_heat!=null){
            response.addData("data",residual_heat);
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
        residual_heatMapper.deleteByPrimaryKey(id);
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
        List<Residual_heat> residual_heatlist;
        if(val==""){
            residual_heatlist =residual_heatMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = residual_heatMapper.countB();
            response.addData("total",total);
        }
        else{
            residual_heatlist =residual_heatMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = residual_heatMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",residual_heatlist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
