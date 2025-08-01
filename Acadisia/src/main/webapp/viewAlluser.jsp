
<%@page import="com.demo.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>User | Acadisia</title> 
  
  <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet"> 
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
  <link rel="stylesheet" href="assets/css/acadisia.css">
  <link rel="stylesheet" href="assets/css/login.css">
</head>
<body>
<%@include file="header1.jsp"%>
  <div class="welcome-area" id="welcome" style="padding-top: 50px;" >
  
 	<div class="d-inline-block" style="width: 1200px; text-align: left;"> 
	<div class="container">
		<div class="row justify-content-center">
			 <div class="col-12">
					   
			  	<table class="table table-bordered text-center" bgcolor="white" style="width: 100%;">					  
			  
						
					<tr style="background-color: #ac59ff;">
						<th>S.No.</th>
						<th>Name</th>
						<th>Email</th>
						<th>Password</th>
						<th>Role</th>
					</tr>
					<%
					HttpSession session1 = request.getSession(false);
					String email = (String)session1.getAttribute("email");
					
					List<User> list = (List)request.getAttribute("list");
					int i = 0;
					while(i<list.size()){
						User u = list.get(i);
						%>
						<tr>
							<td><%= i+1%></th>
							<td><%= u.getName() %></td>
							<td><%=u.getEmail() %></td>
							<td><%=u.getPassword() %></td>
							<td><%=u.getRole()%></td>
						</tr>
						<%
						i++;
					}
						%>
					<tr >
						<td></td>
						<td></td>
						<td>
						<button name="btn" class="btn text-white px-4 py-2" 
						style="background-color: #8261ee; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); border: none;">
						<a href="user.jsp"class="btn text-white px-4 py-2 rounded text-decoration-none">Back</a>
						</button>
						</td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
  
    <!-- jQuery -->
    <script src="assets/js/jquery-2.1.0.min.js"></script>

    <!-- Bootstrap -->
    <script src="assets/js/popper.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!-- Plugins -->
    <script src="assets/js/scrollreveal.min.js"></script>
    <script src="assets/js/waypoints.min.js"></script>
    <script src="assets/js/jquery.counterup.min.js"></script>
    <script src="assets/js/imgfix.min.js"></script> 
    
    <!-- Global Init -->
    <script src="assets/js/custom.js"></script>
   
</body>
</html>
