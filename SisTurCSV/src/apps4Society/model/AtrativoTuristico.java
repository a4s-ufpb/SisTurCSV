package apps4Society.model;

public class AtrativoTuristico extends Atrativos{

	private long id;
	
	
	public void setId(long id) {
		this.id=id;
	}
	public long getId() {
		return id;
	}
	

	private String nome_atrativo;// 2
	private String comochegar;
	private String codValidacao;
	private String infoContato;
	private String informacoes_relevantes;

	
	
	
	public AtrativoTuristico(String date,String imgUrl , String codvalidacao , String nome_atrativo, String comochegar , String descricao 
			, String infContato,double latitude , double longitude,String site , String cidade , String estado , 
			String informacoes_relevantes, String email_responsavel , String nome_responsavel , String contato_responsavel , 
			String fonte_inf , String nome_resp_at , String contato_resp_at , String email_resp_at) {
		//* novo construtor para o formulario reformulado;
		
		setDate(date); // 0
		setImgUrl(imgUrl);
		setCodValidacao(codvalidacao); // 1
		setNome_atrativo(nome_atrativo); // 2
		setComochegar(comochegar); // 3
		setDescricao(descricao); // 4
		setInfoContato(infContato); // 5
		setLatitude(latitude);// 6
		setLongitude(longitude);  // 7
		setSite(site); // 8
		setCidade(cidade); // 9
		setEstado(estado); // 10
		setInformacoes_relevantes(informacoes_relevantes); // 11
		setEmail_responsavel_preenchimento(email_responsavel); // 12
		setNome_responsavel_preenchimento(nome_responsavel); // 13
		setContato_responsavel_preenchimento(contato_responsavel); // 14
		setFonte_informacoes(fonte_inf); // 15
		setNome_responsavel_atrativo(nome_resp_at); // 16
		setContato_responsavel_atrativo(contato_resp_at); // 17
		setEmail_responsavel_atrativo(email_resp_at); // 18
		
		
		
		
	}
	public String getNome_atrativo() {
		return nome_atrativo;
	}
	public void setNome_atrativo(String nome_atrativo) {
		this.nome_atrativo = nome_atrativo;
	}
	public String getComochegar() {
		return comochegar;
	}
	public void setComochegar(String comochegar) {
		this.comochegar = comochegar;
	}
	public String getCodValidacao() {
		return codValidacao;
	}
	public void setCodValidacao(String codValidacao) {
		this.codValidacao = codValidacao;
	}
	public String getInfoContato() {
		return infoContato;
	}
	public void setInfoContato(String infoContato) {
		this.infoContato = infoContato;
	}
	public String getInformacoes_relevantes() {
		return informacoes_relevantes;
	}
	public void setInformacoes_relevantes(String informacoes_relevantes) {
		this.informacoes_relevantes = informacoes_relevantes;
	}
	
	

}
