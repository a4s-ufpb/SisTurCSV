package apps4Society.controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import apps4Society.dao.AtrativoTuristico_control;
import apps4Society.dao.Municipios_control;
import apps4Society.dao.Praia_control;
import apps4Society.model.AtrativoTuristico;
import apps4Society.model.Municipios;
import apps4Society.model.Praia;
import appss4Society.LoaderCSV;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

public class OpenButtonController implements Initializable{
	
	/*
	 * 
	 */
	private static ArrayList<Municipios> lista_municipios = new ArrayList<Municipios>();
	private static ArrayList<AtrativoTuristico> lista_Atrativo = new ArrayList<AtrativoTuristico>();
	private static ArrayList<Praia> list_praia = new ArrayList<Praia>();
	
	private static String caminho;
	private static String path_log;
	
	private static JButton localizararq;
	
	@FXML
	private Button button;
	
	@FXML
	private TextField fieldPath;
	
	@FXML
	private void openFolder(ActionEvent evento) {
		
		FileChooser arquivocsv = new FileChooser();
		arquivocsv.setTitle("Encontre o arquivo CSV");
		arquivocsv.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV", "*.csv"));
		File arquivo = arquivocsv.showOpenDialog(null);
		
		
       fieldPath.setText(arquivo.getAbsolutePath());

        caminho = arquivo.getAbsolutePath().toString();
        path_log = arquivo.getParent();
        
        String nomearq = arquivo.getName();
        System.out.println(arquivo.toString());
       
       try {
		verificaTipo(nomearq);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      
       
    }
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void verificaTipo(String p) throws SQLException, ClassNotFoundException, IOException{
		
		/*
		 * verifica o caminho do arquivo especificado, checa palavra por palavra do caminho até ser compativel com o nome
		 * do CSV especifico
		 * ex: /home/osvaldoairon/Documentos/praias.csv
		 *  ValidaPraia é igual a home?, osvaldoairon? ,Documentos?, praias.csv?
		 *  se sim ele carrega os metodos do CSV. 
		 */
		
		
		String validaPraia = "praias.csv";
		String validaMunicipio ="municipios.csv";
		String validaAtrativo = "atrativoTuristico.csv";
		boolean inter=false;
		
			if(p.equals(validaPraia)){
				carregarPraias(caminho);
				inter = false;
			}else if(p.equals(validaMunicipio)){
				carregarMunicipios(caminho , path_log);
				inter = false;
			}else if(p.equals(validaAtrativo)){
				carregarAtrativosTuristicos(caminho, path_log);
				inter =false;
			}else{
				inter=true;
			}
		
		if(inter){
			fieldPath.setText("CSV válido nao encontrado!");
			JOptionPane.showMessageDialog(null, "Porfavor coloque um arquivo com os requisitos necessários");
		}
	}
	
	public static void carregarPraias(String patch) throws SQLException, ClassNotFoundException{
		
		/*
		 * 	Tem como parametro o caminho do arquivo csv especificado.
		 * carrega a classe LoaderCSV que vai pegar os dados do CSV
		 * em seguida guarda a lista de objetos "Praias" no banco de dados chamando a classe praiaControl
		 */
		
		LoaderCSV loader_praia = new LoaderCSV();
		
		Praia_control praia = new Praia_control();
		
		list_praia = loader_praia.lerArquivosCSV_Praia(patch);
		
		if(list_praia != null){
			for(int i = 0 ; i < list_praia.size();i++){
				praia.addPraia(list_praia.get(i));
			}
			JOptionPane.showMessageDialog(null, "Dados do tipo Praias foram inseridos");
		}
	}
	public static void carregarAtrativosTuristicos(String patch, String path_log) throws SQLException, ClassNotFoundException, IOException{
		LoaderCSV loader_atrativo = new LoaderCSV();

		AtrativoTuristico_control a = new AtrativoTuristico_control();
		
		lista_Atrativo = loader_atrativo.lerArquivosCSV_AtrativoTuristico(patch , path_log);
		if(lista_Atrativo!=null){
			for(int i = 0 ; i <lista_Atrativo.size();i++){
				a.addAtratativoTuristico(lista_Atrativo.get(i));
			}
			JOptionPane.showMessageDialog(null, "Dados do tipo AtrativoTuristico foram inseridos");
			lista_Atrativo.clear();
			
		}else {
			JOptionPane.showMessageDialog(null, "Erro no carregamento do CSV MUNICIPIOS");
		}
		
		
	}
	
	public static void carregarMunicipios(String patch, String path_log) throws IOException, ClassNotFoundException, SQLException{
		LoaderCSV loader_muncipios = new LoaderCSV();
		Municipios_control n = new Municipios_control();
		
		lista_municipios = loader_muncipios.lerArquivosCSV_Municipio(patch, path_log);
		
		if(lista_municipios!=null){
			for(int i =0 ; i<lista_municipios.size();i++){
				n.addMunicipio(lista_municipios.get(i));
			}
			JOptionPane.showMessageDialog(null, "Dados do tipo Municipios foram inseridos");
			lista_municipios.clear();
		}else {
			JOptionPane.showMessageDialog(null, "Erro no carregamento CSV ATRATIVOS TURISTICOS");
		}
		
	}

}
