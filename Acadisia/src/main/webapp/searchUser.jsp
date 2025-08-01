<%@page import="java.util.List"%>
<%@ page import="com.demo.pojo.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User | Acadisia</title>

    <!-- CSS and Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet"> 
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
    <link rel="stylesheet" href="assets/css/acadisia.css">
    <link rel="stylesheet" href="assets/css/login.css">
</head>
<body>

<%@include file="header1.jsp"%>
  <!-- Hero Section -->

<!-- Content Area -->
	<div class="login-box">
    	<div class="box">
    		<%
    		String msg = (String)request.getAttribute("msg");
    		if(msg != null){
    		%>
    			<h2><%=msg %></h2>
    		<%
    		}else{
    			User u = (User)request.getAttribute("user");
    			if(u != null){
    			%>
    			<form action="UserServlet?link=update&id=<%=u.getId() %>" method="post">
    				<h2>User Details</h2>
    				<input type="text" name="name" value="<%=u.getName() %>" required>
    				<input type="email" name="email" value="<%=u.getEmail() %>" required>
    				<input type="text" name="password" value="<%=u.getPassword() %>" required>
   		            <input type="text" name="role" value="<%=u.getRole()%>" required>
   	            	<button type="submit">Update</button><br><br>
   	            </form>
    			<%
    			}else{
    				%>
    				<h2>Search User</h2>
    		    	<form action="UserServlet?link=search" method="post">
	    			    <select name = "id">
	    				    <option value="">Select</option>
	    		    		<%
	    		   			HttpSession session1 = request.getSession(false);
	    		    		String email = (String)session1.getAttribute("email");
	    		    		
	    		    		List<User> list = (List)request.getAttribute("list");
	    		    		
	    					int i = 0;
	    					while(i<list.size()){
	    						User u1 = list.get(i);
	    						if(u1.getEmail().equals(email) == false){
	    							%>
	    							<option value="<%=u1.getId() %>"><%=u1.getId() %></option>
	    							<%
	    						}
	    						i++;
	    					}
	    					%>
	    	   		   </select	>
          		   		<button type="submit">Search</button><br><br>
        			</form>
    				<%
    				}
    			}
    			%>
    			 <button name="btn">
    				<a href="user.jsp" class="btn text-white px-4 py-2 rounded text-decoration-none">Back</a>
    		    </button>
        	</div>
      </div>
    		
 			
<!-- JS Scripts -->
<script src="assets/js/jquery-2.1.0.min.js"></script>
<script src="assets/js/popper.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/scrollreveal.min.js"></script>
<script src="assets/js/waypoints.min.js"></script>
<script src="assets/js/jquery.counterup.min.js"></script>
<script src="assets/js/imgfix.min.js"></script> 
<script src="assets/js/custom.js"></script>

</body>
</html>
