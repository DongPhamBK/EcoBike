package com.ebr.service;

import com.ebr.bean.Bike;
import com.ebr.bean.Rent;
import com.ebr.db.IBikeDatabase;
import com.ebr.db.IRentDatabase;
import com.ebr.db.JsonBikeDatabase;
import com.ebr.db.JsonRentDatabase;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;

@Path("/rents")
public class RentService {

    private IRentDatabase rentDatabase;

    public RentService() {
        rentDatabase = JsonRentDatabase.singleton();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Rent> getAllRents(@QueryParam("rentId") String rentId, @QueryParam("bikeId") String bikeId,
                                       @QueryParam("userId") String userId, @QueryParam("bikeType") String bikeType,
                                       @QueryParam("deposit") long deposit, @QueryParam("rentTime") Date rentTime,
                                       @QueryParam("status") boolean status) {
        Rent rent = new Rent(rentId, bikeId, userId, bikeType, deposit, rentTime, status);
        ArrayList<Rent> res = rentDatabase.searchRent(rent);
        return res;
    }

    @POST
    @Path("/update/{rentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Rent updateRent(@PathParam("rentId") String rentId, Rent rent) {
        return rentDatabase.updateRent(rent);
    }

    @POST
    @Path("/delete/{rentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Rent deleteRent(@PathParam("rentId") String rentId, Rent rent) {
        return rentDatabase.deleteRent(rent);
    }

    @POST
    @Path("/addRent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Rent addRent(Rent rent) {
        return rentDatabase.addRent(rent);
    }
}
