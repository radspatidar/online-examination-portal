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
	
  	<div class="login-box">
    <div class="box">
    <h2>Add New User</h2>
    <%
 		String msg = (String)request.getAttribute("msg");
		if(msg != null){
			out.println(msg);
		}
	%>
    <form action="RegisterServlet" method="post">
      <input type="text" name="name" placeholder="Enter Name" required>
      <input type="email" name="email" placeholder="Enter Email" required>
      <input type="password" name="password" placeholder="Password" required>
      <input type="text" name="role" placeholder="Enter Role" required>
      <button type="submit" value="Add User" name = "btn">Add User</button><br>&nbsp;
    </form>
    <button name="btn">
	<a href="user.jsp" class="btn text-white px-4 py-2 rounded text-decoration-none">Back</a>
 </button>
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
