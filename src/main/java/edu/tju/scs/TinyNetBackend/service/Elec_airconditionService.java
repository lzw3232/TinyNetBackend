package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Elec_airconditionMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Elec_aircondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Elec_airconditionService {

    @Autowired
    protected Elec_airconditionMapper elec_airconditionMapper;

    private boolean check(int id,String owner)
    {
        if(elec_airconditionMapper.selectByPrimaryKey(id)==null||!owner.equals(elec_airconditionMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject elec_aircondition, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        elec_aircondition.put("owner",username);
        elec_aircondition.remove("id");
        Elec_aircondition elec_aircondition1 = JSONObject.toJavaObject(elec_aircondition, Elec_aircondition.class);

        elec_airconditionMapper.insert(elec_aircondition1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject elec_aircondition, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Elec_aircondition elec_aircondition1 = JSONObject.toJavaObject(elec_aircondition,Elec_aircondition.class);
        if(!username.equals(elec_aircondition1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(elec_aircondition1.getId(),elec_aircondition1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        elec_airconditionMapper.updateByPrimaryKey(elec_aircondition1);
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

        Elec_aircondition elec_aircondition =elec_airconditionMapper.selectByPrimaryKey(id);

        if(elec_aircondition!=null){
            response.addData("data",elec_aircondition);
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
        elec_airconditionMapper.deleteByPrimaryKey(id);
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
        List<Elec_aircondition> elec_airconditionlist;
        if(val==""){
            elec_airconditionlist =elec_airconditionMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = elec_airconditionMapper.countB();
            response.addData("total",total);
        }
        else{
            elec_airconditionlist =elec_airconditionMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = elec_airconditionMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",elec_airconditionlist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
