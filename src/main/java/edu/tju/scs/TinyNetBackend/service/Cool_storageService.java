package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Cool_storageMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Cool_storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Cool_storageService {

    @Autowired
    protected Cool_storageMapper cool_storageMapper;

    private boolean check(int id,String owner)
    {
        if(cool_storageMapper.selectByPrimaryKey(id)==null||!owner.equals(cool_storageMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject cool_storage, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        cool_storage.put("owner",username);
        cool_storage.remove("id");
        Cool_storage cool_storage1 = JSONObject.toJavaObject(cool_storage, Cool_storage.class);

        cool_storageMapper.insert(cool_storage1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject cool_storage, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Cool_storage cool_storage1 = JSONObject.toJavaObject(cool_storage,Cool_storage.class);
        if(!username.equals(cool_storage1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(cool_storage1.getId(),cool_storage1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        cool_storageMapper.updateByPrimaryKey(cool_storage1);
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

        Cool_storage cool_storage =cool_storageMapper.selectByPrimaryKey(id);

        if(cool_storage!=null){
            response.addData("data",cool_storage);
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
        cool_storageMapper.deleteByPrimaryKey(id);
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
        List<Cool_storage> cool_storagelist;
        if(val==""){
            cool_storagelist =cool_storageMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = cool_storageMapper.countB();
            response.addData("total",total);
        }
        else{
            cool_storagelist =cool_storageMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = cool_storageMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",cool_storagelist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
