package br.com.otSession.filtros;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.google.gson.Gson;

@WebFilter("/home")
public class FiltroLogin implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String context = request.getServletContext().getContextPath();
		
		try {
			HttpSession sessao = ((HttpServletRequest) request).getSession();
			String usuario = null;
			if (sessao != null) {
				usuario = (String) sessao.getAttribute("login");
			}
			if (usuario == null) {
				sessao.setAttribute("msg", "Você não está logado!");
				
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("url", context + "/index.html");
//				
//				Gson gson = new Gson();
//				String retornoJson = gson.toJson(map);
//				
//				PrintWriter out = response.getWriter();
//				response.setContentType("application/json");
//				response.setCharacterEncoding("UTF-8");
//				out.print(retornoJson);
//				out.flush();
				
				((HttpServletResponse) response).sendRedirect(context + "/index.html");
				
			} else {
				chain.doFilter(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
