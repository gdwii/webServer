package tomcat.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/session/get")
public class SessionGet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2953499713730939674L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String testContent = (String)req.getSession().getAttribute("test");
		resp.getWriter().print(testContent);
	}
}
