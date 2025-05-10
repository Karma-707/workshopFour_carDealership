package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        //load dealership details
        dealership = DealershipFileManager.getDealership();
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

    private void processGetByPriceRequest() {
        System.out.println("Price Request Filter");
        System.out.print("Enter starting price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter ending price: ");
        double maxPrice = scanner.nextDouble();



        //TODO: ask the user for a starting price & ending price
        ArrayList<Vehicle> filteredVehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);

        //Display vehicles = print
        if(filteredVehicles.isEmpty()) {
            System.out.println("No vehicles found in that price range");
        }
        else {
            //TODO: Print using method
            displayVehicles(filteredVehicles);
        }

    }

    private void processGetByMakeModelRequest() {

    }

    private void processGetByYearRequest() {

    }

    private void processGetByColorRequest() {

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
//            System.out.printf("Vin: %-6d Year: %-5d Make: %-10s Model: %-10s Vehicle Type: %10s Color: %s Odometer: %-10d Price: %.2f\n",
//                    vehicle.getVin(),
//                    vehicle.getYear(),
//                    vehicle.getMake(),
//                    vehicle.getModel(),
//                    vehicle.getVehicleType(),
//                    vehicle.getColor(),
//                    vehicle.getOdometer(),
//                    vehicle.getPrice()
//            );
        }
    }




}
