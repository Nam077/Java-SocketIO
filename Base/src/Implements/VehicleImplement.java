package Implements;

import Interfaces.VehicleInterface;
import Models.Vehicle;
import Services.VehicleService;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class VehicleImplement extends UnicastRemoteObject implements VehicleInterface {
    public VehicleService vehicleService = new VehicleService();

    public VehicleImplement() throws Exception {
        super();
    }


    @Override
    public ArrayList<Vehicle> getAllVehicle() throws Exception {
        return vehicleService.getAllVehicle();
    }

    @Override
    public Vehicle getVehicle(Vehicle vehicle) throws Exception {
        return null;
    }

    @Override
    public Boolean insertVehicle(Vehicle vehicle) throws Exception {
        return vehicleService.insertVehicle(vehicle);
    }

    @Override
    public Boolean updateVehicle(Vehicle vehicle) throws Exception {
        return vehicleService.updateVehicle(vehicle);
    }

    @Override
    public Boolean deleteVehicle(Vehicle vehicle) throws Exception {
        return vehicleService.deleteVehicle(vehicle);
    }

    @Override
    public ArrayList<Vehicle> searchVehicle(String search) throws Exception {
        return vehicleService.searchVehicle(search);
    }
}
