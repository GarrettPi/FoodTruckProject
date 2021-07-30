package foodTruckProject;

import java.util.Scanner;

public class FoodTruckApp {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		FoodTruckApp fta = new FoodTruckApp();

		FoodTruck[] foodTrucks = new FoodTruck[5];

		// main program loop
		while (true) {
			String name;
			String foodType;
			int rating;
			int trucksEntered = 0;
			String response;
			System.out.println("Please enter the name of the Food Truck:\n(enter \"quit\" to proceed to the menu)");
			name = scanner.nextLine();

			if (name.equals("quit") && trucksEntered == 0) {
				System.out
						.println("No trucks entered and you have chosen to quit.\nThank you for using Food Trucks App");
				return;
			} else if (name.equals("quit") && trucksEntered > 0) {
				fta.displayMenu();
			}

			System.out.printf("What type of food does %s sell?", name);
			foodType = scanner.nextLine();
			System.out.printf("\nHow good is the %s from %s, on a scale of 1-10?", foodType, name);
			rating = scanner.nextInt();
			scanner.nextLine();
			foodTrucks[FoodTruck.getTruckNumber()-1] = fta.addFoodTruck(name, foodType, rating);

		}

	}

	public FoodTruck addFoodTruck(String name, String foodType, int rating) {
		FoodTruck foodTruck = new FoodTruck(name, foodType, rating);
		System.out.println(foodTruck);
		return foodTruck;
	}

	public void displayMenu() {
		System.out.println("PlaceHolder Menu");
	}
}
