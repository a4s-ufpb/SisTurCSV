package apps4Society.dao;

import apps4Society.conf.ConfBanco;
import apps4Society.model.AtrativoTuristico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AtrativoTuristico_control {
	
	
	
	public void createTableAtrativo() throws ClassNotFoundException, SQLException {
		/*
		 * Responsavel por criar a tabela de atrativos no postgresql
		 * se a mesma nao existir
		*/
		Connection con = ConfBanco.getConnection();
		
		String sql = "CREATE TABLE IF NOT EXISTS atrativos_turisticos ( \n" + " id INTEGER AUTO PRIMARY KEY AUTOINCREMENT \n"+
		"cidade TEXT NOT NULL \n" +
				"cod_validacao TEXT NOT NULL \n" +
				"como_chegar TEXT NOT NULL \n"+
				"contato_responsavel_atrativo TEXT NOT NULL \n"+
				" contato_responsavel_preenchimento TEXT NOT NULL \n"+
				"date TEXT NOT NULL \n "+
				"descricao TEXT NOT NULL \n"+
				"email_atrativo TEXT NOT NULL \n "+
				"email_responsavel_preenchimento TEXT  \n "+
				"estado TEXT NOT NULL \n " +
				"fonte_informacoes TEXT NOT NULL \n"+
				"imgurl TEXT \n "+
				"info_contato TEXT \n"+
				"informacoes_relevantes TEXT \n"+
				"latitude REAL \n"+
				"longitude REAL \n "+
				"nome_atrativo TEXT NOT NULL \n "
				+"nome_responsavel_preenchimento TEXT \n" +
				"nome_responsavel_atrativo TEXT \n"+
				"site TEXT ";
		
		
		PreparedStatement statement = (PreparedStatement)con.prepareStatement(sql);
		
		statement.executeQuery();
		
	}
	
	
	public boolean verificaAtrativoTuristico(AtrativoTuristico at) throws SQLException, ClassNotFoundException{
		Connection cx = ConfBanco.getConnection();
		String sql = "SELECT nome_atrativo,como_chegar,cod_validacao FROM atrativos_turisticos";
		PreparedStatement st = (PreparedStatement)cx.prepareStatement(sql);
		ResultSet rx = st.executeQuery();
		while(rx.next()){
			String nome = rx.getString("nome_atrativo");
			String comochegar = rx.getString("como_chegar");
			String codva = rx.getString("cod_validacao");
			if(at.getNome_atrativo().equals(nome) && at.getComochegar().equals(comochegar) && at.getCodValidacao().equals(codva)){
				return true;
			}
		}
		rx.close();
		st.close();
		cx.close();
		return false;
	}
	
	public void addAtratativoTuristico(AtrativoTuristico aTuristico) throws SQLException, ClassNotFoundException{
		
		if(verificaAtrativoTuristico(aTuristico)){
			System.out.println("Atrativo turistico ja foi adicionado no banco");
		}else{
			try{
				Connection cx = ConfBanco.getConnection();
				String sql = "INSERT INTO atrativos_turisticos(date,cod_validacao,nome_atrativo,como_chegar,descricao,info_contato,latitude,longitude,site,cidade,estado,informacoes_relevantes,email_responsavel_preenchimento,nome_responsavel_preenchimento,contato_responsavel_preenchimento,fonte_informacoes,nome_responsavel_atrativo,contato_responsavel_atrativo,email_atrativo)" +
						"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement statement = (PreparedStatement)cx.prepareStatement(sql);
				statement.setString(1, aTuristico.getDate());
				statement.setString(2, aTuristico.getImgUrl());
				statement.setString(3, aTuristico.getCodValidacao());
				statement.setString(4, aTuristico.getNome_atrativo());
				statement.setString(5, aTuristico.getComochegar());
				statement.setString(6, aTuristico.getDescricao());
				statement.setString(7, aTuristico.getInfoContato());
				statement.setDouble(8, aTuristico.getLatitude());
				statement.setDouble(9, aTuristico.getLongitude());
				statement.setString(10, aTuristico.getSite());
				statement.setString(11, aTuristico.getCidade());
				statement.setString(12, aTuristico.getEstado());
				statement.setString(13, aTuristico.getInformacoes_relevantes());
				statement.setString(14, aTuristico.getEmail_responsavel_preenchimento());
				statement.setString(15, aTuristico.getNome_responsavel_preenchimento());
				statement.setString(16, aTuristico.getContato_responsavel_preenchimento());
				
				statement.setString(17, aTuristico.getFonte_informacoes());
				statement.setString(18, aTuristico.getNome_responsavel_atrativo());
				statement.setString(19, aTuristico.getContato_responsavel_atrativo());
				statement.setString(20, aTuristico.getEmail_responsavel_atrativo());
				
				
				
				
				statement.execute();
				statement.close();
				cx.close();
				System.err.println("Atratativo Turistico Adicionado!");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void deleteAtrativoTuristico(int ID_atratativo) throws SQLException{
		try{
			Connection cx= ConfBanco.getConnection();
			String sql = "DELETE FROM atratativos_turisticos WHERE id = ?";
			PreparedStatement statement =(PreparedStatement)cx.prepareStatement(sql);
			statement.setInt(1,ID_atratativo);
			
			cx.close();
			statement.close();
			System.out.println("Atratativo Turistico Removido");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
