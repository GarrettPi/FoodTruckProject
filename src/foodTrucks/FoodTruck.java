package foodTrucks;

public class FoodTruck {

	private static int truckNumber = 1;
	private int uniqueID;
	private String name;
	private String foodType;
	private int rating;
	
	public FoodTruck(int uniqueID, String name, String foodType, int rating) {
		super();
		this.uniqueID = uniqueID;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}

	public int getUniqueID() {
		return uniqueID;
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

	public static int getTruckNumber() {
		return truckNumber;
	}

	public static void setTruckNumber(int truckNumber) {
		FoodTruck.truckNumber = truckNumber;
	}

	

}
