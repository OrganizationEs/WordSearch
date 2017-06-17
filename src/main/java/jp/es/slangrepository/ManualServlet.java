package jp.es.slangrepository;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ManualServlet extends HttpServlet {
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
	    response.setContentType("text/html;charset=Shift_JIS");
	    PrintWriter out = response.getWriter();

	    out.println("<html>");
	    out.println("<head><title>Manual</title></head><body>");
	    out.println("上ウインドウのアイコン押下か検索窓使用で、この下ウインドウに用語が出るます");
	    out.println("</body></html>");

	    out.close();
	}
}
