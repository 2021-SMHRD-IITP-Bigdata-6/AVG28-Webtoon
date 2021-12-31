<%@page import="com.webtoon.DTO.usersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>


	 <section class = "login-form">
    <h1>회원가입</h1>
		<form action="JoinCon.do" method="post">
		    <div class = "int-area">
		        <!-- 아이디 입력 -->
		     	<input type="text" placeholder="ID" name = "user_id">
		        <!-- 아이디 중복체크(아직안만듬) -->
		        
		    </div>
		
		    <div class = "int-area">
		        <!-- 비밀번호입력 -->
		        <input type="password" placeholder="PASSWORD" name = "user_pw">
		    </div>
		
		    <div class = "int-area">
		      <!-- # 이메일 입력 -->
		      <input type="text" placeholder="E-mail" name = "user_email">
		  </div>
		
		    <div class = "int-area">
		        <!-- # 전화번호입력 -->
		        <input type="tel" placeholder="TEL : 010-0000-0000" name = "user_tel" >
		    </div>
		
		    <div class = "int-area">
		      <!-- # 주소입력 -->
		      <input type="text" placeholder="ADDRESS" name = "user_addr">
		    </div>
		
		   <div class = "gender-area">
		      <!-- # 성별 입력 -->
		      남<input type="radio" name = "user_gender" value ="남">
		      여<input type="radio" name = "user_gender" value ="여">
		    
		    </div>
		    <div class = "btn-area">
		      <!-- # 버튼 -->
	      
	      <button type="submit" value="Join">회원가입</button>

    </div>
    </form>
  </section>

</body>
</html>