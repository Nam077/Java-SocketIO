package Interfaces;

import Models.Vehicle;

import java.rmi.Remote;
import java.util.ArrayList;

public interface VehicleInterface extends Remote {
    public ArrayList<Vehicle> getAllVehicle() throws Exception;
    public Vehicle getVehicle(Vehicle vehicle) throws Exception;
    public Boolean insertVehicle(Vehicle vehicle) throws Exception;
    public Boolean updateVehicle(Vehicle vehicle) throws Exception;
    public Boolean deleteVehicle(Vehicle vehicle) throws Exception;
    public ArrayList<Vehicle> searchVehicle(String search) throws Exception;

}
