package edu.tju.scs.TinyNetBackend.common;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.model.po.*;
import edu.tju.scs.TinyNetBackend.model.po.Record;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileHelper {

    public static String getOurput(String username,String recordname)
    {
        String path="/"+username+"/"+recordname+"/IO/OUT0/";
        String ret="";
        JSONObject output = new JSONObject();
        JSONObject temp;
        File file;
        FileInputStream in;
        Scanner scanner;
        List<Double>list;
        /*
        try {

            File file = new File(path);
            String[] filePath = file.list();
            for (int i = 0; i < filePath.length; i++)
            {

                File tempfile = new File(path+"/"+filePath[i]);
                FileInputStream in = new FileInputStream(tempfile);
                ret=ret+filePath[i]+";";
                Scanner scanner = new Scanner(in);
                while (scanner.hasNext())
                {
                    ret=ret+scanner.nextLine()+'\n';
                }

                in.close();
                if(i!=filePath.length-1)
                    ret=ret+'|';

            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }

        */
        try{

            file=new File(path+"Abschille_Details.txt");
            in = new FileInputStream(file);
            scanner = new Scanner(in);
            temp =  new JSONObject();
            temp.put("pjzlgl",scanner.nextDouble());
            temp.put("rjzll",scanner.nextDouble());
            temp.put("zzll",scanner.nextDouble());
            temp.put("zxsclgl",scanner.nextDouble());
            temp.put("zdsclgl",scanner.nextDouble());
            temp.put("pjcrgl",scanner.nextDouble());
            temp.put("rjcrl",scanner.nextDouble());
            temp.put("zcrl",scanner.nextDouble());
            temp.put("zxscrgl",scanner.nextDouble());
            temp.put("zdscrgl",scanner.nextDouble());
            temp.put("yxsj",scanner.nextDouble());
            temp.put("xszyql",scanner.nextDouble());
            output.put("Abschille_Details",temp);
            in.close();

            file=new File(path+"AccPowerSupply.txt");
            in = new FileInputStream(file);
            scanner = new Scanner(in);
            temp =  new JSONObject();
            temp.put("qnhdlzj",scanner.nextDouble());
            output.put("AccPowerSupply",temp);
            in.close();

            file=new File(path+"AnnualCost_Abschille.txt");
            in = new FileInputStream(file);
            scanner = new Scanner(in);
            temp =  new JSONObject();
            temp.put("czcbnz",scanner.nextDouble());
            temp.put("thcbnz",scanner.nextDouble());
            temp.put("ywcbnz",scanner.nextDouble());
            temp.put("rlcbnz",scanner.nextDouble());
            temp.put("cznz",scanner.nextDouble());
            temp.put("cbzjnz",scanner.nextDouble());
            output.put("AnnualCost_Abschille",temp);
            in.close();

            file=new File(path+"AnnualCost_accumulateloan.txt");
            in = new FileInputStream(file);
            scanner = new Scanner(in);
            temp =  new JSONObject();
            temp.put("qkljnz",scanner.nextDouble());
            list = new ArrayList<>();
            while(scanner.hasNext())
                list.add(scanner.nextDouble());
            temp.put("qkljnzlist",list);
            output.put("AnnualCost_accumulateloan",temp);
            in.close();

            file=new File(path+"AnnualCost_accumulateNPV.txt");
            in = new FileInputStream(file);
            scanner = new Scanner(in);
            temp =  new JSONObject();
            temp.put("ljjxjlnz",scanner.nextDouble());
            list = new ArrayList<>();
            while(scanner.hasNext())
                list.add(scanner.nextDouble());
            temp.put("ljjxjlnzlist",list);
            output.put("AnnualCost_accumulateNPV",temp);
            in.close();

            file=new File(path+"Every_AnnualCost_BT.txt");
            in = new FileInputStream(file);
            scanner = new Scanner(in);
            temp =  new JSONObject();
            temp.put("czcbnz",scanner.nextDouble());
            temp.put("thcbnz",scanner.nextDouble());
            temp.put("ywcbnz",scanner.nextDouble());
            temp.put("rlcbnz",scanner.nextDouble());
            temp.put("cznz",scanner.nextDouble());
            temp.put("cbzjnz",scanner.nextDouble());
            output.put("Every_AnnualCost_BT",temp);
            in.close();

            file=new File(path+"AnnualCost_Cool.txt");
            in = new FileInputStream(file);
            scanner = new Scanner(in);
            temp =  new JSONObject();
            temp.put("zlsynz",scanner.nextDouble());
            list = new ArrayList<>();
            while(scanner.hasNext())
                list.add(scanner.nextDouble());
            temp.put("zlsynzlist",list);
            output.put("AnnualCost_Cool",temp);
            in.close();

            file=new File(path+"AnnualCost_Coolstorage.txt");
            in = new FileInputStream(file);
            scanner = new Scanner(in);
            temp =  new JSONObject();
            temp.put("czcbnz",scanner.nextDouble());
            temp.put("thcbnz",scanner.nextDouble());
            temp.put("ywcbnz",scanner.nextDouble());
            temp.put("rlcbnz",scanner.nextDouble());
            temp.put("cznz",scanner.nextDouble());
            temp.put("cbzjnz",scanner.nextDouble());
            output.put("AnnualCost_Coolstorage",temp);
            in.close();

            file=new File(path+"AnnualCost_costflow.txt");
            in = new FileInputStream(file);
            scanner = new Scanner(in);
            temp =  new JSONObject();
            temp.put("jycbnz",scanner.nextDouble());
            list = new ArrayList<>();
            while(scanner.hasNext())
                list.add(scanner.nextDouble());
            temp.put("jycbnzlist",list);
            output.put("AnnualCost_costflow",temp);
            in.close();

            //11-20




        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  output.toString();
    }

    public  static  String readFile(String path)
    {
        String ret="";
        try{

                File tempfile = new File(path);
                FileInputStream in = new FileInputStream(tempfile);
                Scanner scanner = new Scanner(in);
                while (scanner.hasNext()) {
                    ret = ret + scanner.nextLine() + '\n';
                }
                in.close();


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  ret;

    }


    public static String getInput(String temp)
    {
        String ret="";
        JSONObject jsonpObject= JSON.parseObject(temp);
        System.out.println(jsonpObject);
        JSONObject json = JSON.parseObject(jsonpObject.get("deviceData").toString());
        System.out.println(json);
        int len;


        ret+="AbschilleParameter.txt:|";


        ret+="BatteryParameter.txt:";
        JSONObject batterydata = JSON.parseObject(json.get("battery").toString());
        if(batterydata!=null)
        {
            batterydata = JSON.parseObject(batterydata.get("data").toString());
            List<Battery> batterys  = JSON.parseArray(batterydata.get("battery_ids").toString(),Battery.class);
            // List<Battery> batterys = JSON.parseArray(batterydata.get("battery_ids").toString());
            len=batterys.size();
            for(int i=0;i<len;i++)
            {
                ret+=batterys.get(i).toString1();
                ret+=batterydata.get("battery_soc_init").toString()+'\n';
                ret+=batterydata.get("battery_soc_upper_limit").toString()+'\n';
                ret+=batterydata.get("battery_soc_lower_limit").toString()+'\n';
                ret+=batterydata.get("battery_total_flow").toString()+'\n';
                ret+=batterydata.get("battery_back_flow").toString()+'\n';
                ret+=batterys.get(i).toString2()+'\n';
            }
        }

        //System.out.println(batterydata.toString());
        ret+="|";

        ret+="ConverterParameter.txt:|";

        ret+="Coolload.txt:|";

        ret+="CoolstorageParameter.txt:|";

        ret+="DieselParameter.txt:";
        JSONObject generatordata = JSON.parseObject(json.get("generator").toString());
        if(generatordata!=null)
        {
            generatordata = JSON.parseObject(generatordata.get("data").toString());
            List<Generator> generators  = JSON.parseArray(generatordata.get("generator_ids").toString(), Generator.class);
            len=generators.size();
            for(int i=0;i<len;i++)
            {
                ret+=generators.get(i).toString1();
                if(generators.get(i).getType().equals("汽油"))
                {
                    ret+=generatordata.get("qiyou_price").toString()+'\n';
                }
                else
                {
                    ret+=generatordata.get("chaiyou_price").toString()+'\n';
                }
                ret+=generators.get(i).toString2()+'\n';
            }
            //System.out.println(batterydata.toString());
            ret+="|";
            for(int i=0;i<len;i++)
            {
                ret+="DieselPowerCurve"+Integer.toString(i)+".txt:";
                ret+=generators.get(i).toString3();
                ret+="|";
            }
        }
        else
        {
            ret+="|";
        }


        ret+="ElecairconditionParameter.txt:|";

        ret+="ElecboilerParameter.txt:|";

        ret+="ElectricitychillerParameter.txt:|";
        //Todo
        ret+="GAParameter.txt:";
        try{
            ret+=readFile("D:/IN0/GAParameter.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';


        ret+="GasboilerParameter.txt:|";

        ret+="GasPowerCurve.txt:|";

        ret+="GasturebineParameter.txt:|";

        ret+="Heatload.txt:|";

        ret+="HeatstorageParameter.txt:|";

        ret+="HydroTurbineParameter.txt:";
        JSONObject turbinedata = JSON.parseObject(json.get("turbine").toString());
        if(turbinedata!=null)
        {
            turbinedata = JSON.parseObject(turbinedata.get("data").toString());
            List<Turbine> turbines  = JSON.parseArray(turbinedata.get("turbine_ids").toString(),Turbine.class);
            // List<Battery> batterys = JSON.parseArray(batterydata.get("battery_ids").toString());
            len=turbines.size();
            for(int i=0;i<len;i++)
            {
                ret+=turbines.get(i).toString1()+'\n';
            }
        }
        ret+="|";

        ret+="PhotovoltaicParameter.txt:";
        JSONObject photovoltaicdata = JSON.parseObject(json.get("photovoltaic").toString());
        if(photovoltaicdata!=null)
        {
            photovoltaicdata = JSON.parseObject(photovoltaicdata.get("data").toString());
            List<Photovoltaic> photovoltaics  = JSON.parseArray(photovoltaicdata.get("photovoltaic_ids").toString(),Photovoltaic.class);
            // List<Battery> batterys = JSON.parseArray(batterydata.get("battery_ids").toString());
            len=photovoltaics.size();
            for(int i=0;i<len;i++)
            {
                ret+=photovoltaics.get(i).toString1();
                ret+=photovoltaicdata.get("photovoltaic_sq").toString()+'\n';
                ret+=photovoltaicdata.get("photovoltaic_wd").toString()+'\n';
                ret+=photovoltaicdata.get("photovoltaic_jd").toString()+'\n';
                ret+=photovoltaics.get(i).toString2()+'\n';
            }
        }
        ret+="|";

        ret+="PowerPriload.txt:";
        try{
            ret+=readFile("D:/IN0/PowerPriload.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        ret+="PumpParameter.txt:|";

        ret+="PurchasePrice_Grid.txt:|";

        ret+="SellingPrice_Grid.txt:|";

        ret+="SolarRadiation.txt:";
        try{
            ret+=readFile("D:/IN0/SolarRadiation.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';
        //Todo 这个还有些问题，这些参数页面里现在还找不到
        ret+="SourceParameter.txt:";
        try{
            ret+=readFile("D:/IN0/SourceParameter.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        //Todo 参数有点多，慢慢往里边填
        ret+="SystemParameter.txt:";
        try{
            ret+=readFile("D:/IN0/SourceParameter.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        ret+="WasteheatboilerParameter.txt:|";

        ret+="SystemParameter.txt:";
        try{
            ret+=readFile("D:/IN0/WaterFlow.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        ret+="SystemParameter.txt:";
        try{
            ret+=readFile("D:/IN0/Weekend.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        ret+="Weekend_Cool.txt:|";

        ret+="Weekend_Heat.txt:|";

        ret+="windSpeed.txt:";
        try{
            ret+=readFile("D:/IN0/windSpeed.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        ret+="WindTurbineParameter.txt:";
        JSONObject wind_turbinesdata = JSON.parseObject(json.get("wind_turbines").toString());
        if(wind_turbinesdata!=null)
        {
            wind_turbinesdata = JSON.parseObject(wind_turbinesdata.get("data").toString());
            List<Wind_Turbines> wind_turbines  = JSON.parseArray(wind_turbinesdata.get("wind_turbines_ids").toString(), Wind_Turbines.class);
            len=wind_turbines.size();
            for(int i=0;i<len;i++)
            {
                ret += wind_turbinesdata.get("fscldjdmgd").toString() + '\n';
                ret += wind_turbinesdata.get("hbgd").toString() + '\n';
                ret += wind_turbinesdata.get("dmcccd").toString() + '\n';
                ret += wind_turbines.get(i).toString1() + '\n';
            }
            //System.out.println(batterydata.toString());
            ret+="|";
            for(int i=0;i<len;i++)
            {
                ret+="WTPowerCurve"+Integer.toString(i)+".txt:";
                ret+=wind_turbines.get(i).toString2();
                ret+="|";
            }
        }
        else
        {
            ret+="|";
        }

        ret+="WorkingDays.txt:";
        try{
            ret+=readFile("D:/IN0/WorkingDays.txt");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ret+='|';

        ret+="WorkingDays_Cool.txt:|";

        ret+="WorkingDays_Heat.txt:|";

        return ret;
    }

    public static boolean checkFinish(String username,String recordname)
    {
        String path="F:"+File.separator+username+File.separator+recordname+File.separator+"exe"+File.separator+"IO"+File.separator+"OUT0";
        String[] filePath=null;
        try {

            File file = new File(path);
            filePath = file.list();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if(filePath.length>0)
            return true;
        else
            return false;
    }

    public static void newRecord(Record record)
    {
        String path="F:"+File.separator+record.getOwner()+File.separator+record.getName();
        try {

            //copyDir("F:\\exe",path);
            copyFolder("F:"+File.separator+"exe",path);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void createUser(String username)
    {
        String newPath = "/"+username;
        try {
            if (!(new File(newPath)).exists()) {
                (new File(newPath)).mkdir();
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String getExe(String username,String recordname)
    {
//        String a="F:"+File.separator+username+File.separator+recordname+File.separator+"exe"+File.separator+"DesignElectricPower_Test.exe";
//        System.out.println(a);
        return "F:"+File.separator+username+File.separator+recordname+File.separator+"exe"+File.separator+"DesignElectricPower_Test.exe";
    }

    public static String getDir(String username,String recordname)
    {
        return "F:"+File.separator+username+File.separator+recordname;
    }
    public static void main(String[] args) {
        RecordWithBLOBs record = new RecordWithBLOBs();
        record.setName("lzw");
        record.setOwner("lzw");
        getIO(record);
    }


    public static void setIO(RecordWithBLOBs record)
    {
        String username=record.getOwner();
        String recordname=record.getName();
        String path="F:"+File.separator+username+File.separator+recordname+File.separator+"exe"+File.separator+"IO";
        StringBuilder result = new StringBuilder();

        String filePath = "F:\\1.txt";
        File file1 = new File(filePath);
        if(file1.exists()){
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));
                String s = null;
                while((s = br.readLine())!=null){
                    result.append(s+"\n");
                    //System.out.println(s);
                }
                br.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        String input = result.toString();
//        String input=record.getInput();
        String file[] = input.split("\\|");

        try {
            (new File(path)).mkdir();
            (new File(path+File.separator+"IN0")).mkdir();
            (new File(path+File.separator+"OUT0")).mkdir();
            for(int i=0;i<file.length;i++)
            {
                //System.out.println(file[i]);
                String temp[]=file[i].split(":");
                if(temp.length==2)
                {
                    File newfile = new File(path+File.separator+"IN0"+File.separator+temp[0]);
                    FileOutputStream out = new FileOutputStream(newfile);

                    out.write(temp[1].getBytes());
                    out.close();
                }
                else if(temp.length==1)
                {
                    File newfile = new File(path+File.separator+"IN0"+File.separator+temp[0]);
                    FileOutputStream out = new FileOutputStream(newfile);

                    out.close();

                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void copyFolder(String oldPath, String newPath) {

        try {
            (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹
            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }

                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" +
                            (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {//如果是子文件夹
                    copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();

        }
    }


//    public static void copyDir(String sourcePath, String newPath) throws IOException {
//        File file = new File(sourcePath);
//        String[] filePath = file.list();
//
//        if (!(new File(newPath)).exists()) {
//            (new File(newPath)).mkdir();
//        }
//        System.out.println("sasa");
//        for (int i = 0; i < filePath.length; i++) {
//            if ((new File(sourcePath + file.separator + filePath[i])).isDirectory()) {
//                if(filePath[i].equals("IO"))
//                    continue;
//
//                copyDir(sourcePath  + file.separator  + filePath[i], newPath  + file.separator + filePath[i]);
//            }
//
//            if (new File(sourcePath  + file.separator + filePath[i]).isFile()) {
//                copyFile(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
//            }
//
//        }
//    }


    public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);;

        byte[] buffer=new byte[2097152];
        int readByte = 0;
        while((readByte = in.read(buffer)) != -1){
            out.write(buffer, 0, readByte);
        }

        in.close();
        out.close();
    }

    public static void getIO(RecordWithBLOBs record)
    {
        String username=record.getOwner();
        String recordname=record.getName();
        String path="F:\\6.12\\bin\\IO\\IN0";
        List<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();
        String input = "";
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i].toString());
                StringBuilder result = new StringBuilder();
                File file1 = new File(tempList[i].toString());
                if(file1.exists()){
                    //System.out.println(tempList[i].toString().split("\\\\")[tempList[i].toString().split("\\\\").length-1]);
                    input += "|"+tempList[i].toString().split("\\\\")[tempList[i].toString().split("\\\\").length-1] +":";
                    try{
                        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tempList[i].toString()),"gbk"));
                        String s = null;
                        while((s = br.readLine())!=null){
                            result.append(s+"\n");
                        }
                        br.close();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                input += result;
            }
        }

        input = input.substring(1,input.length()-1);
        try{
            FileOutputStream out = new FileOutputStream("F:"+File.separator+username+File.separator+recordname+File.separator+"1.txt");
            out.write(input.getBytes());
            out.close();
        }
        catch (Exception e){

        }


    }



}
