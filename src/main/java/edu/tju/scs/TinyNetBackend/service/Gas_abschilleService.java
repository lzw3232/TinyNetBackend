package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Gas_abschilleMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Gas_abschille;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Slf4j
@Service
public class Gas_abschilleService {

    @Autowired
    protected Gas_abschilleMapper gas_abschilleMapper;

    private boolean check(int id,String owner)
    {
        if(gas_abschilleMapper.selectByPrimaryKey(id)==null||!owner.equals(gas_abschilleMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject gas_abschille, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        gas_abschille.put("owner",username);
        gas_abschille.remove("id");
        Gas_abschille gas_abschille1 = JSONObject.toJavaObject(gas_abschille, Gas_abschille.class);

        gas_abschilleMapper.insert(gas_abschille1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject gas_abschille, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Gas_abschille gas_abschille1 = JSONObject.toJavaObject(gas_abschille,Gas_abschille.class);
        if(!username.equals(gas_abschille1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(gas_abschille1.getId(),gas_abschille1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        gas_abschilleMapper.updateByPrimaryKey(gas_abschille1);
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

        Gas_abschille gas_abschille =gas_abschilleMapper.selectByPrimaryKey(id);

        if(gas_abschille!=null){
            response.addData("data",gas_abschille);
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
        gas_abschilleMapper.deleteByPrimaryKey(id);
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
        List<Gas_abschille> gas_abschillelist;
        if(val==""){
            gas_abschillelist =gas_abschilleMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = gas_abschilleMapper.countB();
            response.addData("total",total);
        }
        else{
            gas_abschillelist =gas_abschilleMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = gas_abschilleMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",gas_abschillelist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
