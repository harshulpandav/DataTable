<%@page import="fsu.cimes.contacts.jpa.SpringApplicationContext"%>
<%@page import="fsu.cimes.contacts.jpa.TransactionService"%>
<%@page import="java.util.*"%>
<%@page import="fsu.cimes.contacts.jpa.*"%>
<%@page import="fsu.cimes.contacts.model.*"%>
<!---
   @author hpandav 
-->
<% 
session.setAttribute("listGroupSel", null);	
session.setAttribute("listMatSel", null);
TransactionService t = (TransactionService) SpringApplicationContext
		.getBean("transactionService");
t.removeSelections();
%>