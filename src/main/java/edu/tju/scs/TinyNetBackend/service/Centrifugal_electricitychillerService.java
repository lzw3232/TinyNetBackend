package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Centrifugal_electricitychillerMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Centrifugal_electricitychiller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Centrifugal_electricitychillerService {

    @Autowired
    protected Centrifugal_electricitychillerMapper centrifugal_electricitychillerMapper;

    private boolean check(int id,String owner)
    {
        if(centrifugal_electricitychillerMapper.selectByPrimaryKey(id)==null||!owner.equals(centrifugal_electricitychillerMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject centrifugal_electricitychiller, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        centrifugal_electricitychiller.put("owner",username);
        centrifugal_electricitychiller.remove("id");
        Centrifugal_electricitychiller centrifugal_electricitychiller1 = JSONObject.toJavaObject(centrifugal_electricitychiller, Centrifugal_electricitychiller.class);

        centrifugal_electricitychillerMapper.insert(centrifugal_electricitychiller1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject centrifugal_electricitychiller, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Centrifugal_electricitychiller centrifugal_electricitychiller1 = JSONObject.toJavaObject(centrifugal_electricitychiller,Centrifugal_electricitychiller.class);
        if(!username.equals(centrifugal_electricitychiller1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(centrifugal_electricitychiller1.getId(),centrifugal_electricitychiller1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        centrifugal_electricitychillerMapper.updateByPrimaryKey(centrifugal_electricitychiller1);
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

        Centrifugal_electricitychiller centrifugal_electricitychiller =centrifugal_electricitychillerMapper.selectByPrimaryKey(id);

        if(centrifugal_electricitychiller!=null){
            response.addData("data",centrifugal_electricitychiller);
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
        centrifugal_electricitychillerMapper.deleteByPrimaryKey(id);
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
        List<Centrifugal_electricitychiller> centrifugal_electricitychillerlist;
        if(val==""){
            centrifugal_electricitychillerlist =centrifugal_electricitychillerMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = centrifugal_electricitychillerMapper.countB();
            response.addData("total",total);
        }
        else{
            centrifugal_electricitychillerlist =centrifugal_electricitychillerMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = centrifugal_electricitychillerMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",centrifugal_electricitychillerlist);

        return new ErrorReport(0,"success",response);

    }

}
