<%@page import="com.webtoon.DTO.webtoonDTO"%>
<%@page import="com.webtoon.DTO.usersDTO"%>
<%@page import="com.usersDAO.usersDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="assets/js/jquery-1.11.0.min.js"></script>

    <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
		
	</head>
	<style>
	
	</style>
	<body style="text-align: center;">
		<%
		usersDTO dto = (usersDTO)session.getAttribute("dto");
	
		webtoonDTO wdto = (webtoonDTO)request.getAttribute("wdto");
	%>

    <!-- Start Top Nav -->
    <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
        <div class="container text-light">
            <div class="w-100 d-flex justify-content-between">
                <div>
                    <i class="fa fa-envelope mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:info@company.com">info@company.com</a>
                    <i class="fa fa-phone mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
                </div>
                <div>
                    <!-- <a class="text-light" href="https://fb.com/templatemo" target="_blank" rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a> -->
                    <!-- 로그인으로 이동 -->
                    <%if(dto == null) { %>
                    <a href = "login.jsp" class="navbar-sm-brand text-light text-decoration-none">로그인&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
                    <!-- 회원가입으로 이동 -->
                    <a href = "join.jsp" class="navbar-sm-brand text-light text-decoration-none">회원가입</a>
                    <%}else if(dto.getUser_yesno() == "no"){ %>
                    <a href = "selection.jsp" class="navbar-sm-brand text-light text-decoration-none">찜목록&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
                    <a href = "update.jsp" class="navbar-sm-brand text-light text-decoration-none">회원정보수정&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
                    <a href = "LogoutCon.do" class="navbar-sm-brand text-light text-decoration-none">로그아웃</a>
                    <%}else { %>
                    <a href = "selection.jsp" class="navbar-sm-brand text-light text-decoration-none">찜목록&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
                    <a href = "LogoutCon.do" class="navbar-sm-brand text-light text-decoration-none">로그아웃</a>
                    <%} %>
                </div>
            </div>
        </div>
    </nav>
    <!-- Close Top Nav -->


    <!-- Header -->
    <nav class="navbar navbar-expand-lg navbar-light shadow">
        <div class="container d-flex justify-content-between align-items-center">

            <!-- 왼쪽 위에 로고 -->
            <a class="navbar-brand text-success logo h1 align-self-center" href="main.jsp">
                AVG28
            </a>

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                <div class="flex-fill">
                    <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="main.jsp">Main</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="recommend.jsp">Recommend</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="community_list.jsp">게시글</a>
                        </li>
                        <%if(dto==null) {%>

                        <%}else if(dto.getUser_yesno().equals("no")){ %>
                        <li class="nav-item">
                            <a class="nav-link" href="myPage.jsp">마이페이지</a>
                        </li>
                        <%}else {%>
                        <li class="nav-item">
                            <a class="nav-link" href="adminMyPage.jsp">회원관리</a>
                        </li>
                        <%} %>
                    </ul>
                </div>
                <div class="navbar align-self-center d-flex">
                    <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                        <div class="input-group">
                            <input type="text" class="form-control" id="inputMobileSearch" placeholder="Search ...">
                            <div class="input-group-text">
                                <i class="fa fa-fw fa-search"></i>
                            </div>
                        </div>
                    </div>
                    <a class="nav-icon d-none d-lg-inline" href="#" data-bs-toggle="modal" data-bs-target="#templatemo_search">
                        <i class="fa fa-fw fa-search text-dark mr-2"></i>
                    </a>
                    <a class="nav-icon position-relative text-decoration-none" href="#">
                        <i class="fa fa-fw fa-cart-arrow-down text-dark mr-1"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">7</span>
                    </a>
                    <a class="nav-icon position-relative text-decoration-none" href="#">
                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">+99</span>
                    </a>
                </div>
            </div>

        </div>
    </nav>
    <!-- Close Header -->

    <!-- Modal -->
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <!-- 검색창 -->
                    <input type="text" class="form-control" id="webtoon_search" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>

	    <section class="container py-5">
        <div class="row text-center pt-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">회원관리</h1>
                <p>
                    Member Management
                </p>
            </div>
        </div>
        
    </section>
    
    	    <section class="container py-5">
        <div class="row text-center pt-3">
            <div class="col-lg-6  m-auto">




		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<thead>
								<tr>
									<td colspan="2"> <input type="text" name="user_Search" placeholder="검색어를 입력하세요."> </td>
									<td><button onclick="userSearch()">검색</button></td>
								</tr>
								<tr>
									<td>ID</td>
									<td>Email</td>
									<td>Tel</td>
									<td>Addr</td>
									<td>Joindate</td>										
								</tr>
							</thead>			
							
							    <!-- Start Featured Product -->
    
					<tbody id="tbody" >
					<%
						usersDAO dao = new usersDAO();
						ArrayList<usersDTO> arr = dao.selectMember();
						
						for(int i = 0; i < arr.size(); i++){
							
							out.print("<tr>");
							out.print("<td>"+arr.get(i).getUser_id()+"</td>");
							out.print("<td>"+arr.get(i).getUser_email()+"</td>");
							out.print("<td>"+arr.get(i).getUser_tel()+"</td>");
							out.print("<td>"+arr.get(i).getUser_addr()+"</td>");
							out.print("<td>"+arr.get(i).getUser_joindate()+"</td>");
							out.print("<td><a href ='DeleteCon.do?delete_email="+arr.get(i).getUser_id()+"'>삭제</a></td>"); 
							out.print("</tr>");					//? QueryString
							
						}
					%>
					</tbody>
						</table>
					</nav>			
			</div>
		            </div>
        </div>
        
    </section>
		
		<!-- Scripts -->
		    <!-- Start Script -->
    		<script src="assets/js/bootstrap.bundle.min.js"></script>
    		<script src="assets/js/custom.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->

			<script type="text/javascript">

				function userSearch() {
					
					$.ajax({
						
						url : "searchUser.do", // servlet으로 보낼꺼기 때문에 뒤에 확정자를 안붙여도됨.
						type : "get",

						data : {
							"user_id" : $('input[name=user_Search]').val()
						},
						dataType : 'json', // JSON 데이터를 가져올때, jsoin으로 꼭 지정해야함.
						success : function(res){ // 서버에 요청한 결과가 매개변수안에 담김
							console.log(res);
						
							$('#tbody').html(''); // tbody의 html코드를 초기화
							for(let i = 0; i < res.length; i++){
							
								// 태그 만들기
								let table = '';
								table += '<tr>';
								table += '<td>' + res[i].user_id + '</td>';
								table += '<td>' + res[i].user_email + '</td>';
								table += '<td>' + res[i].user_tel + '</td>';
								table += '<td>' + res[i].user_addr + '</td>'; 
								table += '<td>' + res[i].user_joindate + '</td>';
								table += "<td><a href ='DeleteCon.do?delete_email="+res[i].user_id+"'>삭제</a></td>";								
								table += '</tr>';						
								$('#tbody').append(table);
								
							}
						
							
						},
						error : function() {
							alert("요청 실패!");
						}
							
					});
				}
				</script>
			
	</body>
</html>

