package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.ScrollMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Scroll;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class ScrollService {

    @Autowired
    protected ScrollMapper scrollMapper;

    private boolean check(int id,String owner)
    {
        if(scrollMapper.selectByPrimaryKey(id)==null||!owner.equals(scrollMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject scroll, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        scroll.put("owner",username);
        scroll.remove("id");
        Scroll scroll1 = JSONObject.toJavaObject(scroll,Scroll.class);

        scrollMapper.insert(scroll1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject scroll, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Scroll scroll1 = JSONObject.toJavaObject(scroll,Scroll.class);
        if(!username.equals(scroll1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(scroll1.getId(),scroll1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        scrollMapper.updateByPrimaryKey(scroll1);
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

        Scroll scroll =scrollMapper.selectByPrimaryKey(id);

        if(scroll!=null){
            response.addData("data",scroll);
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
        scrollMapper.deleteByPrimaryKey(id);
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
        List<Scroll> scrolllist;
        if(val==""){
            scrolllist =scrollMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = scrollMapper.countB();
            response.addData("total",total);
        }
        else{
            scrolllist =scrollMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = scrollMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",scrolllist);

        return new ErrorReport(0,"success",response);

    }

}
