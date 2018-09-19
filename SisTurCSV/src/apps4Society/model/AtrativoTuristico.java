package apps4Society.model;

public class AtrativoTuristico extends Atrativos{

	private long id;
	
	
	public void setId(long id) {
		this.id=id;
	}
	public long getId() {
		return id;
	}
	
	private String date; // 0
	private String imagemUrl ; 
	private String codValidacao;// 1
	private String nome_atrativo;// 2
	private String comoChegar;// 3
	private String descricao;// 4
	private String infoContato;// 5
	private double latitude;// 6
	private double longitude;// 7
	private String site;// 8
	private String cidade;// 9
	private String estado;// 10
	private String informacoes_relevantes;// 11
	private String email_responsavel_preenchimento;// 12
	private String nome_responsavel_preenchimento; // 13
	private String contato_responsavel_preenchimento; // 14
	private String fonte_informacoes; // 15
	private String nome_responsavel_atrativo;// 16
	private String contato_responsavel_atrativo;// 17
	private String email_responsavel_atrativo;// 18
	
	public void setDate(String date) {
		this.date=date;
	}
	
	public String getDate() {
		return date;
	}
	

	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getComoChegar() {
		return comoChegar;
	}
	public void setComoChegar(String comoChegar) {
		this.comoChegar = comoChegar;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getInfoContato() {
		return infoContato;
	}
	public void setInfoContato(String infoContato) {
		this.infoContato = infoContato;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodValidacao() {
		return codValidacao;
	}
	public void setCodValidacao(String codValidacao) {
		this.codValidacao = codValidacao;
	}
	public String getNome_atrativo() {
		return nome_atrativo;
	}
	public void setNome_atrativo(String nome_atrativo) {
		this.nome_atrativo = nome_atrativo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getInformacoes_relevantes() {
		return informacoes_relevantes;
	}
	public void setInformacoes_relevantes(String informacoes_relevantes) {
		this.informacoes_relevantes = informacoes_relevantes;
	}
	public String getEmail_responsavel_preenchimento() {
		return email_responsavel_preenchimento;
	}
	public void setEmail_responsavel_preenchimento(String email_responsavel) {
		this.email_responsavel_preenchimento = email_responsavel;
	}
	public String getNome_responsavel_preenchimento() {
		return nome_responsavel_preenchimento;
	}
	public void setNome_responsavel_preenchimento(String nome_responsavel_preenchimento) {
		this.nome_responsavel_preenchimento = nome_responsavel_preenchimento;
	}
	public String getContato_responsavel_preenchimento() {
		return contato_responsavel_preenchimento;
	}
	public void setContato_responsavel_preenchimento(String contato_responsavel_preenchimento) {
		this.contato_responsavel_preenchimento = contato_responsavel_preenchimento;
	}
	public String getFonte_informacoes() {
		return fonte_informacoes;
	}
	public void setFonte_informacoes(String fonte_informacoes) {
		this.fonte_informacoes = fonte_informacoes;
	}
	public String getNome_responsavel_atrativo() {
		return nome_responsavel_atrativo;
	}
	public void setNome_responsavel_atrativo(String nome_responsavel_atrativo) {
		this.nome_responsavel_atrativo = nome_responsavel_atrativo;
	}
	public String getContato_responsavel_atrativo() {
		return contato_responsavel_atrativo;
	}
	public void setContato_responsavel_atrativo(String contato_responsavel_atrativo) {
		this.contato_responsavel_atrativo = contato_responsavel_atrativo;
	}
	public String getEmail_responsavel_atrativo() {
		return email_responsavel_atrativo;
	}
	public void setEmail_responsavel_atrativo(String email_responsavel_atrativo) {
		this.email_responsavel_atrativo = email_responsavel_atrativo;
	}
	
	
	
	public AtrativoTuristico(String date,String imgUrl , String codvalidacao , String nome_atrativo, String comochegar , String descricao 
			, String infContato,double latitude , double longitude,String site , String cidade , String estado , 
			String informacoes_relevantes, String email_responsavel , String nome_responsavel , String contato_responsavel , 
			String fonte_inf , String nome_resp_at , String contato_resp_at , String email_resp_at) {
		//* novo construtor para o formulario reformulado;
		
		setDate(date); // 0
		setImagemUrl(imgUrl);
		setCodValidacao(codvalidacao); // 1
		setNome_atrativo(nome_atrativo); // 2
		setComoChegar(comochegar); // 3
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
	public String getImagemUrl() {
		return imagemUrl;
	}
	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}
	
	

}
