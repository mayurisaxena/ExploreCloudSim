<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>


<%!
public void passToJava()
{
Long k= request.getParameter("len");
Double s= request.getParameter("st");
out.println(k);
}

%>




</head>

<body>
<form id="form1" name="form1" method="post" action="passToJava">
  <label>Number of CLoudlets:
  <input type="text" name="CLno" />
  </label>
 
  <p>
    <label> 
    
    </label></p>
  <div align="justify"></div><p><label><div align="center">
      <input type="submit" name="Submit" value="Submit" />
    </div>
    </label>
  </p>
  <p align="center">&nbsp; </p>
</form>
</body>
</html>
