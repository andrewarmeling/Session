package br.com.otSession.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUsuarioDAO {

	private Connection conexao;

	public JDBCUsuarioDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public boolean validarUsuario(String usuario, String senha) {
		try {

			String comando = "SELECT usuario FROM usuarios WHERE usuario = '" + usuario + "' AND senha = '" + senha + "';";
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);

			if (rs.next()) {
				return true;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
