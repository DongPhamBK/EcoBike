package com.ebr.bean;

import java.util.Date;

public class Rent {

    private String rentId;
    private String bikeId;
    private String userId;
    private String bikeType;
    private long deposit;
    private Date rentTime;
    private boolean status;

    public Rent() {
        super();
    }

    public Rent(String rentId, String bikeId, String userId, String bikeType, long deposit, Date rentTime, boolean status) {
        this.rentId = rentId;
        this.bikeId = bikeId;
        this.userId = userId;
        this.bikeType = bikeType;
        this.deposit = deposit;
        this.rentTime = rentTime;
        this.status = status;
    }

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public Date getRentTime() {
        return rentTime;
    }

    public void setRentTime(Date rentTime) {
        this.rentTime = rentTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean match(Rent rent) {
        if (rent == null)
            return true;

        if (rent.rentId != null && !rent.rentId.equals("") && !this.rentId.contains(rent.rentId)) {
            return false;
        }
        if (rent.bikeId != null && !rent.bikeId.equals("") && !this.bikeId.contains(rent.bikeId)) {
            return false;
        }
        if (rent.userId != null && !rent.userId.equals("") && !this.userId.contains(rent.userId)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rent) {
            return this.rentId.equals(((Rent) obj).rentId);
        }
        return false;
    }
}
