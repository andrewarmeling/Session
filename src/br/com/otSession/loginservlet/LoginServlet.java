package br.com.otSession.loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

//import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.otSession.bd.conexao.Conexao;
import br.com.otSession.jdbc.JDBCUsuarioDAO;

import com.google.gson.*;

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
//		System.out.println("Post");

		Conexao conec = new Conexao();
		Connection conexao = conec.abrirConexao();

//		System.out.println(objetoDAO.validarUsuario(request.getParameter("usuario"), request.getParameter("senha")));


//		Aplicação base64 e MD5
		
//		System.out.println("usuario: " + request.getParameter("usuario"));
//		System.out.println("senha Base64: " + request.getParameter("senha"));
//
//		String senhaB64 = request.getParameter("senha");
//		try {
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			md.update(senhaB64.getBytes());
//			byte[] codificado = md.digest();
//			BigInteger hex = new BigInteger(1, codificado);
//			String hashMD5 = hex.toString(16);
//			while (hashMD5.length() < 32) {
//				hashMD5 = 0 + hashMD5;
//			}
//			System.out.println("senha Base64 + MD5: " + hashMD5);
//		} catch (NoSuchAlgorithmException e) {
//			throw new RuntimeException(e);
//		}

		
//		Validação de usuário e criação de sessão
		
		JDBCUsuarioDAO objetoDAO = new JDBCUsuarioDAO(conexao);
		
		String context = request.getServletContext().getContextPath();
		
		if (objetoDAO.validarUsuario(request.getParameter("usuario"), request.getParameter("senha"))) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("login", request.getParameter("usuario"));
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("url", context + "/app/home.html");
			
			Gson gson = new Gson();
			String retornoJson = gson.toJson(map);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(retornoJson);
			out.flush();
			
		} else {			
			Map<String, String> map = new HashMap<String, String>();
			map.put("url", context + "/index.html");
			
			Gson gson = new Gson();
			String retornoJson = gson.toJson(map);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(retornoJson);
			out.flush();
			
		}

	}
}
