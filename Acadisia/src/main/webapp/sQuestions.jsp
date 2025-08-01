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
    
  <title>Question Bank | Acadisia</title>
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
                    HttpSession session1 = request.getSession(false);
                    String subject = (String)session1.getAttribute("subject");
                    %>
                       <h1><%=subject %> Questions</h1>
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
                    <%
                    List<QuestionBank> list = new ArrayList<QuestionBank>();
                    list = (List)session1.getAttribute("list");
                    int i = 0;
                    while (i < list.size()) {
                        QuestionBank qb = list.get(i);
                    %>
                        <!-- ***** Features Small Item Start ***** -->
                        <div class="d-inline-block" style="width: 1200px; text-align: left;"> 
                            <div class="features-small-item">
                                <div id="text-left" class="question-line mb-2 text-start">
                                    <h6><strong>Q.<%= i + 1 %>:</strong><%= qb.getQuestion_text() %></h6>
                                    <p><strong>Ans:</strong><%= qb.getAnswer() %></p>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Features Small Item End ***** -->
                    <%
                    i++;
                    }
                    %>
                    <button name="btn" class="btn text-white px-4 py-2" 
					          style="background-color: #8261ee; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); border: none;">
					    <a href="SubjectServlet?link=questionbank" class="btn text-white px-4 py-2 rounded text-decoration-none">Back</a>
					  </button>
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
 
