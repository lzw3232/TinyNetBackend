package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Direct_fired_lithium_bromideMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Direct_fired_lithium_bromide;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Direct_fired_lithium_bromideService {

    @Autowired
    protected Direct_fired_lithium_bromideMapper direct_fired_lithium_bromideMapper;

    private boolean check(int id,String owner)
    {
        if(direct_fired_lithium_bromideMapper.selectByPrimaryKey(id)==null||!owner.equals(direct_fired_lithium_bromideMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject direct_fired_lithium_bromide, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        direct_fired_lithium_bromide.put("owner",username);
        direct_fired_lithium_bromide.remove("id");
        Direct_fired_lithium_bromide direct_fired_lithium_bromide1 = JSONObject.toJavaObject(direct_fired_lithium_bromide, Direct_fired_lithium_bromide.class);

        direct_fired_lithium_bromideMapper.insert(direct_fired_lithium_bromide1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject direct_fired_lithium_bromide, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Direct_fired_lithium_bromide direct_fired_lithium_bromide1 = JSONObject.toJavaObject(direct_fired_lithium_bromide,Direct_fired_lithium_bromide.class);
        if(!username.equals(direct_fired_lithium_bromide1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(direct_fired_lithium_bromide1.getId(),direct_fired_lithium_bromide1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        direct_fired_lithium_bromideMapper.updateByPrimaryKey(direct_fired_lithium_bromide1);
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

        Direct_fired_lithium_bromide direct_fired_lithium_bromide =direct_fired_lithium_bromideMapper.selectByPrimaryKey(id);

        if(direct_fired_lithium_bromide!=null){
            response.addData("data",direct_fired_lithium_bromide);
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
        direct_fired_lithium_bromideMapper.deleteByPrimaryKey(id);
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
        List<Direct_fired_lithium_bromide> direct_fired_lithium_bromidelist;
        if(val==""){
            direct_fired_lithium_bromidelist =direct_fired_lithium_bromideMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = direct_fired_lithium_bromideMapper.countB();
            response.addData("total",total);
        }
        else{
            direct_fired_lithium_bromidelist =direct_fired_lithium_bromideMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = direct_fired_lithium_bromideMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",direct_fired_lithium_bromidelist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
