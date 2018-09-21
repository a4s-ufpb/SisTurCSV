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
	/*
	 * Problemas a serem resolvidos qualquer valor diferente do indice especificado , tera seu valor no banco trocado
	 * se forem dos mesmos tipos
	 * ele pega sempre a primeira linha de cada coluna, impossibilitando do usuario criar algum "nome referencia"
	 * na primeira linha do arquivo
	 */
	
	public void teste() throws IllegalStateException, IOException{
		/*
		 * Esse codigo no FIleReader permite que as primeiras linhas do arquivos nao sejam lidas
		 * dessa forma facilitando a compreensando do usuario para inserir os dados respectivos;
		 * 
		 * 
		 * CSVReader reader = new CSVReader(new FileReader("/home/osvaldoairon/Documentos/xd.csv"),',', '\t',1);
		 String[] linhas;
		 while((linhas=reader.readNext())!=null){
			 System.out.println(linhas[2]);
			
		 }
	}
		 */
		
		
	
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
	
	
	public ArrayList<Praia> lerArquivosCSV_Praia(String caminhoCSV){
		/*
		 * Indices
		 * nome = 0
		 * comochegar= 1
		 * descricao = 2
		 * infoContato = 3
		 * latitude = 4
		 * longitude =5
		 * perigotubarao =6
		 * propriabanho = 7
		 * tipoOrla=8
		 */
		try{
			
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
			String[] leitorLinhas;
			
			while((leitorLinhas=leitor.readNext()) != null){
				int x = leitorLinhas.length -1;				
				if(leitorLinhas[0].isEmpty() || leitorLinhas[1].isEmpty() || leitorLinhas[2].isEmpty() || leitorLinhas[6].isEmpty() || leitorLinhas[7].isEmpty() || leitorLinhas[8].isEmpty()){
					System.out.print("Preencha os dados corretamente");
				}else{
					list_praias.add(new Praia(leitorLinhas[0],leitorLinhas[1],leitorLinhas[2],leitorLinhas[3],Double.parseDouble(leitorLinhas[4]),Double.parseDouble(leitorLinhas[5]),leitorLinhas[6],leitorLinhas[7],leitorLinhas[8]));
					salvarLogs_praias(list_praias,caminhoCSV);
					
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.err.println("Tamanho da lista praia"+list_praias.size());
		return list_praias;
	}
	public ArrayList<Municipios> lerArquivosCSV_Municipio(String caminhoCSV, String path_log) throws IOException{
		/*
		 * Cria um objeto do tipo leitorCsv que carrega um arquivo do tipo csv;
		 * Ã© necessario passar um caminho do arquivo para que ele carregue;
		 * foi criado um array de string que percorre a cada iteraÃ§cao do leitor
		 * cada campo Ã© separado por virgula, desse modo ele retorna os dados da coluna 0
		 */
		
		/*
		 * Indices Para Municipios
		 * 0 = date
		 * 1= cep
		 * 2 = areaTerritorial
		 * 3 = estado
		 * 4 = latitude
		 * 5 = longitude
		 * 6 = nome
		 * 7 = populacao
		 * 8 = site
		 */
		try{
			
			paths(caminhoCSV);
			
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
			String[] leitorLinhas;
			
			String data = "";
			String imgUrl= "";
			String codvalidacao = "";
			String nomeCidade = "";
			String descricao = "";
			String area = "";
			String latitude = "";
			String longitude = "";
			String estado = "";
			String populacao = "";
			String site = "";
			String inf_relevante = "";
			String email_responsavel = "";
			String nome_responsavel = "";
			String contato_responsavel = "";
			String fonte_inf = "";
			
			while((leitorLinhas=leitor.readNext()) != null){
				int x = leitorLinhas.length -1;
				
				if(leitorLinhas[0].isEmpty()) {
					data="Data nao informada!";
				}else if(leitorLinhas[1].isEmpty()) {
					imgUrl = "Url nao informada!";
				}else if(leitorLinhas[2].isEmpty()) {
					codvalidacao="Codigo de Validacao nao informado";
				}else if(leitorLinhas[3].isEmpty()) {
					nomeCidade="Nome do municipio nao informado";
				}
				else if(leitorLinhas[4].isEmpty()) {
					descricao=" Descricao do municipio nao informado";
				}
				else if(leitorLinhas[5].isEmpty()) {
					area="Area do municipio nao informado";
				}
				else if(leitorLinhas[6].isEmpty()) {
					latitude="Latitude do municipio nao informado";
				}
				else if(leitorLinhas[7].isEmpty()) {
					longitude="Longitude do municipio nao informado";
				}
				else if(leitorLinhas[8].isEmpty()) {
					estado="Estado do municipio nao informado";
				}
				else if(leitorLinhas[9].isEmpty()) {
					populacao="Populacao do municipio nao informado";
				}
				else if(leitorLinhas[10].isEmpty()) {
					site="Site do municipio nao informado";
				}else if(leitorLinhas[11].isEmpty()) {
					inf_relevante="Informacoes Relevantes do municipio nao informado";
				}
				else if(leitorLinhas[12].isEmpty()) {
					email_responsavel="Email do Responsavel pelo preenchimento nao informado";
				}
				else if(leitorLinhas[13].isEmpty()) {
					nome_responsavel="Nome do Responsavel pelo preenchimento nao informado";
				}
				else if(leitorLinhas[14].isEmpty()) {
					contato_responsavel="contato do Responsavel pelo preenchimento nao informado";
				}
				else if(leitorLinhas[15].isEmpty()) {
					fonte_inf="Fonte de informacoes  do municipio nao informado";
				}
				else{
					 data = leitorLinhas[0].trim();
					 imgUrl= leitorLinhas[1].trim();
					 codvalidacao = checkCamp(leitorLinhas[2].trim());
					 nomeCidade = leitorLinhas[3].trim();
					 descricao = checkCamp(leitorLinhas[4].trim());
					 area = checkLatLong(leitorLinhas[5].trim());
					 latitude = checkLatLong(leitorLinhas[6].trim());
					 longitude = checkLatLong(leitorLinhas[7].trim());
					 estado = leitorLinhas[8].trim();
					 populacao = leitorLinhas[9].trim();
					 site = leitorLinhas[10].trim();
					 inf_relevante = checkCamp(leitorLinhas[11].trim());
					 email_responsavel = leitorLinhas[12].trim();
					 nome_responsavel = leitorLinhas[13].trim();
					 contato_responsavel = leitorLinhas[14].trim();
					 fonte_inf = checkCamp(leitorLinhas[15].trim());
			
		
					
					list_mun.add(new Municipios(data,imgUrl,codvalidacao,nomeCidade,descricao,area,Double.parseDouble(latitude),Double.parseDouble(longitude),estado,Integer.parseInt(populacao),site,inf_relevante, email_responsavel, nome_responsavel , contato_responsavel,fonte_inf));
					
	
				}
				
				
			}
		}catch(NumberFormatException e){
			
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
				int x = leitorLinhas.length -1;
				
				if(leitorLinhas[0].isEmpty()) {
					data="Data nao informada!";
				}else if(leitorLinhas[1].isEmpty()) {
					imgUrl = "Url nao informada!";
				}else if(leitorLinhas[2].isEmpty()) {
					codvalidacao="Codigo de Validacao nao informado";
				}else if(leitorLinhas[3].isEmpty()) {
					nomeCidade="Nome do municipio nao informado";
				}
				else if(leitorLinhas[4].isEmpty()) {
					descricao=" Descricao do municipio nao informado";
				}
				else if(leitorLinhas[5].isEmpty()) {
					area="Area do municipio nao informado";
				}
				else if(leitorLinhas[6].isEmpty()) {
					latitude="Latitude do municipio nao informado";
				}
				else if(leitorLinhas[7].isEmpty()) {
					longitude="Longitude do municipio nao informado";
				}
				else if(leitorLinhas[8].isEmpty()) {
					estado="Estado do municipio nao informado";
				}
				else if(leitorLinhas[9].isEmpty()) {
					populacao="Populacao do municipio nao informado";
				}
				else if(leitorLinhas[10].isEmpty()) {
					site="Site do municipio nao informado";
				}else if(leitorLinhas[11].isEmpty()) {
					inf_relevante="Informacoes Relevantes do municipio nao informado";
				}
				else if(leitorLinhas[12].isEmpty()) {
					email_responsavel="Email do Responsavel pelo preenchimento nao informado";
				}
				else if(leitorLinhas[13].isEmpty()) {
					nome_responsavel="Nome do Responsavel pelo preenchimento nao informado";
				}
				else if(leitorLinhas[14].isEmpty()) {
					contato_responsavel="contato do Responsavel pelo preenchimento nao informado";
				}
				else if(leitorLinhas[15].isEmpty()) {
					fonte_inf="Fonte de informacoes  do municipio nao informado";
				}
				else{
					data = retireAspas(leitorLinhas[0].trim());
					 imgUrl=retireAspas(leitorLinhas[1].trim());
					 codvalidacao = retireAspas(leitorLinhas[2].trim());
					 nomeCidade = retireAspas(leitorLinhas[1].trim());
					 descricao = checkCamp(retireAspas(leitorLinhas[2].trim()));
					 area = checkLatLong(retireAspas(leitorLinhas[3].trim()));
					 latitude = checkLatLong(retireAspas(leitorLinhas[4].trim()));
					 longitude = checkLatLong(retireAspas(leitorLinhas[5].trim()));
					 estado = retireAspas(leitorLinhas[6].trim());
					 populacao = retireAspas(leitorLinhas[7].trim());
					 site = retireAspas(leitorLinhas[8]);
					 inf_relevante = checkCamp(retireAspas(leitorLinhas[9].trim()));
					 email_responsavel = retireAspas(leitorLinhas[10].trim());
					 nome_responsavel = retireAspas(leitorLinhas[11].trim());
					 contato_responsavel = retireAspas(leitorLinhas[12].trim());
					 fonte_inf = checkCamp(retireAspas(leitorLinhas[13].trim()));
			
		
					
					list_mun.add(new Municipios(data,imgUrl,codvalidacao,nomeCidade,descricao,area,Double.parseDouble(latitude),Double.parseDouble(longitude),estado,Integer.parseInt(populacao),site,inf_relevante, email_responsavel, nome_responsavel , contato_responsavel,fonte_inf));
					
					
				}
		}
	}
		
		
		/*
		 * Cria um txt com os dados que foram inseridos no banco;
		 */
		if(list_mun.size() != 0){
			int tamanhoVetor = list_mun.size();
			salvaLogs_municipios(list_mun , path_log , tamanhoVetor);
			
			System.err.println("Tamanho da lista municipios: "+list_mun.size());
		}
		return list_mun;
	}
	
	public ArrayList<AtrativoTuristico> lerArquivosCSV_AtrativoTuristico(String caminhoCSV, String path) throws IOException{
		/*
		 * Indices para AtrativoTuristicos
		 * 0 = data
		 * 1 = nome
		 * 2 = comoChegar
		 * 3 = descricao
		 * 4 = info_contato
		 * 5 = latitude
		 * 6 = longitude;
		 * 7 = site;
		 */
		try {
			paths(caminhoCSV);
			
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
			String[] leitorLinhas;
			
			String date = ""; // 0
			String imgurl = ""; // 1
			String codValidacao = ""; // 2
			String nomeAtrativo = ""; // 3
			String comoChegar = ""; // 4
			String descricao = ""; // 5
			String infContato = ""; // 6
			double latitude = 0; // 7
			double longitude = 0; // 8
			String site = ""; // 9
			String cidade = ""; // 10
			String estado = ""; // 11
			String informacoes_relevantes = ""; // 12
			String email_responsavel = ""; // 13
			String nome_responsavel_preenchimento = ""; // 14
			String contato_responsavel_preenchimento = ""; // 15
			String fonte_inf = ""; // 16
			String nome_resp_at = ""; // 17
			String contato_resp_at = ""; // 18
			String email_resp_at = ""; // 19
			
			while((leitorLinhas=leitor.readNext())!=null){
				
				if(leitorLinhas[0].isEmpty() ){
					date="Data nao informada!";
				}else if(leitorLinhas[1].isEmpty()) {
					imgurl = "Imagem nao informada!";
				}else if(leitorLinhas[2].isEmpty()) {
					codValidacao = "Codigo de validacao nao informado!";
				}else if(leitorLinhas[3].isEmpty()) {
					nomeAtrativo = "Nome Atrativo nao informado!";
				}else if(leitorLinhas[4].isEmpty()) {
					comoChegar = "Como chegar no atrativo nao informado!";
				}else if(leitorLinhas[5].isEmpty()) {
					descricao = "Descricao nao informado!";
				}else if(leitorLinhas[6].isEmpty()) {
					infContato= "Contato do Atrativo nao informado!";
				}else if(leitorLinhas[7].isEmpty()) {
					latitude = 0;
				}else if(leitorLinhas[8].isEmpty()) {
					longitude = 0;
				}else if(leitorLinhas[9].isEmpty()) {
					site = "Site do Atrativo nao informado!";
				}else if(leitorLinhas[10].isEmpty()) {
					cidade = "Cidade do atrativo nao informado!";
				}else if(leitorLinhas[11].isEmpty()) {
					estado = "Estado do atrativo nao informado";
				}else if(leitorLinhas[12].isEmpty()) {
					informacoes_relevantes = "Informacoes Relevantes nao informado!";
				}else if(leitorLinhas[13].isEmpty()) {
					email_responsavel = "Email do Responsavel pelo Atrativo nao informado";
				}else if(leitorLinhas[14].isEmpty()) {
					nome_responsavel_preenchimento = "Nome do Responsavel pelo preenchimento nao informado";
				}else if(leitorLinhas[15].isEmpty()) {
					contato_responsavel_preenchimento = "Contato do Responsavel pelo preenchimento nao informado";
				}else if(leitorLinhas[16].isEmpty()) {
					fonte_inf = "Fonte de informacoes nao informado!";
				}else if(leitorLinhas[17].isEmpty()) {
					nome_resp_at = "Nome do Responsavel pelo Atrativo nao informado!";
				}
				else if(leitorLinhas[18].isEmpty()) {
					contato_resp_at = "Contato do responsavel pelo Atrativo nao informado!";
				}else if(leitorLinhas[19].isEmpty()) {
					email_resp_at = "Email do Responsavel pelo Atrativo nao informado!";
				}
				else{
						 date = leitorLinhas[0].trim();
						 imgurl = leitorLinhas[1].trim();
						codValidacao = leitorLinhas[1].trim();
						 nomeAtrativo = leitorLinhas[2].trim();
						 comoChegar = leitorLinhas[3].trim();
						 descricao = leitorLinhas[4].trim();
						infContato = leitorLinhas[5].trim();
						 latitude = Double.parseDouble(leitorLinhas[6].trim());
						 longitude = Double.parseDouble(leitorLinhas[7].trim());
						 site = leitorLinhas[8].trim();
						cidade = leitorLinhas[9].trim();
						 estado = leitorLinhas[10].trim();
						 informacoes_relevantes = leitorLinhas[11].trim();
						 email_responsavel = leitorLinhas[12].trim();
						 nome_responsavel_preenchimento = leitorLinhas[13].trim();
						 contato_responsavel_preenchimento = leitorLinhas[14].trim();
						fonte_inf = leitorLinhas[15].trim();
						 nome_resp_at = leitorLinhas[16].trim();
						contato_resp_at = leitorLinhas[17].trim();
						 email_resp_at = leitorLinhas[18].trim();
					
					list_atrativos.add(new AtrativoTuristico(date,imgurl,codValidacao,nomeAtrativo,comoChegar,descricao,infContato,latitude,longitude,site,cidade,estado,informacoes_relevantes,
							email_responsavel,nome_responsavel_preenchimento,contato_responsavel_preenchimento,fonte_inf,nome_resp_at,contato_resp_at,
							email_resp_at));
					
				}
				
			}
		}catch(NumberFormatException e){
			
			
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
			String[] leitorLinhas;
			String date = ""; // 0
			String imgurl = ""; // 1
			String codValidacao = ""; // 2
			String nomeAtrativo = ""; // 3
			String comoChegar = ""; // 4
			String descricao = ""; // 5
			String infContato = ""; // 6
			double latitude = 0; // 7
			double longitude = 0; // 8
			String site = ""; // 9
			String cidade = ""; // 10
			String estado = ""; // 11
			String informacoes_relevantes = ""; // 12
			String email_responsavel = ""; // 13
			String nome_responsavel_preenchimento = ""; // 14
			String contato_responsavel_preenchimento = ""; // 15
			String fonte_inf = ""; // 16
			String nome_resp_at = ""; // 17
			String contato_resp_at = ""; // 18
			String email_resp_at = ""; // 19
			
			while((leitorLinhas=leitor.readNext())!=null){
				if(leitorLinhas[0].isEmpty() ){
					date="Data nao informada!";
				}else if(leitorLinhas[1].isEmpty()) {
					imgurl = "Imagem nao informada!";
				}else if(leitorLinhas[2].isEmpty()) {
					codValidacao = "Codigo de validacao nao informado!";
				}else if(leitorLinhas[3].isEmpty()) {
					nomeAtrativo = "Nome Atrativo nao informado!";
				}else if(leitorLinhas[4].isEmpty()) {
					comoChegar = "Como chegar no atrativo nao informado!";
				}else if(leitorLinhas[5].isEmpty()) {
					descricao = "Descricao nao informado!";
				}else if(leitorLinhas[6].isEmpty()) {
					infContato= "Contato do Atrativo nao informado!";
				}else if(leitorLinhas[7].isEmpty()) {
					latitude = 0;
				}else if(leitorLinhas[8].isEmpty()) {
					longitude = 0;
				}else if(leitorLinhas[9].isEmpty()) {
					site = "Site do Atrativo nao informado!";
				}else if(leitorLinhas[10].isEmpty()) {
					cidade = "Cidade do atrativo nao informado!";
				}else if(leitorLinhas[11].isEmpty()) {
					estado = "Estado do atrativo nao informado";
				}else if(leitorLinhas[12].isEmpty()) {
					informacoes_relevantes = "Informacoes Relevantes nao informado!";
				}else if(leitorLinhas[13].isEmpty()) {
					email_responsavel = "Email do Responsavel pelo Atrativo nao informado";
				}else if(leitorLinhas[14].isEmpty()) {
					nome_responsavel_preenchimento = "Nome do Responsavel pelo preenchimento nao informado";
				}else if(leitorLinhas[15].isEmpty()) {
					contato_responsavel_preenchimento = "Contato do Responsavel pelo preenchimento nao informado";
				}else if(leitorLinhas[16].isEmpty()) {
					fonte_inf = "Fonte de informacoes nao informado!";
				}else if(leitorLinhas[17].isEmpty()) {
					nome_resp_at = "Nome do Responsavel pelo Atrativo nao informado!";
				}
				else if(leitorLinhas[18].isEmpty()) {
					contato_resp_at = "Contato do responsavel pelo Atrativo nao informado!";
				}else if(leitorLinhas[19].isEmpty()) {
					email_resp_at = "Email do Responsavel pelo Atrativo nao informado!";
				}else{
						date = retireAspas(leitorLinhas[0].trim());
						 imgurl = retireAspas(leitorLinhas[1].trim());
						 codValidacao =  retireAspas(leitorLinhas[1].trim());
						 nomeAtrativo =  retireAspas(leitorLinhas[2].trim());
						comoChegar =  retireAspas(leitorLinhas[3].trim());
						descricao =  checkCamp(retireAspas(leitorLinhas[4].trim()));
						 infContato =  retireAspas(leitorLinhas[5].trim());
						 latitude = Double.parseDouble( retireAspas(leitorLinhas[6].trim()));
						 longitude = Double.parseDouble( retireAspas(leitorLinhas[7].trim()));
						 site =  retireAspas(leitorLinhas[8].trim());
						 cidade =  retireAspas(leitorLinhas[9].trim());
						 estado =  retireAspas(leitorLinhas[10].trim());
						 informacoes_relevantes =  retireAspas(leitorLinhas[11].trim());
						 email_responsavel =  retireAspas(leitorLinhas[12].trim());
						 nome_responsavel_preenchimento =  retireAspas(leitorLinhas[13].trim());
						 contato_responsavel_preenchimento =  retireAspas(leitorLinhas[14].trim());
						//System.err.println("XDXDXD?" + contato_responsavel_preenchimento);
						 fonte_inf =  retireAspas(leitorLinhas[15].trim());
						 nome_resp_at =  retireAspas(leitorLinhas[16].trim());
						 contato_resp_at =  retireAspas(leitorLinhas[17].trim());
						 email_resp_at =  retireAspas(leitorLinhas[18].trim());
					
					list_atrativos.add(new AtrativoTuristico(date,imgurl,codValidacao,nomeAtrativo,comoChegar,descricao,infContato,latitude,longitude,site,cidade,estado,informacoes_relevantes,
							email_responsavel,nome_responsavel_preenchimento,contato_responsavel_preenchimento,fonte_inf,nome_resp_at,contato_resp_at,
							email_resp_at));
					
				}
				
			}
			
		}
		if(list_atrativos.size() != 0){
			int tamanhoVetor = list_atrativos.size();
			salvarLogs_turisticos(list_atrativos , path , tamanhoVetor);
			System.err.println("Tamanho da lista Atrativos: "+tamanhoVetor);
		}
		return list_atrativos;
	}
	
	
	public void salvarLogs_praias(ArrayList<Praia> list , String caminhoCSV){
		
		try {
			// File file = new
	
			File file = new File("Praias.txt"); // quebra de linha \r\n
			String dados_turismo = "";
			String conteudo;
			String saidacorretaTubarao;
			String saidacorretaBanho;
			if(file!=null){
				System.out.println("Arquivo criado");
			}

			FileWriter arq = new FileWriter(file);
			arq.write("--------------- RelatÃ³rio de Praias Salvos pelo Sistema ---------------------");
			arq.write("\r\n");
			for (int i = 0; i < list.size(); i++) {

				if(list.get(i).getPerigoTubarao()){
					saidacorretaTubarao="sim";
				}else{
					saidacorretaTubarao="nÃ£o";
				}
				if(list.get(i).getPropiaBanho()){
					saidacorretaBanho="sim";
				}else{
					saidacorretaBanho="nÃ£o";
				}
				dados_turismo = "Nome: " + list.get(i).getNome() + "\r\n" + "Como chegar: " + list.get(i).getComochegar()
						+ "\r\n" + "Descricao: " + list.get(i).getDescricao() + "\r\n" + "Latitude: " + list.get(i).getLatitude()
						+ "\r\n" + "Longitude: " + list.get(i).getLongitude() + "\r\n" + "Infomacaoo Contato: " + list.get(i).getInfo_contato() + "\r\n" +
						"\r\n" + "Perigo Tubarao: " + saidacorretaTubarao +  "\r\n"+"Propria para banho?: " +saidacorretaBanho +"\r\n "+ "TIPO DA ORLA: "+list.get(i).getTipoOrla()  +"\r\n" + "----------------------------------------------------------------------------------------------------------------" + "\r\n";
				
				arq.write("\r\n");
				conteudo = dados_turismo;
				conteudo += "\r\n";

				arq.write(conteudo);

			}
			arq.write("\r\n");
			arq.write("Armazenados com sucesso!");
			arq.close();

		} catch (IOException e) {
			e.printStackTrace();
			}
		
	}
	public void salvarLogs_turisticos(ArrayList<AtrativoTuristico> list, String caminhoCSV , int tamanhoVETOR){
		try {
			// File file = new
			/*
			 * SALVA OS DADOS ARMAZENADOS EM UM ARQUIVO TXT QUE SERVE COMO REGISTRO DA OPERAÃ‡ÃƒO.
			 */
			
			
			//
			
			
			
			
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
		/*
		 * trata os campos de populacao,lattitude e longitude
		 * caso o usuario digite virgula
		 * exemplo 1 populacao: 44,444
		 * exemplo 2 latitude; -4,389230
		 * exemplo 3 longitude: 47,1723923
		 * 
		 */
	
		String normal = lat;
		String[] saida = lat.split(",");
		if(saida.length>1) {
			String op = saida[0]+"."+saida[1];
			//System.out.println(op);
			return op;
		}
		return normal;
		
		
	}
	
	public String retireAspas(String string){
		 /*
		  * Nao encontrei um metodo na classe String que retira-se os espaÃ§os que o CSV do GOOGLE FORMS CRIA,
		  * entao criei esse metodo para retirar as aspas entre os atributos do municipios cadastrados no CSV
		  * a ideia do nome do arquivo ainda continua a mesma (municipios.csv Â«Â«); or atrativosTUristicos;
		  * 
		  * 
		  */
		//System.err.println("saida" + string);
		 
		String saida2 = null;
		String saida_normal = null;
		String x = null;
	
		String[] saida = string.split("");
		//System.out.print(saida[1]);
		
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
