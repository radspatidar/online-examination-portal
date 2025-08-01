<%@page import="com.demo.pojo.Quiz"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.demo.pojo.QuestionBank"%>
<%@page import="java.util.List"%>
<%@page import="com.demo.daoimpl.QuestionBankDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    
  <title>Result | Acadisia</title>
  <link rel="stylesheet" href="assets/css/acadisia.css">
  <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">

  <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
  
</head>
<body>
<%
String req = (String)request.getAttribute("req");

if(req.equals("report")){
	%>
	 <%@include file="header1.jsp"%>
	<%
}else{
	%>
	 <%@include file="header2.jsp"%>
	<%
}
%>

 
  <!-- Hero Section -->
  <section class="welcome-area">
  	<!-- ***** Header Text Start ***** -->
        <div class="header-text">
            <div class="container">
                <div class="row">
                    <div class="offset-xl-3 col-xl-6 offset-lg-2 col-lg-8 col-md-12 col-sm-12">
                    <%
		                List<Quiz> list = new ArrayList<Quiz>();
		                
				        list = (List)request.getAttribute("result");
				        
				        Quiz q = list.getFirst();
				         
		                String name = q.getName();
		                
		                String email = q.getEmail();
		                
		                String subject =q.getSubject();
		             %>
                       <h1><%=subject %> Quiz Result</h1>
                    </div>
                </div>
            </div>
        </div>
        <!-- ***** Header Text End ***** -->
  </section>
  
  <!-- ***** Features Small Start ***** -->
<section class="section home-feature">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="d-flex flex-wrap justify-content-start gap-3">
                
                    <!-- ***** Features Small Item Start ***** -->
                        <div class="d-inline-block" style="width: 1200px; text-align: left;"> 
                            <div class="features-small-item">
                                <div id="text-left" class="question-line mb-2 text-start">
                                    <h6><strong>Name : </strong><%=name %></h6>
                                    <h6><strong>Email : </strong><%= email %></h6>
                                   
                                </div>
                            </div>
                        </div>
                        <!-- ***** Features Small Item End ***** -->
                    <%
            		 
			         int i = 0;
			         while (i < list.size()) {
			             q = list.get(i);
			          %> 
			        <!-- ***** Features Small Item Start ***** -->
	                <div class="d-inline-block" style="width: 1200px; text-align: left;"> 
				        <div class="features-small-item">
	                        <div id="text-left" class="question-line mb-2 text-start">
			                                
	                           <h6><strong>Q.<%= i + 1 %>:</strong> <%= q.getQuestion() %></h6>
				                <%
				                    String selected_answer = q.getSelected_answer();
				                    int id = q.getQuestion_id();
				                    
				                    String[] options = { q.getOption_a(), q.getOption_b(), q.getOption_c(), q.getOption_d() };
				                    
				                    char optionLabel = 'A';
				                    
				                    for (int j = 0; j < options.length; j++) {
				                    	
				                        String option = options[j];
				                        
				                        String inputId = id + "_" + optionLabel;
				                %>
				                    <input type="radio" id="<%= inputId %>" name="<%= id %>" value="<%= option %>" <%=selected_answer.equals(option) ? "checked" : "" %> disabled >
				                    <label for="<%= inputId %>"><%= option %></label><br>
				                <%
				                        optionLabel++;
				                    }
				                %>
			                                 	
			                    <h6><strong>Correct Answer : </strong><%= q.getCorrect_answer() %></h6>
			                                    
			                </div>
			             </div>
			          </div>
			    <%
			    i++;
			    }
			         if(req.equals("report")){
			        	 %>
			        	 	<button name="btn" class="btn text-white px-4 py-2" 
								 style="background-color: #8261ee; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); border: none;">
								 <a href="ReportServlet" class="btn text-white px-4 py-2 rounded text-decoration-none">Back</a>
							</button>
			        	 
			        	 <%
			         }else{
			        	 %>
			        	 	<button name="btn" class="btn text-white px-4 py-2" 
								 style="background-color: #8261ee; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); border: none;">
								 <a href="SubjectServlet?link=quiz" class="btn text-white px-4 py-2 rounded text-decoration-none">Back</a>
							</button>
			        	 
			        	 <%
			         }
			    %>        
             
		    
			
				</div>
				<br><br>
            </div>
        </div>
    </div>
</section>
<!-- ***** Features Small End ***** -->
    <%@include file="footer.jsp"%>
    <script src="assets/js/dropdown	.js"></script>
    
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
 
