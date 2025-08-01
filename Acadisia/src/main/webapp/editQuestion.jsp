<%@page import="com.demo.pojo.QuestionBank"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Question Bank | Acadisia</title> 
  
  <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet"> 
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
  <link rel="stylesheet" href="assets/css/acadisia.css">
  <link rel="stylesheet" href="assets/css/login.css">
  <script>
        function autoResize(textarea) {
            textarea.style.height = 'auto'; 
            textarea.style.height = textarea.scrollHeight + 'px';
        }

        window.onload = function () {
            const textarea = document.getElementById("answer");
            autoResize(textarea);
        };
    </script>
</head>
<body>
<%@include file="header1.jsp"%>	
    <%
 		QuestionBank qb = (QuestionBank)request.getAttribute("qb");
		if(qb != null){
			%>
			  <form action="EditQuestionServlet?question_id=<%=qb.getQuestion_id() %>" method="post">
			    <div class="d-inline-block" style="width: 1200px; text-align: left;"> 
			    	<div class="features-small-item">
			         	<div id="text-left" class="question-line mb-2 text-start">
							<h2 class="text-center" style="color: #8a15ff;">Edit Question</h2>
			            		<div class="mb-3">
        							<label class="form-label fw-bold"><h6><%= qb.getQuestion_text() %></h6></label>
						        
						        	<textarea id="answer" name="answer" class="form-control" style="overflow: hidden; resize: none;" oninput="autoResize(this)"><%= qb.getAnswer() %></textarea>
						    </div>
						</div>
						<button type="submit" class="btn text-white px-4 py-2 rounded" style="background-color: #8261ee;">
						    Update Question
						</button>
						<a href="aQuestions.jsp" class="btn text-white px-4 py-2 rounded text-decoration-none" style="background-color: #8261ee;">Back</a>
				   </div>
			    </div>

	            
			 </form>
			<%
		}
	%>
    
    
  
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
