<!DOCTYPE html>
<%@page import="fsu.cimes.contacts.jpa.SpringApplicationContext"%>
<%@page import="fsu.cimes.contacts.jpa.TransactionService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="fsu.cimes.contacts.jpa.*"%>
<%@page import="fsu.cimes.contacts.model.*"%>
<html>
<head>

<%@include file="Header.jsp"%>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<!-- <link rel="stylesheet" type="text/css" -->
<!-- 	href="./css/jquery.dynatable.css"> -->

<!-- <script type="text/javascript" language="javascript" -->
<!-- 	src="./js/jquery.dynatable.js"></script> -->
<!-- <script type="text/javascript" src="./js/scrolling.js"></script> -->
<!-- <script type="text/javascript" charset="utf-8"> -->
	
</script>
</head>
<body id="home">
	<div id="showAlert" style="display: none;"
		class="bb-alert alert alert-info">
		<span></span>
	</div>
	<%@include file="NavBar.jsp"%>
	<div id="main">


		<div id="menu">
			<div id="content">

				<div id="posCodeContainer" style="position: relative; overflow: hidden;">
					<fieldset>
					
						<div align="center">
							
							 <select class="form-control" id="MailingID" name="posCodeSel" value=" Mailing ID"
									onchange="getLabelUsingMailingIDList();">
								
								<option style="width: 400px" value="select" selected>Select Mailing
									ID</option>
								<%
									List<MailingHistoryOverall> listIDs = t.findMailingIDsCount();

									for (MailingHistoryOverall p : listIDs) {
										if (p.getId() == null)
											continue;
								%>
								<option style="width: 400px" value="<%=p.getId()%>"><%=p.getId()%></option>

								<%
									}
								%>

							</select>
							
						</div>
						
					</fieldset>
				<button type="button" class="btn btn-default " id="export-to-excel" onclick="getLabelUsingMailingIDList();">
							 <span class="glyphicon glyphicon-cloud-download" aria-hidden="true"></span> Export to Excel
				</button>
			
				</div>
				<!-- 	<fieldset>
					<button name="showNames" id="getLabelUsingMailingIDs"
						onclick="getLabelUsingMailingIDList();">OK -->
				
				</fieldset>



				<fieldset>
					<div class="row">
						<div class="col-sm-12">
							<table id="printIDs" class="table">
								
							</table>
						</div>
					</div>
				</fieldset>
			</div>
		</div>
	</div>
	
</body>
</html>