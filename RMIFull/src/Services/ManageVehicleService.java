package Services;

import Models.ManageVehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManageVehicleService {
    //get connection from ConnectDB class and return connection
    ConnectDB connectDB = new ConnectDB();
    Connection conn = connectDB.getConnection();

    //Object Manage with id,user_id,name,vehicle_id,date,plate
    //insert ManageVehicle
    public Boolean insertManageVehicle(ManageVehicle manageVehicle) {
        try {
            String sql = "INSERT INTO manage_vehicle(user_id,name,vehicle_id,date,plate) VALUES(?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, manageVehicle.getUser_id());
            pst.setString(2, manageVehicle.getName());
            pst.setInt(3, manageVehicle.getVehicle_id());
            pst.setString(4, manageVehicle.getDate());
            pst.setString(5, manageVehicle.getPlate());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //update ManageVehicle
    public Boolean updateManageVehicle(ManageVehicle manageVehicle) {
        try {
            String sql = "UPDATE manage_vehicle SET user_id=?,name=?,vehicle_id=?,date=?,plate=? WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, manageVehicle.getUser_id());
            pst.setString(2, manageVehicle.getName());
            pst.setInt(3, manageVehicle.getVehicle_id());
            pst.setString(4, manageVehicle.getDate());
            pst.setString(5, manageVehicle.getPlate());
            pst.setInt(6, manageVehicle.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //delete ManageVehicle
    public Boolean deleteManageVehicle(ManageVehicle manageVehicle) {
        try {
            String sql = "DELETE FROM manage_vehicle WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, manageVehicle.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //get all ManageVehicle
    public ArrayList<ManageVehicle> getAllManageVehicle() {
        ArrayList<ManageVehicle> manageVehicles = new ArrayList<>();
        try {
            String sql = "SELECT * FROM manage_vehicle";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ManageVehicle manageVehicle = new ManageVehicle();
                manageVehicle.setId(rs.getInt("id"));
                manageVehicle.setUser_id(rs.getInt("user_id"));
                manageVehicle.setName(rs.getString("name"));
                manageVehicle.setVehicle_id(rs.getInt("vehicle_id"));
                manageVehicle.setDate(rs.getString("date"));
                manageVehicle.setPlate(rs.getString("plate"));
                manageVehicles.add(manageVehicle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manageVehicles;
    }
    //Search ManageVehicle all attribute
    public ArrayList<ManageVehicle> searchManageVehicle(String search) {
        ArrayList<ManageVehicle> manageVehicles = new ArrayList<>();
        try {
            String sql = "SELECT * FROM manage_vehicle WHERE id LIKE '%" + search + "%' OR user_id LIKE '%" + search + "%' OR name LIKE '%" + search + "%' OR vehicle_id LIKE '%" + search + "%' OR date LIKE '%" + search + "%' OR plate LIKE '%" + search + "%'";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ManageVehicle manageVehicle = new ManageVehicle();
                manageVehicle.setId(rs.getInt("id"));
                manageVehicle.setUser_id(rs.getInt("user_id"));
                manageVehicle.setName(rs.getString("name"));
                manageVehicle.setVehicle_id(rs.getInt("vehicle_id"));
                manageVehicle.setDate(rs.getString("date"));
                manageVehicle.setPlate(rs.getString("plate"));
                manageVehicles.add(manageVehicle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manageVehicles;
    }

}

