<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link type="text/css" href="/Admission/css/blue/style.css" rel="stylesheet"/>
<script type="text/javascript" src="/Admission/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/Admission/js/jquery.tablesorter.js"></script>
<title>Applicant List</title>
<style type="text/css">
	a{color: rgb(0, 165, 233);}
</style>
</head>
<body>
	<b>CS Grad Admission</b>
	<br/><br/>
	<a href="/Admission/NewAdmission">Add New Application</a>
	<br/><br/>
	
	<c:if test="${fn:length(applicantList) == 0}">
		<p>We don't have any applicant yet.</p>
	</c:if>
		
	<c:if test="${fn:length(applicantList) > 0}">
		<form action="EditApplication" method="post" name="editApplicationForm">
			<input type="hidden" name="applicantId"/>
			<table border="1" class="tablesorter">
			<thead><tr>
			  <th>Applicant</th><th>Application Received On</th><th>GPA</th><th>Status</th><th style="background-image: none;pointer-events: none;"></th>
			</tr></thead>
			<tbody>
			<c:forEach items="${applicantList}" var="applicant" varStatus="status">
				<tr>
				  <td>${applicant.applicantName}</td>
				  <td><fmt:formatDate pattern="M/d/yyyy" value="${applicant.receivedDate}" /></td>
				  <td>${applicant.gpa}</td>
				  <td>${applicationStatus.get(applicant.status)}</td>
				  <td><a href="#" onclick="submitForm(${status.index})">Edit</a></td>
				</tr>
			</c:forEach>
				</tbody>
			</table>
		</form>
	</c:if>

<script type="text/javascript">
$(document).ready(function() { 
    // call the tablesorter plugin 
    $("table").tablesorter(); 
}); 


function submitForm(applicantId)
{   
	document.getElementsByName("applicantId")[0].value=applicantId;
	document.forms["editApplicationForm"].submit();
}

</script>	
</body>

</html>