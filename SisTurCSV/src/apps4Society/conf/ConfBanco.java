package apps4Society.conf;
import java.sql.Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Interf.Loggers_z;
import application.Execute;

import java.sql.*;

public class ConfBanco implements Loggers_z{
	
	
	/*
	 * Gerenciador de Logs!
	 */
	private final static Logger slf4jLogger = LoggerFactory.getLogger(ConfBanco.class);
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		Class.forName("org.postgresql.Driver");
		DriverManager.registerDriver(new org.postgresql.Driver());
		
		
		String user = "postgres";
		String password = "admin";
		String url = "jdbc:postgresql://192.168.0.108:5432/apps4Society";
		
	
		Connection com = DriverManager.getConnection(url,user,password);
		if(com!=null) {
			conexao("OK !");
		}else {
			conexao("error conexao BANCO !");
		}
		
		return com;
	}

	@Override
	public void paths(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void arqs(String arqs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputs(String variaveis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sucess(String msg_sucess) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(String msg_error) {
		// TODO Auto-generated method stub
		
	}

	
	public static void conexao(String cnc) {
		slf4jLogger.info("Conexao Result:" +cnc);
	}

	@Override
	public void connect(String cnc) {
		// TODO Auto-generated method stub
		
	}
	
	

}
