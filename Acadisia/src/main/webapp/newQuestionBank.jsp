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
<%@include file="header1.jsp"%>
	
	
  <!-- Hero Section -->
  <section class="welcome-area" style="heigth: 1200px;">
  	<!-- ***** Header Text Start ***** -->
        <div class="header-text">
            <div class="container">
                <div class="row">
                    <div class="offset-xl-3 col-xl-6 offset-lg-2 col-lg-8 col-md-12 col-sm-12">
                   
					<h3>Create new Question Bank</h3>
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
                        
                           <%
						 		String msg = (String)request.getAttribute("msg");
								if(msg != null){
									%>
							 <form action="QuestionBankServlet" method="post">
									    <div class="d-inline-block" style="width: 1200px; text-align: left;"> 
									    	<div class="features-small-item">
									         	<div id="text-left" class="question-line mb-2 text-start">
													<h2 class="text-center" style="color: #8a15ff; font-size: 35px">Add New QuestionBank</h2><br>
									            		<div class="mb-3">
						        							<textarea name="question_text" class="form-control" style="height: 80px;" placeholder="Enter Question" required></textarea><br>
												        	 <textarea name="answer" class="form-control" style="height: 100px;" placeholder="Enter Answer" required></textarea>
													    </div>
													</div>
												<button type="submit" class="btn text-white px-4 py-2 rounded" style="background-color: #8261ee;" value="Add More Questions" name = "btn">Add More Questions</button>
												<button type="submit" class="btn text-white px-4 py-2 rounded" style="background-color: #8261ee;" value="Create QuestionBank" name = "btn">Create QuestionBank</button>
												
										   </div>
									    </div>
									 </form>
									  <%
								}else{
									%>
									  <form action="QuestionBankServlet" method="post">
									    <div class="d-inline-block" style="width: 1200px; text-align: left;"> 
									    	<div class="features-small-item">
									         	<div id="text-left" class="question-line mb-2 text-start">
													<h2 class="text-center" style="color: #8a15ff; font-size: 35px">Add New QuestionBank</h2><br>
									            		<div class="mb-3">
									            			<input type="text" name="subject" class="form-control" style="height: 60px;" placeholder="Enter Subject" required><br>
						        							<textarea name="question_text" class="form-control" style="height: 80px;" placeholder="Enter Question" required></textarea><br>
												        	 <textarea name="answer" class="form-control" style="height: 100px;" placeholder="Enter Answer" required></textarea>
													    </div>
													</div>
												<button type="submit" class="btn text-white px-4 py-2 rounded" style="background-color: #8261ee;" value="Add Questions" name = "btn">Add Questions</button>
												<button type="submit" class="btn text-white px-4 py-2 rounded" style="background-color: #8261ee;" value="Create QuestionBank" name = "btn">Create QuestionBank</button>
												
										   </div>
									    </div>
									 </form>
									 <%
								}
							%>
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
 