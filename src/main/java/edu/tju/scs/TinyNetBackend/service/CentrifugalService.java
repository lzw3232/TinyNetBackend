package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.CentrifugalMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Centrifugal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class CentrifugalService {

    @Autowired
    protected CentrifugalMapper centrifugalMapper;

    private boolean check(int id,String owner)
    {
        if(centrifugalMapper.selectByPrimaryKey(id)==null||!owner.equals(centrifugalMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject centrifugal, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        centrifugal.put("owner",username);
        centrifugal.remove("id");
        Centrifugal centrifugal1 = JSONObject.toJavaObject(centrifugal,Centrifugal.class);

        centrifugalMapper.insert(centrifugal1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject centrifugal, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Centrifugal centrifugal1 = JSONObject.toJavaObject(centrifugal,Centrifugal.class);
        if(!username.equals(centrifugal1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(centrifugal1.getId(),centrifugal1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        centrifugalMapper.updateByPrimaryKey(centrifugal1);
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

        Centrifugal centrifugal =centrifugalMapper.selectByPrimaryKey(id);

        if(centrifugal!=null){
            response.addData("data",centrifugal);
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
        centrifugalMapper.deleteByPrimaryKey(id);
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
        List<Centrifugal> centrifugallist;
        if(val==""){
            centrifugallist =centrifugalMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = centrifugalMapper.countB();
            response.addData("total",total);
        }
        else{
            centrifugallist =centrifugalMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = centrifugalMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",centrifugallist);

        return new ErrorReport(0,"success",response);

    }

}
