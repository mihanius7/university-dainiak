package com.belhard;

import java.util.Objects;

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

	@Override
	public String toString() {
		String output = country.toUpperCase() + ", " + city + ", " + street + ", " + house;
		if (flat != 0)
			output = output.concat(" - " + flat);
		if (postalCode != 0)
			output = output.concat(", " + postalCode);
		output = output.concat(". ");
		return output;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + flat;
		result = prime * result + house;
		result = prime * result + (int) (postalCode ^ (postalCode >>> 32));
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(street, other.street) && flat == other.flat && house == other.house
				&& postalCode == other.postalCode;
	}

}
