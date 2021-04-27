package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Hydro_turbineMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Hydro_turbine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Hydro_turbineService {

    @Autowired
    protected Hydro_turbineMapper hydro_turbineMapper;

    private boolean check(int id,String owner)
    {
        if(hydro_turbineMapper.selectByPrimaryKey(id)==null||!owner.equals(hydro_turbineMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject hydro_turbine, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        hydro_turbine.put("owner",username);
        hydro_turbine.remove("id");
        Hydro_turbine hydro_turbine1 = JSONObject.toJavaObject(hydro_turbine, Hydro_turbine.class);

        hydro_turbineMapper.insert(hydro_turbine1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject hydro_turbine, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Hydro_turbine hydro_turbine1 = JSONObject.toJavaObject(hydro_turbine,Hydro_turbine.class);
        if(!username.equals(hydro_turbine1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(hydro_turbine1.getId(),hydro_turbine1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        hydro_turbineMapper.updateByPrimaryKey(hydro_turbine1);
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

        Hydro_turbine hydro_turbine =hydro_turbineMapper.selectByPrimaryKey(id);

        if(hydro_turbine!=null){
            response.addData("data",hydro_turbine);
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
        hydro_turbineMapper.deleteByPrimaryKey(id);
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
        List<Hydro_turbine> hydro_turbinelist;
        if(val==""){
            hydro_turbinelist =hydro_turbineMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = hydro_turbineMapper.countB();
            response.addData("total",total);
        }
        else{
            hydro_turbinelist =hydro_turbineMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = hydro_turbineMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",hydro_turbinelist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
