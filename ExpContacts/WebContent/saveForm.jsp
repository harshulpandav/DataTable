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
	int mailingID = Integer.parseInt(request.getParameter("mailingID"));
	String mailingIDDesc = request.getParameter("mIDDesc");

	TransactionService t = (TransactionService) SpringApplicationContext
	.getBean("transactionService");
	List<String> listGroupSel =new ArrayList<String>();
	listGroupSel = (List<String>)session.getAttribute("listGroupSel");
	List<String> listMatSel =new ArrayList<String>();
	listMatSel = (List<String>)session.getAttribute("listMatSel");
	MailingHistoryOverall m = new MailingHistoryOverall();
	m.setDescription(mailingIDDesc);
	t.addMailingHistoryOverall(m);
	List<MailingHistoryContacts> listMHC = new ArrayList<MailingHistoryContacts>();
	List<MailingHistoryPositionCodes> listMHPC = new ArrayList<MailingHistoryPositionCodes>();
	MailingHistoryContacts mhc;
	MailingHistoryPositionCodes mhpc;
	for(String g: listGroupSel){
		mhpc = new MailingHistoryPositionCodes();
		mhpc.setMailingID(mailingID);
		mhpc.setPositionCode(g);
		listMHPC.add(mhpc);
		for(Contacts c : t.findContactsByPositionCode(g)){
			for(String mat: listMatSel){
				mhc = new MailingHistoryContacts();
				mhc.setMailingID(mailingID);
				mhc.setPatronContactID(c.getId());
				mhc.setMaterialID(t.findMaterialByName(mat).get(0).getId());
				listMHC.add(mhc);
			}
		}
	}
	t.addListMailingHistoryContacts(listMHC);
	t.addListMailingHistoryPositionCodes(listMHPC);

%>