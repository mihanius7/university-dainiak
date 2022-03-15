package com.belhard.university;

public class Address {
	private String country;
	private String city;
	private String street;
	private int house;
	private int flat;
	private long postalCode;

	public Address(String country, String city, String street, int house) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.house = house;
	}

	public Address(String country, String city, String street, int house, int flat) {
		this(country, city, street, house);
		this.flat = flat;
	}

	public Address(String country, String city, String street, int house, int flat, long postalCode) {
		this(country, city, street, house, flat);
		this.postalCode = postalCode;
	}

	public Address(String country, String city, String street, int house, long postalCode) {
		this(country, city, street, house);
		this.postalCode = postalCode;
	}

	public String toString() {
		String output = country + ", " + city + ", " + street + ", " + house;
		if (flat != 0)
			output = output.concat(" - " + flat);
		if (postalCode != 0)
			output = output.concat(", " + postalCode);
		return output;
	}
}
