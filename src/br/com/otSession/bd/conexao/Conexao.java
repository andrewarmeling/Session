package br.com.otSession.bd.conexao;

import java.sql.Connection;

public class Conexao {

	private Connection conexao;

	public Connection abrirConexao() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	//Possível causador de problema no futuro
			conexao = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/agendacontato", "root", "as");
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
