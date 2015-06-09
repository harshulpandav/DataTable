<%@page import="fsu.cimes.contacts.jpa.SpringApplicationContext"%>
<%@page import="fsu.cimes.contacts.jpa.TransactionService"%>
<%@page import="java.util.*"%>
<%@page import="fsu.cimes.contacts.jpa.*"%>
<%@page import="fsu.cimes.contacts.model.*"%>

<!---
   @author hpandav 
-->
 
<% 
		String category = request.getParameter("category");
		String selection = request.getParameter("selection");
// 		TransactionService t = (TransactionService) SpringApplicationContext
// 		.getBean("transactionService");
		List<String> listSel =new ArrayList<String>();	
		if("grpSelList".equals(category)){
			listSel = (List<String>)session.getAttribute("listGroupSel");
			listSel.remove(selection);
			session.setAttribute("listGroupSel",listSel);
		}
		else{
			listSel = (List<String>)session.getAttribute("listMatSel");
			listSel.remove(selection);
			session.setAttribute("listMatSel",listSel);
		}
		
%>