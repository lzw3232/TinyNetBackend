package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Lithium_bromideMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Lithium_bromide;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 22:36 18/12/12.
 */
@Slf4j
@Service
public class Lithium_bromideService {

    @Autowired
    protected Lithium_bromideMapper lithium_bromideMapper;

    private boolean check(int id,String owner)
    {
        if(lithium_bromideMapper.selectByPrimaryKey(id)==null||!owner.equals(lithium_bromideMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject lithium_bromide, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        lithium_bromide.put("owner",username);
        lithium_bromide.remove("id");
        Lithium_bromide lithium_bromide1 = JSONObject.toJavaObject(lithium_bromide, Lithium_bromide.class);

        lithium_bromideMapper.insert(lithium_bromide1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject lithium_bromide, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Lithium_bromide lithium_bromide1 = JSONObject.toJavaObject(lithium_bromide,Lithium_bromide.class);
        if(!username.equals(lithium_bromide1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(lithium_bromide1.getId(),lithium_bromide1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        lithium_bromideMapper.updateByPrimaryKey(lithium_bromide1);
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

        Lithium_bromide lithium_bromide =lithium_bromideMapper.selectByPrimaryKey(id);

        if(lithium_bromide!=null){
            response.addData("data",lithium_bromide);
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
        lithium_bromideMapper.deleteByPrimaryKey(id);
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
        List<Lithium_bromide> lithium_bromidelist;
        if(val==""){
            lithium_bromidelist =lithium_bromideMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = lithium_bromideMapper.countB();
            response.addData("total",total);
        }
        else{
            lithium_bromidelist =lithium_bromideMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = lithium_bromideMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",lithium_bromidelist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
