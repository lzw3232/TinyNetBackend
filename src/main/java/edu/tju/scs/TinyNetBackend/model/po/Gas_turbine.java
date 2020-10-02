package edu.tju.scs.TinyNetBackend.model.po;

public class Gas_turbine {
    private Integer id;

    private String name;

    private Double ratedPower;

    private Double mLoadRate;

    private Double gasTurbineEff;

    private Double gasCogRatio;

    private Double lifetime;

    private Integer number1;

    private Integer number2;

    private Integer number3;

    private Integer number4;

    private Double fBuildCost1;

    private Double fBuildCost2;

    private Double fBuildCost3;

    private Double fBuildCost4;

    private Double rBuildCost1;

    private Double rBuildCost2;

    private Double rBuildCost3;

    private Double rBuildCost4;

    private Double operCost1;

    private Double operCost2;

    private Double operCost3;

    private Double operCost4;

    private String outPower1;

    private String outPower2;

    private String outPower3;

    private String fuelUse1;

    private String fuelUse2;

    private String fuelUse3;

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

    public Double getRatedPower() {
        return ratedPower;
    }

    public void setRatedPower(Double ratedPower) {
        this.ratedPower = ratedPower;
    }

    public Double getmLoadRate() {
        return mLoadRate;
    }

    public void setmLoadRate(Double mLoadRate) {
        this.mLoadRate = mLoadRate;
    }

    public Double getGasTurbineEff() {
        return gasTurbineEff;
    }

    public void setGasTurbineEff(Double gasTurbineEff) {
        this.gasTurbineEff = gasTurbineEff;
    }

    public Double getGasCogRatio() {
        return gasCogRatio;
    }

    public void setGasCogRatio(Double gasCogRatio) {
        this.gasCogRatio = gasCogRatio;
    }

    public Double getLifetime() {
        return lifetime;
    }

    public void setLifetime(Double lifetime) {
        this.lifetime = lifetime;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public Integer getNumber3() {
        return number3;
    }

    public void setNumber3(Integer number3) {
        this.number3 = number3;
    }

    public Integer getNumber4() {
        return number4;
    }

    public void setNumber4(Integer number4) {
        this.number4 = number4;
    }

    public Double getfBuildCost1() {
        return fBuildCost1;
    }

    public void setfBuildCost1(Double fBuildCost1) {
        this.fBuildCost1 = fBuildCost1;
    }

    public Double getfBuildCost2() {
        return fBuildCost2;
    }

    public void setfBuildCost2(Double fBuildCost2) {
        this.fBuildCost2 = fBuildCost2;
    }

    public Double getfBuildCost3() {
        return fBuildCost3;
    }

    public void setfBuildCost3(Double fBuildCost3) {
        this.fBuildCost3 = fBuildCost3;
    }

    public Double getfBuildCost4() {
        return fBuildCost4;
    }

    public void setfBuildCost4(Double fBuildCost4) {
        this.fBuildCost4 = fBuildCost4;
    }

    public Double getrBuildCost1() {
        return rBuildCost1;
    }

    public void setrBuildCost1(Double rBuildCost1) {
        this.rBuildCost1 = rBuildCost1;
    }

    public Double getrBuildCost2() {
        return rBuildCost2;
    }

    public void setrBuildCost2(Double rBuildCost2) {
        this.rBuildCost2 = rBuildCost2;
    }

    public Double getrBuildCost3() {
        return rBuildCost3;
    }

    public void setrBuildCost3(Double rBuildCost3) {
        this.rBuildCost3 = rBuildCost3;
    }

    public Double getrBuildCost4() {
        return rBuildCost4;
    }

    public void setrBuildCost4(Double rBuildCost4) {
        this.rBuildCost4 = rBuildCost4;
    }

    public Double getOperCost1() {
        return operCost1;
    }

    public void setOperCost1(Double operCost1) {
        this.operCost1 = operCost1;
    }

    public Double getOperCost2() {
        return operCost2;
    }

    public void setOperCost2(Double operCost2) {
        this.operCost2 = operCost2;
    }

    public Double getOperCost3() {
        return operCost3;
    }

    public void setOperCost3(Double operCost3) {
        this.operCost3 = operCost3;
    }

    public Double getOperCost4() {
        return operCost4;
    }

    public void setOperCost4(Double operCost4) {
        this.operCost4 = operCost4;
    }

    public String getOutPower1() {
        return outPower1;
    }

    public void setOutPower1(String outPower1) {
        this.outPower1 = outPower1 == null ? null : outPower1.trim();
    }

    public String getOutPower2() {
        return outPower2;
    }

    public void setOutPower2(String outPower2) {
        this.outPower2 = outPower2 == null ? null : outPower2.trim();
    }

    public String getOutPower3() {
        return outPower3;
    }

    public void setOutPower3(String outPower3) {
        this.outPower3 = outPower3 == null ? null : outPower3.trim();
    }

    public String getFuelUse1() {
        return fuelUse1;
    }

    public void setFuelUse1(String fuelUse1) {
        this.fuelUse1 = fuelUse1 == null ? null : fuelUse1.trim();
    }

    public String getFuelUse2() {
        return fuelUse2;
    }

    public void setFuelUse2(String fuelUse2) {
        this.fuelUse2 = fuelUse2 == null ? null : fuelUse2.trim();
    }

    public String getFuelUse3() {
        return fuelUse3;
    }

    public void setFuelUse3(String fuelUse3) {
        this.fuelUse3 = fuelUse3 == null ? null : fuelUse3.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }
}