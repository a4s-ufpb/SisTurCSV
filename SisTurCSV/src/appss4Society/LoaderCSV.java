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
import apps4Society.model.Praia;
import java.util.List;
import org.slf4j.Logger;	
import org.slf4j.LoggerFactory;
import java.io.File;

public class LoaderCSV {
	private static ArrayList<Municipios> list_mun =  new ArrayList<Municipios>();
	private static ArrayList<AtrativoTuristico> list_atrativos = new ArrayList<AtrativoTuristico>();
	private static ArrayList<Praia> list_praias = new ArrayList<Praia>();
	
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
			
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
			String[] leitorLinhas;
			
			
			while((leitorLinhas=leitor.readNext()) != null){
				int x = leitorLinhas.length -1;
				
				if(leitorLinhas[0].isEmpty() || leitorLinhas[1].isEmpty() || leitorLinhas[2].isEmpty() || leitorLinhas[5].isEmpty() || leitorLinhas[7].isEmpty()){
					System.out.println("Preencha os dados corretamente/1");	
				}
				else{
					String data = leitorLinhas[0].trim();
					String imgUrl= leitorLinhas[1].trim();
					String codvalidacao = leitorLinhas[2].trim();
					String nomeCidade = leitorLinhas[3].trim();
					String descricao = leitorLinhas[4].trim();
					String area = leitorLinhas[5].trim();
					String latitude = leitorLinhas[6].trim();
					String longitude = leitorLinhas[7].trim();
					String estado = leitorLinhas[8].trim();
					String populacao = leitorLinhas[9].trim();
					String site = leitorLinhas[10].trim();
					String inf_relevante = leitorLinhas[11].trim();
					String email_responsavel = leitorLinhas[12].trim();
					String nome_responsavel = leitorLinhas[13].trim();
					String contato_responsavel = leitorLinhas[14].trim();
					String fonte_inf = leitorLinhas[15].trim();
			
		
					
					list_mun.add(new Municipios(data,imgUrl,codvalidacao,nomeCidade,descricao,area,Double.parseDouble(latitude),Double.parseDouble(longitude),estado,Integer.parseInt(populacao),site,inf_relevante, email_responsavel, nome_responsavel , contato_responsavel,fonte_inf));
					
	
				}
				
				
			}
		}catch(NumberFormatException e){
			
				@SuppressWarnings("deprecation")
				CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
				String[] leitorLinhas;
			
				while((leitorLinhas=leitor.readNext()) != null){
				int x = leitorLinhas.length -1;
				
				if(leitorLinhas[0].isEmpty() || leitorLinhas[1].isEmpty() || leitorLinhas[2].isEmpty() || leitorLinhas[5].isEmpty() || leitorLinhas[7].isEmpty()){
					System.out.println("Preencha os dados corretamente/1");	
				}
				else{
					String data = retireAspas(leitorLinhas[0].trim());
					String imgUrl=retireAspas(leitorLinhas[1].trim());
					String codValidacao = retireAspas(leitorLinhas[2].trim());
					String nomeCidade = retireAspas(leitorLinhas[1].trim());
					String descricao = retireAspas(leitorLinhas[2].trim());
					String area = retireAspas(leitorLinhas[3].trim());
					String latitude = retireAspas(leitorLinhas[4].trim());
					String longitude = retireAspas(leitorLinhas[5].trim());
					String estado = retireAspas(leitorLinhas[6].trim());
					String populacao = retireAspas(leitorLinhas[7].trim());
					String site = retireAspas(leitorLinhas[8]);
					String inf_relevante = retireAspas(leitorLinhas[9].trim());
					String email_responsavel = retireAspas(leitorLinhas[10].trim());
					String nome_responsavel = retireAspas(leitorLinhas[11].trim());
					String contato_responsavel = retireAspas(leitorLinhas[12].trim());
					String fonte_inf = retireAspas(leitorLinhas[13].trim());
			
		
					
					list_mun.add(new Municipios(data,imgUrl,codValidacao,nomeCidade,descricao,area,Double.parseDouble(latitude),Double.parseDouble(longitude),estado,Integer.parseInt(populacao),site,inf_relevante, email_responsavel, nome_responsavel , contato_responsavel,fonte_inf));
					
					
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
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
			String[] leitorLinhas;
			while((leitorLinhas=leitor.readNext())!=null){
				System.err.println(leitorLinhas[0]);
				System.err.println(leitorLinhas[1]);
				System.err.println(leitorLinhas[2]);
				System.err.println(leitorLinhas[3]);
				System.err.println(leitorLinhas[4]);
				System.err.println(leitorLinhas[5].trim());
				System.err.println(leitorLinhas[6]);
				System.err.println(leitorLinhas[7]);
				if(leitorLinhas[2].isEmpty() || leitorLinhas[4].isEmpty() || leitorLinhas[9].isEmpty()){
					System.err.println(leitorLinhas[1]);
					System.err.println(leitorLinhas[0]);
					System.out.println("Preencha os dados corretamente/1");	
				}else{
						String date = leitorLinhas[0].trim();
						String imgurl = leitorLinhas[1].trim();
						String codValidacao = leitorLinhas[1].trim();
						String nomeAtrativo = leitorLinhas[2].trim();
						String comoChegar = leitorLinhas[3].trim();
						String descricao = leitorLinhas[4].trim();
						String infContato = leitorLinhas[5].trim();
						double latitude = Double.parseDouble(leitorLinhas[6].trim());
						double longitude = Double.parseDouble(leitorLinhas[7].trim());
						String site = leitorLinhas[8].trim();
						String cidade = leitorLinhas[9].trim();
						String estado = leitorLinhas[10].trim();
						String informacoes_relevantes = leitorLinhas[11].trim();
						String email_responsavel = leitorLinhas[12].trim();
						String nome_responsavel_preenchimento = leitorLinhas[13].trim();
						String contato_responsavel_preenchimento = leitorLinhas[14].trim();
						String fonte_inf = leitorLinhas[15].trim();
						String nome_resp_at = leitorLinhas[16].trim();
						String contato_resp_at = leitorLinhas[17].trim();
						String email_resp_at = leitorLinhas[18].trim();
					
					list_atrativos.add(new AtrativoTuristico(date,imgurl,codValidacao,nomeAtrativo,comoChegar,descricao,infContato,latitude,longitude,site,cidade,estado,informacoes_relevantes,
							email_responsavel,nome_responsavel_preenchimento,contato_responsavel_preenchimento,fonte_inf,nome_resp_at,contato_resp_at,
							email_resp_at));
					
				}
				
			}
		}catch(NumberFormatException e){
			
			
			CSVReader leitor = new CSVReader(new FileReader(caminhoCSV),',', '\t',1);
			String[] leitorLinhas;
			while((leitorLinhas=leitor.readNext())!=null){
				if(leitorLinhas[0].isEmpty() || leitorLinhas[1].isEmpty() || leitorLinhas[2].isEmpty() || leitorLinhas[3].isEmpty() || leitorLinhas[6].isEmpty()){
					System.out.println("Preencha os dados corretamente/1");	
				}else{
						String date = retireAspas(leitorLinhas[0].trim());
						String imgurl = retireAspas(leitorLinhas[1].trim());
						String codValidacao =  retireAspas(leitorLinhas[1].trim());
						String nomeAtrativo =  retireAspas(leitorLinhas[2].trim());
						String comoChegar =  retireAspas(leitorLinhas[3].trim());
						String descricao =  retireAspas(leitorLinhas[4].trim());
						String infContato =  retireAspas(leitorLinhas[5].trim());
						double latitude = Double.parseDouble( retireAspas(leitorLinhas[6].trim()));
						double longitude = Double.parseDouble( retireAspas(leitorLinhas[7].trim()));
						String site =  retireAspas(leitorLinhas[8].trim());
						String cidade =  retireAspas(leitorLinhas[9].trim());
						String estado =  retireAspas(leitorLinhas[10].trim());
						String informacoes_relevantes =  retireAspas(leitorLinhas[11].trim());
						String email_responsavel =  retireAspas(leitorLinhas[12].trim());
						String nome_responsavel_preenchimento =  retireAspas(leitorLinhas[13].trim());
						String contato_responsavel_preenchimento =  retireAspas(leitorLinhas[14].trim());
						//System.err.println("XDXDXD?" + contato_responsavel_preenchimento);
						String fonte_inf =  retireAspas(leitorLinhas[15].trim());
						String nome_resp_at =  retireAspas(leitorLinhas[16].trim());
						String contato_resp_at =  retireAspas(leitorLinhas[17].trim());
						String email_resp_at =  retireAspas(leitorLinhas[18].trim());
					
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

				dados_turismo = "Nome do Atrativo Turistico: " + list.get(i).getNome_atrativo() + "\r\n" + "Como chegar: " + list.get(i).getComoChegar()
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
			arq.close();

		} catch (IOException e) {
			e.printStackTrace();
			}
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
}
