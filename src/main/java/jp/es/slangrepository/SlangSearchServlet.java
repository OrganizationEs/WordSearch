package jp.es.slangrepository;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SlangSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ApplicationContext app;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		app = new ClassPathXmlApplicationContext("/spring/application-config.xml");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
