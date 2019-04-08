package br.com.otSession.bd.conexao;

import java.sql.Connection;
//import java.sql.DriverManager;

public class Conexao {

	private Connection conexao;

	public Connection abrirConexao() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/otSession", "root", "as");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}

	public void fecharConexao() {
		try {
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
