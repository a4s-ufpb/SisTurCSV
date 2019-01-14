package apps4Society.dao;

import apps4Society.conf.ConfBanco;
import apps4Society.exceptions.CreateTableException;
import apps4Society.model.AtrativoTuristico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AtrativoTuristico_control {
	
	
	
	public void createTableAtrativo() throws ClassNotFoundException, SQLException, CreateTableException{
		/*
		 * Responsavel por criar a tabela de atrativos no postgresql
		 * se a mesma nao existir
		*/
		Connection con = ConfBanco.getConnection();
		
		String sql = "CREATE TABLE IF NOT EXISTS atrativos_turisticos ( " + 
				" id SERIAL PRIMARY KEY, cidade TEXT NOT NULL, cod_validacao TEXT NOT NULL, "
				+ "contato_responsavel_atrativo TEXT NOT NULL, date TEXT NOT NULL, "
				+ "descricao TEXT NOT NULL, email_atrativo TEXT NOT NULL, "
				+ "email_responsavel_preenchimento TEXT NOT NULL, estado TEXT NOT NULL, imgUrl TEXT, "
				+ "info_contato TEXT ,latitude TEXT , longitude TEXT , "
				+ "informacoes_relevantes TEXT NOT NULL , nome_atrativo TEXT NOT NULL , "
				+ 
				"nome_responsavel_preenchimento TEXT, "
				+ "site TEXT, nome_responsavel_atrativo TEXT, "
				+ "contato_responsavel_preenchimento TEXT, "
				+ "fonte_informacoes TEXT NOT NULL, "
				+ "como_chegar TEXT NOT NULL, "
				+ "link_maps TEXT )";
		
		
		PreparedStatement statement = (PreparedStatement)con.prepareStatement(sql);
		
		statement.execute();
		
	}
	
	
	public boolean verificaAtrativoTuristico(AtrativoTuristico at) throws SQLException, ClassNotFoundException{
		Connection cx = ConfBanco.getConnection();
		String nome_at = "\'"+at.getNome_atrativo()+"\'";
		String como_at = "\'"+at.getComochegar()+"\'";
		String estado_at = "\'"+at.getEstado()+"\'";
		
		String sql = "SELECT nome_atrativo,como_chegar,cod_validacao FROM atrativos_turisticos"
				+ " WHERE nome_atrativo="+nome_at+" AND como_chegar="+como_at+" AND estado="+estado_at;
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
			System.out.println("Atrativo turistico Ja adicionado: " + aTuristico.getNome_atrativo());
		}else{
			try{
				Connection cx = ConfBanco.getConnection();
				String sql = "INSERT INTO atrativos_turisticos(actived,date,email_responsavel_preenchimento,nome_atrativo,como_chegar,descricao,imgurl,info_contato,latitude,longitude,link_maps,site,cidade,estado,nome_responsavel_atrativo,contato_responsavel_atrativo,email_atrativo,informacoes_relevantes,fonte_informacoes,contato_responsavel_preenchimento,nome_responsavel_preenchimento,cod_validacao)" +
						"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement statement = (PreparedStatement)cx.prepareStatement(sql);
				statement.setBoolean(1, true);
				statement.setString(2, aTuristico.getDate());
				statement.setString(3, aTuristico.getEmail_responsavel_preenchimento());
				statement.setString(4, aTuristico.getNome_atrativo());
				statement.setString(5, aTuristico.getComochegar());
				statement.setString(6, aTuristico.getDescricao());
				statement.setString(7, aTuristico.getImgUrl());
				statement.setString(8, aTuristico.getInfoContato());
				statement.setString(9, aTuristico.getLatitude());
				statement.setString(10, aTuristico.getLongitude());
				statement.setString(11, aTuristico.getLink_maps());
				statement.setString(12, aTuristico.getSite());
				statement.setString(13, aTuristico.getCidade());
				statement.setString(14, aTuristico.getEstado());
				statement.setString(15, aTuristico.getNome_responsavel_atrativo());
				statement.setString(16, aTuristico.getContato_responsavel_atrativo());
				statement.setString(17, aTuristico.getEmail_responsavel_atrativo());
				statement.setString(18, aTuristico.getInformacoes_relevantes());
				statement.setString(19, aTuristico.getFonte_informacoes());
				statement.setString(20, aTuristico.getContato_responsavel_preenchimento());
				statement.setString(21, aTuristico.getNome_responsavel_preenchimento());
				statement.setString(22, aTuristico.getCodValidacao());
				
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
			String sql = "DELETE * FROM atratativos_turisticos WHERE id = ?";
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
