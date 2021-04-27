package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Screw_electricitychillerMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Screw_electricitychiller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Screw_electricitychillerService {

    @Autowired
    protected Screw_electricitychillerMapper screw_electricitychillerMapper;

    private boolean check(int id,String owner)
    {
        if(screw_electricitychillerMapper.selectByPrimaryKey(id)==null||!owner.equals(screw_electricitychillerMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject screw_electricitychiller, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        screw_electricitychiller.put("owner",username);
        screw_electricitychiller.remove("id");
        Screw_electricitychiller screw_electricitychiller1 = JSONObject.toJavaObject(screw_electricitychiller,Screw_electricitychiller.class);

        screw_electricitychillerMapper.insert(screw_electricitychiller1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject screw_electricitychiller, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Screw_electricitychiller screw_electricitychiller1 = JSONObject.toJavaObject(screw_electricitychiller,Screw_electricitychiller.class);
        if(!username.equals(screw_electricitychiller1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(screw_electricitychiller1.getId(),screw_electricitychiller1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        screw_electricitychillerMapper.updateByPrimaryKey(screw_electricitychiller1);
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

        Screw_electricitychiller screw_electricitychiller =screw_electricitychillerMapper.selectByPrimaryKey(id);

        if(screw_electricitychiller!=null){
            response.addData("data",screw_electricitychiller);
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
        screw_electricitychillerMapper.deleteByPrimaryKey(id);
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
        List<Screw_electricitychiller> screw_electricitychillerlist;
        if(val==""){
            screw_electricitychillerlist =screw_electricitychillerMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = screw_electricitychillerMapper.countB();
            response.addData("total",total);
        }
        else{
            screw_electricitychillerlist =screw_electricitychillerMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = screw_electricitychillerMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",screw_electricitychillerlist);

        return new ErrorReport(0,"success",response);

    }

}
