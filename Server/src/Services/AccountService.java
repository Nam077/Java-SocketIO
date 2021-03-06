package Services;

import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountService {
    //get connection from ConnectDB
    Connection conn = ConnectDB.getConnection();
    SecurityRSA securityRSA = new SecurityRSA();
    public ArrayList<User> getListUser() {
        ArrayList<User> listUser = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setCode(rs.getString("code"));
                listUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }
    //check if email is exist
    public boolean checkEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //insert new user to database with model Users return message
    public Boolean insertUser(User user) {
       Boolean results = false;
        String sql = "INSERT INTO users (name, email, password, role, address, phone, code) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getRole());
            pst.setString(5, user.getAddress());
            pst.setString(6, user.getPhone());
            pst.setString(7, user.getCode());
            int rs = pst.executeUpdate();
            if (rs > 0) {
            	results = true;
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    //update user to database with model Users return message
    public String updateUser(User user) {
        String message = "";
        String sql = "UPDATE users SET name = ?, email = ?, password = ?, role = ?, address = ?, phone = ?, code = ? WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getRole());
            pst.setString(5, user.getAddress());
            pst.setString(6, user.getPhone());
            pst.setString(7, user.getCode());
            pst.setInt(8, user.getId());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                message = "Updated";
            } else {
                message = "Not Updated";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    //delete user to database with model Users return message
    public String deleteUser(User user) {
        String message = "";
        String sql = "DELETE FROM users WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, user.getId());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                message = "Deleted";
            } else {
                message = "Not Deleted";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    //get user from database with model Users return model Users with email
    public User getUser(String email) {
        User user = new User();
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setCode(rs.getString("code"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //get user from database with model Users return model Users with id
    public User getUser(int id) {
        User user = new User();
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setCode(rs.getString("code"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //check login with model Users return user
    public User checkLogin(User user) {
    	User userReturn = new User();
        //check account exit email after check password
        String sql = "SELECT * FROM users WHERE email = ? limit 1";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getEmail());
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
            	String password = securityRSA.decrypt(rs.getString("password"));
                if (password.equals(user.getPassword())) {
                    userReturn.setId(rs.getInt("id"));
                    userReturn.setName(rs.getString("name"));
                    userReturn.setEmail(rs.getString("email"));
                    userReturn.setPassword(rs.getString("password"));
                    userReturn.setRole(rs.getString("role"));
                    userReturn.setAddress(rs.getString("address"));
                    userReturn.setPhone(rs.getString("phone"));
                    userReturn.setCode(rs.getString("code"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userReturn;
    }

    public static void main(String[] args) {
		AccountService accountService = new AccountService();
		User user  = new User();
		user.setEmail("email0@gmail.com");
		user.setPassword("password0");
		System.out.println(accountService.checkLogin(user));
	}
}
