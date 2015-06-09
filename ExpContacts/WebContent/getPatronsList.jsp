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
		List<Contacts> listContact = t.getContacts();
		String patronList = "";
		StringBuffer buffer = new StringBuffer();
// 		System.out.println(session.getId());
		for(Contacts c:listContact){
			if(c.getPositionCode()!=null && c.getPositionCode().contains(posCode))
			buffer.append(c.getPatronID()+"|");	
		}
		patronList = buffer.toString().substring(0,buffer.toString().length()-1);
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(patronList);
%>