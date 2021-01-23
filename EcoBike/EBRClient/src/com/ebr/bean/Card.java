package com.ebr.bean;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("card")
@JsonSubTypes({ @Type(value = Card.class, name = "card") })
public class Card {
	private String id;
	private String name;
	private String securityCode;
	private String exprirationDate;
	private int money;
	
	public Card() {
		super();
	}
	public Card(String id,String name,String securityCode,String exprirationDate,int money
			) {
		this.id = id;
		this.name=name;
		this.securityCode=securityCode;
		this.exprirationDate=exprirationDate;
		this.money=money;
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
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getExprirationDate() {
		return exprirationDate;
	}
	public void setExprirationDate(String exprirationDate) {
		this.exprirationDate = exprirationDate;
	}
	@Override
	public String toString() {
		return "id: " + this.id + ", name: " + this.name + 
				", securityCode: " + this.securityCode+", exprirationDate: " + this.exprirationDate+ ", money: " + this.money;
	}
	public boolean match(Card card) {
		if (card == null)
			return true;
		
		
		if (card.id != null && !card.id.equals("") && !this.id.contains(card.id)) {
			return false;
		}
		if (card.name != null && !card.name.equals("") && !this.name.contains(card.name)) {
			return false;
		}
		if (card.securityCode != null && !card.securityCode.equals("") && !this.securityCode.contains(card.securityCode)) {
			return false;
		}
		if (card.exprirationDate != null && !card.exprirationDate.equals("") && !this.exprirationDate.contains(card.exprirationDate)) {
			return false;
		}
		if (card.money != 0 && this.money != card.money) {
			return false;
		}
		
		return true;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Card) {
			return this.id.equals(((Card) obj).id);
		}
		return false;
	}
}