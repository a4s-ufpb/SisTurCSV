package apps4Society.model;

import com.opencsv.bean.CsvBindByName;

public class Municipios extends Atrativos {

private long id;
	
	public void setId(long id) {
		this.id=id;
	}
	public long getId() {
		return id;
	}
	
	private String codValidacao;
	private String nome_cidade; // 1
	private String areaTerritorial; // 3
	private int populacao; // 7 
	
	

	
	
	
	public String getNomecidade() {
		return nome_cidade;
	}
	public void setNomecidade(String nome) {
		this.nome_cidade = nome;
	}
	public int getPopulacao() {
		return populacao;
	}
	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	
	
	public Municipios() {}

	
	public String getEmail_responsavel() {
		return getEmail_responsavel_preenchimento();
	}
	public void setEmail_responsavel(String email_responsavel) {
		this.setEmail_responsavel_preenchimento(email_responsavel);
	}
	public String getNome_responsavel() {
		return getNome_responsavel_preenchimento();
	}
	
	public String getContatos_responsavel() {
		return getContatos_responsavel_preenchimento();
	}
	public void setContatos_responsavel(String contatos_responsavel) {
		this.setContatos_responsavel_preenchimento(contatos_responsavel);
	}
	
	public String getAreaTerritorial() {
		return areaTerritorial;
	}
	public void setAreaTerritorial(String areaTerritorial) {
		this.areaTerritorial = areaTerritorial;
	}
	
	public Municipios(String data, String imgUrl,String codValidacao,String nomecidade, String desc , String area, Double lat, Double longi , String estado1,int populacao,String site, String inf_relevante , String emailResponsavel ,String nomeResponsavel, String contatoResponsavel ,String informacoesFonte){
		setDate(data); // 0
		setImgUrl(imgUrl); // 1
		setCodValidacao(codValidacao); // 2
		setNomecidade(nomecidade); // 3
		setDescricao(desc); // 4
		setAreaTerritorial(area); // 5
		setLatitude(lat); // 6
		setLongitude(longi); // 7
		setEstado(estado1); // 7
		setPopulacao(populacao); // 9
		setSite(site);// 10
		setInformacoesRelevantes(inf_relevante); // 11
		setEmail_responsavel(emailResponsavel); // 12
		setNome_responsavel_preenchimento(nomeResponsavel); // 13
		setContatos_responsavel(contatoResponsavel); // 14
		setFonte_informacoes(informacoesFonte); // 15
		

	}
	
	public String getCodValidacao() {
		return codValidacao;
	}
	public void setCodValidacao(String codValidacao) {
		this.codValidacao = codValidacao;
	}
	

}
