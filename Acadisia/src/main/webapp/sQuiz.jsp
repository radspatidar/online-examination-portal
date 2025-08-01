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
    
  <title>Quiz | Acadisia</title>
  <link rel="stylesheet" href="assets/css/acadisia.css">
  <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">

  <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
  
</head>
<body>

  <%@include file="header2.jsp"%>
  
  <!-- Hero Section -->
  <section class="welcome-area">
  	<!-- ***** Header Text Start ***** -->
        <div class="header-text">
            <div class="container">
                <div class="row">
                    <div class="offset-xl-3 col-xl-6 offset-lg-2 col-lg-8 col-md-12 col-sm-12">
                    <%
                    
                    Integer marksObj = (Integer) request.getAttribute("marks");
                    int marks = (marksObj != null) ? marksObj : 0;
                    Integer total_marksObj = (Integer) request.getAttribute("totalMarks");
                    int total_marks = (total_marksObj != null) ? total_marksObj : 0;
                  
            		if(marksObj != null){
            			%>
            			<!-- ***** Features Small Item Start ***** -->
						<div class="container d-flex justify-content-center align-items-center">
						  <div class="card text-center shadow" style="width: 400px; height: 300px; border-radius: 15px; background-color:rgb(241, 241, 241); box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3); transition: all 0.3s ease;">             
						    <div class="card-body d-flex flex-column justify-content-center align-items-center">
						
						      <form action="ResultServlet?req=result" method="post">
						        <h5 class="card-title">Marks = <%=marks %>/<%=total_marks%></h5>
						        <br>
						        <button type="submit" class="btn text-white px-4 py-2 rounded" style="background-color: #8261ee;">
						          View Result
						        </button>
						        <a href="SubjectServlet?link=quiz"
						           class="btn text-white px-4 py-2 rounded text-decoration-none mt-2"
						           style="background-color: #8261ee;">
						          Back
						        </a>
						      </form>
						      
						    </div>
						  </div>
						</div>
						<!-- ***** Features Small Item End ***** -->
            				<%
            		}else{
            		
                    HttpSession session1 = request.getSession(false);
                    String subject = (String)session1.getAttribute("quizsubject");
                    %>
                       <h1><%=subject %> Quiz</h1>
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
                    
            			
            		
            			<form action="SQuizServlet" method="post">
            			<%
            			       List<Quiz> list = new ArrayList<Quiz>();
			                    list = (List)session1.getAttribute("quizlist");
			                    int i = 0;
			                    while (i < list.size()) {
			                        Quiz q = list.get(i);
			                    %>
			                        <!-- ***** Features Small Item Start ***** -->
			                        <div class="d-inline-block" style="width: 1200px; text-align: left;"> 
			                            <div class="features-small-item">
			                                <div id="text-left" class="question-line mb-2 text-start">
			                                
			                                    <h6><strong>Q.<%= i + 1 %>:</strong><%= q.getQuestion() %></h6>
			                                    <%
				                    
							                    int id = q.getId();
							                    
							                    String[] options = { q.getOption_a(), q.getOption_b(), q.getOption_c(), q.getOption_d() };
							                    
							                    char optionLabel = 'A';
							                    
							                    
							                    for (int j = 0; j < options.length; j++) {
							                    	
							                        String option = options[j];
							                      
							                        String inputId = id + "_" + optionLabel;
							                        
							                        if(j == 0){
							                           %>
							                           	<input type="radio" id="<%= inputId %>" name="<%= id %>" value="<%= option %>" required>
							                    		<label for="<%= inputId %>"><%= option %></label><br>
							                           <%
							                        }else{
							                        	%>
							                           	<input type="radio" id="<%= inputId %>" name="<%= id %>" value="<%= option %>" >
							                    		<label for="<%= inputId %>"><%= option %></label><br>
							                           <%
							                        }
							                        optionLabel++;
							                    }
							                %>
						                         
			                                
			                                  </div>
			                            </div>
			                        </div>
			                        <!-- ***** Features Small Item End ***** -->
			                    <%
			                    i++;
			               }
			                    
			        %>     
            		
                      <button type="submit" name="btn" class="btn text-white px-4 py-2" 
					          style="background-color: #8261ee; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); border: none;">
					    <font color=white>Submit</font>
					  </button>&nbsp;&nbsp;
             
					  <button name="btn" class="btn text-white px-4 py-2" 
					          style="background-color: #8261ee; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); border: none;">
					    <a href="SubjectServlet?link=quiz" class="text-white">Back</a>
					  </button>
					  
					  </form>
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
 
