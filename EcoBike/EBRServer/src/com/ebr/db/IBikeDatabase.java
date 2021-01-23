package com.ebr.db;

import com.ebr.bean.Bike;

import java.util.ArrayList;

public interface IBikeDatabase {
    public ArrayList<Bike> searchBike(Bike bike);
    public Bike updateBike(Bike bike);
    public Bike addBike(Bike bike);
    public Bike deleteBike(Bike bike);
}
