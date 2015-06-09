<%@page import="fsu.cimes.contacts.jpa.SpringApplicationContext"%>
<%@page import="fsu.cimes.contacts.jpa.TransactionService"%>
<%@page import="java.util.*"%>
<%@page import="fsu.cimes.contacts.jpa.*"%>
<%@page import="fsu.cimes.contacts.model.*"%>

<!---
   @author hpandav 
-->
 
<% 
		String posCode = request.getParameter("posCodeSelected");
		TransactionService t = (TransactionService) SpringApplicationContext
		.getBean("transactionService");
		t.addGroupSelections(posCode);
		List<String> listGroupSel =new ArrayList<String>();	
		listGroupSel = (List<String>)session.getAttribute("listGroupSel");
		listGroupSel.add(posCode);
		session.setAttribute("listGroupSel",listGroupSel);
%>