package fsu.cimes.contacts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fsu.cimes.contacts.jpa.SpringApplicationContext;
import fsu.cimes.contacts.jpa.TransactionService;
import fsu.cimes.contacts.model.MaterialsAvailable;

/**
*
* @author hpandav
*/

@WebServlet("/saveMaterial")
public class saveMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public saveMaterial() {
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
		if(request.getParameter("id")!=null){
		int id = Integer.parseInt((String)request.getParameter("id"));
		TransactionService t = (TransactionService) SpringApplicationContext
				.getBean("transactionService");
		MaterialsAvailable m = t.getMaterialsAvailableById(id).get(0);

		request.setAttribute("matId",m.getId());
		request.setAttribute("matName",m.getMaterialName());
		request.setAttribute("format",m.getFormat());
		request.setAttribute("delMethod",m.getDefaulDeliveryMethod());
		request.setAttribute("project",m.getProject());
		request.setAttribute("electronic",m.getElectronic());
		request.setAttribute("active",m.getActive());
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addNewMaterial.jsp");
		dispatcher.forward(request,response);
		//processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String matName = request.getParameter("matName");
		String format = request.getParameter("format");
		String delMethod = request.getParameter("delMethod");
		String project = request.getParameter("project");
		boolean electronic = "true".equals(request.getParameter("electronic"))?true:false;
		boolean active = "true".equals(request.getParameter("active"))?true:false;
		TransactionService t = (TransactionService) SpringApplicationContext
		.getBean("transactionService");
		MaterialsAvailable m = new MaterialsAvailable();
		m.setActive(active);
		m.setDefaulDeliveryMethod(delMethod);
		m.setElectronic(electronic);
		m.setFormat(format);
		m.setMaterialName(matName);
		m.setProject(project);
		t.addMaterialsAvailable(m);
		request.setAttribute("dataSaved", "true");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addNewMaterial.jsp");
		dispatcher.forward(request,response);

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
