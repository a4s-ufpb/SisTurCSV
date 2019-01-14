package apps4Society.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import apps4Society.conf.ConfBanco;
import apps4Society.exceptions.CreateTableException;
import apps4Society.model.*;
public class Municipios_control {
	
	
	public void createTablesMunicipios() throws SQLException, ClassNotFoundException, CreateTableException{
		/*
		 * Responsavel por criar a tabela de Municipios no postgresql
		 * se a mesma nao existir
		*/
		Connection con = ConfBanco.getConnection();
		
		String sql = "CREATE TABLE IF NOT EXISTS municipios ( " + 
		" id SERIAL PRIMARY KEY, area_territorial TEXT NOT NULL, cod_validacao TEXT NOT NULL, "
		+ "contatos_responsavel_preenchimento TEXT NOT NULL, date TEXT NOT NULL, "
		+ "descricao TEXT NOT NULL, email_responsavel_preenchimento TEXT NOT NULL, "
		+ "estado TEXT NOT NULL, fonte_informacoes TEXT NOT NULL, img_url TEXT, "
		+ "informacoes_relevantes TEXT NOT NULL,latitude REAL , longitude REAL , "
		+ "nome_cidade TEXT NOT NULL , nome_responsavel_preenchimento TEXT NOT NULL , "
		+ "populacao INTEGER, site TEXT )";
		
		
		PreparedStatement statement = (PreparedStatement)con.prepareStatement(sql);
		
		statement.execute();
		
		
	}
	
	public boolean verificaDados(Municipios city) throws SQLException, ClassNotFoundException{
		Connection cx = ConfBanco.getConnection();
		/*
		 * Esse metodo verifica se ja existe dados existentes entre o banco de dados e o CSV
		 * 
		 */
		String nome_city = "\'"+city.getNomecidade()+"\'";
		String estado_city = "\'"+city.getEstado()+"\'";
		String lat_city = "\'"+city.getLatitude()+"\'";
		String lot_city = "\'"+city.getLongitude()+"\'";
		String sql = "SELECT nome_cidade,estado,latitude,longitude FROM municipios "
				+ "WHERE nome_cidade="+nome_city+" AND estado="+estado_city+" AND latitude="+lat_city+" AND longitude="+lot_city;
		PreparedStatement statement =(PreparedStatement)cx.prepareStatement(sql);
		
		ResultSet result = statement.executeQuery();
		while(result.next()){
			String name = result.getString("nome_cidade");
			String estado = result.getString("estado");
			String lat = result.getString("latitude");
			String longi = result.getString("longitude"); 
			if(city.getNomecidade().equals(name) && city.getEstado().equals(estado) && city.getLatitude()==lat && city.getLongitude() == longi){
				// daado ja esta incluso
				return true;
			}
		}
		result.close();
		statement.close();
		cx.close();
		return false;
	}
	
	public void addMunicipio(Municipios municipios) throws ClassNotFoundException, SQLException{
		
		if(verificaDados(municipios)){
			System.err.println("dado ja add: "+ municipios.getNomecidade());
		}else{
			try{
				Connection cx = ConfBanco.getConnection();
				String sql = "INSERT INTO municipios(date,img_url,cod_validacao,nome_cidade,descricao,area_territorial,latitude,longitude,estado,populacao,site,informacoes_relevantes,email_responsavel_preenchimento, nome_responsavel_preenchimento, contatos_responsavel_preenchimento,fonte_informacoes) "
						+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				
				PreparedStatement statement = (PreparedStatement)cx.prepareStatement(sql);
				
				statement.setString(1, municipios.getDate());
				statement.setString(2, municipios.getImgUrl());
				statement.setString(3, municipios.getCodValidacao());
				statement.setString(4, municipios.getNomecidade());
				statement.setString(5, municipios.getDescricao());
				statement.setString(6, municipios.getAreaTerritorial());
				statement.setString(7, municipios.getLatitude());
				statement.setString(8, municipios.getLongitude());
				statement.setString(9, municipios.getEstado());
				statement.setInt(10,municipios.getPopulacao());
				statement.setString(11, municipios.getSite());
				statement.setString(12,municipios.getInformacoesRelevantes());
				statement.setString(13, municipios.getEmail_responsavel());
				statement.setString(14, municipios.getNome_responsavel());
				statement.setString(15, municipios.getContatos_responsavel());
				statement.setString(16, municipios.getFonte_informacoes());
				
				
				statement.execute();
				statement.close();
				cx.close();
				System.err.println("Adicionado!");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public void removerMunicipio(int ID_municipio) throws ClassNotFoundException, SQLException{
		
		try{
			Connection cx = ConfBanco.getConnection();
			String sql = "DELETE FROM municipios WHERE id= ?";
			PreparedStatement statement = (PreparedStatement)cx.prepareStatement(sql);
			statement.setInt(1, ID_municipio);
			statement.execute();
			
			statement.close();
			cx.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
		

}
