package tomcat.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/session/add")
public class SessionAdd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3911778699112807902L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("test", "test session data");
		resp.getWriter().println("finish putting session data");
	}
}
