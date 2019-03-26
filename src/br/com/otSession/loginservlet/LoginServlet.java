package br.com.otSession.loginservlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.otSession.bd.conexao.Conexao;
import br.com.otSession.jdbc.JDBCUsuarioDAO;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Get");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post");
		
		Conexao conec = new Conexao();
		Connection conexao = conec.abrirConexao();
		
		JDBCUsuarioDAO objetoDAO = new JDBCUsuarioDAO(conexao);
		
		System.out.println(objetoDAO.validarUsuario(request.getParameter("usuario")));		
		
	}
}
