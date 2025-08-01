<%@page import="java.util.ArrayList"%>
<%@page import="com.demo.pojo.User"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Report | Acadisia</title> 
  
  <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet"> 
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
  <link rel="stylesheet" href="assets/css/acadisia.css">
  <link rel="stylesheet" href="assets/css/login.css">
</head>
<body style="margin: 0; padding: 0;">
 <%@include file="header1.jsp"%>
 
  <div class="welcome-area" id="welcome" style="padding-top: 150px;" >

        <!-- ***** Header Text Start ***** -->
        
                    <%
        Map<User, ArrayList<String>> map = (Map<User, ArrayList<String>>)request.getAttribute("map");
		if(map != null){
			%>
			<div class="d-inline-block" style="width: 1200px; text-align: left;"> 
			<div class="container">
			  <div class="row justify-content-center">
			    <div class="col-12">
			      <table class="table table-bordered text-center"  style="width: 100%;">
						
					<tr class="table table-dark">
						<th>S.No.</th>
						<th>Name</th>
						<th>Email</th>
						<th>Subject</th>
						<th>Result</th>
					</tr>
					<%
					int j =1;
					for(Map.Entry<User,ArrayList<String>> e : map.entrySet()) {
						
						
						User u = e.getKey();
						
						ArrayList<String> list = e.getValue();
						
						int i =0;
						while(i<list.size()){
							%>
							<tr>
								<td><%= j%></td>
								<td><%= u.getName() %></td>
								<td><%=u.getEmail() %></td>
								<td><%=list.get(i)%></td>
								<td>
									<form action="ResultServlet?email=<%= u.getEmail() %>&subject=<%=list.get(i) %>" method="post">
				                        <button type="submit" name="btn" class="btn btn-primary px-3 py-1 rounded-3 shadow" style="background-color: #8261ee; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); border: none;">
								    	     <font color=white>View Result</font>
										</button>                              
				                    </form> 
		                        </td>
						   </tr>
						
						<%
						i++;
						j++;
						}	
						
					}
					%>
					<tr >
						<td></td>
						<td></td>
						<td>
						<button name="btn" class="btn text-white px-4 py-2" 
						style="background-color: #8261ee; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); border: none;">
						<a href="admin.jsp" class="text-white">Back</a>
						</button>
						</td>
						<td></td>
						<td></td>
					</tr>
				<%
			}
		    %>
			</table>
		</div>
	</div>
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
