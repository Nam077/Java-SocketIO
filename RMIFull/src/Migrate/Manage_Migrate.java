package Migrate;

import Services.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Manage_Migrate {
    //get connection from Services / ConnectDB class and return connection
    ConnectDB connectDB = new ConnectDB();
    Connection conn = connectDB.getConnection();
    public boolean createTableManage() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS manage_vehicle (id int primary key auto_increment, user_id int, name varchar(255), vehicle_id int, date varchar(255), plate varchar(255))";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        //run createTableManage() method
        Manage_Migrate manage_migrate = new Manage_Migrate();
        manage_migrate.createTableManage();
    }
}
