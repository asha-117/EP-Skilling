<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body bgcolor="lightblue">
 <%@ page import="com.klu.Bean.Bean,com.klu.Connections.DBUtil,java.util.*,java.sql.*" %>
<h1>Employees List</h1>  
<%
   Connection con=DBUtil.DBConnection(); 
    PreparedStatement ps=con.prepareStatement("select * from employee");  
     ResultSet rs=ps.executeQuery(); 
     
       %>
      <TABLE border="1" width="90%">  
      <TR>
      <TH>Name</TH>
      <TH>Password</TH>
      <TH>Email</TH>
      <TH>Country</TH>
      <TH>Edit</TH>
      <TH>Delete</TH>
      </TR>
      <% while(rs.next()){ %>
      <TR>
       <TD> <%= rs.getString(1) %></TD>
       <TD> <%= rs.getString(2) %></TD>
       <TD> <%= rs.getString(3) %></TD>
       <TD> <%= rs.getString(4) %></TD>
       <TD><a href="update.html">Edit</a></TD>  
       <TD><a href="delete.html">Delete</a></TD>
      </TR>      
      <% } %>
     </TABLE>
     <br>
     <TD><a href="index.html">Add a new Employee</a></TD> 
</body>
</html>