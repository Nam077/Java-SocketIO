package Interfaces;

import Models.User;

import java.rmi.Remote;
import java.util.ArrayList;

public interface UserInterface extends Remote {
    public User getUser(User user) throws Exception;
    public ArrayList<User> getAllUser() throws Exception;
    public Boolean insertUser(User user) throws Exception;
    public Boolean updateUser(User user) throws Exception;
    public Boolean deleteUser(User user) throws Exception;
    public ArrayList<User> SearchUser(String search) throws Exception;
    public User checkLogin(User user) throws Exception;
}
