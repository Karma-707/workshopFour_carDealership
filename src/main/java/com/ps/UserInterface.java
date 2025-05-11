package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        //load dealership details
        this.dealership = DealershipFileManager.getDealership();
    }

    //Constructor
    public UserInterface() {
        init();
    }

    //Display all
    public void display() {
        //TODO: Create main menu method
        System.out.println("Welcome to the dealership program");
        int mainMenuCommand;

        do {
            System.out.println("1. Get by price");
            System.out.println("2. Get by make/model");
            System.out.println("3. Get by year range");
            System.out.println("4. Get by color");
            System.out.println("5. Get by mileage range");
            System.out.println("6. Get by type (car, truck, SUV, van)");
            System.out.println("7. Get ALL vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("0. Exit");

            System.out.print("Enter your command: ");
            mainMenuCommand = scanner.nextInt();

            //options switches
            switch(mainMenuCommand) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not found, try again");
            }

        } while (mainMenuCommand != 0);
    }

    //print price by user range
    private void processGetByPriceRequest() {
        System.out.println("Price Request Filter");

        //ask the user for a starting price & ending price
        System.out.print("Enter Minimum Price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter Maximum Price: ");
        double maxPrice = scanner.nextDouble();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);

        //display vehicles filtered by price
        if(filteredVehicles.isEmpty()) {
            System.out.println("No vehicles found in that price range");
        }
        else {
            System.out.println("Displaying Filtered Price Range");
            displayVehicles(filteredVehicles);
        }
    }

    //print model by user request
    private void processGetByMakeModelRequest() {
        System.out.println("Make/Model Request Filter");
        scanner.nextLine(); //eat white space

        //ask user for model to filter
        System.out.print("Enter Make: ");
        String make = scanner.nextLine().trim();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine().trim();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehiclesByMakeModel(make, model);

        //display vehicles filtered by make/model
        if(make.isEmpty() && model.isEmpty()) {
            System.out.println("You didn't enter any make or model to display");
        }
        else if (!make.isEmpty() && model.isEmpty()) {
            System.out.println("Display Filtered Make Range");
            if(filteredVehicles.isEmpty()) {
                System.out.println("Sorry no vehicle of your search");
            }
            else {
                displayVehicles(filteredVehicles);
            }
        }
        else if (make.isEmpty() && !model.isEmpty()) {
            System.out.println("Display Filtered Model Range");
            if(filteredVehicles.isEmpty()) {
                System.out.println("Sorry no vehicle of your search");
            }
            else {
                displayVehicles(filteredVehicles);
            }
        }
        else {
            System.out.println("Display Filtered Make & Model Range");
            if(filteredVehicles.isEmpty()) {
                System.out.println("Sorry no vehicle of your search");
            }
            else {
                displayVehicles(filteredVehicles);
            }
        }

    }

    //print year by user request
    private void processGetByYearRequest() {
        System.out.println("Year Request Filter");

        //ask user for year range to filter
        System.out.print("Enter Minimum Year: ");
        double minYear = scanner.nextDouble();
        System.out.print("Enter Maximum Year: ");
        double maxYear = scanner.nextDouble();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehiclesByYear(minYear, maxYear);

        //display vehicles filtered by year range
        if(filteredVehicles.isEmpty()) {
            System.out.println("No vehicles found in that year range");
        }
        else {
            System.out.println("Displaying Filtered Year Range");
            displayVehicles(filteredVehicles);
        }
    }

    //print color by user request
    private void processGetByColorRequest() {
        System.out.println("Color Request Filter");
        scanner.nextLine(); //eat white space

        //ask user for color to filter
        System.out.print("Enter Color: ");
        String color = scanner.nextLine().trim();

        ArrayList<Vehicle> filteredVehicles = dealership.getVehiclesByColor(color);

        //display vehicles filtered by color
        if(color.isEmpty()) {
            System.out.println("You didn't enter any color to display");
        }
        else if(filteredVehicles.isEmpty()) {
            System.out.println("No vehicles found in that color");
        }
        else {
            System.out.println("Displaying Filtered Color");
            displayVehicles(filteredVehicles);
        }
    }

    private void processGetByMileageRequest() {

    }

    private void processGetByVehicleTypeRequest() {

    }

    //print all vehicles
    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.println("Displaying All Vehicles");
        displayVehicles(vehicles);
    }

    private void processAddVehicleRequest() {

    }

    private void processRemoveVehicleRequest() {

    }


    //helper method to print vehicles in array list
    private static void displayVehicles(ArrayList<Vehicle> vehicles) {
        for(Vehicle vehicle: vehicles) {
            System.out.print(vehicle);
        }
    }


}
