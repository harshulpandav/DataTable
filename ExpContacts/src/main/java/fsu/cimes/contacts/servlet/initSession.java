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
 * Servlet implementation class initSession
 */
@WebServlet("/init.do")
public class initSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public initSession() {
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
		ProcessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request, response);
	}

	private void ProcessRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		PrintWriter out = response.getWriter();
		if (application.getAttribute("UserLogined") == null) {
			application.setAttribute("UserLogined", 0);
			application.setAttribute("userID", "");
			application.setAttribute("reset", false);
		}

		if (application.getAttribute("userID") != "") {
			if (!session.getId().equals(application.getAttribute("userID"))) {
				out.print("<script type=\"text/javascript\">"
						+ "alert(\"Other User is accessing this page !!!!\");"
						+ "window.location='Index.jsp'</script>");
				System.out.println("We have user already!!!!");
			}else {
				application.setAttribute("UserLogined", 1);
				application.setAttribute("userID", session.getId());			
				response.sendRedirect("start.jsp");
				System.out.println("After init  ASI:"+application.getAttribute("userID"));
				System.out.println("After init  MSI:"+session.getId());
			}
		} else {
			application.setAttribute("UserLogined", 1);
			application.setAttribute("userID", session.getId());			
			System.out.println("After init  ASI:"+application.getAttribute("userID"));
			System.out.println("After init  MSI:"+session.getId());
			response.sendRedirect("start.jsp");
		}
	}

}
