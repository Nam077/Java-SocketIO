package Services;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB {
	 private static String DB_URL = "jdbc:mysql://localhost:3306/"+ReadConfig.getVariable("NAME_DATABASE");
	    public static Connection getConnection() {
	        Connection conn = null;
	        try {
	        	String username = ReadConfig.getVariable("USER_DATABASE");
	        	String password = ReadConfig.getVariable("PASS_DATABASE");
	            conn = DriverManager.getConnection(DB_URL, username , password);
	            System.out.println("Kết nối ok");
	        } catch (Exception ex) {
	            System.out.println("Kết nối thất bại !");
	            ex.printStackTrace();
	        }
	        return conn;
	    }
}
