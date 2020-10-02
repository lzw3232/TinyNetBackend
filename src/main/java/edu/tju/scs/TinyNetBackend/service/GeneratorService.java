package edu.tju.scs.TinyNetBackend.service;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.GeneratorMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseObjectData;
import edu.tju.scs.TinyNetBackend.model.po.Battery;
import edu.tju.scs.TinyNetBackend.model.po.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class GeneratorService {

    @Autowired
    protected GeneratorMapper generatorMapper;


    private boolean check(int id,String owner)
    {
        if(generatorMapper.selectByPrimaryKey(id)==null||!owner.equals(generatorMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject generator, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        generator.put("owner",username);
        generator.remove("id");
        Generator generator1 = JSONObject.toJavaObject(generator,Generator.class);

        generatorMapper.insert(generator1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject generator, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Generator generator1 = JSONObject.toJavaObject(generator,Generator.class);
        if(!username.equals(generator1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(generator1.getId(),generator1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        generatorMapper.updateByPrimaryKey(generator1);
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

        Generator generator =generatorMapper.selectByPrimaryKey(id);

        if(generator!=null){
            response.addData("data",generator);
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
        generatorMapper.deleteByPrimaryKey(id);
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
        List<Generator> generatorlist;
        if(val==""){
            generatorlist =generatorMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = generatorMapper.countB();
            response.addData("total",total);
        }
        else{
            generatorlist =generatorMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = generatorMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",generatorlist);

        return new ErrorReport(0,"success",response);

    }

}
