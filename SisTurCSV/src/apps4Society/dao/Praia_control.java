package apps4Society.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import apps4Society.conf.ConfBanco;
import apps4Society.model.AtrativoTuristico;
import apps4Society.model.Praia;

public class Praia_control {
	
	public boolean verificaDadosPraia(Praia p) throws SQLException, ClassNotFoundException{
		Connection cx = ConfBanco.getConnection();
		/*
		 * Esse metodo verifica se ja existe dados existentes entre o banco de dados e o CSV
		 * 
		 */
		String sql = "SELECT * FROM praias";
		PreparedStatement statement =(PreparedStatement)cx.prepareStatement(sql);
		
		ResultSet result = statement.executeQuery();
		while(result.next()){
		
			String name = result.getString("nome");
			String como_chegar = result.getString("comochegar");
			if(p.getNome().equals(name) && p.getComochegar().equals(como_chegar)){
				// daado ja esta incluso
				return true;
			}
		}
		result.close();
		statement.close();
		cx.close();
		return false;
		
	}
	
	public void addPraia(Praia praia) throws SQLException, ClassNotFoundException{
		
		if(verificaDadosPraia(praia)){
			System.err.println("dado praia ja add ");
		}else{
			try{
				Connection cx = ConfBanco.getConnection();
				String sql = "INSERT INTO praias(nome,comochegar,descricao,info_contato,latitude,longitude,perigo_tubarao,propia_banho,tipo_orla)" +
						"VALUES (?,?,?,?,?,?,?,?,?)";
				PreparedStatement statement = (PreparedStatement)cx.prepareStatement(sql);
				statement.setString(1, praia.getNome());
				statement.setString(2, praia.getComochegar());
				statement.setString(3, praia.getDescricao());
				statement.setString(4,praia.getInfo_contato());
				statement.setDouble(5, praia.getLatitude());
				statement.setDouble(6,	praia.getLongitude());
				statement.setBoolean(7,praia.getPerigoTubarao());
				statement.setBoolean(8, praia.getPropiaBanho());
				statement.setString(9, praia.getTipoOrla());
				
				
				statement.execute();
				statement.close();
				cx.close();
				System.err.println("Praia Adicionado!");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
