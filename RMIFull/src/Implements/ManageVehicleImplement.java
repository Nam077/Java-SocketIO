package Implements;

import Interfaces.ManageVehicleInterface;
import Models.ManageVehicle;
import Services.ManageVehicleService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ManageVehicleImplement extends UnicastRemoteObject implements ManageVehicleInterface {
    public ManageVehicleService manageVehicleService = new ManageVehicleService();

    public ManageVehicleImplement() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<ManageVehicle> getAllManageVehicle() throws Exception {
        return manageVehicleService.getAllManageVehicle();
    }

    @Override
    public ManageVehicle getManageVehicle(ManageVehicle manageVehicle) throws Exception {
        return null;
    }

    @Override
    public Boolean insertManageVehicle(ManageVehicle manageVehicle) throws Exception {
        return manageVehicleService.insertManageVehicle(manageVehicle);
    }

    @Override
    public Boolean updateManageVehicle(ManageVehicle manageVehicle) throws Exception {
        return manageVehicleService.updateManageVehicle(manageVehicle);
    }

    @Override
    public Boolean deleteManageVehicle(ManageVehicle manageVehicle) throws Exception {
        return manageVehicleService.deleteManageVehicle(manageVehicle);
    }

    @Override
    public ArrayList<ManageVehicle> searchManageVehicle(String search) throws Exception {
        return manageVehicleService.searchManageVehicle(search);
    }
}
