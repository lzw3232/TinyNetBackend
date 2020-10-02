package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Gas_turbineMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Gas_turbine;
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
public class Gas_turbineService {

    @Autowired
    protected Gas_turbineMapper gas_turbineMapper;

    private boolean check(int id,String owner)
    {
        if(gas_turbineMapper.selectByPrimaryKey(id)==null||!owner.equals(gas_turbineMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject gas_turbine, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        gas_turbine.put("owner",username);
        gas_turbine.remove("id");
        Gas_turbine gas_turbine1 = JSONObject.toJavaObject(gas_turbine, Gas_turbine.class);

        gas_turbineMapper.insert(gas_turbine1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject gas_turbine, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Gas_turbine gas_turbine1 = JSONObject.toJavaObject(gas_turbine,Gas_turbine.class);
        if(!username.equals(gas_turbine1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(gas_turbine1.getId(),gas_turbine1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        gas_turbineMapper.updateByPrimaryKey(gas_turbine1);
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

        Gas_turbine gas_turbine =gas_turbineMapper.selectByPrimaryKey(id);

        if(gas_turbine!=null){
            response.addData("data",gas_turbine);
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
        gas_turbineMapper.deleteByPrimaryKey(id);
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
        List<Gas_turbine> gas_turbinelist;
        if(val==""){
            gas_turbinelist =gas_turbineMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = gas_turbineMapper.countB();
            response.addData("total",total);
        }
        else{
            gas_turbinelist =gas_turbineMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = gas_turbineMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",gas_turbinelist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
