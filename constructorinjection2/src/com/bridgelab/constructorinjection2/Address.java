package com.bridgelab.constructorinjection2;

public class Address {
	private String name;
	private String city;
	private String country;
	public Address(String name, String city, String country) {
		super();
		this.name = name;
		this.city = city;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [name=" + name + ", city=" + city + ", country=" + country + "]";
	}
	

}
