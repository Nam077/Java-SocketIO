package Services;

import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserService {
    public ConnectDB connectDB = new ConnectDB();
    public Connection conn = connectDB.getConnection();

    public boolean insertUser(User user) {
        try {
            String password = user.getPassword();
            SecurityRSA securityRSA = new SecurityRSA();
            String passwordEncrypt = securityRSA.encrypt(password);

            String sql = "INSERT INTO user(`name`, `email`, `password`, `address`, `phone`, `date`, `code`, `role`) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, passwordEncrypt);
            pst.setString(4, user.getAddress());
            pst.setString(5, user.getPhone());
            pst.setString(6, user.getDate());
            pst.setString(7, user.getCode());
            pst.setString(8, user.getRole());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //update user to database and return true if success else return false
    public boolean updateUser(User user) {
        try {

            String password = user.getPassword();
            SecurityRSA securityRSA = new SecurityRSA();
            password = securityRSA.encrypt(password);
            System.out.println(user);
            String sql = "UPDATE user SET `name`=?, `email`=?, `password`=?, `address`=?, `phone`=?, `date`=?, `code`=?, `role`=? WHERE `id`=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, password);
            pst.setString(4, user.getAddress());
            pst.setString(5, user.getPhone());
            pst.setString(6, user.getDate());
            pst.setString(7, user.getCode());
            pst.setString(8, user.getRole());
            pst.setInt(9, user.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    ///delete user from database input object User and return true if success else return false
    public boolean deleteUser(User user) {
        try {
            String sql = "DELETE FROM user WHERE `id`=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, user.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    ///kiểu muốn làm theo hướng đối tượng ấy cho nó chuẩn luôn chứ truyền vớ vẩn vào ko thích hahah
    ///checkLogin start check email after check password
    public User checkLogin(User user) {
        //check email exist
        try {
            String sql = "SELECT * FROM user WHERE `email`=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getEmail());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                //check password
                String password = rs.getString("password");
                SecurityRSA securityRSA = new SecurityRSA();
                password = securityRSA.decrypt(password);
                if (password.equals(user.getPassword())) {
                    //get user
                    User user1 = new User();
                    user1.setId(rs.getInt("id"));
                    user1.setName(rs.getString("name"));
                    user1.setEmail(rs.getString("email"));
                    user1.setPassword(rs.getString("password"));
                    user1.setAddress(rs.getString("address"));
                    user1.setPhone(rs.getString("phone"));
                    user1.setDate(rs.getString("date"));
                    user1.setCode(rs.getString("code"));
                    user1.setRole(rs.getString("role"));
                    return user1;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    //get ArrayList<User> from database and return ArrayList<User>
    ///hiểu cái này ko?
    //// ý là nó sẽ lấy ra tất cả các user trong database
    ///xong nó truyền tất cả vào ArrayList<User>
    public ArrayList<User> getAllUser() {
        ArrayList<User> list = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM user";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ///phần này nó sẽ tạo ra 1 đối tượng User mới
                User user = new User();
                //set du lieu cho user
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                String password = SecurityRSA.decrypt(rs.getString("password"));
                user.setPassword(password);
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setDate(rs.getString("date"));
                user.setCode(rs.getString("code"));
                user.setRole(rs.getString("role"));
                ///phần này nó sẽ thêm vào ArrayList<User>
                list.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        ///phần này nó sẽ trả về ArrayList<User>
        return list;
        ///hiểu chưa
    }

    ///get user from database input Object user by id and return User
    public User getUserById(User user) {
        try {
            String sql = "SELECT * FROM user WHERE `id`=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, user.getId());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setDate(rs.getString("date"));
                user.setCode(rs.getString("code"));
                user.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    //getUser where Id
    public User getUserById(int id) {
        try {
            String sql = "SELECT * FROM user WHERE `id`=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setDate(rs.getString("date"));
                user.setCode(rs.getString("code"));
                user.setRole(rs.getString("role"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //Search all row in database
    public ArrayList<User> Search(String search) {
        ArrayList<User> list = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM user WHERE `name` LIKE '%" + search + "%' OR `email` LIKE '%" + search + "%' OR `address` LIKE '%" + search + "%' OR `phone` LIKE '%" + search + "%' OR `date` LIKE '%" + search + "%' OR `code` LIKE '%" + search + "%' OR `role` LIKE '%" + search + "%'OR `id` LIKE '%" + search + "%'";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                String password = SecurityRSA.decrypt(rs.getString("password"));
                user.setPassword(password);
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setDate(rs.getString("date"));
                user.setCode(rs.getString("code"));
                user.setRole(rs.getString("role"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
