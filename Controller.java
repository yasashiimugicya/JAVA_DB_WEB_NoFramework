package chap16;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Login;
import model.Logout;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("ACTION");

		String page = null;

		if (action.equals("LOGIN")) {
			Login login = new Login();

			if (login.execute(req) == true) {
				page = "./chap16/success.jsp";
			} else {
				page = "./chap16/start.jsp";
			}
		} else if (action.equals("LOGOUT")) {
			Logout logout = new Logout();
			logout.execute(req);

			page = "./chap16/start.jsp";
		}

		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, res);
	}

}
