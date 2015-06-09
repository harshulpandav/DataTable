
<%@page import="fsu.cimes.contacts.jpa.SpringApplicationContext"%>
<%@page import="fsu.cimes.contacts.jpa.TransactionService"%>
<%@page import="java.util.*"%>
<%@page import="fsu.cimes.contacts.jpa.*"%>
<%@page import="fsu.cimes.contacts.model.*"%>


<%
	//System.out.println("called in getlabels");
	String mailingID = request.getParameter("mailingID");
	System.out.println(mailingID);
	TransactionService t = (TransactionService) SpringApplicationContext
			.getBean("transactionService");

	List<GetPrintLabelV> labelList = t.getPrintingLabels(Integer.parseInt(mailingID));
	List<String> mylist = new ArrayList<String>();
 
	
	
	
    int count=0;
	//System.out.print(labelList.size());
	String generatedLabels = "";
	StringBuffer buffer = new StringBuffer();
 	for(int i=0;i<labelList.size();i++){
		GetPrintLabelV c=labelList.get(i);
		 if(Integer.toString(c.getMailingID()).equalsIgnoreCase(mailingID))
		{//print labels
			 count++;
			 buffer.append(c.getSalutation() + "==" + c.getFirstname() + "=="
				+ c.getLastname() + "==" + c.getOrganization() + "=="
				+ c.getAddress1() + "==" + c.getAddress2() + "=="
				+ c.getAddress3() + "==" + c.getAddress4() + "=="
				+ c.getCity() + "==" + c.getState() + "==" + c.getZip()
				+ "==");
		
		 }
		else {
			//No printing Labels avaialbale for this Mailing ID;
		} 
	} 

	 generatedLabels = buffer.toString();
	 generatedLabels= Integer.toString(count)+generatedLabels;
	System.out.println("mailingIdList: " + generatedLabels); 
	//response.setContentType("application/json");
	response.setHeader("Cache-Control", "no-cache");
	response.getWriter().write(generatedLabels);
	//response.getWriter().write(new JsonPrintLabel().getJson(labelList));
%>