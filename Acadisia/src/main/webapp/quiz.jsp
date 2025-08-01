<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    
  <title>Quiz | Acadisia</title>
  <link rel="stylesheet" href="assets/css/acadisia.css">
  <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">

  <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
  
</head>
<body>

  <%@include file="header1.jsp"%>
  <!-- Hero Section -->
  <section class="welcome-area">
    <div class="header-text">
     <h1>Quiz Management</h1>
	<p>
	  As an admin, you have full control over the quizzes in the system.<br>
	  You can create new quizzes, update existing ones, or delete those no longer needed.<br>
	  Keep the quiz list organized, relevant, and engaging to ensure a smooth experience for all users.
	</p>
    </div>
  </section>


	<!-- ***** Features Small Start ***** -->
    <section class="section home-feature">
        <div class="container">
            <div class="row g-4">
                <div class="col-lg-12">
                     <div class="row ">
                     <%
                    List<String> list = new ArrayList<String>();
                    HttpSession session1 = request.getSession(false);
                    list = (List)session1.getAttribute("quizSubjects");
                    int i = 0;
                    while (i < list.size()) {
                        String s = list.get(i);
                    %>
                        <!-- ***** Features Small Item Start ***** -->
							  <div class="col-lg-3 col-md-6 col-sm-12" data-scroll-reveal="enter bottom move 50px over 0.6s after 0.2s">
								    <div class="features-small-item">
									   	<div class="icon">
									        <i><img src="assets/images/featured-item-01.png" alt=""></i>
									     </div>
								     	 <a href='QuizServlet?link=<%=s %>'><b><%=s %></b></a>&nbsp;&nbsp;&nbsp;&nbsp;
								     	 <a href="DeleteServlet?subject=<%=s %>&link=quiz" title="Delete" class="position-absolute bottom-0 end-0"><i class="bi bi-trash"></i></a>
							        </div>
  						      </div>
                        <!-- ***** Features Small Item End ***** -->
					 <%
                    i++;
                    }
                     %> 
                        <!-- ***** Features Small Item Start ***** -->
                        <div class="col-lg-3 col-md-6 col-sm-12" data-scroll-reveal="enter bottom move 50px over 0.6s after 0.2s">
                            <div class="features-small-item">
                                <div class="icon">
                                    <i><img src="assets/images/featured-item-01.png" alt=""></i>
                                </div>
                                <a href='newQuiz.jsp'><b>ADD NEW</b></a>  
                            </div>
                        </div>
                        <!-- ***** Features Small Item End ***** -->
                    </div>
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