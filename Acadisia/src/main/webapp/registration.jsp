<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Registration | Acadisia</title> 
  
  <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet"> 
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
  <link rel="stylesheet" href="assets/css/acadisia.css">
  <link rel="stylesheet" href="assets/css/login.css">
</head>
<body>
<!--***** Header Area Start ***** -->
    <header class="header-area header-sticky">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav class="main-nav">
                        <!-- ***** Logo Start ***** -->
                         <div class="logo" style="color: #8a15ff;">&nbsp;&nbsp;
						    <i class="fas fa-home fa-2x"></i>
						    <b><span style="font-size: 28px;">Acadisia</span></b>
						</div>
                        <!-- ***** Logo End ***** -->
                        <!-- ***** Menu Start ***** -->
                        <ul class="nav">
                            <li><a href="index.jsp"><b><span style="font-size: 18px;">Home</span></b></a></li>
                            <li><a href="registration.jsp" class="active"><b><span style="font-size: 18px;">Register</span></b></a></li>
                            <li><a href="login.jsp"><b><span style="font-size: 18px;">Login</span></b></a></li>
                        </ul>
                        <a class='menu-trigger'>
                            <span>Menu</span>
                        </a>
                        <!-- ***** Menu End ***** -->
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->
	
	
  	<div class="login-box">
    <div class="box">
    <h2>Registration</h2>
    <%
 		String msg = (String)request.getAttribute("msg");
		if(msg != null){
			out.println(msg);
		}
	%>
    <form action="RegisterServlet" method="post">
      <input type="text" name="name" placeholder="Name" required>
      <input type="email" name="email" placeholder="Email" required>
      <input type="password" name="password" placeholder="Password" required minlength="4" maxlength="16">
      <button type="submit" value="register" name = "btn">Register</button>
    </form>
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
