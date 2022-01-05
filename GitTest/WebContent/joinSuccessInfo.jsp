<%@page import="com.webtoon.DTO.mywebtoonDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.usersDAO.webtoonDAO"%>
<%@page import="com.webtoon.DTO.webtoonDTO"%>
<%@page import="com.webtoon.DTO.usersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


					<%
					usersDTO dto = (usersDTO)session.getAttribute("dto");
					
					webtoonDTO wdto1 = (webtoonDTO)session.getAttribute("wdto1");
					ArrayList<webtoonDTO> wdto_genre = (ArrayList<webtoonDTO>)session.getAttribute("wdto_genre");
					ArrayList<mywebtoonDTO> mwdto1 = (ArrayList<mywebtoonDTO>)session.getAttribute("mwdto1");
					%>
					
					<script>
				         alert("찜목록에 추가하였습니다.");
				         let wseq = '<%=wdto1.getWebtoon_seq()%>';
				         let wgenre = '<%=wdto1.getWebtoon_genre()%>';
				         let user_id = '<%=dto.getUser_id()%>';
				         document.location.href="webtoonInfoGo.do?webtoon_se="+wseq+"&webtoon_ge="+wgenre+"&webtoon_i="+user_id;
				    </script>

<!DOCTYPE html>
<html>
<head>
    <title>Zay Shop eCommerce HTML CSS Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
</head>

	<body style="text-align: center;">

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">
					<font size="8">찜 Info 성공</font><br>
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
