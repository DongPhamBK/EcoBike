package com.ebr.db;

import com.ebr.bean.Bike;
import com.ebr.db.seed.Seed;

import java.util.ArrayList;


public class JsonBikeDatabase implements IBikeDatabase{

    private static IBikeDatabase singleton = new JsonBikeDatabase();

    private ArrayList<Bike> bikes = Seed.singleton().getBikes();

    private JsonBikeDatabase() {}

    public static IBikeDatabase singleton() {
        return singleton;
    }

    @Override
    public ArrayList<Bike> searchBike(Bike bike) {
        ArrayList<Bike> res = new ArrayList<>();
        for (Bike b: bikes) {
            if (b.match(bike)) {
                res.add(b);
            }
        }
        return res;
    }

    @Override
    public Bike updateBike(Bike bike) {
        for (Bike m: bikes) {
            if (m.equals(bike)) {
                bikes.remove(m);
                bikes.add(bike);
                return bike;
            }
        }
        return null;
    }

    @Override
    public Bike addBike(Bike bike) {
        for (Bike b: bikes) {
            if (b.equals(bike)) {
                return null;
            }
        }
        bikes.add(bike);
        return bike;
    }

    @Override
    public Bike deleteBike(Bike bike) {
        for(Bike b : bikes) {
            if(b.equals(bike)) {
                bikes.remove(b);
                return bike;
            }
        }
        return null;
    }
}
