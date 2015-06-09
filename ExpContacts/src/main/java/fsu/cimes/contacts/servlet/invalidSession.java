package fsu.cimes.contacts.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fsu.cimes.contacts.jpa.SpringApplicationContext;
import fsu.cimes.contacts.jpa.TransactionService;

/**
*
* @author mchimankar
*/
/**
 * Servlet implementation class invalidSession
 */
@WebServlet("/invalS.do")
public class invalidSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public invalidSession() {
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
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(true);
		session.setAttribute("listGroupSel", null);	
		session.setAttribute("listMatSel", null);
		TransactionService t = (TransactionService) SpringApplicationContext
				.getBean("transactionService");
		t.removeSelections();
		processRequest(request, response);

	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("Invalide call!!!");
		ServletContext sc = getServletContext();
		sc.setAttribute("UserLogined", 0);
		sc.setAttribute("reset", true);
		sc.setAttribute("userID", "");
		System.out.println("After Invalid ASI:"+sc.getAttribute("userID"));
		
		
	}

}
