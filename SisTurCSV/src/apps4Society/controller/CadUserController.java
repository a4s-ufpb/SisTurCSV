package apps4Society.controller;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import apps4Society.dao.User_control;
import apps4Society.model.User;
import cUtils.MeuCalendario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CadUserController implements Initializable{
	@FXML
	private TextField nomecad;
	@FXML
	private TextField logincad;
	@FXML
	private TextField emailcad;
	@FXML
	private TextField senhacad;
	@FXML
	private TextField codigocad;
	
	private Alert alert;
	private Alert alert_sucess;
	private Alert alert_information;
	
	private MeuCalendario mycalendar;
	
	
	
	
	@FXML
	private void cadUser() throws ClassNotFoundException, UnsupportedEncodingException, NoSuchAlgorithmException, SQLException {
		mycalendar = new MeuCalendario();
		
		alert = new Alert(Alert.AlertType.ERROR);
		alert_sucess = new Alert(Alert.AlertType.CONFIRMATION);
		
		if(nomecad.getText().toString().isEmpty() || logincad.getText().toString().isEmpty()
				|| emailcad.getText().toString().isEmpty() ||
				senhacad.getText().toString().isEmpty() || codigocad.getText().toString().isEmpty()) {
			alert.setTitle("Erro no Cadastro!");
			alert.setContentText("Preencha os campos corretamente!");
			alert.showAndWait();
		}else {
			String data = mycalendar.emitirData();
			String nome = nomecad.getText().toString();
			String login = logincad.getText().toString();
			String email = emailcad.getText().toString();
			String senha = senhacad.getText().toString();
			String codigo = codigocad.getText().toString();
			User u = new User(nome,login,email,senha,codigo,data);
			User_control dt = new User_control();
			dt.CadaddUser(u);
			
			alert_sucess.setTitle("Usuario Cadastrado!");
			alert_sucess.setContentText("Usuario cadastrado com sucesso!");
			alert_sucess.show();
			
			limparCampos();
			
		}
		
	}
	@FXML
	private void btnCancel() {
		alert_information = new Alert(Alert.AlertType.INFORMATION);
		alert_information.setTitle("Operacao cancelada!");
		alert_information.setContentText("Operacao Cancelada!");
		alert_information.show();
		limparCampos();
		
	}
	public void limparCampos() {
		nomecad.setText("");
		logincad.setText("");
		emailcad.setText("");
		senhacad.setText("");
		codigocad.setText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
