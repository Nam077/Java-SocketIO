package Models;

import Implements.UserImplement;
import Implements.VehicleImplement;
import Interfaces.UserInterface;
import Interfaces.VehicleInterface;

import java.rmi.registry.LocateRegistry;

//class Server RMI and registry UserInterface
public class Server {
    public  Server() {
        try {
            //Tạo LocateRegistry để lấy địa chỉ của Registry ở port 1099
            LocateRegistry.createRegistry(1099);
            // tạo một đối tượng UserInterface
            UserInterface userInterface = new UserImplement();
            VehicleInterface vehicleInterface = new VehicleImplement();
            // Register the server
            LocateRegistry.getRegistry().rebind("UserInterface", userInterface);
            LocateRegistry.getRegistry().rebind("VehicleInterface", vehicleInterface);
            //get Rmi registry full url UserInterface and VehicleInterface
            System.out.println("Server is running");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}