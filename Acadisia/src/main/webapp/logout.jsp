<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
   HttpSession session1 = request.getSession(false);
   session1.invalidate();
%>
<jsp:forward page="login.jsp"></jsp:forward>

</body>
</html>