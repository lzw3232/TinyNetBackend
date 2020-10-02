package edu.tju.scs.TinyNetBackend.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.FileHelper;
import edu.tju.scs.TinyNetBackend.common.RecordList;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.RecordMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseObjectData;
import edu.tju.scs.TinyNetBackend.model.po.RecordWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    private boolean check(String name,String owner)
    {
        RecordWithBLOBs record = recordMapper.selectByPrimaryKey(name);
        if(record==null||!owner.equals(record.getOwner()))
            return false;
        return true;
    }

    public ErrorReport add(HttpServletRequest request, String recordname, String input)
    {
        input = FileHelper.getInput(input);
        RecordWithBLOBs record = new RecordWithBLOBs();
        record.setName(recordname);
        record.setState(0);
        record.setInput(input);
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        record.setOwner(username);
        record.setOutput(null);
        recordMapper.insert(record);
        return new ErrorReport(0,"success");
    }

    public ErrorReport update(HttpServletRequest request,String recordname,String input)
    {

        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        RecordWithBLOBs record = new RecordWithBLOBs();
        record.setName(recordname);
        record.setState(0);
        record.setInput(input);
        record.setOutput(null);
        if(!username.equals(record.getOwner()))
            return new ErrorReport(31,"id no exist");
        if(!check(record.getName(),record.getOwner()))
            return new ErrorReport(31,"id no exist");
        recordMapper.updateByPrimaryKey(record);
        return new ErrorReport(0,"success");
    }

    public ErrorReport delete(HttpServletRequest request,String recordname)
    {

        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(recordname,username))
            return new ErrorReport(31,"id no exist");
        recordMapper.deleteByPrimaryKey(recordname);
        return new ErrorReport(0,"success");
    }


    public ErrorReport select(HttpServletRequest request,String recordname)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        if(!check(recordname,username))
            return new ErrorReport(31,"id no exist");
        RecordList.update();
        RecordWithBLOBs record=recordMapper.selectByPrimaryKey(recordname);
        if(record!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(record));
        else
            return new ErrorReport(11,"id not found");

    }

    public ErrorReport list(String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);

        List<RecordWithBLOBs> recordlist=recordMapper.selectByOwner(username);
        response.addData("data",recordlist);

        return new ErrorReport(0,"success",response);
    }



    public ErrorReport action(String token,String recordname)//HttpServletRequest request,
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        RecordWithBLOBs record=recordMapper.selectByPrimaryKey(recordname);
        if(RecordList.check(record)){
            Thread thread = new Thread(){
                public void run() {
                    RecordList.add(record);
                }};
            thread.start();
            // 获取子线程的返回值：主线程等待法
            while (!RecordList.check(record)){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                }
            }
            return new ErrorReport(0,"success",response);
        }
        else{
            return new ErrorReport(1,"This project is Running",response);
        }


//        if(!username.equals(record.getOwner()))
//            return  new ErrorReport(31,"id no exist");
//        if(RecordList.check(record))
//        {
//            if(RecordList.checkNum())
//            {
//                RecordList.add(record);
//                record.setState(1);
//                recordMapper.updateByPrimaryKey(record);
//                return new ErrorReport(0,"success");
//            }
//
//            else
//                return new ErrorReport(22,"Quantitative restriction");
//        }
//        else
//            return new ErrorReport(21,"another record for this user already running");

    }

    public ErrorReport getRes(String token,String recordname)//HttpServletRequest request,
    {
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        RecordWithBLOBs record=recordMapper.selectByPrimaryKey(recordname);
        JSONObject res = RecordList.getRes(record);
        response.addData("data",res.getString("data"));
        return new ErrorReport(Integer.parseInt(res.getString("errno")),res.getString("errmsg"),response);

    }

    public ErrorReport getOutput(String token,String recordname)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);

        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        if(!check(recordname,username)){
            return new ErrorReport(31,"id no exist",response);
        }
        RecordWithBLOBs record=recordMapper.selectByPrimaryKey(recordname);
        if(record.getOutput().length()<=10){
            String output = RecordList.getOutput(record);
            if(output.length()>=10){
                record.setOutput(output);
                recordMapper.updateByPrimaryKeyWithBLOBs(record);
                response.addData("output", JSON.parseObject(output));
            }
        }
        else{
            response.addData("output",JSON.parseObject(record.getOutput()));
        }
        return new ErrorReport(0,"success",response);
    }
}
