<%@page import="fsu.cimes.contacts.jpa.SpringApplicationContext"%>
<%@page import="fsu.cimes.contacts.jpa.TransactionService"%>
<%@page import="java.util.*"%>
<%@page import="fsu.cimes.contacts.jpa.*"%>
<%@page import="fsu.cimes.contacts.model.*"%>
<!---
   @author hpandav 
-->
<% 
		String matSelected = request.getParameter("matSelected");
		TransactionService t = (TransactionService) SpringApplicationContext
		.getBean("transactionService");
		t.addMatSelections(matSelected);
		List<String> listMatSel =new ArrayList<String>();	
		listMatSel = (List<String>)session.getAttribute("listMatSel");
		listMatSel.add(matSelected);
		session.setAttribute("listMatSel",listMatSel);
%>