package Controllers;

import Models.Client;
import Models.ManageVehicle;
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
    public static Client client = new Client();

    public static void main(String[] args) {

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
                        ArrayList<Vehicle> listVehicle = client.getAllVehicle();
                        ArrayList<ManageVehicle> listManageVehicle = client.getAllManageVehicle();
                        addDataToTableManageVehicle(listManageVehicle);
                        addDataToComboBoxNameVehicleManage(listVehicle);
                        addDataToComboBoxNameUserManage(listUser);
                        addDataToTableUser(listUser);
                        addDataToTableVehicle(listVehicle);
                        manage.AuthUser.setText(userOutput.getName());
                        manage.setVisible(true);

                    } else {
                        login.notification("Login Failed");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        /////// Xử lý ở phần Logut//////////////////////////////
        manage.LogoutPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //show Dialog exit or login again
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    manage.setVisible(false);
                    login.setVisible(true);
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
                        addDataToComboBoxNameUserManage(listUser);
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
                        addDataToComboBoxNameUserManage(listUser);
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
                        addDataToComboBoxNameUserManage(listUser);
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
        ///thêm Vehicle vào database và load lại table
        manage.addVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vehicle vehicleInput = new Vehicle();
                String id = manage.idVehicle.getText();
                String name = manage.nameVehicle.getText();
                String color = manage.colorVehicle.getText();
                String type = manage.typeVehicle.getText();
                String date = manage.dateVehicle.getText();
                String seat_capacity = manage.seat_capacityVehicle.getText();
                String capacity = manage.capacityVehicle.getText();
                String brand = manage.brandVehicle.getText();
                vehicleInput.setId(Integer.parseInt(id));
                vehicleInput.setName(name);
                vehicleInput.setColor(color);
                vehicleInput.setType(type);
                vehicleInput.setDate(date);
                vehicleInput.setSeat_capacity(seat_capacity);
                vehicleInput.setCapacity(capacity);
                vehicleInput.setBrand(brand);
                try {
                    Boolean checkInsert = client.insertVehicle(vehicleInput);
                    if (checkInsert) {
                        manage.notification("Add Vehicle Successful");
                        ArrayList<Vehicle> listVehicle = client.getAllVehicle();
                        addDataToTableVehicle(listVehicle);
                        addDataToComboBoxNameVehicleManage(listVehicle);
                    } else {
                        manage.notification("Add Vehicle Failed");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ///sửa Vehicle vào database và load lại table
        manage.updateVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vehicle vehicleInput = new Vehicle();
                String id = manage.idVehicle.getText();
                String name = manage.nameVehicle.getText();
                String color = manage.colorVehicle.getText();
                String type = manage.typeVehicle.getText();
                String date = manage.dateVehicle.getText();
                String seat_capacity = manage.seat_capacityVehicle.getText();
                String capacity = manage.capacityVehicle.getText();
                String brand = manage.brandVehicle.getText();
                vehicleInput.setId(Integer.parseInt(id));
                vehicleInput.setName(name);
                vehicleInput.setColor(color);
                vehicleInput.setType(type);
                vehicleInput.setDate(date);
                vehicleInput.setSeat_capacity(seat_capacity);
                vehicleInput.setCapacity(capacity);
                vehicleInput.setBrand(brand);
                try {
                    Boolean checkUpdate = client.updateVehicle(vehicleInput);
                    if (checkUpdate) {
                        manage.notification("Update Vehicle Successful");
                        ArrayList<Vehicle> listVehicle = client.getAllVehicle();
                        addDataToTableVehicle(listVehicle);
                        addDataToComboBoxNameVehicleManage(listVehicle);
                        ArrayList<ManageVehicle> listManageVehicle = client.getAllManageVehicle();
                        addDataToTableManageVehicle(listManageVehicle);
                    } else {
                        manage.notification("Update Vehicle Failed");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ///xóa Vehicle vào database và load lại table
        manage.deleteVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vehicle vehicleInput = new Vehicle();
                vehicleInput.setId(Integer.parseInt(manage.idVehicle.getText()));
                String id = manage.idVehicle.getText();
                try {
                    Boolean checkDelete = client.deleteVehicle(vehicleInput);
                    if (checkDelete) {
                        manage.notification("Delete Vehicle Successful");
                        ArrayList<Vehicle> listVehicle = client.getAllVehicle();
                        addDataToTableVehicle(listVehicle);
                        addDataToComboBoxNameVehicleManage(listVehicle);
                    } else {
                        manage.notification("Delete Vehicle Failed");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ///tìm kiếm Vehicle theo tất cả các thuộc tính
        manage.searchVehicle.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                String search = manage.searchVehicle.getText();
                ArrayList<Vehicle> listVehicle = null;
                try {
                    listVehicle = client.searchVehicle(search);
                    addDataToTableVehicle(listVehicle);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        /////////////////////Xử lý ở phần ManageVehicle//////////////////////////////
        manage.tableManage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //get Model from to tableUser
                DefaultTableModel model = (DefaultTableModel) manage.tableManage.getModel();
                int row = manage.tableManage.getSelectedRow();
                manage.idManage.setText(model.getValueAt(row, 0) + "");
                manage.nameUserManage.setSelectedItem(model.getValueAt(row, 1) + "");
                manage.nameManage.setText(model.getValueAt(row, 2) + "");
                manage.nameVehicleManage.setSelectedItem(model.getValueAt(row, 3) + "");
                manage.dateManage.setText(model.getValueAt(row, 4) + "");
                manage.plateManage.setText(model.getValueAt(row, 5) + "");

            }
        });
        //thêm ManageVehicle vào database và load lại table
        manage.addManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageVehicle manageVehicleInput = new ManageVehicle();
                String id = manage.idManage.getText();
                String nameUser = manage.nameUserManage.getSelectedItem().toString();
                String nameVehicle = manage.nameVehicleManage.getSelectedItem().toString();
                String date = manage.dateManage.getText();
                String plate = manage.plateManage.getText();
                String name = manage.nameManage.getText();
                manageVehicleInput.setId(Integer.parseInt(id));
                Integer id_user = getIdFromString(nameUser);
                manageVehicleInput.setUser_id(id_user);
                manageVehicleInput.setName(name);
                Integer id_vehicle = getIdFromString(nameVehicle);
                manageVehicleInput.setVehicle_id(id_vehicle);
                manageVehicleInput.setDate(date);
                manageVehicleInput.setPlate(plate);
                System.out.println(manageVehicleInput);
                try {
                    Boolean checkInsert = client.insertManageVehicle(manageVehicleInput);
                    if (checkInsert) {
                        manage.notification("Add Manage Vehicle Successful");
                        ArrayList<ManageVehicle> listManageVehicle = client.getAllManageVehicle();
                        addDataToTableManageVehicle(listManageVehicle);
                    } else {
                        manage.notification("Add Manage Vehicle Failed");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //sửa ManageVehicle vào database và load lại table
        manage.updateManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageVehicle manageVehicleInput = new ManageVehicle();
                String id = manage.idManage.getText();
                String nameUser = manage.nameUserManage.getSelectedItem().toString();
                String nameVehicle = manage.nameVehicleManage.getSelectedItem().toString();
                String date = manage.dateManage.getText();
                String plate = manage.plateManage.getText();
                String name = manage.nameManage.getText();
                System.out.println(name);
                manageVehicleInput.setId(Integer.parseInt(id));
                Integer id_user = getIdFromString(nameUser);
                manageVehicleInput.setUser_id(id_user);
                Integer id_vehicle = getIdFromString(nameVehicle);
                manageVehicleInput.setVehicle_id(id_vehicle);
                manageVehicleInput.setDate(date);
                manageVehicleInput.setPlate(plate);
                manageVehicleInput.setName(name);
                try {
                    Boolean checkUpdate = client.updateManageVehicle(manageVehicleInput);
                    if (checkUpdate) {
                        manage.notification("Update Manage Vehicle Successful");
                        ArrayList<ManageVehicle> listManageVehicle = client.getAllManageVehicle();
                        addDataToTableManageVehicle(listManageVehicle);
                    } else {
                        manage.notification("Update Manage Vehicle Failed");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //xóa ManageVehicle vào database và load lại table
        manage.deleteManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageVehicle manageVehicle = new ManageVehicle();
                manageVehicle.setId(Integer.parseInt(manage.idManage.getText()));
                try {
                    Boolean checkDelete = client.deleteManageVehicle(manageVehicle);
                    if (checkDelete) {
                        manage.notification("Delete Manage Vehicle Successful");
                        ArrayList<ManageVehicle> listManageVehicle = client.getAllManageVehicle();
                        addDataToTableManageVehicle(listManageVehicle);
                    } else {
                        manage.notification("Delete Manage Vehicle Failed");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //tìm kiếm ManageVehicle theo tất cả các thuộc tính
        manage.searchManage.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                String search = manage.searchManage.getText();
                ArrayList<ManageVehicle> listManageVehicle = null;
                try {
                    listManageVehicle = client.searchManageVehicle(search);
                    addDataToTableManageVehicle(listManageVehicle);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

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

    //add Data to table ManageTable
    public static void addDataToTableManageVehicle(ArrayList<ManageVehicle> manageVehicles) {
        DefaultTableModel modelManage = new DefaultTableModel();
        Object columns[] = {"ID", "User Name", "Name", "Vehicle Name", "Date", "Plate"};
        modelManage = new DefaultTableModel(columns, 0);
        //add data to table
        for (ManageVehicle manageVehicle : manageVehicles) {
            User user = getUserById(manageVehicle.getUser_id());
            Vehicle vehicle = getVehicleById(manageVehicle.getVehicle_id());
            Object[] row = {manageVehicle.getId(), user.getName() + " - " + user.getId(), manageVehicle.getName(), vehicle.getName() + " - " + vehicle.getId(), manageVehicle.getDate(), manageVehicle.getPlate()};
            modelManage.addRow(row);
        }
        manage.tableManage.setModel(modelManage);
    }

    //get User by id
    public static User getUserById(int id) {
        User user = null;
        try {
            user = client.getUserById(id);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return user;
    }

    //get Name Vehicle by id
    ///get VehicleById
    public static Vehicle getVehicleById(int id) {
        Vehicle vehicle = new Vehicle();
        try {
            vehicle = client.getVehicleById(id);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return vehicle;
    }

    //add data to combobox nameUserManage
    public static void addDataToComboBoxNameUserManage(ArrayList<User> listUser) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (User user : listUser) {
            model.addElement(user.getName() + " - " + user.getId());
        }
        manage.nameUserManage.setModel(model);

    }

    //add data to combobox nameVehicleManage
    public static void addDataToComboBoxNameVehicleManage(ArrayList<Vehicle> listVehicle) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (Vehicle vehicle : listVehicle) {

            model.addElement(vehicle.getName() + " - " + vehicle.getId());

        }
        manage.nameVehicleManage.setModel(model);
    }

    public static int getIdFromString(String str) {
        String[] arr = str.split(" - ");
        return Integer.parseInt(arr[1]);
    }


}
