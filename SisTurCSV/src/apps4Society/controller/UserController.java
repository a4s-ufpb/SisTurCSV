package apps4Society.controller;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import apps4Society.dao.User_control;
import java.util.Date;
import cUtils.MeuCalendario;
//import application.CadUserWindow;
//import application.WindowCSV;


public class UserController implements Initializable{
	/*
	 * (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 * 
	 * Controler of View User
	 * CadUser
	 * LogINUser
	 */
	@FXML
	private Button entrar;
	
	@FXML 
	private TextField loginf;
	@FXML 
	private PasswordField pass_f;
	
	@FXML
	private PasswordField cod_f;
	
	private Alert dialogError;
	private MeuCalendario mycalendar;

	private static boolean verific;

	public void showHints() {
		pass_f = new PasswordField();
		pass_f.setPromptText("Insira a senha aqui");
		cod_f = new PasswordField();
		cod_f.setPromptText("Insira o codigo administrador aqui");
	}
	@FXML
	private void cadInterface(ActionEvent event) throws Exception {
	//	new CadUserWindow().start(new Stage());
	}

	@FXML
	private void loginUser(ActionEvent event) throws Exception {
		/*
		 * Event of acess User to System. Botton
		 * Verificar a entrada de dados do usuario ( evitar entradas vazias!)
		 * imprimir senha invalida Caixa de texto ou aviso
		 */
		
		dialogError = new Alert(Alert.AlertType.ERROR);
		
		if(loginf.getText().toString().isEmpty() || pass_f.getText().toString().isEmpty()) {
			dialogError.setTitle("Erro de Login");
			dialogError.setContentText("Preencha os campos corretamente!");
			dialogError.showAndWait();
		}else {
			System.out.println("foi");
			User_control dt = new User_control();
			
			boolean saida = dt.efetuarLogin(loginf.getText().toString(),pass_f.getText().toString());
			validarLogin(saida);
			limparCampos();
			
		}
		
		
	}
	
	public void limparCampos() {
		loginf.setText("");
		pass_f.setText("");
		cod_f.setText("");
	}
	
	public void validarLogin(boolean valid) throws Exception {
		if(valid) {
			System.out.println("Login realizado!");
	//		new WindowCSV().start(new Stage());
		}else {
			System.err.println("Senha errada!");
			dialogError= new Alert(Alert.AlertType.ERROR);
			dialogError.setTitle("SENHA ERRADA!");
			dialogError.setContentText("Senha errada, tente novamente!");
			dialogError.show();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
