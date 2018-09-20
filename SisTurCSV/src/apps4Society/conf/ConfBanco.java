package apps4Society.conf;
import java.sql.Connection;
import java.sql.*;

public class ConfBanco {
	
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		Class.forName("org.postgresql.Driver");
		DriverManager.registerDriver(new org.postgresql.Driver());
		
		String hostname="192.168.0.7";
		String appDB = "apps4Society";
		String user = "postgres";
		String password = "6036236";
		String url = "jdbc:postgresql://192.168.0.107:5432/apps4Society";
		
	
		Connection com = DriverManager.getConnection(url,user,password);
		if(com!=null) {
			System.err.println("conexao bem sucedida!");
		}
		
		return com;
	}
	
	

}
