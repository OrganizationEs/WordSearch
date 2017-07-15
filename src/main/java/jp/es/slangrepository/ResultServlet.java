package jp.es.slangrepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// メインページ上画面の検索実行に対応して、DBから用語セット群を抽出し、メインページ下画面へhtmlで反映させる
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ApplicationContext app;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		app = new ClassPathXmlApplicationContext("/spring/application-config.xml");
	}

	// メインページ上画面の検索実行に対応して、DBから用語セット群を抽出し、メインページ下画面へhtmlで反映させる
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyWord = request.getParameter("message");
		Extract extract = new Extract();

		ArrayList<SlangBean> extractSlangs = extract.exacExtract(keyWord);

	    response.setContentType("text/html;charset=Shift_JIS");
	    PrintWriter out = response.getWriter();

	    out.println("<html>");
	    out.println("<head><title>Lainz用語検索サイト_検索結果フレーム</title><link rel=\"stylesheet\" type=\"text/css\" href=\"css/test.css\" /></head><body>");
		for (int i = 0; i < extractSlangs.size(); i++) {
			out.println("<div class=\"box28\">");
			out.println("<span class=\"box-title\">");
			out.println(extractSlangs.get(i).getName());
			out.println("</span>");
			out.println("<p>");
			out.println(extractSlangs.get(i).getDescription());
			out.println("<br>");
			out.print("関連語：");
			out.println(extractSlangs.get(i).getRelational());
			out.println("</p>");
			out.println("</div>");
		}
	    out.println("</body></html>");

	    out.close();
	}
}