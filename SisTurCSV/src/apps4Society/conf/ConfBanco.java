package apps4Society.conf;
import java.sql.*;
public class ConfBanco {
	
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		String hostname="apps4society-2018.database.windows.net";
		String appDB = "apps4Society";
		String user = "rootosvaldo@apps4society-2018";
		String password = "7154819osvaldo-";
		String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=50;",hostname,appDB,user,password);
		
	
		Connection com = DriverManager.getConnection(url);
		if(com!=null) {
			System.err.println("conexao bem sucedida!");
		}
		
		return com;
	}
	
	

}
