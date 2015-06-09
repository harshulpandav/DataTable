<%@page import="fsu.cimes.contacts.jpa.SpringApplicationContext"%>
<%@page import="fsu.cimes.contacts.jpa.TransactionService"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fsu.cimes.contacts.jpa.*"%>
<%@page import="fsu.cimes.contacts.model.*"%>
<!---
   @author hpandav 
-->
<% 
	String matName = request.getParameter("matName");
	String format = request.getParameter("format");
	String delMethod = request.getParameter("delMethod");
	String project = request.getParameter("project");
	boolean electronic = Boolean.getBoolean(request.getParameter("electronic"));
	boolean active = Boolean.getBoolean(request.getParameter("active"));
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

%>