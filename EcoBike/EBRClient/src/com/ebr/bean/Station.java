package com.ebr.bean;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

//cac thong so cua tram xe (station )
// class nay y nhu ben server
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("stations")
@JsonSubTypes({ @Type(value = Station.class, name = "station") })
public class Station {

	private String stationId;
	private String stationName;
	private String stationAddress;
	private int numberBikes;
	private int numberEBikes;
	private int numberTwinBikes;
	private int numberEmptyDocks;
	private int stationDistance;
	private float stationTime;

	public Station() {

	}

	public Station(String stationId, String stationName, String stationAddress, int numberBikes, int numberEBikes,
			int numberTwinBikes, int numberEmptyDocks, int stationDistance, float stationTime) {
		super();
		this.stationId = stationId;
		this.stationName = stationName;
		this.stationAddress = stationAddress;
		this.numberBikes = numberBikes;
		this.numberEBikes = numberEBikes;
		this.numberTwinBikes = numberTwinBikes;
		this.numberEmptyDocks = numberEmptyDocks;
		this.stationDistance = stationDistance;
		this.stationTime = stationTime;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationAddress() {
		return stationAddress;
	}

	public void setStationAddress(String stationAddress) {
		this.stationAddress = stationAddress;
	}

	public int getNumberBikes() {
		return numberBikes;
	}

	public void setNumberBikes(int numberBikes) {
		this.numberBikes = numberBikes;
	}

	public int getNumberEBikes() {
		return numberEBikes;
	}

	public void setNumberEBikes(int numberEBikes) {
		this.numberEBikes = numberEBikes;
	}

	public int getNumberTwinBikes() {
		return numberTwinBikes;
	}

	public void setNumberTwinBikes(int numberTwinBikes) {
		this.numberTwinBikes = numberTwinBikes;
	}

	public int getNumberEmptyDocks() {
		return numberEmptyDocks;
	}

	public void setNumberEmptyDocks(int numberEmptyDocks) {
		this.numberEmptyDocks = numberEmptyDocks;
	}

	public int getStationDistance() {
		return stationDistance;
	}

	public void setStationDistance(int stationDistance) {
		this.stationDistance = stationDistance;
	}

	public float getStationTime() {
		return stationTime;
	}

	public void setStationTime(float stationTime) {
		this.stationTime = stationTime;
	}

	@Override
	public String toString() { // TODO Auto-generated method stub
		return "Station ID: " + this.stationId + "Station Name: " + this.stationName + "StationAdsress: "
				+ this.stationAddress + "Empty Doc: " + this.numberEmptyDocks;
	}

	public boolean match(Station station) {
		if (station == null)
			return true;

		if (station.stationId != null && !station.stationId.equals("") && !this.stationId.contains(station.stationId)) {
			return false;
		}
		if (station.stationName != null && !station.stationName.equals("")
				&& !this.stationName.contains(station.stationName)) {
			return false;
		}
		if (station.stationAddress != null && !station.stationAddress.equals("")
				&& !this.stationAddress.contains(station.stationAddress)) {
			return false;
		}
		if (station.numberBikes != 0 && this.numberBikes != station.numberBikes) {
			return false;
		}
		if (station.numberEBikes != 0 && this.numberEBikes != station.numberEBikes) {
			return false;
		}
		if (station.numberEmptyDocks != 0 && this.numberEmptyDocks != station.numberEmptyDocks) {
			return false;
		}
		if (station.numberTwinBikes != 0 && this.numberTwinBikes != station.numberTwinBikes) {
			return false;
		}
		if (station.stationDistance != 0 && this.stationDistance != station.stationDistance) {
			return false;
		}
		if (station.stationTime != 0 && this.stationTime != station.stationTime) {
			return false;
		}

		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Station) {
			return this.stationId.equals(((Station) obj).stationId);
		}
		return false;
	}

}
