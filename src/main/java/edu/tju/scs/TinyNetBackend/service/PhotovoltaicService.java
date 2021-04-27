package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.PhotovoltaicMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Photovoltaic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class PhotovoltaicService {

    @Autowired
    protected PhotovoltaicMapper photovoltaicMapper;

    private boolean check(int id,String owner)
    {
        if(photovoltaicMapper.selectByPrimaryKey(id)==null||!owner.equals(photovoltaicMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject photovoltaic, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        photovoltaic.put("owner",username);
        photovoltaic.remove("id");
        Photovoltaic photovoltaic1 = JSONObject.toJavaObject(photovoltaic, Photovoltaic.class);

        photovoltaicMapper.insert(photovoltaic1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject photovoltaic, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Photovoltaic photovoltaic1 = JSONObject.toJavaObject(photovoltaic,Photovoltaic.class);
        if(!username.equals(photovoltaic1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(photovoltaic1.getId(),photovoltaic1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        photovoltaicMapper.updateByPrimaryKey(photovoltaic1);
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

        Photovoltaic photovoltaic =photovoltaicMapper.selectByPrimaryKey(id);

        if(photovoltaic!=null){
            response.addData("data",photovoltaic);
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
        photovoltaicMapper.deleteByPrimaryKey(id);
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
        List<Photovoltaic> photovoltaiclist;
        if(val==""){
            photovoltaiclist =photovoltaicMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = photovoltaicMapper.countB();
            response.addData("total",total);
        }
        else{
            photovoltaiclist =photovoltaicMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = photovoltaicMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",photovoltaiclist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
