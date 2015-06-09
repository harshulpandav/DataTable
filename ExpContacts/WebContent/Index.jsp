<!DOCTYPE html>
<%@page import="fsu.cimes.contacts.jpa.SpringApplicationContext"%>
<%@page import="fsu.cimes.contacts.jpa.TransactionService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="fsu.cimes.contacts.jpa.*"%>
<%@page import="fsu.cimes.contacts.model.*"%>
<%
	if (application.getAttribute("UserLogined") == null) {
		application.setAttribute("UserLogined", 0);
		application.setAttribute("userID", "");
		application.setAttribute("reset", false);
	}
%>
<html>
<head>
<%@include file="Header.jsp"%>
<script type="text/javascript">
	var myVar = setInterval(function() {
		checkUserLoginedIndex()
	}, 4000);
	
	window.onload = function() {
		$('#CreateListAnchor').click(function(){
			$(".loader").fadeIn("fast");
		});
		// Animate loader off screen
	$(".loader").fadeOut("slow");
	}
</script>
</head>
<body id="home">
<div class="loader"></div>
	<div id="showAlert" style="display: none;"
		class="bb-alert alert alert-info">
		<span></span>
	</div>
	<%@include file="NavBar.jsp"%>
	<div id="menu">
		<div id="main">
			<button id="warningButn" class="btn btn-danger" style="display: none;" onclick="javascript:invalidateSession()">
				<i class="glyphicon glyphicon-hand-right"></i> Terminate Other User's Session
			</button>
			<div id="content">
				<div style="width: 100%; overflow: auto;">
					<div style="float: left; width: 77%">
						<div id="posCodeContainer"
							style="position: relative; overflow: hidden;">
							<fieldset>
								<a id="CreateListAnchor" href="init.do" class="list-group-item">Select Groups for Mailing</a>
								<a id="mailingListAnchor" href="PrintLabelUsingMailingID.jsp" class="list-group-item">Get Mailing List</a>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>