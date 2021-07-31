package com.distillery.foodtruck.app;

import java.util.Scanner;

public class FoodTruckApp {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		FoodTruckApp fta = new FoodTruckApp();

		FoodTruck[] foodTrucks = new FoodTruck[5];
		int trucksEntered = 0;

		// main program loop
		while (trucksEntered < 5) {
			String name;
			String foodType;
			int rating;
			String response;
			System.out.println("Please enter the name of the Food Truck:\n(enter \"quit\" to proceed to the menu)");
			name = scanner.nextLine();

			if (name.equals("quit") && trucksEntered == 0) {
				System.out
						.println("No trucks entered and you have chosen to quit.\nThank you for using Food Trucks App");
				break;
			} else if (name.equals("quit") && trucksEntered > 0) {
				break;
			}

			System.out.printf("What type of food does %s sell?\n", name);
			foodType = scanner.nextLine();
			System.out.printf("How good is the %s from %s, on a scale of 1-10?\n", foodType, name);
			rating = scanner.nextInt();
			scanner.nextLine();
			foodTrucks[FoodTruck.getTruckNumber() - 1] = fta.addFoodTruck(name, foodType, rating);
			trucksEntered++;

		}

		while (trucksEntered > 0) {
			fta.displayMenu();
			int menuChoice = scanner.nextInt();
			switch (menuChoice) {
			case 1:
				fta.listFoodTrucks(foodTrucks);
				break;
			case 2:
				fta.calculateFoodTruckAverage(foodTrucks);
			case 3:
			case 4:
				return;
			default:
				System.out.println("Invalid Selection.  Please Try Again.");
			}
		}

	}

	public FoodTruck addFoodTruck(String name, String foodType, int rating) {
		FoodTruck foodTruck = new FoodTruck(name, foodType, rating);
		System.out.println("\nFood Truck Added:\n" + foodTruck + "\n");
		return foodTruck;
	}

	public void displayMenu() {
		System.out.println(
				"Main Menu\nPlease Make a Selection:\n1) View all Food Trucks\n2) See Average Food Truck Ratings\n3) See the Highest-Rated Food Truck\n4) Quit the Program");

	}

	public void listFoodTrucks(FoodTruck[] foodTrucks) {
		for (FoodTruck foodTruck : foodTrucks) {
			if (foodTruck != null) {
				System.out.println(foodTruck);
			}
		}
	}

	public void calculateFoodTruckAverage(FoodTruck[] foodTrucks) {
		double average = 0.0;
		for (FoodTruck foodTruck : foodTrucks) {
			if (foodTruck != null) {
				average += foodTruck.getRating();
//				System.out.println(average);
			}
		}
		average /= foodTrucks.length;
		System.out.printf("\nThe average of all food trucks in our database is %.2f", average);

	}

}
