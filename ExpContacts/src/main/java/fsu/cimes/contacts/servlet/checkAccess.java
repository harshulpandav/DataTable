package fsu.cimes.contacts.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mchimankar
 */
/**
 * Servlet implementation class checkAccess
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/chechAccess.do" })
public class checkAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public checkAccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		PrintWriter out = response.getWriter();
		// System.out.println(application.getAttribute("userID"));
		if (application.getAttribute("UserLogined") == null) {
			application.setAttribute("UserLogined", 0);
			application.setAttribute("userID", "");
			application.setAttribute("reset", false);
		}
		String referer = request.getHeader("Referer");

		if (referer.contains("start.jsp") || referer.contains("init.do")) {
			if (!session.getId().equals(application.getAttribute("userID"))) {
				out.write("false");
//				System.out.println(referer);
//				System.out.println("Application Context Session ID:"
//						+ application.getAttribute("userID"));
//				System.out.println("My Context Session ID:"
//						+session.getId());
				
			} else {
				out.write("true");
			}
		} else if (application.getAttribute("userID").equals("")) {
			out.write("true");
		} else if (application.getAttribute("userID").equals(session.getId())) {
			out.write("true");
		} else {
			out.write("false" + "");
		}

	}

}
