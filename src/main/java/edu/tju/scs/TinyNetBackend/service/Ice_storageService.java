package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Ice_storageMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Ice_storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Ice_storageService {

    @Autowired
    protected Ice_storageMapper ice_storageMapper;

    private boolean check(int id,String owner)
    {
        if(ice_storageMapper.selectByPrimaryKey(id)==null||!owner.equals(ice_storageMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject ice_storage, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        ice_storage.put("owner",username);
        ice_storage.remove("id");
        Ice_storage ice_storage1 = JSONObject.toJavaObject(ice_storage, Ice_storage.class);

        ice_storageMapper.insert(ice_storage1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject ice_storage, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Ice_storage ice_storage1 = JSONObject.toJavaObject(ice_storage,Ice_storage.class);
        if(!username.equals(ice_storage1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(ice_storage1.getId(),ice_storage1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        ice_storageMapper.updateByPrimaryKey(ice_storage1);
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

        Ice_storage ice_storage =ice_storageMapper.selectByPrimaryKey(id);

        if(ice_storage!=null){
            response.addData("data",ice_storage);
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
        ice_storageMapper.deleteByPrimaryKey(id);
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
        List<Ice_storage> ice_storagelist;
        if(val==""){
            ice_storagelist =ice_storageMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = ice_storageMapper.countB();
            response.addData("total",total);
        }
        else{
            ice_storagelist =ice_storageMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = ice_storageMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",ice_storagelist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
