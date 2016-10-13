package tomcat.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/session/test")
public class SessionTest extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6731154383432904324L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "sessionId=" + req.getSession().getId();
		resp.getWriter().println(result);
	}
}
