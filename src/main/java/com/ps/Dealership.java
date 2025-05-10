package com.ps;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    //Constructors
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        //make new array list and put filter in it n return that
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        return filteredVehicles;
    }

    //TODO methods
//    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
//
//    }
//
//    public ArrayList<Vehicle> getVehiclesByYear(double min, double max) {
//
//    }
//
//    public ArrayList<Vehicle> getVehiclesByColor(String color) {
//
//    }
//
//    public ArrayList<Vehicle> getVehiclesByMileage(double min, double max) {
//
//    }
//
//    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
//
//    }
//

    //return vehicles list
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    //getter
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
