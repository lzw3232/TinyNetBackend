package edu.tju.scs.TinyNetBackend.model.po;

public class Battery {
    private Integer id;

    private String name;

    private Double ratedVoltage;

    private Double roundTridEfficiency;

    private Double maximumChargeRate;

    private Double maximumChargeCurrent;

    private Double constRate;

    private Double maximumCapacity;

    private Double floatLife;

    private Double lifeTimeThroughput;

    private Integer dAtype;

    private Integer numberofBattery;

    private String manufacturer;

    private Integer numberOrCapacity1;

    private Integer numberOrCapacity2;

    private Integer numberOrCapacity3;

    private Integer numberOrCapacity4;

    private Double capitalCurve1;

    private Double capitalCurve2;

    private Double capitalCurve3;

    private Double capitalCurve4;

    private Double replacementCost1;

    private Double replacementCost2;

    private Double replacementCost3;

    private Double replacementCost4;

    private Double maintainCost1;

    private Double maintainCost2;

    private Double maintainCost3;

    private Double maintainCost4;

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

    public Double getRatedVoltage() {
        return ratedVoltage;
    }

    public void setRatedVoltage(Double ratedVoltage) {
        this.ratedVoltage = ratedVoltage;
    }

    public Double getRoundTridEfficiency() {
        return roundTridEfficiency;
    }

    public void setRoundTridEfficiency(Double roundTridEfficiency) {
        this.roundTridEfficiency = roundTridEfficiency;
    }

    public Double getMaximumChargeRate() {
        return maximumChargeRate;
    }

    public void setMaximumChargeRate(Double maximumChargeRate) {
        this.maximumChargeRate = maximumChargeRate;
    }

    public Double getMaximumChargeCurrent() {
        return maximumChargeCurrent;
    }

    public void setMaximumChargeCurrent(Double maximumChargeCurrent) {
        this.maximumChargeCurrent = maximumChargeCurrent;
    }

    public Double getConstRate() {
        return constRate;
    }

    public void setConstRate(Double constRate) {
        this.constRate = constRate;
    }

    public Double getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(Double maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public Double getFloatLife() {
        return floatLife;
    }

    public void setFloatLife(Double floatLife) {
        this.floatLife = floatLife;
    }

    public Double getLifeTimeThroughput() {
        return lifeTimeThroughput;
    }

    public void setLifeTimeThroughput(Double lifeTimeThroughput) {
        this.lifeTimeThroughput = lifeTimeThroughput;
    }

    public Integer getdAtype() {
        return dAtype;
    }

    public void setdAtype(Integer dAtype) {
        this.dAtype = dAtype;
    }

    public Integer getNumberofBattery() {
        return numberofBattery;
    }

    public void setNumberofBattery(Integer numberofBattery) {
        this.numberofBattery = numberofBattery;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Integer getNumberOrCapacity1() {
        return numberOrCapacity1;
    }

    public void setNumberOrCapacity1(Integer numberOrCapacity1) {
        this.numberOrCapacity1 = numberOrCapacity1;
    }

    public Integer getNumberOrCapacity2() {
        return numberOrCapacity2;
    }

    public void setNumberOrCapacity2(Integer numberOrCapacity2) {
        this.numberOrCapacity2 = numberOrCapacity2;
    }

    public Integer getNumberOrCapacity3() {
        return numberOrCapacity3;
    }

    public void setNumberOrCapacity3(Integer numberOrCapacity3) {
        this.numberOrCapacity3 = numberOrCapacity3;
    }

    public Integer getNumberOrCapacity4() {
        return numberOrCapacity4;
    }

    public void setNumberOrCapacity4(Integer numberOrCapacity4) {
        this.numberOrCapacity4 = numberOrCapacity4;
    }

    public Double getCapitalCurve1() {
        return capitalCurve1;
    }

    public void setCapitalCurve1(Double capitalCurve1) {
        this.capitalCurve1 = capitalCurve1;
    }

    public Double getCapitalCurve2() {
        return capitalCurve2;
    }

    public void setCapitalCurve2(Double capitalCurve2) {
        this.capitalCurve2 = capitalCurve2;
    }

    public Double getCapitalCurve3() {
        return capitalCurve3;
    }

    public void setCapitalCurve3(Double capitalCurve3) {
        this.capitalCurve3 = capitalCurve3;
    }

    public Double getCapitalCurve4() {
        return capitalCurve4;
    }

    public void setCapitalCurve4(Double capitalCurve4) {
        this.capitalCurve4 = capitalCurve4;
    }

    public Double getReplacementCost1() {
        return replacementCost1;
    }

    public void setReplacementCost1(Double replacementCost1) {
        this.replacementCost1 = replacementCost1;
    }

    public Double getReplacementCost2() {
        return replacementCost2;
    }

    public void setReplacementCost2(Double replacementCost2) {
        this.replacementCost2 = replacementCost2;
    }

    public Double getReplacementCost3() {
        return replacementCost3;
    }

    public void setReplacementCost3(Double replacementCost3) {
        this.replacementCost3 = replacementCost3;
    }

    public Double getReplacementCost4() {
        return replacementCost4;
    }

    public void setReplacementCost4(Double replacementCost4) {
        this.replacementCost4 = replacementCost4;
    }

    public Double getMaintainCost1() {
        return maintainCost1;
    }

    public void setMaintainCost1(Double maintainCost1) {
        this.maintainCost1 = maintainCost1;
    }

    public Double getMaintainCost2() {
        return maintainCost2;
    }

    public void setMaintainCost2(Double maintainCost2) {
        this.maintainCost2 = maintainCost2;
    }

    public Double getMaintainCost3() {
        return maintainCost3;
    }

    public void setMaintainCost3(Double maintainCost3) {
        this.maintainCost3 = maintainCost3;
    }

    public Double getMaintainCost4() {
        return maintainCost4;
    }

    public void setMaintainCost4(Double maintainCost4) {
        this.maintainCost4 = maintainCost4;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }
}
