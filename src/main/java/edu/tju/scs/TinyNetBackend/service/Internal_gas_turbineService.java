package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Internal_gas_turbineMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Internal_gas_turbine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class Internal_gas_turbineService {

    @Autowired
    protected Internal_gas_turbineMapper internal_gas_turbineMapper;

    private boolean check(int id,String owner)
    {
        if(internal_gas_turbineMapper.selectByPrimaryKey(id)==null||!owner.equals(internal_gas_turbineMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject internal_gas_turbine, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        internal_gas_turbine.put("owner",username);
        internal_gas_turbine.remove("id");
        Internal_gas_turbine internal_gas_turbine1 = JSONObject.toJavaObject(internal_gas_turbine,Internal_gas_turbine.class);

        internal_gas_turbineMapper.insert(internal_gas_turbine1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject internal_gas_turbine, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Internal_gas_turbine internal_gas_turbine1 = JSONObject.toJavaObject(internal_gas_turbine,Internal_gas_turbine.class);
        if(!username.equals(internal_gas_turbine1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(internal_gas_turbine1.getId(),internal_gas_turbine1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        internal_gas_turbineMapper.updateByPrimaryKey(internal_gas_turbine1);
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

        Internal_gas_turbine internal_gas_turbine =internal_gas_turbineMapper.selectByPrimaryKey(id);

        if(internal_gas_turbine!=null){
            response.addData("data",internal_gas_turbine);
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
        internal_gas_turbineMapper.deleteByPrimaryKey(id);
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
        List<Internal_gas_turbine> internal_gas_turbinelist;
        if(val==""){
            internal_gas_turbinelist =internal_gas_turbineMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = internal_gas_turbineMapper.countB();
            response.addData("total",total);
        }
        else{
            internal_gas_turbinelist =internal_gas_turbineMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = internal_gas_turbineMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",internal_gas_turbinelist);

        return new ErrorReport(0,"success",response);

    }
}
