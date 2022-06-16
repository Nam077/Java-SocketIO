package Services;

import Models.Manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManageService {
    //get connection from ConnectDB class and return connection
    ConnectDB connectDB = new ConnectDB();
    Connection conn = connectDB.getConnection();

    //Object Manage with id,user_id,name,vehicle_id,date,plate
    //insert Manage input object Manage and return true if success else return false
    public boolean insertManage(Manage manage) {
        try {
            String sql = "INSERT INTO manage(`user_id`, `name`, `vehicle_id`, `date`, `plate`) VALUES(?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, manage.getUser_id());
            pst.setString(2, manage.getName());
            pst.setInt(3, manage.getVehicle_id());
            pst.setString(4, manage.getDate());
            pst.setString(5, manage.getPlate());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //update Manage input object Manage and return true if success else return false
    public boolean updateManage(Manage manage) {
        try {
            String sql = "UPDATE manage SET `user_id`=?, `name`=?, `vehicle_id`=?, `date`=?, `plate`=? WHERE `id`=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, manage.getUser_id());
            pst.setString(2, manage.getName());
            pst.setInt(3, manage.getVehicle_id());
            pst.setString(4, manage.getDate());
            pst.setString(5, manage.getPlate());
            pst.setInt(6, manage.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //delete Manage input object Manage and return true if success else return false
    public boolean deleteManage(Manage manage) {
        try {
            String sql = "DELETE FROM manage WHERE `id`=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, manage.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //get ArrayList of Manage from database and return ArrayList of Manage
    public ArrayList<Manage> getAllManage() {
        ArrayList<Manage> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM manage";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Manage manage = new Manage();
                manage.setId(rs.getInt("id"));
                manage.setUser_id(rs.getInt("user_id"));
                manage.setName(rs.getString("name"));
                manage.setVehicle_id(rs.getInt("vehicle_id"));
                manage.setDate(rs.getString("date"));
                manage.setPlate(rs.getString("plate"));
                list.add(manage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //get Manage from database in with id and return Manage
    public Manage getManageById(int id) {
        Manage manage = new Manage();
        try {
            String sql = "SELECT * FROM manage WHERE `id`=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                manage.setId(rs.getInt("id"));
                manage.setUser_id(rs.getInt("user_id"));
                manage.setName(rs.getString("name"));
                manage.setVehicle_id(rs.getInt("vehicle_id"));
                manage.setDate(rs.getString("date"));
                manage.setPlate(rs.getString("plate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return manage;
    }
    //create table Manage and return true if success else return false

}

