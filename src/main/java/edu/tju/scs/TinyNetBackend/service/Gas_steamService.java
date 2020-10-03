package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Gas_steamMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Gas_steam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Gas_steamService {

    @Autowired
    protected Gas_steamMapper gas_steamMapper;

    private boolean check(int id,String owner)
    {
        if(gas_steamMapper.selectByPrimaryKey(id)==null||!owner.equals(gas_steamMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject gas_steam, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        gas_steam.put("owner",username);
        gas_steam.remove("id");
        Gas_steam gas_steam1 = JSONObject.toJavaObject(gas_steam, Gas_steam.class);

        gas_steamMapper.insert(gas_steam1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject gas_steam, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Gas_steam gas_steam1 = JSONObject.toJavaObject(gas_steam,Gas_steam.class);
        if(!username.equals(gas_steam1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(gas_steam1.getId(),gas_steam1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        gas_steamMapper.updateByPrimaryKey(gas_steam1);
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

        Gas_steam gas_steam =gas_steamMapper.selectByPrimaryKey(id);

        if(gas_steam!=null){
            response.addData("data",gas_steam);
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
        gas_steamMapper.deleteByPrimaryKey(id);
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
        List<Gas_steam> gas_steamlist;
        if(val==""){
            gas_steamlist =gas_steamMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = gas_steamMapper.countB();
            response.addData("total",total);
        }
        else{
            gas_steamlist =gas_steamMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = gas_steamMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",gas_steamlist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
