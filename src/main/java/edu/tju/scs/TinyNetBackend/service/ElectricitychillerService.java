package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.ElectricitychillerMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Electricitychiller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class ElectricitychillerService {

    @Autowired
    protected ElectricitychillerMapper electricitychillerMapper;

    private boolean check(int id,String owner)
    {
        if(electricitychillerMapper.selectByPrimaryKey(id)==null||!owner.equals(electricitychillerMapper.selectByPrimaryKey(id).getOwner()))
            return false;        return true;
    }


    public ErrorReport add(JSONObject electricitychiller, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        electricitychiller.put("owner",username);
        electricitychiller.remove("id");
        Electricitychiller electricitychiller1 = JSONObject.toJavaObject(electricitychiller, Electricitychiller.class);

        electricitychillerMapper.insert(electricitychiller1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject electricitychiller, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Electricitychiller electricitychiller1 = JSONObject.toJavaObject(electricitychiller,Electricitychiller.class);
        if(!username.equals(electricitychiller1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(electricitychiller1.getId(),electricitychiller1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        electricitychillerMapper.updateByPrimaryKey(electricitychiller1);
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

        Electricitychiller electricitychiller =electricitychillerMapper.selectByPrimaryKey(id);

        if(electricitychiller!=null){
            response.addData("data",electricitychiller);
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
        electricitychillerMapper.deleteByPrimaryKey(id);
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
        List<Electricitychiller> electricitychillerlist;
        if(val==""){
            electricitychillerlist =electricitychillerMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = electricitychillerMapper.countB();
            response.addData("total",total);
        }
        else{
            electricitychillerlist =electricitychillerMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = electricitychillerMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",electricitychillerlist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
