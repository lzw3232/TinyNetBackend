package edu.tju.scs.TinyNetBackend.model.po;

public class Diesel {
    private Integer id;

    private String name;

    private Double ratedCapacity;

    private Double minimumLoadRate;

    private Double minimumRunningTime;

    private Double lifeTime;

    private String manufacturer;

    private Double percentofCO2;

    private Double percentofCO;

    private Double percentofUnburned;

    private Double percentofMatter;

    private Double percentofNO;

    private Double percentofSO2;

    private String type;

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

    private String fDieselPower;

    private String fuelConsumption;

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

    public Double getRatedCapacity() {
        return ratedCapacity;
    }

    public void setRatedCapacity(Double ratedCapacity) {
        this.ratedCapacity = ratedCapacity;
    }

    public Double getMinimumLoadRate() {
        return minimumLoadRate;
    }

    public void setMinimumLoadRate(Double minimumLoadRate) {
        this.minimumLoadRate = minimumLoadRate;
    }

    public Double getMinimumRunningTime() {
        return minimumRunningTime;
    }

    public void setMinimumRunningTime(Double minimumRunningTime) {
        this.minimumRunningTime = minimumRunningTime;
    }

    public Double getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(Double lifeTime) {
        this.lifeTime = lifeTime;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Double getPercentofCO2() {
        return percentofCO2;
    }

    public void setPercentofCO2(Double percentofCO2) {
        this.percentofCO2 = percentofCO2;
    }

    public Double getPercentofCO() {
        return percentofCO;
    }

    public void setPercentofCO(Double percentofCO) {
        this.percentofCO = percentofCO;
    }

    public Double getPercentofUnburned() {
        return percentofUnburned;
    }

    public void setPercentofUnburned(Double percentofUnburned) {
        this.percentofUnburned = percentofUnburned;
    }

    public Double getPercentofMatter() {
        return percentofMatter;
    }

    public void setPercentofMatter(Double percentofMatter) {
        this.percentofMatter = percentofMatter;
    }

    public Double getPercentofNO() {
        return percentofNO;
    }

    public void setPercentofNO(Double percentofNO) {
        this.percentofNO = percentofNO;
    }

    public Double getPercentofSO2() {
        return percentofSO2;
    }

    public void setPercentofSO2(Double percentofSO2) {
        this.percentofSO2 = percentofSO2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getfDieselPower() {
        return fDieselPower;
    }

    public void setfDieselPower(String fDieselPower) {
        this.fDieselPower = fDieselPower == null ? null : fDieselPower.trim();
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption == null ? null : fuelConsumption.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }
}