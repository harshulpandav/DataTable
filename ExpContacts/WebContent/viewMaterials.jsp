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
<script type="text/javascript">

window.onload = function() {

	$(".loader").fadeOut("slow");
	getMaterialViewList();

}
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
				<fieldset>
					<div class="row">
						<div class="col-sm-12">
							<table id="printMaterials" class="table">
								
							</table>
						</div>
					</div>
				</fieldset>
			</div>
		</div>
	</div>
	
</body>
</html>