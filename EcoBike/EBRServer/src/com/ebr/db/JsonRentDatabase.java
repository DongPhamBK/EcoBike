package com.ebr.db;

import com.ebr.bean.Bike;
import com.ebr.bean.Rent;
import com.ebr.db.seed.Seed;

import java.util.ArrayList;


public class JsonRentDatabase implements IRentDatabase{

    private static IRentDatabase singleton = new JsonRentDatabase();

    private ArrayList<Rent> rents = Seed.singleton().getRents();

    private JsonRentDatabase() {}

    public static IRentDatabase singleton() {
        return singleton;
    }

    @Override
    public ArrayList<Rent> searchRent(Rent rent) {
        ArrayList<Rent> res = new ArrayList<>();
        for (Rent b: rents) {
            if (b.match(rent)) {
                res.add(b);
            }
        }
        return res;
    }

    @Override
    public Rent updateRent(Rent rent) {
        for (Rent m: rents) {
            if (m.equals(rent)) {
                rents.remove(m);
                rents.add(rent);
                return rent;
            }
        }
        return null;
    }

    @Override
    public Rent addRent(Rent rent) {
        for (Rent b: rents) {
            if (b.equals(rent)) {
                return null;
            }
        }
        rents.add(rent);
        return rent;
    }

    @Override
    public Rent deleteRent(Rent rent) {
        for(Rent b : rents) {
            if(b.equals(rent)) {
                rents.remove(b);
                return rent;
            }
        }
        return null;
    }
}
