package com.ebr.service;

import com.ebr.bean.Bike;
import com.ebr.db.IBikeDatabase;
import com.ebr.db.JsonBikeDatabase;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/bikes")
public class BikeService {

    private IBikeDatabase bikeDatabase;

    public BikeService() {
        bikeDatabase = JsonBikeDatabase.singleton();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Bike> getAllBikes(@QueryParam("id") String id, @QueryParam("name") String name,
                                       @QueryParam("bikeType") String bikeType, @QueryParam("weight") double weight,
                                       @QueryParam("licensePlate") String licensePlate, @QueryParam("manufacturingDate") long manufacturingDate,
                                       @QueryParam("producer") String producer, @QueryParam("cost") long cost,
                                       @QueryParam("status") String status, @QueryParam("stationId") String stationId,
                                       @QueryParam("estimate") double estimate, @QueryParam("batteryPercentage") double batteryPercentage,
                                       @QueryParam("loadCycles") int loadCycles) {
        Bike bike = new Bike(id,name, bikeType, weight,
                licensePlate, manufacturingDate, producer,
                cost, estimate, batteryPercentage, loadCycles,
                status, stationId);
        ArrayList<Bike> res = bikeDatabase.searchBike(bike);
        return res;
    }

    @POST
    @Path("/update/{bikeId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Bike updateBike(@PathParam("bikeId") String bikeId, Bike bike) {
        return bikeDatabase.updateBike(bike);
    }

    @POST
    @Path("/delete/{bikeId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Bike deleteBike(@PathParam("bikeId") String bikeId, Bike bike) {
        return bikeDatabase.deleteBike(bike);
    }

    @POST
    @Path("/addBike")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Bike addBike(Bike bike) {
        return bikeDatabase.addBike(bike);
    }
}
