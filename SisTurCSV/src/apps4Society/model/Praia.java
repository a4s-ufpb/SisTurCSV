package apps4Society.model;

public class Praia{
	
	/*
	 * Essa classe extends o Atratativo Turistico segue a mesma ordem que o pai
	 * entretamento os atributos no banco estao sendo referenciados no rest logo
	 * caso nao sejam utilizados os valores padroes da tabela vao ser null
	 * o mesmo CSV, pode ser usado contudo deve-se colocar os dados respectivos para ser atualizados;
	 */
	
	private boolean perigoTubarao;
	private boolean propiaBanho;
	private String tipoOrla;
	private static  String TIPO_MAR_ABERTO="";
	private static  String TIPO_PEQUENAS_ONDAS="";
	private static  String TIPO_ONDAS_FORTES="";
	
	
	public boolean getPerigoTubarao() {
		return perigoTubarao;
	}
	public void setPerigoTubarao(boolean perigoTubarao) {
		this.perigoTubarao = perigoTubarao;
	}


	public boolean getPropiaBanho() {
		return propiaBanho;
	}
	public void setPropiaBanho(boolean propiaBanho) {
		this.propiaBanho = propiaBanho;
	}
	public String getTipoOrla() {
		return tipoOrla;
	}
	public void setTipoOrla(String tipoOrla) {
		this.tipoOrla = tipoOrla;
	}
	public  String getTipoMarAberto() {
		return TIPO_MAR_ABERTO;
	}
	public void setTipoMarAberto(String maraberto){
		this.TIPO_MAR_ABERTO=maraberto;
	}
	public  String getTipoPequenasOndas() {
		return TIPO_PEQUENAS_ONDAS;
	}
	public static String getTipoOndasFortes() {
		return TIPO_ONDAS_FORTES;
	}
	public void setTipoOndasFortes(String ondasFortes){
		this.TIPO_ONDAS_FORTES=ondasFortes;
	}
	private String comochegar;
	private String descricao;
	private String info_contato;
	private double latitude;
	private double longitude;
	private String nome;
	

	public Praia(String nome,String comochegar,String descricao,String info_contato,double latitude,double longitude,String entradaTubarao , String entradaPropriaBanho, String tipoOrla) {
		setNome(nome);
		setComochegar(comochegar);
		setLatitude(latitude);
		setLongitude(longitude);
		setDescricao(descricao);
		if(entradaTubarao.equals("sim") || entradaTubarao.equals("s") || entradaTubarao.equals("S")){
			setPerigoTubarao(true);
		}else{
			setPerigoTubarao(false);
		}
		if(entradaPropriaBanho.equals("sim") || entradaPropriaBanho.equals("s") || entradaPropriaBanho.equals("S")){
			setPropiaBanho(true);
		}else{
			setPropiaBanho(false);
		}
		setTipoOrla(tipoOrla);
		//setTipoMarAberto(TIPO_MAR_ABERTO);
		//setTipoOndasFortes(TIPO_ONDAS_FORTES);
		
		
	}
	public String getComochegar() {
		return comochegar;
	}
	public void setComochegar(String comochegar) {
		this.comochegar = comochegar;
	}
	public String getInfo_contato() {
		return info_contato;
	}
	public void setInfo_contato(String info_contato) {
		this.info_contato = info_contato;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
