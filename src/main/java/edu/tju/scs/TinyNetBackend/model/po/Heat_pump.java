package edu.tju.scs.TinyNetBackend.model.po;

public class Heat_pump {
    private Integer id;

    private String name;

    private Double thermalRatio;

    private Double refrigerationRatio;

    private String manufacturer;

    private Double ratedThermoElectricPower;

    private Double ratedRefrigeratingElectricPower;

    private Double life;

    private Double heatingConsumptionCoefficient;

    private Double refrigerationConsumptionCoefficient;

    private Integer capacity1;

    private Integer capacity2;

    private Integer capacity3;

    private Integer capacity4;

    private Double initialCost1;

    private Double initialCost2;

    private Double initialCost3;

    private Double initialCost4;

    private Double replacementCost1;

    private Double replacementCost2;

    private Double replacementCost3;

    private Double replacementCost4;

    private Double maintenanceCost1;

    private Double maintenanceCost2;

    private Double maintenanceCost3;

    private Double maintenanceCost4;

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

    public Double getThermalRatio() {
        return thermalRatio;
    }

    public void setThermalRatio(Double thermalRatio) {
        this.thermalRatio = thermalRatio;
    }

    public Double getRefrigerationRatio() {
        return refrigerationRatio;
    }

    public void setRefrigerationRatio(Double refrigerationRatio) {
        this.refrigerationRatio = refrigerationRatio;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Double getRatedThermoElectricPower() {
        return ratedThermoElectricPower;
    }

    public void setRatedThermoElectricPower(Double ratedThermoElectricPower) {
        this.ratedThermoElectricPower = ratedThermoElectricPower;
    }

    public Double getRatedRefrigeratingElectricPower() {
        return ratedRefrigeratingElectricPower;
    }

    public void setRatedRefrigeratingElectricPower(Double ratedRefrigeratingElectricPower) {
        this.ratedRefrigeratingElectricPower = ratedRefrigeratingElectricPower;
    }

    public Double getLife() {
        return life;
    }

    public void setLife(Double life) {
        this.life = life;
    }

    public Double getHeatingConsumptionCoefficient() {
        return heatingConsumptionCoefficient;
    }

    public void setHeatingConsumptionCoefficient(Double heatingConsumptionCoefficient) {
        this.heatingConsumptionCoefficient = heatingConsumptionCoefficient;
    }

    public Double getRefrigerationConsumptionCoefficient() {
        return refrigerationConsumptionCoefficient;
    }

    public void setRefrigerationConsumptionCoefficient(Double refrigerationConsumptionCoefficient) {
        this.refrigerationConsumptionCoefficient = refrigerationConsumptionCoefficient;
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

    public Double getInitialCost1() {
        return initialCost1;
    }

    public void setInitialCost1(Double initialCost1) {
        this.initialCost1 = initialCost1;
    }

    public Double getInitialCost2() {
        return initialCost2;
    }

    public void setInitialCost2(Double initialCost2) {
        this.initialCost2 = initialCost2;
    }

    public Double getInitialCost3() {
        return initialCost3;
    }

    public void setInitialCost3(Double initialCost3) {
        this.initialCost3 = initialCost3;
    }

    public Double getInitialCost4() {
        return initialCost4;
    }

    public void setInitialCost4(Double initialCost4) {
        this.initialCost4 = initialCost4;
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

    public Double getMaintenanceCost1() {
        return maintenanceCost1;
    }

    public void setMaintenanceCost1(Double maintenanceCost1) {
        this.maintenanceCost1 = maintenanceCost1;
    }

    public Double getMaintenanceCost2() {
        return maintenanceCost2;
    }

    public void setMaintenanceCost2(Double maintenanceCost2) {
        this.maintenanceCost2 = maintenanceCost2;
    }

    public Double getMaintenanceCost3() {
        return maintenanceCost3;
    }

    public void setMaintenanceCost3(Double maintenanceCost3) {
        this.maintenanceCost3 = maintenanceCost3;
    }

    public Double getMaintenanceCost4() {
        return maintenanceCost4;
    }

    public void setMaintenanceCost4(Double maintenanceCost4) {
        this.maintenanceCost4 = maintenanceCost4;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }
}