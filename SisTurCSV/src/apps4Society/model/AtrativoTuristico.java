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
	private String link_maps;
	
	
	
	public AtrativoTuristico
	(
			
			String date, // 0
			String email_responsavel_preenchimento , // 1
			String nome_atrativo ,  // 2
			String comochegar, // 3
			String  descricao, // 4
			String imgUrl, // 5
			String infContato,// 6
			String latitude , // 7
			String longitude,// 8
			String link_maps,// 9
			String site , // 10
			String cidade , // 11
			String estado , // 12
			String nome_responsavel_at, // 13
			String contato_responsavel_at , // 14
			String email_resp_at , // 15
			String informacoes_relevantes , // 16
			String fonte_inf , // 17
			String contato_preenchimento , // 18
			String nome_preenchimento , // 19
			String cod_validacao// 20
			) {
		//* novo construtor para o formulario reformulado;
		
		setDate(date); // 0
		setEmail_responsavel_preenchimento(email_responsavel_preenchimento); // 1
		setNome_atrativo(nome_atrativo); // 2
		setComochegar(comochegar); // 3
		setDescricao(descricao); // 4
		setImgUrl(imgUrl); // 5
		setInfoContato(infContato); // 6
		setLatitude(latitude);// 7
		setLongitude(longitude);  // 8
		setLink_maps(link_maps); // 9
		setSite(site); // 10
		setCidade(cidade); // 11
		setEstado(estado); // 12
		setNome_responsavel_atrativo(nome_responsavel_at); // 13
		setContato_responsavel_atrativo(contato_responsavel_at); // 14
		setEmail_responsavel_atrativo(email_resp_at); // 15
		setInformacoes_relevantes(informacoes_relevantes); // 16
		setFonte_informacoes(fonte_inf); // 17
		setContato_responsavel_preenchimento(contato_preenchimento); // 18
		setNome_responsavel_preenchimento(nome_preenchimento); // 19
		setCodValidacao(cod_validacao); //20
		
		
		
		
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
	public String getLink_maps() {
		return link_maps;
	}
	public void setLink_maps(String link_maps) {
		this.link_maps = link_maps;
	}
	
	

}
