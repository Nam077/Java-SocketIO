package Interfaces;

import Models.ManageVehicle;

import java.rmi.Remote;
import java.util.ArrayList;

public interface ManageVehicleInterface extends Remote {
    public ArrayList<ManageVehicle> getAllManageVehicle() throws Exception;
    public ManageVehicle getManageVehicle(ManageVehicle manageVehicle) throws Exception;
    public Boolean insertManageVehicle(ManageVehicle manageVehicle) throws Exception;
    public Boolean updateManageVehicle(ManageVehicle manageVehicle) throws Exception;
    public Boolean deleteManageVehicle(ManageVehicle manageVehicle) throws Exception;
    public ArrayList<ManageVehicle> searchManageVehicle(String search) throws Exception;

}
