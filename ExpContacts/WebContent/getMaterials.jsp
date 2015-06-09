
<%@page import="fsu.cimes.contacts.jpa.SpringApplicationContext"%>
<%@page import="fsu.cimes.contacts.jpa.TransactionService"%>
<%@page import="java.util.*"%>
<%@page import="fsu.cimes.contacts.jpa.*"%>
<%@page import="fsu.cimes.contacts.model.*"%>
<%@page import="com.google.gson.Gson"%>


<%
	TransactionService t = (TransactionService) SpringApplicationContext.getBean("transactionService");
	List<MaterialsAvailable> matList = t.getAllMaterialsAvailable();
	StringBuilder strB = new StringBuilder();
	String prefix = "";
	strB.append("{ \"data\":[");
	
	for(MaterialsAvailable m : matList){
		strB.append(prefix);
		prefix = ",";
		strB.append(m.toString());
		
	}
	strB.append("] }");
	System.out.println(strB.toString());
	response.setContentType("application/json");
	response.getWriter().write(strB.toString());
%>