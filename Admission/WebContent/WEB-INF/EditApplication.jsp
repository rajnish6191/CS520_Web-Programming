<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>CS Grad Admission -Edit</title>
	<style type="text/css">
		tr > td:nth-child(1){
			text-align: right;
		}
		a{color: rgb(0, 165, 233);}
	</style>
</head>
<body>
	<a href="Applicant"><b>CS Grad Admission</b></a> > Edit Application
	<br/><br/>
<form action="NewAdmission" method="post" onsubmit="validate();">
	<input type="hidden" name="applicantId" value="${applicantId}"/>
	<table border="1">
		<tr>
		  <td>Applicant:</td>
		  <td><input type="text" name="applicantName" value="${applicantDeatil.applicantName}" id="applicantName"/></td>
		</tr>
		<tr>
		  <td>Application Received On (M/d/yyyy):</td>
		  <fmt:formatDate pattern='M/d/yyyy' value='${applicantDeatil.receivedDate}' var="date"/>	  
		  <td><input type="text" name="receivedDate" value="${date}"/ id="receivedDate"></td>
		</tr>
		<tr>
		  <td>GPA:</td>
		  <td><input type="text" name="gpa" value="${applicantDeatil.gpa}"/></td>
		</tr>
		<tr>
		  <td>Status:</td>
		  <td>
			  <select name="status">
			     <c:forEach items="${applicationStatus}" var="Status" varStatus="status">
			       <option value="${status.index}" <c:if test="${status.index==applicantDeatil.status}"> selected</c:if> >${Status}</option>
			     </c:forEach>
			  </select>
		  </td>
		</tr>
		<tr>
		  <td colspan="2"><input type="submit" value="SAVE" style="float: right;"/></td>
		</tr>
	</table>
</form>

<script type="text/javascript">
	function validate(){
		
		if(document.getElementById("applicantName").value.trim()==""){
			alert("Please enter applicant name");
			event.preventDefault();
			return false;
			
	
				
		} if(document.getElementById("receivedDate").value.trim()==""){
			alert("Please enter application received date");
			event.preventDefault();
			return false;
			
		
		} if(document.getElementById("receivedDate").value.match(/^(\d{1,2})\/(\d{1,2})\/(\d{4})$/)==null  || document.getElementById("receivedDate").value.split('/')[0]>12 ||  document.getElementById("receivedDate").value.split('/')[1]>31 ){
		
			alert("Please enter valid date");
			event.preventDefault();
			return false;
		}
		
	}
</script>

</body>
</html>