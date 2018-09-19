package Interf;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import apps4Society.model.User;

public interface DataUser {
	
	public boolean verificUser(User user) throws ClassNotFoundException, SQLException;
	public void CadaddUser(User user) throws ClassNotFoundException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException;
	public User getUserInfo(String name);
	public void removeUser(String nomeUser, String codigoUser);
	public User searchUser(String nameUser , String codigoUser);
	public boolean efetuarLogin(String login, String pass) throws ClassNotFoundException, SQLException;
	public String creatCriptLoginVerific(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException;
}
