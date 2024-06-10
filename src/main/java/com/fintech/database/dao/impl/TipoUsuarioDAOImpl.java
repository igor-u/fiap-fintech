package com.fintech.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fintech.database.FintechDBManager;
import com.fintech.database.dao.TipoUsuarioDAO;
import com.fintech.model.usuario.TipoUsuario;

public class TipoUsuarioDAOImpl implements TipoUsuarioDAO {

	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void insert(TipoUsuario tipo) {

		try {
			conexao = FintechDBManager.obterConexao();
			pstmt = conexao.prepareStatement("INSERT INTO TIPOS_USUARIO "
					+ "(ID_TIPO, DESCRICAO) " + 
					"VALUES (?, ?)");

			pstmt.setString(1, tipo.get());
			pstmt.setString(2, tipo.toString());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TipoUsuario> getAll() {
		List<TipoUsuario> tipos = new ArrayList<TipoUsuario>();
		ResultSet resultSet = null;
		conexao = FintechDBManager.obterConexao();
		
		try {
		pstmt = conexao.prepareStatement("SELECT * FROM TIPOS_USUARIO");
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				
				TipoUsuario tipoUsuario = null;
				
				if (resultSet.getString("ID_TIPO").contains("1")) {
					tipoUsuario = TipoUsuario.USUARIO_PESSOA;
				}
				else
					if (resultSet.getString("ID_TIPO").contains("2")) {						
						tipoUsuario = TipoUsuario.USUARIO_EMPRESA;
					}
				
				tipos.add(tipoUsuario);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tipos;
	}

}
