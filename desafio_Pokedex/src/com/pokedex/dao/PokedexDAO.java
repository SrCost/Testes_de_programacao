package com.pokedex.dao;

import com.pokedex.factory.ConnectionFactory;
import com.pokedex.model.Pokemon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class PokedexDAO {
	
	public void save(Pokemon pokemon) {
		
		String sql = "INSERT INTO tb_pokedex(num, name, img, type) VALUES (?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			//criar conexao com o banco de dados
			con = ConnectionFactory.createConnectionToMySQL();
			
			//criar uma constante para executar a query
			pstm = (PreparedStatement) con.prepareStatement(sql);
			
			//adicionar os valores que sao recebidos pela query
			pstm.setLong(1, pokemon.getNum());
			pstm.setString(2, pokemon.getName());
			pstm.setString(3, pokemon.getImg());
			pstm.setString(4, pokemon.getType());
			
			//Exceutar a query
			pstm.execute();
			
			System.out.println("Pokemon adicionado a pokedex com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
			
			//fechar conexoes desnecessarias
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(con!=null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update (Pokemon pokemon) {
		
		String sql = "UPDATE tb_pokedex SET num = ?, name = ?, img = ?, type = ?" +
		"WHERE id = ?";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			//criar conexao com o banco
			con = ConnectionFactory.createConnectionToMySQL();
			
			//criar classe de execucao da query
			pstm = (PreparedStatement) con.prepareStatement(sql);
			
			//Adicionar os valores
			pstm.setLong(1, pokemon.getNum());
			pstm.setString(2, pokemon.getName());
			pstm.setString(3, pokemon.getImg());
			pstm.setString(4, pokemon.getType());
			
			//Id que sera atualizado
			pstm.setInt(4, pokemon.getId());
			
			//executar a query
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
				pstm.close();
			}
			if(con!=null) {
				con.close();
			}
			}catch (Exception e) {
			e.printStackTrace();
		}
	}
}	
	
	public void deleteById (int id) {
		
		String sql = "DELETE FROM tb_pokedex WHERE id = ?";
		
		Connection con = null;
		
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) con.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!= null) {
					pstm.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public List<Pokemon> getPokemon(){
		
		String sql = "SELECT * FROM tb_pokedex";
		
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		//classe que recupera os dados no banco ->SELECT
		ResultSet rset = null;
		
		try {
			con = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) con.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Pokemon pokemon = new Pokemon();
				
				//recuperar os dados no data base
				pokemon.setId(rset.getInt("id"));
				pokemon.setNum(rset.getLong("num"));
				pokemon.setName(rset.getString("name"));
				pokemon.setImg(rset.getNString("img"));
				pokemon.setType(rset.getString("type"));
				
				pokemons.add(pokemon);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(rset!=null) {
				rset.close();
			}	
			if(pstm!=null) {
				pstm.close();
			}
			if(con!=null) {
				con.close();
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		}
			return pokemons;
	}

}
