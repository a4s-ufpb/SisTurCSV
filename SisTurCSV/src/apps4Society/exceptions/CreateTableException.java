package apps4Society.exceptions;

public class CreateTableException extends Exception{
	
	
	private String msg;
	

	public CreateTableException(String msg) {
		super(msg);
		this.msg=msg;
	}
	
	public String getMessage() {
		return this.msg;
	}
	
	public CreateTableException() {
		super("Error ao Criar Tabelas");
	}

}
