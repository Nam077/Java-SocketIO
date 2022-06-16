package Models;

import java.io.Serializable;

public class ManageVehicle implements Serializable {
    int id;
    int user_id;
    String name;
    int vehicle_id;
    String date;
    String plate;
    public ManageVehicle(int id, int user_id, String name, int vehicle_id, String date, String plate) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.vehicle_id = vehicle_id;
        this.date = date;
        this.plate = plate;
    }
    public ManageVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getVehicle_id() {
        return vehicle_id;
    }
    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getPlate() {
        return plate;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }
    @Override
    public String toString() {
        return "Manage [id=" + id + ", user_id=" + user_id + ", name=" + name + ", vehicle_id=" + vehicle_id + ", date="
                + date + ", plate=" + plate + "]";
    }


}
