package edu.tju.scs.TinyNetBackend.common;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.RecordWithBLOBs;
import edu.tju.scs.TinyNetBackend.service.RecordService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecordList {

    private static List<RecordInfo>  list = new ArrayList<RecordInfo>();

    public static RecordInfo getinfo(RecordWithBLOBs record)
    {
        String owner=record.getOwner();
        String name=record.getName();
        for (RecordInfo i:list)
        {
            if(i.getOwner().equals(owner)&&i.getName().equals(name))
                return i;
        }
        return null;
    }


    public static boolean check(RecordWithBLOBs record)
    {
        String name=record.getOwner();
        if(getsize()==0){
            return true;
        }
        for (RecordInfo i:list)
        {
            if(i.getOwner().equals(name))
                return false;
        }
        return true;
    }
    public static boolean checkNum()
    {
        update();
        if(list.size()<5)
            return true;
        else
            return false;
    }

    public static int getsize()
    {
        return list.size();
    }


    public static void update()
    {
        for (RecordInfo i:list)
        {
            Process p=i.getProcess();
            if(FileHelper.checkFinish(i.getOwner(),i.getName()))
            {
                list.remove(i);

//                RecordService.addOutput(i.getName(),FileHelper.getOurput(i.getOwner(),i.getName()));
            }

        }
    }


    public static void main(String[] args) {
        RecordWithBLOBs record = new RecordWithBLOBs();
        record.setName("lzw");
        record.setOwner("lzw");
        Thread p = new Thread(){
            public void run(){
                add(record);
            }
        };
        p.start();
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            System.exit(0);//退出程序
        }
        System.out.println("成功了");

//        RecordInfo recordInfo = getinfo(record);
//        recordInfo.getProcess().destroy();
    }

    public static void add(RecordWithBLOBs record)
    {
        FileHelper.newRecord(record);
        FileHelper.setIO(record);
        RecordInfo recordInfo=new RecordInfo(record.getName(),record.getOwner());
        recordInfo.setRuntime(Runtime.getRuntime());


        try {
            recordInfo.setProcess(recordInfo.getRuntime().exec(FileHelper.getExe(record.getOwner(),record.getName()),null,new File(FileHelper.getDir(record.getOwner(),record.getName())+File.separator+"exe")));
            //recordInfo.setProcess(recordInfo.getRuntime().exec(FileHelper.getExe(record.getOwner(),record.getName())));

            System.out.println("is run");

            list.add(recordInfo);
            System.out.println(list.size());

            BufferedInputStream in = new BufferedInputStream(recordInfo.getProcess().getInputStream());
            BufferedOutputStream outputStream =new BufferedOutputStream(recordInfo.getProcess().getOutputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in,"GB2312"));
            BufferedWriter outp = new BufferedWriter(new OutputStreamWriter(outputStream));
            outp.write("1111");
            outp.flush();
            String lineStr;


            while ((lineStr = inBr.readLine()) != null)
                //获得命令执行后在控制台的输出信息

                System.out.print("");// 打印输出信息不能删，否则会出现程序意外终止，原因不明
            //检查命令是否执行失败。
            if (recordInfo.getProcess().waitFor() != 0) {
                if (recordInfo.getProcess().exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束
                    System.err.println("命令执行失败!");
            }
            inBr.close();
            in.close();
            System.out.println(record.getName()+" is done");
            list.remove(recordInfo);
            System.out.println(list.size());

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static JSONObject getRes(RecordWithBLOBs record){
        JSONObject res = new JSONObject();
        String filePath = FileHelper.getDir(record.getOwner(),record.getName())+File.separator+"LogFile.txt";
        File file = new File(filePath);
        if(file.exists()){
            res.put("errno",0);
            res.put("errmsg","success");
            StringBuilder result = new StringBuilder();
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));
                String s = null;
                while((s = br.readLine())!=null){
                    result.append(s+"<br/>");
                    //System.out.println(s);
                }
                br.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            res.put("data",result);
        }
        else{
            res.put("errno",1);
            res.put("errmsg","The project do not run");
        }


        return res;
    }


}
