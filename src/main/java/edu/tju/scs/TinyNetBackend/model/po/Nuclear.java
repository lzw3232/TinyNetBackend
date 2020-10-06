package edu.tju.scs.TinyNetBackend.model.po;

public class Nuclear {
    private Integer id;

    private String name;

    private Double lifetime;

    private String manufacturer;

    private Double frequencyModulationCoefficient;

    private Double minimuLoadRate;

    private Double upperLimitOfNuclearPowerGeneration;

    private Double quantityOfNuclearFuel;

    private Double nuclearFuelPrices;

    private Double nuclearPowerFuelReplacementTime;

    private Integer capacity1;

    private Integer capacity2;

    private Integer capacity3;

    private Integer capacity4;

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

    public Double getLifetime() {
        return lifetime;
    }

    public void setLifetime(Double lifetime) {
        this.lifetime = lifetime;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Double getFrequencyModulationCoefficient() {
        return frequencyModulationCoefficient;
    }

    public void setFrequencyModulationCoefficient(Double frequencyModulationCoefficient) {
        this.frequencyModulationCoefficient = frequencyModulationCoefficient;
    }

    public Double getMinimuLoadRate() {
        return minimuLoadRate;
    }

    public void setMinimuLoadRate(Double minimuLoadRate) {
        this.minimuLoadRate = minimuLoadRate;
    }

    public Double getUpperLimitOfNuclearPowerGeneration() {
        return upperLimitOfNuclearPowerGeneration;
    }

    public void setUpperLimitOfNuclearPowerGeneration(Double upperLimitOfNuclearPowerGeneration) {
        this.upperLimitOfNuclearPowerGeneration = upperLimitOfNuclearPowerGeneration;
    }

    public Double getQuantityOfNuclearFuel() {
        return quantityOfNuclearFuel;
    }

    public void setQuantityOfNuclearFuel(Double quantityOfNuclearFuel) {
        this.quantityOfNuclearFuel = quantityOfNuclearFuel;
    }

    public Double getNuclearFuelPrices() {
        return nuclearFuelPrices;
    }

    public void setNuclearFuelPrices(Double nuclearFuelPrices) {
        this.nuclearFuelPrices = nuclearFuelPrices;
    }

    public Double getNuclearPowerFuelReplacementTime() {
        return nuclearPowerFuelReplacementTime;
    }

    public void setNuclearPowerFuelReplacementTime(Double nuclearPowerFuelReplacementTime) {
        this.nuclearPowerFuelReplacementTime = nuclearPowerFuelReplacementTime;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }
}