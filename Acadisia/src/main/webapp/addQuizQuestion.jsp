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
<%@include file="header1.jsp"%>
	
	
  <!-- Hero Section -->
  <section class="welcome-area" style="heigth: 1200px;">
  	<!-- ***** Header Text Start ***** -->
        <div class="header-text">
            <div class="container">
                <div class="row">
                    <div class="offset-xl-3 col-xl-6 offset-lg-2 col-lg-8 col-md-12 col-sm-12">
                    <%
				 		String msg = (String)request.getAttribute("msg");
						if(msg != null){
							out.println(msg);
						}
					%>
					<h3>Add Questions in Existing Quiz</h3>
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
                            <form action="AddQuizQuestionServlet" method="post">
                                <div id="text-left" class="question-line mb-2 text-start">
									<h2 class="text-center" style="color: #8a15ff; font-size: 35px">Add Question</h2><br>
					            		<div class="mb-3">
		        							  <textarea name="question" class="form-control" style="height: 60px;" placeholder="Enter Question" required></textarea><br>
										      <textarea name="option_a" class="form-control" style="height: 60px;" placeholder="Enter Option A" required></textarea><br>
										      <textarea name="option_b" class="form-control" style="height: 60px;" placeholder="Enter Option B" required></textarea><br>
										      <textarea name="option_c" class="form-control" style="height: 60px;" placeholder="Enter Option C" required></textarea><br>
										      <textarea name="option_d" class="form-control" style="height: 60px;"placeholder="Enter Option D" required></textarea><br>
										      <textarea name="correct_answer" class="form-control" style="height: 60px;" placeholder="Enter Correct Answer" required></textarea>
								    </div>
								</div>
								<button type="submit" class="btn text-white px-4 py-2 rounded" style="background-color: #8261ee;">
								    Add Question
								</button>
								<a href="aQuiz.jsp" class="btn text-white px-4 py-2 rounded text-decoration-none" style="background-color: #8261ee;">Back</a>
		                            </div>
		                            
		                            </form>
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
 


 
	 