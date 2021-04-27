package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Nuclear_powerMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Nuclear_power;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Nuclear_powerService {

    @Autowired
    protected Nuclear_powerMapper nuclear_powerMapper;

    private boolean check(int id,String owner)
    {
        if(nuclear_powerMapper.selectByPrimaryKey(id)==null||!owner.equals(nuclear_powerMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject nuclear_power, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        nuclear_power.put("owner",username);
        nuclear_power.remove("id");
        Nuclear_power nuclear_power1 = JSONObject.toJavaObject(nuclear_power, Nuclear_power.class);
        nuclear_powerMapper.insert(nuclear_power1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject nuclear_power, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Nuclear_power nuclear_power1 = JSONObject.toJavaObject(nuclear_power,Nuclear_power.class);
        if(!username.equals(nuclear_power1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(nuclear_power1.getId(),nuclear_power1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        nuclear_powerMapper.updateByPrimaryKey(nuclear_power1);
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

        Nuclear_power nuclear_power =nuclear_powerMapper.selectByPrimaryKey(id);

        if(nuclear_power!=null){
            response.addData("data",nuclear_power);
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
        nuclear_powerMapper.deleteByPrimaryKey(id);
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
        List<Nuclear_power> nuclear_powerlist;
        if(val==""){
            nuclear_powerlist =nuclear_powerMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = nuclear_powerMapper.countB();
            response.addData("total",total);
        }
        else{
            nuclear_powerlist =nuclear_powerMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = nuclear_powerMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",nuclear_powerlist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
