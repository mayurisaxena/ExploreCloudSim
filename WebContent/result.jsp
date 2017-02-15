<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<table>
	
			
		<tr>  Cloudlet ID	     <s:iterator value= "cloudletId"> &nbsp; &nbsp; &nbsp;  <td><s:property/> </td> &nbsp;  </s:iterator> </tr>
		<tr>  Virtual Machine ID <s:iterator value= "vmId">  &nbsp; &nbsp; &nbsp; <td><s:property/> </td>&nbsp; </s:iterator>	</tr>
		<tr>  Submission Time	 <s:iterator value= "startTime">   &nbsp; &nbsp; &nbsp; <td><s:property/> </td> &nbsp;</s:iterator>	</tr>
		<tr>  Execution Time     <s:iterator value= "executionTime"> &nbsp; &nbsp; &nbsp; <td><s:property/> </td> &nbsp;</s:iterator></tr>
		<tr>  Finish Time        <s:iterator value= "finishTime">  &nbsp; &nbsp; &nbsp; <td><s:property/> </td>&nbsp;</s:iterator>   </tr>
				
	
	</table>
	
	
</body>
</html>