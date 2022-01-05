<%@page import="com.webtoon.DTO.usersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>

    <section class = "login-form">
        <h1>LOGIN</h1>
        <form action="LoginCon.do">
            <div class = "int-area">
                <input type="text" placeholder="USER_EMAIL" name = "user_id">
                
            </div>
            <div class = "int-area">
                <!-- pw받는곳 -->
                <input type="password" placeholder="PASSWORD" name = "user_pw">
                
            </div>
            <div class = "btn-area">
                <button type="submit" value="Login">LOGIN</button>
            </div>
        </form>
        <div class="caption">
            <a href="join.jsp">회원가입</a>
        </div>
        
    </section>


</body>
</html>