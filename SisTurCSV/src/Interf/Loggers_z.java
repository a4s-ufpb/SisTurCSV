package Interf;

public interface Loggers_z {
	/*
	 * Responsavel pela verificacao de logs utilizando a clase Logger
	 * minha classe LoaderCSV e a classe principal que assinara o contrato com essa interface
	 * a ideia e realizar o controle de fluxo de informacoes que estao sendo realizadas
	 * por baixo da aplicacao, fora os arquivos txt que sao criados;
	 * 
	 */
	
	void paths(String name);
	void arqs(String arqs);
	void inputs(String variaveis);
	void sucess(String msg_sucess);
	void error(String msg_error);
	void connect(String cnc);
	
	
	

}
