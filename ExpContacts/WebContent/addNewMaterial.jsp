<!DOCTYPE html>
<!---
   @author hpandav 
-->
<%@page import="fsu.cimes.contacts.jpa.SpringApplicationContext"%>
<%@page import="fsu.cimes.contacts.jpa.TransactionService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="fsu.cimes.contacts.jpa.*"%>
<%@page import="fsu.cimes.contacts.model.*"%>
<html>
<head>
<%@include file="Header.jsp" %>
<script type="text/javascript">


// window.onbeforeunload = function(e) {
// 	$(".loader").fadeIn("fast");

// 	if($("#resetForm").val()=="true"){
// 		localStorage.removeItem("pCount");
// 		localStorage.removeItem("totCount");
// 		localStorage.removeItem("posCodeSelected");
// 		localStorage.removeItem("matSelected");	
// 	}
// 	else{
// 		localStorage.setItem("pCount", $('#pCount').val());
// 		localStorage.setItem("totCount", $('#tCount').val());
// 		localStorage.setItem("posCodeSelected", $( "#posCode option:selected" ).text());
// 		localStorage.setItem("matSelected", $( "#materialSel option:selected" ).text());
// 	}
// }
window.onload = function() {
// 	   $( "#posCode" )
// 	      .selectmenu()
// 	      .selectmenu( "menuWidget" )
// 	        .addClass( "overflow" );
		// Animate loader off screen
	$(".loader").fadeOut("slow");

	
//   var totCount = localStorage.getItem("totCount");
//   if (totCount != null) $('#tCount').val(totCount);
  
//   var pCount = localStorage.getItem("pCount");
//   if (pCount != null) $('#pCount').val(pCount);
  
//   var posCodeSelected = localStorage.getItem("posCodeSelected");
//   if (posCodeSelected != null) {
// // 	  $('#posCode').val(posCodeSelected);
// 	  $("select#posCode option")
// 	   .each(function() { this.selected = (this.text == posCodeSelected); });
//   }
  
//   var matSelected = localStorage.getItem("matSelected");
//   if (matSelected != null) {
// // 	  $('#materialSel').val(matSelected);
// 	  $("select#materialSel option")
// 	   .each(function() { this.selected = (this.text == matSelected); });
//   }
}
</script>
</head>
<body id="home">
	<input type="hidden" id="dataSaved" value="<%=request.getAttribute("dataSaved")==null?"": request.getAttribute("dataSaved")%>">
	<div id="showAlert" style="display: none;" class="bb-alert alert alert-info" >
        <span></span>
    </div>
<%@include file="NavBar.jsp" %>
<div class="loader"></div>
		<div id="main">

			<input type="hidden" value="false" id="resetForm"/>
			<div id="menu">
				<div id="content">
					<form role="form" method="post" id="newMaterialForm" action="saveMaterial" style="max-width: 400px">
  <input type="hidden" value="<%=request.getAttribute("matId")==null?"": request.getAttribute("matId")%>" class="form-control" id="matId" name="matId" required>
  <div class="form-group">
    <label for="matName">Material Name:</label>
    <input type="text" value="<%=request.getAttribute("matName")==null?"": request.getAttribute("matName")%>" class="form-control" id="matName" name="matName" required>
  </div>
  <div class="form-group">
    <label for="format">Format:</label>
    <input type="text" value="<%=request.getAttribute("format")==null?"": request.getAttribute("format")%>" class="form-control" id="format" name="format" required>
  </div>
   <div class="form-group">
    <label for="delMethod">Default Delivery Method:</label>
    <input type="text" class="form-control" value="<%=request.getAttribute("delMethod")==null?"": request.getAttribute("delMethod")%>" id="delMethod" name="delMethod" required>
  </div>
   <div class="form-group">
    <label for="project">Project:</label>
    <input type="text" class="form-control" value="<%=request.getAttribute("project")==null?"": request.getAttribute("project")%>" id="project" name="project" required>
  </div>
  <div class="checkbox">
    <label><input type="checkbox" value="<%=request.getAttribute("electronic")==null?"false": request.getAttribute("electronic")%>" class="checkboxM" id="electronic"  name="electronic" required>Electronic</label>
  </div>
  <div class="checkbox">
    <label><input type="checkbox" value="<%=request.getAttribute("active")==null?"false": request.getAttribute("active")%>" class="checkboxM"  id="active"  name="active" required>Active</label>
  </div>
  			<button id = "saveBut" class="btn btn-success" type="submit" onclick="saveNewMaterial();">
  				<i class="glyphicon glyphicon-floppy-disk"></i> Save
			</button>
			<button id = "resetBut" class="btn btn-danger" onclick="resetNewMaterial();">
			  <i class="glyphicon glyphicon-refresh"></i> Reset
			</button>
</form>

				</div>
			</div>
		</div>
</body>
</html>