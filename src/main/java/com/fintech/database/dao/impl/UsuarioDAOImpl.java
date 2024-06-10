package com.fintech.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fintech.database.FintechDBManager;
import com.fintech.database.dao.UsuarioDAO;
import com.fintech.model.usuario.TipoUsuario;
import com.fintech.model.usuario.Usuario;
import com.fintech.model.usuario.UsuarioBuilder;

public class UsuarioDAOImpl implements UsuarioDAO {

	private Connection conexao;
	PreparedStatement pstmt = null;

	@Override
	public void insert(Usuario usuario) throws SQLException {

			conexao = FintechDBManager.obterConexao();
			pstmt = conexao.prepareStatement("INSERT INTO USUARIOS "
					+ "(ID_USUARIO, TIPO_USUARIO, NOME, TELEFONE, EMAIL, HASH_SENHA) " + 
					"VALUES (?, ?, ?, ?, ?, ?)");


			pstmt.setString(1, usuario.getId());
			pstmt.setString(2, usuario.getTipo().get());
			pstmt.setString(3, usuario.getNome());
			pstmt.setString(4, usuario.getTelefone());
			pstmt.setString(5, usuario.getEmail());
			pstmt.setString(6, usuario.getHashSenha());

			pstmt.executeUpdate();

	}

	@Override
	public List<Usuario> getAll() {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		ResultSet resultSet = null;
		conexao = FintechDBManager.obterConexao();

		try {
			pstmt = conexao.prepareStatement("SELECT * FROM USUARIOS");
			resultSet = pstmt.executeQuery();

			while(resultSet.next()) {

				Usuario usuario = new UsuarioBuilder()
						.comId(resultSet.getString("ID_USUARIO"))
						.comNome(resultSet.getString("NOME"))
						.comTelefone(resultSet.getString("TELEFONE"))
						.comEmail(resultSet.getString("EMAIL"))
						.comHashSenha(resultSet.getString("HASH_SENHA"))
						.build();;

						if (resultSet.getString("TIPO_USUARIO").contains("1")) {
							usuario.setTipo(TipoUsuario.USUARIO_PESSOA);
						}
						else
							if (resultSet.getString("TIPO_USUARIO").contains("2")) {						
								usuario.setTipo(TipoUsuario.USUARIO_EMPRESA);
							}


						usuarios.add(usuario);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public Usuario findByEmail(String email) {
		Usuario user = new Usuario();
		ResultSet resultSet = null;
		conexao = FintechDBManager.obterConexao();

		try {
			pstmt = conexao.prepareStatement(String.format("SELECT * FROM USUARIOS WHERE EMAIL = '%s'", email));
			resultSet = pstmt.executeQuery();

			while(resultSet.next()) {

				Usuario usuario = new UsuarioBuilder()
						.comId(resultSet.getString("ID_USUARIO"))
						.comNome(resultSet.getString("NOME"))
						.comTelefone(resultSet.getString("TELEFONE"))
						.comEmail(resultSet.getString("EMAIL"))
						.comHashSenha(resultSet.getString("HASH_SENHA"))
						.build();;

						if (resultSet.getString("TIPO_USUARIO").contains("1")) {
							usuario.setTipo(TipoUsuario.USUARIO_PESSOA);
						}
						else
							if (resultSet.getString("TIPO_USUARIO").contains("2")) {						
								usuario.setTipo(TipoUsuario.USUARIO_EMPRESA);
							}

						user = usuario;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;

	}

}
