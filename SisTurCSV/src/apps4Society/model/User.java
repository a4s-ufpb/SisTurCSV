package apps4Society.model;

public class User {
	
	
	private long id;
	private String nome;
	private String email;
	
	private String login;
	private String pass;

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public User() {
		
	}
	public User(String nome , String login , String email , String senha ,String codigo, String datacad) {
		setNome(nome);
		setLogin(login);
		setEmail(email);
		setPass(senha);
		

	}
	

}
