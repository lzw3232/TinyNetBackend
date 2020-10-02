package edu.tju.scs.TinyNetBackend.model.po;

public class Photovoltaic {
    private Integer id;

    private String name;

    private Double edrl;

    private Double jeys;

    private Double gfzltynxsl;

    private Double gffdxl;

    private Double noctwd;

    private Double wdxs;

    private Double noctgz;

    private Double gfbbzwd;

    private Double life;

    private Double stcwd;

    private String factory;

    private Double type;

    private Integer capacity1;

    private Integer capacity2;

    private Integer capacity3;

    private Integer capacity4;

    private Double cjcb1;

    private Double cjcb2;

    private Double cjcb3;

    private Double cjcb4;

    private Double gxcb1;

    private Double gxcb2;

    private Double gxcb3;

    private Double gxcb4;

    private Double yxwhcb1;

    private Double yxwhcb2;

    private Double yxwhcb3;

    private Double yxwhcb4;

    private String owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getEdrl() {
        return edrl;
    }

    public void setEdrl(Double edrl) {
        this.edrl = edrl;
    }

    public Double getJeys() {
        return jeys;
    }

    public void setJeys(Double jeys) {
        this.jeys = jeys;
    }

    public Double getGfzltynxsl() {
        return gfzltynxsl;
    }

    public void setGfzltynxsl(Double gfzltynxsl) {
        this.gfzltynxsl = gfzltynxsl;
    }

    public Double getGffdxl() {
        return gffdxl;
    }

    public void setGffdxl(Double gffdxl) {
        this.gffdxl = gffdxl;
    }

    public Double getNoctwd() {
        return noctwd;
    }

    public void setNoctwd(Double noctwd) {
        this.noctwd = noctwd;
    }

    public Double getWdxs() {
        return wdxs;
    }

    public void setWdxs(Double wdxs) {
        this.wdxs = wdxs;
    }

    public Double getNoctgz() {
        return noctgz;
    }

    public void setNoctgz(Double noctgz) {
        this.noctgz = noctgz;
    }

    public Double getGfbbzwd() {
        return gfbbzwd;
    }

    public void setGfbbzwd(Double gfbbzwd) {
        this.gfbbzwd = gfbbzwd;
    }

    public Double getLife() {
        return life;
    }

    public void setLife(Double life) {
        this.life = life;
    }

    public Double getStcwd() {
        return stcwd;
    }

    public void setStcwd(Double stcwd) {
        this.stcwd = stcwd;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public Double getType() {
        return type;
    }

    public void setType(Double type) {
        this.type = type;
    }

    public Integer getCapacity1() {
        return capacity1;
    }

    public void setCapacity1(Integer capacity1) {
        this.capacity1 = capacity1;
    }

    public Integer getCapacity2() {
        return capacity2;
    }

    public void setCapacity2(Integer capacity2) {
        this.capacity2 = capacity2;
    }

    public Integer getCapacity3() {
        return capacity3;
    }

    public void setCapacity3(Integer capacity3) {
        this.capacity3 = capacity3;
    }

    public Integer getCapacity4() {
        return capacity4;
    }

    public void setCapacity4(Integer capacity4) {
        this.capacity4 = capacity4;
    }

    public Double getCjcb1() {
        return cjcb1;
    }

    public void setCjcb1(Double cjcb1) {
        this.cjcb1 = cjcb1;
    }

    public Double getCjcb2() {
        return cjcb2;
    }

    public void setCjcb2(Double cjcb2) {
        this.cjcb2 = cjcb2;
    }

    public Double getCjcb3() {
        return cjcb3;
    }

    public void setCjcb3(Double cjcb3) {
        this.cjcb3 = cjcb3;
    }

    public Double getCjcb4() {
        return cjcb4;
    }

    public void setCjcb4(Double cjcb4) {
        this.cjcb4 = cjcb4;
    }

    public Double getGxcb1() {
        return gxcb1;
    }

    public void setGxcb1(Double gxcb1) {
        this.gxcb1 = gxcb1;
    }

    public Double getGxcb2() {
        return gxcb2;
    }

    public void setGxcb2(Double gxcb2) {
        this.gxcb2 = gxcb2;
    }

    public Double getGxcb3() {
        return gxcb3;
    }

    public void setGxcb3(Double gxcb3) {
        this.gxcb3 = gxcb3;
    }

    public Double getGxcb4() {
        return gxcb4;
    }

    public void setGxcb4(Double gxcb4) {
        this.gxcb4 = gxcb4;
    }

    public Double getYxwhcb1() {
        return yxwhcb1;
    }

    public void setYxwhcb1(Double yxwhcb1) {
        this.yxwhcb1 = yxwhcb1;
    }

    public Double getYxwhcb2() {
        return yxwhcb2;
    }

    public void setYxwhcb2(Double yxwhcb2) {
        this.yxwhcb2 = yxwhcb2;
    }

    public Double getYxwhcb3() {
        return yxwhcb3;
    }

    public void setYxwhcb3(Double yxwhcb3) {
        this.yxwhcb3 = yxwhcb3;
    }

    public Double getYxwhcb4() {
        return yxwhcb4;
    }

    public void setYxwhcb4(Double yxwhcb4) {
        this.yxwhcb4 = yxwhcb4;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public  String  toString1()
    {
        String ret="";
        ret+=Double.toString(jeys)+'\n';
        ret+=Double.toString(gffdxl)+'\n';
        ret+=Double.toString(wdxs)+'\n';
        ret+=Double.toString(gfbbzwd)+'\n';
        ret+=Double.toString(gfzltynxsl)+'\n';
        ret+=Double.toString(stcwd)+'\n';
        ret+=Double.toString(noctwd)+'\n';
        ret+=Double.toString(noctgz)+'\n';

        return ret;
    }

    public  String  toString2()
    {
        String ret="";
        ret+=Double.toString(life)+'\n';
        ret+=Double.toString(life)+'\n';
        ret+="1"+'\n';
        ret+=Integer.toString(capacity1)+' ';
        ret+=Integer.toString(capacity2)+' ';
        ret+=Integer.toString(capacity3)+' ';
        ret+=Integer.toString(capacity4)+'\n';
        ret+=Double.toString(cjcb1)+' ';
        ret+=Double.toString(cjcb2)+' ';
        ret+=Double.toString(cjcb3)+' ';
        ret+=Double.toString(cjcb4)+'\n';
        ret+=Double.toString(gxcb1)+' ';
        ret+=Double.toString(gxcb2)+' ';
        ret+=Double.toString(gxcb3)+' ';
        ret+=Double.toString(gxcb4)+'\n';
        ret+=Double.toString(yxwhcb1)+' ';
        ret+=Double.toString(yxwhcb2)+' ';
        ret+=Double.toString(yxwhcb3)+' ';
        ret+=Double.toString(yxwhcb4)+'\n';
        return ret;
    }
}
