<%@page import="com.webtoon.DTO.webtoonDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.webtoon.DTO.usersDTO"%>
<%@page import="com.webtoon.DTO.mywebtoonDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>

	<style>
	
	</style>
					<%
					usersDTO dto = (usersDTO)session.getAttribute("dto");
					
					webtoonDTO wdto1 = (webtoonDTO)session.getAttribute("wdto1");
					ArrayList<webtoonDTO> wdto_genre = (ArrayList<webtoonDTO>)session.getAttribute("wdto_genre");
					ArrayList<mywebtoonDTO> mwdto1 = (ArrayList<mywebtoonDTO>)session.getAttribute("mwdto1");
					%>
	<script>
         alert("찜목록에서 삭제하였습니다.");
         let userId = '<%=dto.getUser_id() %>';
         let userPw = '<%=dto.getUser_pw() %>';
         document.location.href="Selection.do?user_id="+userId+"&user_pw="+userPw;
    </script>

	<body style="text-align: center;">

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">
					<font size="8">찜삭제 성공</font><br>
					정보를 확인하세요<br><br>

						<table>
							<tr>
								<td>아이디:</td>
								<td>웹툰:</td>						
							</tr>				
							<tr>
								
							</tr>		
						</table>
						<a href="main.jsp"><input type="button" value="메인페이지로"></a>
					</nav>			
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
			

			
	</body>
</html>

