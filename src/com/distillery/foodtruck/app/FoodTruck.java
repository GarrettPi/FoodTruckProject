package com.distillery.foodtruck.app;

public class FoodTruck {
	// declaring/intializing private fields
	private static int truckNumber = 1;
	private int uniqueID;
	private String name;
	private String foodType;
	private int rating;
	// ctor
	public FoodTruck(String name, String foodType, int rating) {
		this.uniqueID = truckNumber;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		truckNumber++; //incrementing static field for Id assignment
	}

	public int getUniqueID() {
		return uniqueID;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FoodTruck [ID: ");
		builder.append(uniqueID);
		builder.append(", name: ");
		builder.append(name);
		builder.append(", foodType: ");
		builder.append(foodType);
		builder.append(", rating: ");
		builder.append(rating);
		builder.append("]");
		return builder.toString();
	}

	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	// almost left in static methods for the truckNumber get and set YIKES!
}
