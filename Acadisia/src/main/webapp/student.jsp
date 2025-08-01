<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    
  <title>Student Dashboard | Acadisia</title>
  <link rel="stylesheet" href="assets/css/Style.css">
  <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/css/acadisia.css">
  <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
  
</head>
<body>	

  <!-- ***** Header Area Start ***** -->
   <%@include file="header2.jsp"%>
    <!-- ***** Header Area End ***** -->
  
  <!-- Hero Section -->
  <section class="welcome-area">
    <div class="header-text">
    <%
    HttpSession session1 = request.getSession(false);
	String name = (String)session1.getAttribute("name");
    %>
    
      <h1>Welcome  <%= name %></h1>
      <p>Attempt Quiz and see Result</p>
    </div>
  </section>


	<!-- ***** Features Small Start ***** -->
    <section class="section home-feature">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                     <div class="row ">

                        <!-- ***** Features Small Item Start ***** -->
                        <div class="col-lg-6 col-md-6 col-sm-12 col-12" data-scroll-reveal="enter bottom move 50px over 0.6s after 0.2s">
                            <div class="features-small-item">
                                <div class="icon">
                                    <i><img src="assets/images/featured-item-01.png" alt=""></i>
                                </div>
                                <a href="SubjectServlet?link=questionbank"><b>Question Bank</b></a>  
                            </div>
                        </div>
                        <!-- ***** Features Small Item End ***** -->
                        
                        <!-- ***** Features Small Item Start ***** -->
                        <div class="col-lg-6 col-md-6 col-sm-12 col-12" data-scroll-reveal="enter bottom move 50px over 0.6s after 0.2s">
                            <div class="features-small-item">
                                <div class="icon">
                                    <i><img src="assets/images/featured-item-01.png" alt=""></i>
                                </div>
                                <a href="SubjectServlet?link=quiz"><b>Attempt Quiz</b></a>  
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
 
