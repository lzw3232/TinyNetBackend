package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.AbschilleMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Abschille;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class AbschilleService {

    @Autowired
    protected AbschilleMapper abschilleMapper;

    private boolean check(int id,String owner)
    {
        if(abschilleMapper.selectByPrimaryKey(id)==null||!owner.equals(abschilleMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject abschille, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        abschille.put("owner",username);
        abschille.remove("id");
        Abschille abschille1 = JSONObject.toJavaObject(abschille, Abschille.class);

        abschilleMapper.insert(abschille1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject abschille, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Abschille abschille1 = JSONObject.toJavaObject(abschille,Abschille.class);
        if(!username.equals(abschille1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(abschille1.getId(),abschille1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        abschilleMapper.updateByPrimaryKey(abschille1);
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

        Abschille abschille =abschilleMapper.selectByPrimaryKey(id);

        if(abschille!=null){
            response.addData("data",abschille);
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
        abschilleMapper.deleteByPrimaryKey(id);
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
        List<Abschille> abschillelist;
        if(val==""){
            abschillelist =abschilleMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = abschilleMapper.countB();
            response.addData("total",total);
        }
        else{
            abschillelist =abschilleMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = abschilleMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",abschillelist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
