package com.ebr.bean;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("bike")
@JsonSubTypes({ @Type(value = RentalData.class, name = "bike") })
public class RentalData {
	private String id;
	private String name;
	private String typeId;
	private String parkingId;
	private float weight;
	private String licensePlate;
    private String manuafacturingDate;
    private float cost;
    private String producer;
    private String nameType;
    private int so_yen;
    private int tien_coc;
    private int so_ghe_sau;
	
	public RentalData() {
		super();
	}

	
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getParkingId() {
		return parkingId;
	}
	public void setParkingId(String parkingId) {
		this.parkingId = parkingId;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getManuafacturingDate() {
		return manuafacturingDate;
	}
	public void setManuafacturingDate(String manuafacturingDate) {
		this.manuafacturingDate = manuafacturingDate;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getNameType() {
		return nameType;
	}
	public void setNameType(String nameType) {
		this.nameType = nameType;
	}
	public int getSo_yen() {
		return so_yen;
	}
	public void setSo_yen(int so_yen) {
		this.so_yen = so_yen;
	}
	public int getTien_coc() {
		return tien_coc;
	}
	public void setTien_coc(int tien_coc) {
		this.tien_coc = tien_coc;
	}
	public int getSo_ghe_sau() {
		return so_ghe_sau;
	}
	public void setSo_ghe_sau(int so_ghe_sau) {
		this.so_ghe_sau = so_ghe_sau;
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
	

	public boolean match(RentalData bike) {
		if (bike == null)
			return true;
		
		
		if (bike.id != null && !bike.id.equals("") && !this.id.contains(bike.id)) {
			return false;
		}
		
		if (bike.name != null && !bike.name.equals("") && !this.name.contains(bike.name)) {
			return false;
		}
		
		return true;
	}

}