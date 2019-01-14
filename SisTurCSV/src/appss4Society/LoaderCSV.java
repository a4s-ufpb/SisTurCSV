package appss4Society;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import apps4Society.model.Municipios;
import apps4Society.model.AtrativoTuristico;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;

import Interf.Loggers_z;
import apps4Society.model.Praia;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;	
import org.slf4j.LoggerFactory;
import java.io.File;

public class LoaderCSV implements Loggers_z{
	
	private static ArrayList<Municipios> list_mun =  new ArrayList<Municipios>();
	private static ArrayList<AtrativoTuristico> list_atrativos = new ArrayList<AtrativoTuristico>();
	private static ArrayList<Praia> list_praias = new ArrayList<Praia>();
	
	/*
	 * Gerenciador de Logs!
	 */
	private final Logger slf4jLogger = LoggerFactory.getLogger(LoaderCSV.class);
	
	public LoaderCSV(){
		//list_mun = new ArrayList<Municipios>();
		
		
	}
	@Override
	public  void paths(String name) {
		// TODO Auto-generated method stub
		slf4jLogger.info("Path selecionado: " + name);
		
	}
	@Override
	public void arqs(String aqs) {
		// TODO Auto-generated method stub
		slf4jLogger.info("Arquivo txt Criado: " + aqs);
	}
	
	@Override
	public void inputs(String variaveis) {
		// TODO Auto-generated method stub
		slf4jLogger.info("Conteudo da Variavel: " + variaveis);
		
		
	}
	public ArrayList<Municipios> lerArquivosCSV_Municipio(String caminhoCSV, String path_log) throws IOException{
		try{
			
			paths(caminhoCSV);
			
			@SuppressWarnings("deprecation")
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
			String[] leitorLinhas; 
			
			String data = ""; // 0
			String imgUrl= ""; // 1
			String codvalidacao = ""; // 2
			String nomeCidade = ""; // 3
			String descricao = ""; // 4
			String area = ""; // 5
			String latitude = ""; // 6
			String longitude = ""; // 7
			String estado = ""; // 8
			String populacao = ""; // 9
			String site = ""; // 10
			String inf_relevante = ""; // 11
			String email_responsavel = ""; // 12
			String nome_responsavel = ""; // 13
			String contato_responsavel = ""; // 14
			String fonte_inf = ""; // 15
			
			while((leitorLinhas=leitor.readNext()) != null){
			
				 data = retireAspas(leitorLinhas[0].trim());
				 imgUrl=retireAspas(leitorLinhas[1].trim());
				 codvalidacao = retireAspas(leitorLinhas[2].trim());
				 nomeCidade = retireAspas(leitorLinhas[3].trim());
				 descricao = retireAspas(leitorLinhas[4].trim());
				 area = String.valueOf(retireAspas(leitorLinhas[5].trim()));
				 latitude = String.valueOf(retireAspas(leitorLinhas[6].trim()));
				 longitude = String.valueOf(retireAspas(leitorLinhas[7].trim()));
				 estado = retireAspas(leitorLinhas[8].trim());
				 populacao = retireAspas(leitorLinhas[9].trim());
				 site = retireAspas(leitorLinhas[10]);
				 inf_relevante = retireAspas(leitorLinhas[11].trim());
				 email_responsavel = retireAspas(leitorLinhas[12].trim());
				 fonte_inf = retireAspas(leitorLinhas[13].trim());
				 nome_responsavel = retireAspas(leitorLinhas[14].trim());
				 contato_responsavel = retireAspas(leitorLinhas[15].trim());
				 

				list_mun.add(new Municipios(
						data,
						imgUrl,
						codvalidacao,
						nomeCidade,
						descricao,
						area,
						latitude,
						longitude,
						estado,
						populacao,
						site,
						inf_relevante, 
						email_responsavel, 
						nome_responsavel , 
						contato_responsavel,
						fonte_inf
						
						));
				
				
			
			}
				
		}catch(NumberFormatException e){
			e.printStackTrace();
	}
		if(list_mun.size() != 0){
			int tamanhoVetor = list_mun.size();
			salvaLogs_municipios(list_mun , path_log , tamanhoVetor);
			
			System.err.println("Tamanho da lista municipios: "+list_mun.size());
		}
		return list_mun;
	}
	
	public ArrayList<AtrativoTuristico> lerArquivosCSV_AtrativoTuristico(String caminhoCSV, String path) throws IOException{
		try {
			paths(caminhoCSV);	
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
			String[] leitorLinhas;
			
			String date = ""; // 0
			String email_responsavel = ""; // 1
			String nomeAtrativo = ""; // 2
			String comoChegar = ""; // 3
			String descricao = ""; // 4
			String urlImg = "";//5
			String infContato = ""; // 6
			String latitude = ""; // 7
			String longitude = ""; // 8
			String link_at_maps = ""; // 9
			String site = ""; // 10
			String cidade = ""; // 11
			String estado = ""; // 12
			String nome_resp_at = ""; // 13
			String contato_resp_at = ""; // 14
			String email_resp_at = ""; // 15
			String inf_relevante = ""; // 16
			String fonte_inf = ""; // 17
			String contato_preenchimento = ""; // 18
			String nome_resp_preenchimento = ""; // 19
			String cod_validacao_preenchimento = ""; // 20
			
			while((leitorLinhas=leitor.readNext())!=null){
					date = retireAspas(leitorLinhas[0].trim()); // 0
					 email_responsavel = retireAspas(leitorLinhas[1].trim()); // 1
					nomeAtrativo = retireAspas(leitorLinhas[2].trim()); // 2
					comoChegar = retireAspas(leitorLinhas[3].trim()); // 3
					 descricao = retireAspas(leitorLinhas[4].trim()); // 4
					 urlImg = retireAspas(leitorLinhas[5].trim()); //5
					 infContato = retireAspas(leitorLinhas[6].trim()); // 6
					 latitude = retireAspas(leitorLinhas[7].trim()); // 7
					longitude = retireAspas(leitorLinhas[8].trim()); // 8
					 link_at_maps = retireAspas(leitorLinhas[9].trim()); // 9
					 site = retireAspas(leitorLinhas[10].trim()); // 10
					 cidade = retireAspas(leitorLinhas[11].trim()); // 11
					estado = retireAspas(leitorLinhas[12].trim()); // 12
					 nome_resp_at = retireAspas(leitorLinhas[13].trim()); // 13
					contato_resp_at = retireAspas(leitorLinhas[14].trim()); // 14
					 email_resp_at = retireAspas(leitorLinhas[15].trim()); // 15
					 inf_relevante = retireAspas(leitorLinhas[16].trim());// 16
					 fonte_inf = retireAspas(leitorLinhas[17].trim()); // 17
					contato_preenchimento = retireAspas(leitorLinhas[18].trim()); // 18
					 nome_resp_preenchimento = retireAspas(leitorLinhas[19].trim()); // 19
					cod_validacao_preenchimento = retireAspas(leitorLinhas[20].trim()); // 20
					
					list_atrativos.add(
							new AtrativoTuristico(
							date,email_responsavel,nomeAtrativo,
							comoChegar,descricao,urlImg,
							infContato,latitude,longitude,
							link_at_maps,site,cidade
							,estado,nome_resp_at,contato_resp_at,
							email_resp_at,inf_relevante,
							fonte_inf,contato_preenchimento,nome_resp_preenchimento,
							cod_validacao_preenchimento
							)
							);
					
				}		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(list_atrativos.size() != 0){
			int tamanhoVetor = list_atrativos.size();
			salvarLogs_turisticos(list_atrativos , path , tamanhoVetor);
			System.err.println("Tamanho da lista Atrativos: "+tamanhoVetor);
		}
		return list_atrativos;
	}
	public void salvarLogs_turisticos(ArrayList<AtrativoTuristico> list, String caminhoCSV , int tamanhoVETOR){
		try {

			File file = new File(caminhoCSV+"/"+"LOG_ATRATIVOS_TURISTICOS.txt"); // quebra de linha \r\n
			String dados_turismo = "";
			String conteudo;
			if(file!=null){
				System.out.println("Arquivo criado");
			}

			FileWriter arq = new FileWriter(file);
			arq.write("---------------------------------Apps4Society--------------------------------------");
			arq.write("\r\n");
			arq.write("\r\n");
			arq.write(" -                CONTROLE DE LOGS PARA ATRATIVOS TURISTICOS ARMAZENADOS -  ");
			arq.write("\r\n");
			arq.write("\r\n");
			arq.write("--------------- Relatorio de Atrativos Turisticos Salvos pelo Sistema ---------------------");
			arq.write("\r\n");
			for (int i = 0; i < list.size(); i++) {

				dados_turismo = "Nome do Atrativo Turistico: " + list.get(i).getNome_atrativo() + "\r\n" + "Como chegar: " + list.get(i).getComochegar()
						+ "\r\n" + "Descricao: " + list.get(i).getDescricao()+"\r\n"+"Informacoes Relevantes: "+list.get(i).getInformacoes_relevantes() + "\r\n" + "Latitude: " + list.get(i).getLatitude()
						+ "\r\n" + "Longitude: " + list.get(i).getLongitude()+"\r\n"+"Data: "+list.get(i).getDate()+"\r\n"+"Nome do Responsavel pelo Atrativo: "+list.get(i).getNome_responsavel_atrativo()+ "\r\n" + "Email Atrativo Turistico: "+list.get(i).getEmail_responsavel_atrativo()+"\r\n" + "Codigo de Validacao: "+list.get(i).getCodValidacao() + "\r\n" + "InfomaÃ§Ã£o Contato: " + list.get(i).getInfoContato() +
						"\r\n" + "Site: " + list.get(i).getSite() + "\r\n" + "Cidade do Atrativo: "+list.get(i).getCidade()+"\r\n"+"Estado do Atrativo: "+list.get(i).getEstado()+"\r\n"+"Email do responsavel pelo preenchimento: "+list.get(i).getEmail_responsavel_preenchimento()+"\r\n"+"Nome do responsavel pelo preenchimento: "+list.get(i).getNome_responsavel_preenchimento()+"\r\n"+"Contato Responsavel pelo preenchimento: "+list.get(i).getContato_responsavel_preenchimento()+"\r\n"+"----------------------------------------------------------------------------------------------------------------" + "\r\n";
				
				arq.write("\r\n");
				conteudo = dados_turismo;
				conteudo += "\r\n";

				arq.write(conteudo);

			}
			arq.write("\r\n");
			arq.write("Armazenados com sucesso!");
			arq.close();
			arqs("atrativos.txt!");
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
	
	
	public void salvaLogs_municipios(ArrayList<Municipios> list , String caminhoCSV, int lenLista){
		
		try {
			// File file = new
			
			
			
			File file = new File(caminhoCSV+"/"+"LOG_MUNICIPIOS.txt"); // quebra de linha \r\n
			String dados_muncipio = "";
			String conteudo;
			int lenListaCity = lenLista;
			if(file!=null){
				System.out.println("Arquivo criado");
			}

			FileWriter arq = new FileWriter(file);
			arq.write("---------------------------------Apps4Society--------------------------------------");
			arq.write("\r\n");
			arq.write("\r\n");
			arq.write(" -                CONTROLE DE LOGS PARA MUNICIPIOS ARMAZENADOS -");
			arq.write("\r\n");
			arq.write("\r\n");
			arq.write("--------------- Relatorio de Municipios Salvos pelo Sistema ---------------------");
			arq.write("\r\n");
			for (int i = 0; i < list.size(); i++) {

				dados_muncipio = "Data Preenchimento Formulario: "+list.get(i).getDate()+ "\r\n" +"Descricao: "+list.get(i).getDescricao() + "\r\n" +"Area Territorial: " + list.get(i).getAreaTerritorial() + "\r\n" + "Contato Responsavel pelo Preenchimento: " + list.get(i).getContatos_responsavel()
						+ "\r\n" + "Estado: " + list.get(i).getEstado() + "\r\n" + "Latitude: " + list.get(i).getLatitude()
						+ "\r\n" + "Longitude: " + list.get(i).getLongitude() + "\r\n" + "Nome: " + list.get(i).getNomecidade() + "\r\n" + "Populacaoo: " + list.get(i).getPopulacao()
						+ "\r\n" + "Nome Responsavel Preenchimento: "+list.get(i).getNome_responsavel()+ 
						"\r\n" +"Fonte de Informacoes: "+list.get(i).getFonte_informacoes()+
						"\r\n"+
						"Informacoes Relevantes: "+list.get(i).getInformacoesRelevantes()+ "\r\n" +"Email Responsavel Preenchimento: "+list.get(i).getEmail_responsavel()+ "\r\n" +"Site: " + list.get(i).getSite() + "\r\n" + "----------------------------------------------------------------------------------------------------------------" + "\r\n";
				
				arq.write("\r\n");
				conteudo = dados_muncipio;
				conteudo += "\r\n";

				arq.write(conteudo);

			}
			arq.write("\r\n");
			arq.write("Quantidade de Municipios Armazenados: " + lenListaCity);
			arq.write("\r\n");
			arq.write("Armazenados com sucesso!");
			arqs("municipios.txt");
			arq.close();

		} catch (IOException e) {
			e.printStackTrace();
			}
	}
	
	public String checkCamp(String qualquerCampo) {
		String aux = "";
		Pattern padrao = Pattern.compile("[a-z A-Z �-� �-� 0-9]+");
		Matcher m = padrao.matcher(qualquerCampo);
		int i = 1;
		while(m.find()) {
			aux+=m.group();
		}
		
		return aux;
	}
	
	
	public String checkLatLong(String lat) {
		String normal = lat;
		String[] saida = lat.split(",");
		if(saida.length>1) {
			String op = saida[0]+"."+saida[1];
			return op;
		}
		return normal;
	}
	
	public String retireVirgulas(String string) {
		return string.replace(",", ".");
	}
	
	public String retireAspas(String string) throws NullPointerException {
		 /*
		  * Nao encontrei um metodo na classe String que retira-se os espaÃ§os que o CSV do GOOGLE FORMS CRIA,
		  * entao criei esse metodo para retirar as aspas entre os atributos do municipios cadastrados no CSV
		  * a ideia do nome do arquivo ainda continua a mesma (municipios.csv Â«Â«); or atrativosTUristicos;
		  * 
		  * 
		  */
		String x="campo nao informado";
		String y="";
	
		if(string.length()==2) {
			return x;
		}else {
				String saida2 = null;
				String saida_normal = null;
				String[] saida = string.split("");
				
				for(int i = 1 ; i<saida.length -1 ; i ++){
					saida2+=saida[i];
				}
				
				String[] saida_original = saida2.split("");
				for(int i = 4; i< saida_original.length;i++){
						saida_normal += saida_original[i];
					
				}
				if(saida_normal.contains("null")){
					String[] vl = saida_normal.split("null");
					for( String s : vl){
						

							 x = s;
					}
		}
		 
		}		
		return x;
	
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
