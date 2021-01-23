package com.ebr.db;

import com.ebr.bean.Rent;

import java.util.ArrayList;

public interface IRentDatabase {
        public ArrayList<Rent> searchRent(Rent bike);
        public Rent updateRent(Rent bike);
        public Rent addRent(Rent bike);
        public Rent deleteRent(Rent bike);
}
