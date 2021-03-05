package edu.tju.scs.TinyNetBackend.model.ours;

import edu.tju.scs.TinyNetBackend.model.po.Generator;

public class Generator_ours {
    Generator generator;

    public Generator_ours(Generator generator){
        this.generator = generator;
    }

    public  String  toString1()
    {
        String ret="";
        ret+=Double.toString(generator.getEdgl())+'\n';
        ret+=Double.toString(generator.getZdfzl())+'\n';
        ret+=Double.toString(generator.getZxyysj())+'\n';
        ret+=Double.toString(generator.getLife())+'\n';
        ret+=Double.toString(generator.getCo2())+'\n';
        ret+=Double.toString(generator.getCo())+'\n';
        ret+=Double.toString(generator.getWrsdqhhw())+'\n';
        ret+=Double.toString(generator.getKlw())+'\n';
        ret+=Double.toString(generator.getDyhw())+'\n';
        ret+=Double.toString(generator.getSo2())+'\n';

        return  ret;

    }

    public String toString2()
    {
        String ret="";
        ret+=Integer.toString(generator.getCapacity1())+' ';
        ret+=Integer.toString(generator.getCapacity2())+' ';
        ret+=Integer.toString(generator.getCapacity3())+' ';
        ret+=Integer.toString(generator.getCapacity4())+'\n';
        ret+=Double.toString(generator.getCjcb1())+' ';
        ret+=Double.toString(generator.getCjcb2())+' ';
        ret+=Double.toString(generator.getCjcb3())+' ';
        ret+=Double.toString(generator.getCjcb4())+'\n';
        ret+=Double.toString(generator.getGxcb1())+' ';
        ret+=Double.toString(generator.getGxcb2())+' ';
        ret+=Double.toString(generator.getGxcb3())+' ';
        ret+=Double.toString(generator.getGxcb4())+'\n';
        ret+=Double.toString(generator.getYxwhcb1())+' ';
        ret+=Double.toString(generator.getYxwhcb2())+' ';
        ret+=Double.toString(generator.getYxwhcb3())+' ';
        ret+=Double.toString(generator.getYxwhcb4())+'\n';
        return ret;
    }

    public String toString3()
    {
        String ret="";
        return ret;
    }
}
