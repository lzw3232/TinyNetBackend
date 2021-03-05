package edu.tju.scs.TinyNetBackend.controller;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RecordController {

    @Autowired
    protected RecordService recordService;

    @RequestMapping(value = "/tinyNet/record/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody(required=false) JSONObject data)
    {
        return recordService.add(data.getString("token"),data.getJSONObject("record"));
    }

    @RequestMapping(value = "/tinyNet/record/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody(required=false) JSONObject data)
    {
        return recordService.update(data.getString("token"),data.getJSONObject("record"));
    }

    @RequestMapping(value = "/tinyNet/record/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(@RequestBody(required=false) JSONObject data)
    {
        return recordService.delete(data.getString("token"),data.getInteger("id"));
    }

    @RequestMapping(value = "/tinyNet/record/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(@RequestBody(required=false) JSONObject data)
    {
        return recordService.select(data.getString("token"),data.getInteger("id"));
    }

    @RequestMapping(value = "/tinyNet/record/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(@RequestBody(required=false) JSONObject data)
    {
        return recordService.list(data.getString("token"),data.getInteger("pi"),data.getInteger("ps"),data.getString("val"));
    }

    @ResponseBody
    @RequestMapping(value = "/tinyNet/record/action",method = RequestMethod.POST)
    public ErrorReport action(@RequestBody(required=false) JSONObject data)
    {
        return recordService.action(data.getString("token"),data.getJSONObject("data"));

    }

    @ResponseBody
    @RequestMapping(value = "/tinyNet/record/getRes",method = RequestMethod.POST)
    public ErrorReport getRes(@RequestBody(required=false) JSONObject data)
    {
        return recordService.getRes(data.getString("token"),data.getInteger("id"));

    }

    @ResponseBody
    @RequestMapping(value = "/tinyNet/record/getOutput",method = RequestMethod.POST)
    public ErrorReport getOutput(@RequestBody(required=false) JSONObject data)
    {
        return recordService.getOutput(data.getString("token"),data.getInteger("id"));

    }





}
