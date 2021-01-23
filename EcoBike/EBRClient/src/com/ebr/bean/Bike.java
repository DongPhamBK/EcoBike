package com.ebr.bean;

public class Bike {

    private String id;
    private String name;
    private String bikeType; //{SINGLE_BIKE, SINGLE_E_BIKE, DOUBLE_BIKE, DOUBLE_E_BIKE}
    private double weight;
    private String licensePlate;
    private long manufacturingDate;
    private String producer;
    private long cost;

    private double estimate;
    private double batteryPercentage;
    private int loadCycles;

    private String status;

    private String stationId;

    public Bike() {
        super();
    }

    public Bike(String id, String name, String bikeType, double weight, String licensePlate, long manufacturingDate, String producer, long cost, double estimate, double batteryPercentage, int loadCycles, String status, String stationId) {
        this.id = id;
        this.name = name;
        this.bikeType = bikeType;
        this.weight = weight;
        this.licensePlate = licensePlate;
        this.manufacturingDate = manufacturingDate;
        this.producer = producer;
        this.cost = cost;
        this.estimate = estimate;
        this.batteryPercentage = batteryPercentage;
        this.loadCycles = loadCycles;
        this.status = status;
        this.stationId = stationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public long getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(long manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public double getEstimate() {
        return estimate;
    }

    public void setEstimate(double estimate) {
        this.estimate = estimate;
    }

    public double getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(double batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public int getLoadCycles() {
        return loadCycles;
    }

    public void setLoadCycles(int loadCycles) {
        this.loadCycles = loadCycles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public boolean match(Bike bike) {
        if (bike == null)
            return true;


        if (bike.id != null && !bike.id.equals("") && !this.id.contains(bike.id)) {
            return false;
        }
        if (bike.name != null && !bike.name.equals("") && !this.name.contains(bike.name)) {
            return false;
        }
        if (bike.bikeType != null && !bike.bikeType.equals("") && !this.bikeType.contains(bike.bikeType)) {
            return false;
        }
        if (bike.weight != 0 && this.weight != bike.weight) {
            return false;
        }
        if (bike.licensePlate != null && !bike.licensePlate.equals("") && !this.licensePlate.contains(bike.licensePlate)) {
            return false;
        }
        if (bike.manufacturingDate != 0 && this.manufacturingDate != bike.manufacturingDate) {
            return false;
        }
        if (bike.producer != null && !bike.producer.equals("") && !this.producer.contains(bike.producer)) {
            return false;
        }
        if (bike.cost != 0 && this.cost != bike.cost) {
            return false;
        }
        if (bike.estimate != 0 && this.estimate != bike.estimate) {
            return false;
        }
        if (bike.batteryPercentage != 0 && this.batteryPercentage != bike.batteryPercentage) {
            return false;
        }
        if (bike.loadCycles != 0 && this.loadCycles != bike.loadCycles) {
            return false;
        }
        if (bike.status != null && !bike.status.equals("") && !this.status.contains(bike.status)) {
            return false;
        }
        if (bike.stationId != null && !bike.stationId.equals("") && !this.stationId.contains(bike.stationId)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bike) {
            return this.id.equals(((Bike) obj).id);
        }
        return false;
    }
}
