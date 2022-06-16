package Controllers;

import Models.Client;
import Models.User;
import Models.Vehicle;
import Views.Login;
import Views.Manage;
import Views.Register;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class RunClient {
    public static Login login = new Login();
    public static Register register = new Register();
    public static Manage manage = new Manage();


    public static void main(String[] args) {
        Client client = new Client();
        /////////////////////Xử lý ở phần Login//////////////////////////////
        login.reg_btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                register.setVisible(true);
            }
        });
        login.submit_btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User userInput = new User();
                userInput.setEmail(login.emailLogin.getText());
                userInput.setPassword(login.passwordLogin.getText());
                try {
                    User userOutput = client.checkLogin(userInput);
                    if (userOutput != null) {
                        login.notification("Login Successful");
                        login.setVisible(false);
                        ArrayList<User> listUser = client.getAllUser();
                        addDataToTableUser(listUser);
                        manage.setVisible(true);
                    } else {
                        login.notification("Login Failed");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        /////////////////////Xử lý ở phần Register//////////////////////////////
        register.login_btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register.setVisible(false);
                login.setVisible(true);
            }
        });
        register.submit_btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User userInput = new User();
                String email = register.emailRegister.getText();
                String password = register.passwordRegister.getText();
                String name = register.nameRegister.getText();


                if (validateRegister(email, password, name)) {
                    userInput.setEmail(email);
                    userInput.setPassword(password);
                    userInput.setName(name);
                    userInput.setRole("User");
                    try {
                        Boolean checkInsert = client.insertUser(userInput);
                        if (checkInsert) {
                            register.notification("Register Successful");
                            register.setVisible(false);
                            login.setVisible(true);
                        } else {
                            register.notification("Register Failed");
                        }

                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        /////////////////////Xử lý ở phần Manage//////////////////////////////
        /////////////////////Xử lý ở phần Manage User//////////////////////////////
        manage.tableUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //get Model from to tableUser
                DefaultTableModel model = (DefaultTableModel) manage.tableUser.getModel();
                int row = manage.tableUser.getSelectedRow();
                Object[] columns = {"ID", "Name", "Email", "Password", "Address", "Phone", "Date", "Code", "Role"};
                manage.idUser.setText(model.getValueAt(row, 0) + "");
                manage.nameUser.setText(model.getValueAt(row, 1) + "");
                manage.emailUser.setText(model.getValueAt(row, 2) + "");
                manage.passwordUser.setText(model.getValueAt(row, 3) + "");
                manage.addressUser.setText(model.getValueAt(row, 4) + "");
                manage.phoneUser.setText(model.getValueAt(row, 5) + "");
                manage.dateUser.setText(model.getValueAt(row, 6) + "");
                manage.codeUser.setText(model.getValueAt(row, 7) + "");
                manage.roleUser.setSelectedItem(model.getValueAt(row, 8) + "");


            }
        });
        ///thêm User vào database và load lại table
        manage.addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User userInput = new User();
                String id = manage.idUser.getText();
                String name = manage.nameUser.getText();
                String email = manage.emailUser.getText();
                String password = manage.passwordUser.getText();
                String address = manage.addressUser.getText();
                String phone = manage.phoneUser.getText();
                String date = manage.dateUser.getText();
                String code = manage.codeUser.getText();
                String role = manage.roleUser.getSelectedItem().toString();

                userInput.setName(name);
                userInput.setEmail(email);
                userInput.setPassword(password);
                userInput.setAddress(address);
                userInput.setPhone(phone);
                userInput.setDate(date);
                userInput.setCode(code);
                userInput.setRole(role);
                try {
                    Boolean checkInsert = client.insertUser(userInput);
                    if (checkInsert) {
                        manage.notification("Add User Successful");
                        ArrayList<User> listUser = client.getAllUser();
                        addDataToTableUser(listUser);
                    } else {
                        manage.notification("Add User Failed");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ///sửa User vào database và load lại table
        manage.updateUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User userInput = new User();
                String id = manage.idUser.getText();
                String name = manage.nameUser.getText();
                String email = manage.emailUser.getText();
                String password = manage.passwordUser.getText();
                String address = manage.addressUser.getText();
                String phone = manage.phoneUser.getText();
                String date = manage.dateUser.getText();
                String code = manage.codeUser.getText();
                String role = manage.roleUser.getSelectedItem().toString();
                userInput.setId(Integer.parseInt(id));
                userInput.setName(name);
                userInput.setEmail(email);
                userInput.setPassword(password);
                userInput.setAddress(address);
                userInput.setPhone(phone);
                userInput.setDate(date);
                userInput.setCode(code);
                userInput.setRole(role);
                System.out.println(userInput);
                try {
                    Boolean checkUpdate = client.updateUser(userInput);
                    if (checkUpdate) {
                        manage.notification("Update User Successful");
                        ArrayList<User> listUser = client.getAllUser();
                        addDataToTableUser(listUser);
                    } else {
                        manage.notification("Update User Failed");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ///xóa User vào database và load lại table
        manage.deleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User userInput = new User();
                userInput.setId(Integer.parseInt(manage.idUser.getText()));
                String id = manage.idUser.getText();
                try {
                    Boolean checkDelete = client.deleteUser(userInput);
                    if (checkDelete) {
                        manage.notification("Delete User Successful");
                        ArrayList<User> listUser = client.getAllUser();
                        addDataToTableUser(listUser);
                    } else {
                        manage.notification("Delete User Failed");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //tìm kiếm User theo tất cả các thuộc tính
        manage.searchUser.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                String search = manage.searchUser.getText();
                ArrayList<User> listUser = null;
                try {
                    listUser = client.searchUser(search);
                    addDataToTableUser(listUser);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        /////////////////////Xử lý ở phần Manage Vehicle//////////////////////////////
        manage.tableVehicle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //get Model from to tableUser
                DefaultTableModel model = (DefaultTableModel) manage.tableVehicle.getModel();
                int row = manage.tableVehicle.getSelectedRow();
                Object[] columns = {"ID", "Name", "Color", "Type", "Date", "Seat Capacity", "Capacity", "Brand"};
                manage.idVehicle.setText(model.getValueAt(row, 0) + "");
                manage.nameVehicle.setText(model.getValueAt(row, 1) + "");
                manage.colorVehicle.setText(model.getValueAt(row, 2) + "");
                manage.typeVehicle.setText(model.getValueAt(row, 3) + "");
                manage.dateVehicle.setText(model.getValueAt(row, 4) + "");
                manage.seat_capacityVehicle.setText(model.getValueAt(row, 5) + "");
                manage.capacityVehicle.setText(model.getValueAt(row, 6) + "");
                manage.brandVehicle.setText(model.getValueAt(row, 7) + "");
            }
        });
    }



    //validate register email, password, name
    public static boolean validateRegister(String email, String password, String name) {
        //check email not empty
        if (email.isEmpty()) {
            register.notification("Email is empty");
            return false;
        }
        //check email format
        if (!validateEmail(email)) {
            register.notification("Email is invalid");
            return false;
        }
        //check password not empty
        if (password.isEmpty()) {
            register.notification("Password is empty");
            return false;
        }
        //check password length
        if (password.length() < 6) {
            register.notification("Password is too short is less than 6 characters");
            return false;
        }
        //check name not empty
        if (name.isEmpty()) {
            register.notification("Name is empty");
            return false;
        }

        return true;
    }

    public static boolean validateEmail(String email) {
        return Pattern.matches("[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*", email);
    }

    public static void addDataToTableUser(ArrayList<User> listUser) {
        DefaultTableModel modelUser = new DefaultTableModel();
        Object[] columns = {"ID", "Name", "Email", "Password", "Address", "Phone", "Date", "Code", "Role"};
        modelUser = new DefaultTableModel(columns, 0);
        //add data to table
        for (User user : listUser) {
            Object[] row = {user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhone(), user.getDate(), user.getCode(), user.getRole()};
            modelUser.addRow(row);
        }
        manage.tableUser.setModel(modelUser);
    }

    //add Data to table VehicleTable
    public static void addDataToTableVehicle(ArrayList<Vehicle> listVehicle) {
        DefaultTableModel modelVehicle = new DefaultTableModel();

        Object[] columns = {"ID", "Name", "Color", "Type", "Date", "Seat Capacity", "Capacity", "Brand"};
        modelVehicle = new DefaultTableModel(columns, 0);
        //add data to table
        for (Vehicle vehicle : listVehicle) {
            Object[] row = {vehicle.getId(), vehicle.getName(), vehicle.getColor(), vehicle.getType(), vehicle.getDate(), vehicle.getSeat_capacity(), vehicle.getCapacity(), vehicle.getBrand()};
            modelVehicle.addRow(row);
        }
        manage.tableVehicle.setModel(modelVehicle);
    }

}
