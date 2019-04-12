package br.com.otSession.loginservlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
				
//		System.out.println(objetoDAO.validarUsuario(request.getParameter("usuario"), request.getParameter("senha")));

		System.out.println("usuario: " + request.getParameter("usuario"));
		System.out.println("senha Base64: " + request.getParameter("senha"));
		
		String senhaMD5 = request.getParameter("senha");
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		md.update(senhaMD5.getBytes("UTF-8"), 0, senhaMD5.length());
		
//		System.out.println("MD5: " + new BigInteger(1, md.digest()).toString());
		System.out.println("MD5: " + md.digest().toString());
		
//		if (objetoDAO.validarUsuario(request.getParameter("usuario"), request.getParameter("senha"))) {
//			HttpSession sessao = request.getSession();
//			sessao.setAttribute("login", request.getParameter("usuario"));
//			response.sendRedirect("/Session/home.html");
//		} else {
//			response.sendRedirect("/Session/index.html");
//		}
		
	}
}
