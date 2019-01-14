package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Interf.Loggers_z;
import apps4Society.dao.AtrativoTuristico_control;
import apps4Society.dao.Municipios_control;
import apps4Society.dao.Praia_control;
import apps4Society.exceptions.CreateTableException;
import apps4Society.model.AtrativoTuristico;
import apps4Society.model.Municipios;
import apps4Society.model.Praia;
import appss4Society.LoaderCSV;
import java.util.Scanner;

public class Execute implements Loggers_z{

	private static ArrayList<Municipios> lista_municipios = new ArrayList<Municipios>();
	private static ArrayList<AtrativoTuristico> lista_Atrativo = new ArrayList<AtrativoTuristico>();
	private static ArrayList<Praia> list_praia = new ArrayList<Praia>();
	
	private static String caminho;
	private static String path_log;
	
	/*
	 * Gerenciador de Logs!
	 */
	private final static Logger slf4jLogger = LoggerFactory.getLogger(Execute.class);
	public static void main(String args[]) throws CreateTableException {
		String file = new File("").getAbsolutePath();
		readMe(file);
		pegaCaminho(args[0]);
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
	
	public static void readMe(String path) {

		try {
			File file = new File(path +"/"+"Readme.txt"); // quebra de linha \r\n
			if(file!=null){
				System.out.println("Arquivo Readme criado");
			}
			FileWriter arq = new FileWriter(file);
			arq.write("---------------------------------Apps4Society--------------------------------------");
			arq.write("\r\n");
			arq.write("\r\n");
			arq.write(" -               Arquivos CSV suportados: municipios.csv e atrativoTuristico.csv  -");
			arq.write("\r\n");
			arq.write(" - O caminho do arquivo deve ser passado via argumento ! ");
			arq.write("\r\n");
			arq.write("Exemplo Windows: C:\\\\Users\\\\osvaldoairon\\\\Desktop\\\\municipios.csv");
			arq.write("\r\n");
			arq.write("Exemplo Linux: /home/osvaldoairon/Documentos/atrativoTuristico.csv");
			arq.write("\r\n");
			arq.write("Obs: Nome dos arquivos csv DEVEM SER 'municipios.csv' ou 'atrativoTuristico.csv' ");
			arq.write("\r\n");
			arq.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void su(String msg_sucess) {
		slf4jLogger.info("Dados inseridos com sucesso Tipo: "  + msg_sucess);
	}
	public static void er(String msg_error) {
		slf4jLogger.info("Error, Tipo: "  + msg_error);
	}
	public static void pegaCaminho(String args) throws CreateTableException {
		
			
			caminho = args;
			
			if(caminho.equals("")) {
				er("Entrada Invalida!");
			}else {
				File arquivo = new File(caminho);
				
				 caminho = arquivo.getAbsolutePath().toString();
				
				 path_log = arquivo.getParent();
  
				  String nomearq = arquivo.getName();

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
	
		}
		
	public static void verificaTipo(String p) throws SQLException, ClassNotFoundException, IOException, CreateTableException{
		String validaPraia = "praias.csv";
		String validaMunicipio ="municipios.csv";
		String validaAtrativo = "atrativoTuristico.csv";
		boolean inter=false;
		
			if(p.equals(validaPraia)){
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
			er("Path - Insira o caminho de acordo com o exemplo");
			
		}
	}
	
	public static void carregarAtrativosTuristicos(String patch, String path_log) throws SQLException, ClassNotFoundException, IOException, CreateTableException{
		LoaderCSV loader_atrativo = new LoaderCSV();

		AtrativoTuristico_control a = new AtrativoTuristico_control();
		a.createTableAtrativo();
		lista_Atrativo = loader_atrativo.lerArquivosCSV_AtrativoTuristico(patch , path_log);
		if(lista_Atrativo!=null){
			for(int i = 0 ; i <lista_Atrativo.size();i++){
				a.addAtratativoTuristico(lista_Atrativo.get(i));
			}
			su("Atrativos Turisticos");
			lista_Atrativo.clear();
			
		}else {
			er("Atrativo Turistico CSV");
		}
		
		
	}
	
	public static void carregarMunicipios(String patch, String path_log) throws IOException, ClassNotFoundException, SQLException, CreateTableException{
		LoaderCSV loader_muncipios = new LoaderCSV();
		Municipios_control n = new Municipios_control();
		n.createTablesMunicipios();
		
		lista_municipios = loader_muncipios.lerArquivosCSV_Municipio(patch, path_log);
		
		if(lista_municipios!=null){
			for(int i =0 ; i<lista_municipios.size();i++){
				n.addMunicipio(lista_municipios.get(i));
			}
			su("Municipios");
			lista_municipios.clear();
		}else {
			er("Municipio CSV");
		}
		
	}
	@Override
	public void sucess(String msg_sucess) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void error(String msg_error) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void connect(String cnc) {
		// TODO Auto-generated method stub
		
	}

	
}
