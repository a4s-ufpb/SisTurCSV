package cUtils;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class MeuCalendario {
	
	private static Date data;
	private static Calendar calendario;
	private static SimpleDateFormat format_s;
	
	
	public String emitirData() {
		calendario = Calendar.getInstance();
		
		String saida_calendar = String.valueOf(calendario.getTime());
		
		return saida_calendar;
	}

}
