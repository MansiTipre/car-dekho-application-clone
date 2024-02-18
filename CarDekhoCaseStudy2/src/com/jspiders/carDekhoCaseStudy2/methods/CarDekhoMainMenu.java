package com.jspiders.carDekhoCaseStudy2.methods;


import java.sql.SQLException;
import java.util.Scanner;

import com.jspiders.carDekhoCaseStudy2.operations.CarOperations;

public class CarDekhoMainMenu {
	
	 public static void mainMenu() {
			 System.out.println("===== Menu =====\n" 
	                 + "1.View all cars\n" 
				     + "2.Search cars\n" 
	                 + "3.Add cars\n"
				     + "4.Remove car\n" 
	                 + "5.Update car Price\n" 
				     + "6.Exit\n");
		}
	 
	 
	 public static void searchCar() throws SQLException {
			boolean loop2=true;
			while (loop2) {
				System.out.println("======= Search cars =======\n"
						+"1. Search car by Id\n"
			            +"2. Search cars by name\n"
						+"3. Search cars by price\n"
						+"4. Search cars by brand\n"
						+"5. Search cars by fuelType\n"
						+"6. Search cars by Color\n"
						+"7. Go back");
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter your choice");
				int choice1 = scanner.nextInt();
				switch (choice1) {
				case 1: {
					System.out.println("Search cars by ID");
					carOperation.searchCarById(scanner);
					break;
				}
				case 2: {
					System.out.println("Search cars by name");
					carOperation.searchCarByName(scanner);
					break;
				}
				case 3: {
					System.out.println("Search cars by price");
					carOperation.searchCarByPrice(scanner);
					break;
				}
				case 4: {
					System.out.println("Search cars by brand");
					carOperation.searchCarByBrand(scanner);
					break;
				}
				case 5: {
					System.out.println("Search cars by fuelType");
					carOperation.searchCarByFuel(scanner);
					//mainMenu();
					
					break;
				}
				case 6: {
					System.out.println("Search cars by color");
					carOperation.searchCarByColor(scanner);
					break;
				}
				case 7: {
					mainMenu();
					loop2=false;
					break;
				}
				default:{
					System.out.println("Invalid choice...please try again");
					//mainMenu();
					//loop2=false;
				}
				}
			}
		}
	 
//	 public static void admin() {
//		 System.out.println("Enter 1 to sing up\nEnter 2 to log in");
//		 Scanner scanner = new Scanner(System.in);
//		 int choice=scanner.nextInt();
//		 switch (choice) {
//		case 1: {
//			CarOperations.singUp(scanner);
//			break;
//		}
//		case 2: {
//			CarOperations.logIn(scanner);
//			break;
//		}
//		default:
//			System.out.println("Error");
//		}
//	 }
	 
	 static CarOperations carOperation = new CarOperations();
	 
	 
		public static void main(String[] args) throws SQLException {
	
            CarOperations.admin();
//			mainMenu();
			boolean loop = true;
			while (loop) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter your choice");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1: {
					carOperation.allCars();
					mainMenu();
					break;
				}
				case 2: {
					searchCar();
					mainMenu();
					break;
				}
				case 3: {
					carOperation.addCar(scanner);
					mainMenu();
					break;
				}
				case 4: {
					carOperation.removeCar(scanner);
					mainMenu();
					break;
				}
				case 5: {
					carOperation.updateCar(scanner);
					mainMenu();
					
					break;
				}
				case 6: {
					loop = false;
					System.out.println("Thank you...\n Visit again");
					break;
				}
				default: {
					System.out.println("Invalid choice...please try again");
					mainMenu();
					break;
				}
				}
			}

		}


}
