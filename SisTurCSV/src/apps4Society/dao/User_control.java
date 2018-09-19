package apps4Society.dao;

import apps4Society.conf.ConfBanco;
import apps4Society.model.User;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import Interf.DataUser;

public class User_control implements DataUser{
	

	
	protected final static String cript_M ="MD5";
	protected final static String format_String_hex="%02X";
	protected final static String COLUNA_LOGIN ="login";
	private   final static String COLUNA_PASS = "pass";
	private final static String COLUNA_COD = "codigo";
	
	

	public void CadaddUser(User user) throws ClassNotFoundException, SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		// utilizando a classe MD para criar o algoritmo de cript
		// pegando a senha do usuario em byte e utilizando o algoritmo da classe md
		// utilizando a classe Stringbuilder para criar uma Stringhexadecimal 
		// percorrendo cada byte do array de bytes do pass_hash
		// adicionando cada byte transformado no objeto hexString e por fim pegando a String do objeto
		// hexString
		
		String pass_user = user.getPass();
		
		final MessageDigest md = MessageDigest.getInstance(cript_M);
		final byte[] pass_hash = md.digest(pass_user.getBytes("UTF-8"));
		StringBuilder hexString = new StringBuilder();
		for(byte bb : pass_hash) {
			hexString.append(String.format(format_String_hex, 0xFF & bb));
		}
		String senhacript = hexString.toString();
		user.setPass(senhacript);
		
		
		if(verificUser(user)) {
			System.out.println("Usuario ja cadastrado!");
		}else {
			String sql = "INSERT INTO usuarios (nome,login,pass,email,codigo,date_acesso) VALUES (?,?,?,?,?,?)";
			
			
			Connection cx = ConfBanco.getConnection();
		
			PreparedStatement stat = (PreparedStatement)cx.prepareStatement(sql);
			
			stat.setString(1, user.getNome());
			stat.setString(2, user.getLogin());
			stat.setString(3, user.getPass());
			stat.setString(4, user.getEmail());
			
			
			
			stat.execute();
			stat.close();
			cx.close();
			System.out.println("Usuario cadastrado!");
		}
		
		
	}

	public User getUserInfo(String name) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public void removeUser(String nomeUser, String codigoUser) {
		// TODO Auto-generated method stub
		
	}

	public User searchUser(String nameUser, String codigoUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean verificUser(User user) throws ClassNotFoundException, SQLException {
		Connection cx = ConfBanco.getConnection();

		
		String sql = "SELECT login,pass FROM usuarios";
		PreparedStatement stat = (PreparedStatement)cx.prepareStatement(sql);
		
		ResultSet rx = stat.executeQuery();
		
		while(rx.next()) {
			String log = rx.getString("login");
			String pass = rx.getString("pass");
			if(user.getLogin().equals(log) && user.getPass().equals(pass)) {
				return true;
			}
				
		}
		cx.close();
		rx.close();
		stat.close();
		return false;
	}

	public boolean efetuarLogin(String login, String pass) throws ClassNotFoundException, SQLException {
		/*
		 * Codigo que faz a verificao se o usuario pode logar ou nao
		 * usando uma "autenticacao de dois fatores"
		 * com a senha criptografada e necessario verificar se a senha do usuario [e igual a mesma "hash"
		 * depois e verificado se o codigo que ele inseriu quando se cadastrou [e o codigo gravado
		 * pelo administrador do sistema.
		 */
		try{
			
			
			String pass_reali =creatCriptLoginVerific(pass);
			String login_query = "\'"+login+"\'";
			String pass_query = "\'"+pass_reali+"\'";
			
			Connection cx = ConfBanco.getConnection();
		//	System.err.println(pass_query);
		//	System.out.println(login_query);
			String sql = "SELECT login,pass FROM usuarios WHERE login="+login_query;
			//System.err.println(sql);
		
			PreparedStatement st = (PreparedStatement)cx.prepareStatement(sql);
			ResultSet rx = st.executeQuery();
			boolean condxStop = false;
			int cont=0;
			
			while(rx.next()) {
				//System.err.println("Entrou: "+rx.getString("login"));
				//System.err.println(rx.getString("pass"));
				cont ++;
				
				if(cont >= 2) {
					return false;
				}else {
					return true;
				}
				//String log = rx.getString("login");
				//String pas = rx.getString("pass");
				//String cod = rx.getString("codigo");
				
				/*
				 * if((codigo.equals(cod_p)) && (cod_p.equals(cod)) ){
					condxStop = true;
					return true;
					
				}
				
				if(condxStop) {
					break;
				}
				
				
			}
				 */
			}
				
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		
		return false;
	}

	@Override
	public String creatCriptLoginVerific(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	//	encoderB = new BCryptPasswordEncoder();
		 /*
		  * final MessageDigest md = MessageDigest.getInstance(cript_M);
		final byte[] pass_hash_login = md.digest(pass.getBytes("UTF-8"));
		StringBuilder hexString_log = new StringBuilder();
		for(byte bb : pass_hash_login) {
			hexString_log.append(String.format(format_String_hex, 0xFF & bb));
		}
		String senhacript_login = hexString_log.toString();
		  */
		//String senhacript_login = encoderB.encode(pass);
		//System.out.println("senha cript" +senhacript_login);
		//return senhacript_login;
		return "xd";
		
	}

	

}
