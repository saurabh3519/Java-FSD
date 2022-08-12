<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<%@page import="com.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!int pid;String pname;float price;%>
<%
pid = Integer.parseInt(request.getParameter("pid"));
pname = request.getParameter("pname");
price = Float.parseFloat(request.getParameter("price"));
Product p = new Product();
p.setPid(pid);
p.setPname(pname);
p.setPrice(price);
request.getSession(true);
Object obj = session.getAttribute("obj");
List<Product> listOfObj;
if(obj==null){
	listOfObj = new ArrayList<Product>();
	listOfObj.add(p);
	session.setAttribute("obj", listOfObj);	
}else{
	listOfObj = (List<Product>)session.getAttribute("obj");
	listOfObj.add(p);
	session.setAttribute("obj", listOfObj);
}
Iterator<Product> li =listOfObj.iterator();
while(li.hasNext()) {
	Product pr = li.next();
	out.print(pr+"<br>");
}
if(pid==3){
	session.invalidate();
}
%>
<%@include file="index.jsp" %>
</body>
</html>