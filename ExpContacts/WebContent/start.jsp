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
$(document).ready( function(){
	var myVar = setInterval(function() {
		checkUserLoginedStart()
	}, 3000);
});

window.onbeforeunload = function(e) {
	$(".loader").fadeIn("fast");

	if($("#resetForm").val()=="true"){
		localStorage.removeItem("pCount");
		localStorage.removeItem("totCount");
		localStorage.removeItem("posCodeSelected");
		localStorage.removeItem("matSelected");	
	}
	else{
		localStorage.setItem("pCount", $('#pCount').val());
		localStorage.setItem("totCount", $('#tCount').val());
		localStorage.setItem("posCodeSelected", $( "#posCode option:selected" ).text());
		localStorage.setItem("matSelected", $( "#materialSel option:selected" ).text());
	}
}
window.onload = function() {
// 	   $( "#posCode" )
// 	      .selectmenu()
// 	      .selectmenu( "menuWidget" )
// 	        .addClass( "overflow" );
		// Animate loader off screen
	$(".loader").fadeOut("slow");

  var totCount = localStorage.getItem("totCount");
  if (totCount != null) $('#tCount').val(totCount);
  
  var pCount = localStorage.getItem("pCount");
  if (pCount != null) $('#pCount').val(pCount);
  
  var posCodeSelected = localStorage.getItem("posCodeSelected");
  if (posCodeSelected != null) {
// 	  $('#posCode').val(posCodeSelected);
	  $("select#posCode option")
	   .each(function() { this.selected = (this.text == posCodeSelected); });
  }
  
  var matSelected = localStorage.getItem("matSelected");
  if (matSelected != null) {
// 	  $('#materialSel').val(matSelected);
	  $("select#materialSel option")
	   .each(function() { this.selected = (this.text == matSelected); });
  }
}
</script>
</head>
<body id="home">

	<div id="showAlert" style="display: none;" class="bb-alert alert alert-info" >
        <span></span>
    </div>
<%@include file="NavBar.jsp" %>
<div class="loader"></div>
<%
List<String> listGroupSel =new ArrayList<String>();
if(session.getAttribute("listGroupSel")==null){
	session.setAttribute("listGroupSel", new ArrayList<String>());
}
else{	
listGroupSel = (List<String>)session.getAttribute("listGroupSel");
}
List<String> listMatSel =new ArrayList<String>();
if(session.getAttribute("listMatSel")==null){
	session.setAttribute("listMatSel", new ArrayList<String>());
}
else{	
	listMatSel = (List<String>)session.getAttribute("listMatSel");
}
%>
		<div id="main">
			<button id = "saveBut" class="btn btn-success" onclick="saveForm();">
  				<i class="glyphicon glyphicon-floppy-disk"></i> Save
			</button>
			<button id = "resetBut" class="btn btn-danger" onclick="resetForm();">
			  <i class="glyphicon glyphicon-refresh"></i> Reset
			</button>
			<input type="hidden" value="false" id="resetForm"/>
			<div id="menu">
				<div id="content">
					<div style="width: 100%; overflow: auto;">
						<div style="float: left; width: 77%">
								<fieldset style="margin-bottom: 5px;">
									<label for="mIDDesc">Mailing ID Desc</label>
									<input type=text id="mIDDesc" style="margin-left: 10px;">
								</fieldset>
							<div id="posCodeContainer" style="position: relative; overflow: hidden;">
								<fieldset>
									<label for="posCode">Position Code</label> 
									
									<select
										style="width: 300px; margin-left: 20px" id="posCode"
										name="posCodeSel" onchange="positionCodeSel();">
										<option style="width: 400px" value ="select" selected>Select</option>
										<%
// 											System.out.println(session.getId());
// 											TransactionService t = (TransactionService) SpringApplicationContext
// 													.getBean("transactionService");
											List<PositionCodeCountV> listPos = t.findPositionCodesCountEntities(true, 0,
													0);
											for (PositionCodeCountV p : listPos) {
												if (p.getPositionCode() == null)
													continue;
										%>
<%-- 										<option style="width: 400px" value="<%=p.getId()+","+p.getPCount()%>"><%=(p.getPositionCode().length() > 50 ? p.getPositionCode().substring(0, 48) + "..." : p.getPositionCode())+(" || "+p.getPCount())%></option> --%>
											<option style="width: 400px" value="<%=p.getId()+","+p.getPCount()%>"><%=p.getPositionCode()+(" -- "+p.getPCount())%></option>
							
										<% } %>
	
									</select>
								</fieldset>
								<fieldset>
									<label for="pCount">Preview Count</label>
									<input type=text id="pCount" disabled>
								</fieldset>
								<fieldset>
								<label for="tCount">Total Count</label>
								<input type=text id="tCount" disabled>
							</fieldset>
							</div>
							<div>
								<fieldset>
								    <button name="addToGroup" id="addToGroup" onclick="javascript:addToGrpSel();">Add to Group Selection</button>
								    <button name="showNames" id="getPatrons" onclick="javascript:getPatronList();">Show Names --></button>
								</fieldset>
								<div style="margin-top:20px; margin-left:7px">
									<fieldset>
										<label for="grpSelDiv">Group Selection</label>
										<div id="grpSelDiv">
											<ul id="grpSelList" data-role="listview">
											<% for(String gSel : listGroupSel){ %>
												<li style="margin-bottom: 3px"><%= gSel %><button type="button" class="btn btn-xs btn-danger itemDelete" style="float: right" aria-label="Left Align" onclick="removeSelection(this)"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></li>
											<% } %>
											</ul>
										</div>
									</fieldset>
								</div>
							</div>							
							<div id="materialSelContainer" style="position: relative; overflow: hidden; margin-top: 20px">
								<fieldset>
									<label for="materialSel">Materials Available</label> 
									
									<select
										style="width: 300px; margin-left: 20px" id="materialSel"
										name="materialSel">
										<option style="width: 400px" value ="select" selected>Select</option>
										<%
											List<MaterialsAvailable> listMat = t.getMaterialsAvailable();
											for (MaterialsAvailable m : listMat) {
												if (m.getMaterialName() == null)
													continue;
										%>
										<option style="width: 400px" value="<%=m.getId()%>"><%=m.getMaterialName()%></option>
							
										<% } %>
	
									</select>
								</fieldset>								
							</div>
							<div>
								<fieldset>
								    <button name="addMatToSel" id="addMatToSel" onclick="javascript:addMatToSel();">Add Material to Selection</button>
								</fieldset>
								<div style="margin-top:20px; margin-left:7px">
									<fieldset>
										<label for="matSelList">Material Selection</label>
										<div id="matSelDiv">
											<ul id="matSelList" data-role="listview">
											<% for(String mSel : listMatSel){ %>
												<li  style="margin-bottom: 3px"><%= mSel %><button type="button" style="float: right" class="btn btn-xs btn-danger itemDelete" aria-label="Left Align" onclick="removeSelection(this)"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></li>
											<% } %>
											</ul>
										</div>
									</fieldset>
								</div>
							</div>
							
							
						</div>
						<div>
							<fieldset>
								<label for="patronsDiv">Patrons</label>
								<div id="patronsDiv">
									<ul id="patronList" data-role="listview">
									</ul>
								</div>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
<!-- 	</form> -->
</body>
</html>