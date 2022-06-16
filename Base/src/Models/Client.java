package Models;

import Interfaces.UserInterface;
import Interfaces.VehicleInterface;

import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

public class Client {
    public  UserInterface userInterface;
    public VehicleInterface vehicleInterface;
    public Client () {
        try {
            // tạo một đối tượng UserInterface từ Server ở port 1099 và tên UserInterface
            userInterface = (UserInterface) LocateRegistry.getRegistry("localhost", 1099).lookup("UserInterface");
            vehicleInterface = (VehicleInterface) LocateRegistry.getRegistry("localhost", 1099).lookup("VehicleInterface");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<User> getAllUser() throws Exception {
        return userInterface.getAllUser();
    }
    public User getUser(User user) throws Exception {
        return userInterface.getUser(user);
    }
    public Boolean insertUser(User user) throws Exception {
        return userInterface.insertUser(user);
    }
    public Boolean updateUser(User user) throws Exception {
        return userInterface.updateUser(user);
    }
    public Boolean deleteUser(User user) throws Exception {
        return userInterface.deleteUser(user);
    }
    public ArrayList<User> searchUser(String search) throws Exception {
        return userInterface.SearchUser(search);
    }
    public User checkLogin(User user) throws Exception {
        return userInterface.checkLogin(user);
    }
    public ArrayList<Vehicle> getAllVehicle() throws Exception {
        return vehicleInterface.getAllVehicle();
    }
    public Vehicle getVehicle(Vehicle vehicle) throws Exception {
        return vehicleInterface.getVehicle(vehicle);
    }
    public Boolean insertVehicle(Vehicle vehicle) throws Exception {
        return vehicleInterface.insertVehicle(vehicle);
    }
    public Boolean updateVehicle(Vehicle vehicle) throws Exception {
        return vehicleInterface.updateVehicle(vehicle);
    }
    public Boolean deleteVehicle(Vehicle vehicle) throws Exception {
        return vehicleInterface.deleteVehicle(vehicle);
    }
    public ArrayList<Vehicle> searchVehicle(String search) throws Exception {
        return vehicleInterface.searchVehicle(search);
    }


}
