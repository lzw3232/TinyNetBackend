package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Heat_storageMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Heat_storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Heat_storageService {

    @Autowired
    protected Heat_storageMapper heat_storageMapper;

    private boolean check(int id,String owner)
    {
        if(heat_storageMapper.selectByPrimaryKey(id)==null||!owner.equals(heat_storageMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject heat_storage, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        heat_storage.put("owner",username);
        heat_storage.remove("id");
        Heat_storage heat_storage1 = JSONObject.toJavaObject(heat_storage, Heat_storage.class);

        heat_storageMapper.insert(heat_storage1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject heat_storage, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Heat_storage heat_storage1 = JSONObject.toJavaObject(heat_storage,Heat_storage.class);
        if(!username.equals(heat_storage1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(heat_storage1.getId(),heat_storage1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        heat_storageMapper.updateByPrimaryKey(heat_storage1);
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

        Heat_storage heat_storage =heat_storageMapper.selectByPrimaryKey(id);

        if(heat_storage!=null){
            response.addData("data",heat_storage);
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
        heat_storageMapper.deleteByPrimaryKey(id);
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
        List<Heat_storage> heat_storagelist;
        if(val==""){
            heat_storagelist =heat_storageMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = heat_storageMapper.countB();
            response.addData("total",total);
        }
        else{
            heat_storagelist =heat_storageMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = heat_storageMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",heat_storagelist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
