package com.distillery.foodtruck.app;

import java.util.Scanner;

public class FoodTruckApp {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// instantiating an instance of this class to remove the need for static methods
		FoodTruckApp fta = new FoodTruckApp();
		// creating the array to hold the food truck
		FoodTruck[] foodTrucks = new FoodTruck[5];
		int trucksEntered = 0; // used to determine whether to quit and as index for the FoodTruck[]
		boolean keepGoing = true;
		System.out.println(
				"-----Welcome to the Food Truck Database!-----\nThe easiest way to store and rate your favorite mobile hot spots!\n\n");
		// Data entry loop
		while (trucksEntered < 5) {
			// variables for instantiating FoodTrucks
			String name;
			String foodType;
			int rating;
			// data entry storage
			String response;
			System.out.println(
					"Please enter the name of the Food Truck you'd like to store:\n(enter \"quit\" to proceed to the menu)");
			name = scanner.nextLine();
			// quits the program if quit is entered and no trucks have been instantiated
			if (name.equals("quit") && trucksEntered == 0) {
				System.out
						.println("No trucks entered and you have chosen to quit.\nThank you for using Food Trucks App");
				break;
			} else if (name.equals("quit") && trucksEntered > 0) {
				break; // exits this loop to enter main menu loop
			}

			System.out.printf("What type of food does %s sell?\n", name);
			foodType = scanner.nextLine();
			System.out.printf("How good is the %s from %s, on a scale of 1-10?\n", foodType, name);
			rating = scanner.nextInt();
			scanner.nextLine();
			// instantiates the truck and increments the counter for the index
			foodTrucks[trucksEntered] = fta.addFoodTruck(name, foodType, rating);
			trucksEntered++;

		}
		// main menu loop
		while (trucksEntered > 0 && keepGoing) { // condition skips this loop if quit is called pre entry of truck
			fta.displayMenu();
			int menuChoice = scanner.nextInt();
			keepGoing = fta.activateMenuOption(menuChoice, foodTrucks);
		}

	}
	// sends new truck to ctor and adds to array
	public FoodTruck addFoodTruck(String name, String foodType, int rating) {
		FoodTruck foodTruck = new FoodTruck(name, foodType, rating);
		System.out.println("\nFood Truck Added: " + foodTruck.getName() + "\n");
		return foodTruck;
	}
	// prints the menu
	public void displayMenu() {
		System.out.println(
				"\nMain Menu\nPlease Make a Selection:\n1) View all Food Trucks\n2) See Average Food Truck Ratings\n3) See the Highest-Rated Food Truck\n4) Quit the Program");

	}
	// processes menu input
	public boolean activateMenuOption(int menuChoice, FoodTruck[] foodTrucks) {
		switch (menuChoice) {
		case 1:
			listFoodTrucks(foodTrucks);
			break;
		case 2:
			calculateFoodTruckAverage(foodTrucks);
			break;
		case 3:
			findHighestRating(foodTrucks);
			break;
		case 4:
			System.out.println("\nThank you for using The Food Truck Database!\n");
			return false;
		default:
			System.out.println("Invalid Selection.  Please Try Again.");
		} return true;
	}
	// lists all FoodTrucks in array
	public void listFoodTrucks(FoodTruck[] foodTrucks) {
		for (FoodTruck foodTruck : foodTrucks) {
			if (foodTruck != null) { // discounts nulls in array
				System.out.println(foodTruck);
			}
		}
	}
	// calculates average of FoodTruck ratings
	public void calculateFoodTruckAverage(FoodTruck[] foodTrucks) {
		double average = 0.0;
		int truckCount = 0;
		for (FoodTruck foodTruck : foodTrucks) {
			if (foodTruck != null) { // discounts nulls in array
				average += foodTruck.getRating();
				truckCount++;
			}
		}
		average /= truckCount;
		System.out.printf("\nThe average rating of all food trucks in our database is %.2f out of 10.\n", average);

	}
	// determines highest-rated FoodTruck and displays all FT data
	public void findHighestRating(FoodTruck[] foodTrucks) {
		int highest = foodTrucks[0].getRating();
		int highestId = foodTrucks[0].getUniqueID();
		String highestName = foodTrucks[0].getName();
		String highestFood = foodTrucks[0].getFoodType();
		FoodTruck bestFoodTruck = null;
		for (int i = 0; i < foodTrucks.length; i++) {
			if (foodTrucks[i] != null && foodTrucks[i].getRating() > highest) {
				highest = foodTrucks[i].getRating();
				highestName = foodTrucks[i].getName();
				highestFood = foodTrucks[i].getFoodType();
				highestId = foodTrucks[i].getUniqueID();
				bestFoodTruck = foodTrucks[i];
			}
		}
		System.out.printf(
				"\nThe highest rated food truck in our database is truck No.%d,\n%s, which sells delicious %s.  It was rated %d points out of 10!\n",
				highestId, highestName, highestFood, highest);
		System.out.println(bestFoodTruck);

	}

}
