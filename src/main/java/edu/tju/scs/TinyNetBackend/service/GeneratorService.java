package edu.tju.scs.TinyNetBackend.service;


import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.GeneratorMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseObjectData;
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
        Generator generator = generatorMapper.selectByPrimaryKey(id);
        if(generator==null||!owner.equals(generator.getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(HttpServletRequest request, Generator generator)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);
        generator.setOwner(username);

        generatorMapper.insert(generator);

        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(HttpServletRequest request,Generator generator)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);
        if(!username.equals(generator.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(generator.getId(),generator.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        generatorMapper.updateByPrimaryKey(generator);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport select(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist",response);
        Generator generator =generatorMapper.selectByPrimaryKey(id);
        if(generator!=null) {
            response.addData("generator",generator);
            return new ErrorReport(0, "success", response);
        }
        else
            return new ErrorReport(11,"id not found",response);
    }

    public ErrorReport delete(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist",response);
        generatorMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport list(HttpServletRequest request)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);

        List<Generator> generatorlist =generatorMapper.selectByOwner(username);
        response.addData("generatorlist",generatorlist);
        return new ErrorReport(0,"success",response);

    }

}
