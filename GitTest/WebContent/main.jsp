<%@page import="com.webtoon.DTO.mywebtoonDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.usersDAO.webtoonDAO"%>
<%@page import="com.webtoon.DTO.webtoonDTO"%>
<%@page import="com.webtoon.DTO.usersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

int pageSize = 15;	//한 페이지에 출력할 레코드 수

/* 페이지 링크를 클릭한 번호 / 현재 페이지  */
String pageNum = request.getParameter("pageNum");

/* 클릭한게 없으면 1번 페이지  */
if(pageNum == null){
	pageNum = "1";
}

/* 연산을 하기 위한 pageNum 형변환 / 현재페이지  */
int currentPage = Integer.parseInt(pageNum);

/* 해당 페이지에서 시작할 레코드 / 마지막 레코드  */
int startRow = (currentPage -1) * pageSize + 1;
int endRow = currentPage * pageSize;

int count = 0;
webtoonDAO wdao = new webtoonDAO();
/* 데이터베이스에 저장된 총 갯수  */
count = wdao.getWebtoonCount();

ArrayList<webtoonDTO> web_arr = null;

if(count > 0){
	/* getList() 메소드 호춣 / 해당 레코드 반환  */
	web_arr = wdao.getSelectWebtoonList(startRow,endRow);
}

%>
<!DOCTYPE html>
<html>
<head>
    <title>웹툰 추천 사이트</title>
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

<body>

	<%
		usersDTO dto = (usersDTO)session.getAttribute("dto");
	
		// 찜목록 불러오기
		ArrayList<mywebtoonDTO> mwdto1 = (ArrayList<mywebtoonDTO>)session.getAttribute("mwdto1");
	%>
	

    <!-- Start Top Nav -->
    <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
        <div class="container text-light">
            <div class="w-100 d-flex justify-content-between">
                <div>
                </div>
                <div>
                    <!-- <a class="text-light" href="https://fb.com/templatemo" target="_blank" rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a> -->
                    <!-- 로그인으로 이동 -->
                    <%if(dto == null) { %>
                    <a href = "login.jsp" class="navbar-sm-brand text-light text-decoration-none">로그인&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
                    <!-- 회원가입으로 이동 -->
                    <a href = "join.jsp" class="navbar-sm-brand text-light text-decoration-none">회원가입</a>
                    <%}else if(dto.getUser_yesno() == "no"){ %>
                    <a href = "Selection.do?user_id=<%=dto.getUser_id() %>&user_pw=<%=dto.getUser_pw() %>" class="navbar-sm-brand text-light text-decoration-none">찜목록&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
                    <a href = "update.jsp" class="navbar-sm-brand text-light text-decoration-none">회원정보수정&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
                    <a href = "LogoutCon.do" class="navbar-sm-brand text-light text-decoration-none">로그아웃</a>
                    <%}else { %>
                    <a href = "Selection.do?user_id=<%=dto.getUser_id() %>&user_pw=<%=dto.getUser_pw() %>" class="navbar-sm-brand text-light text-decoration-none">찜목록&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
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

                        <%}else {%>
                        <li class="nav-item">
                            <a class="nav-link" href="selectMember.jsp">회원관리</a>
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



    <!-- Start Banner Hero -->
    <!-- 움직이는 배너임 손안대도 됨 -->
    <div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
        <ol class="carousel-indicators">
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1"></li>
            <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <!-- 스크롤 배너 이미지1 -->
                            <img class="img-fluid" src="./assets/img/banner_img_01.jpg" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left align-self-center">
                                <h1 class="h1 text-success"><b>연애혁명</b>/ 202</h1>
                                <h3 class="h2">Tiny and Perfect eCommerce Template</h3>
                                <p>
                                    평범하면서 금사빠인 고등학생 순정남 공주영은 까칠하고 차가운 여학생 왕자림을 보고 사랑에 빠져버린다. 너무 다른 둘, 괜찮을까?<br> <a rel="sponsored" class="text-success" href="https://templatemo.com" target="_blank">TemplateMo</a> website. 
                                    <a rel="sponsored" class="text-success" href="https://stories.freepik.com/" target="_blank">Freepik Stories</a>,
                                    <a rel="sponsored" class="text-success" href="https://unsplash.com/" target="_blank">Unsplash</a> and
                                    <a rel="sponsored" class="text-success" href="https://icons8.com/" target="_blank">Icons 8</a>.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <!-- 스크롤 배너이미지2 -->
                            <img class="img-fluid" src="./assets/img/banner_img_02.jpg" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <h1 class="h1"><b>신의탑</b>/ SIU</h1>
                                <h3 class="h2">Aliquip ex ea commodo consequat</h3>
                                <p>
                                    자신의 모든 것이었던 소녀를 쫓아 탑에 들어온 소년
                                    그리고 그런 소년을 시험하는 탑<br>
                                    You are <strong>not permitted</strong> to re-distribute the template ZIP file in any kind of template collection websites.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row p-5">
                        <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                            <!-- 스크롤 배너이미지3 -->
                            <img class="img-fluid" src="./assets/img/banner_img_03.jpg" alt="">
                        </div>
                        <div class="col-lg-6 mb-0 d-flex align-items-center">
                            <div class="text-align-left">
                                <h1 class="h1"><b>참교육</b>/ 채용택</h1>
                                <h3 class="h2">Ullamco laboris nisi ut </h3>
                                <p>
                                    무너진 교권을 지키기 위해 교권보호국 소속 나화진의 참교육이 시작된다!<br>
                                    If you wish to support TemplateMo, please make a small contribution via PayPal or tell your friends about our website. Thank you.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="prev">
            <i class="fas fa-chevron-left"></i>
        </a>
        <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="next">
            <i class="fas fa-chevron-right"></i>
        </a>
    </div>
    <!-- End Banner Hero -->
    <!-- 움직이는 배너끝 -->

    
    
    
    
    
    
    <!-- 이미지를 클릭하면 플랫폼으로 이동하는 기능 -->
    <!-- 안건드려도됨 -->
    <section class="container py-5">
        <div class="row text-center pt-3">
            <div class="col-lg-6 m-auto">
                <h1 class="h1">Categories of The Webtoon</h1>
                <p>
                    Please choose the webtoon platform you want.
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="https://comic.naver.com/webtoon/weekday"><img src="./assets/img/category_img_01.jpg" class="rounded-circle img-fluid border"></a>
                <h5 class="text-center mt-3 mb-3">NAVER</h5>
                <p class="text-center"><a class="btn btn-success" href="https://comic.naver.com/webtoon/weekday">Go Webtoon</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="https://webtoon.kakao.com/"><img src="./assets/img/category_img_02.jpg" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3">KAKAO</h2>
                <p class="text-center"><a class="btn btn-success" href="https://webtoon.kakao.com/">Go Webtoon</a></p>
            </div>
            <div class="col-12 col-md-4 p-5 mt-3">
                <a href="https://www.lezhin.com/ko"><img src="./assets/img/category_img_03.jpg" class="rounded-circle img-fluid border"></a>
                <h2 class="h5 text-center mt-3 mb-3">LEZHIN</h2>
                <p class="text-center"><a class="btn btn-success" href="https://www.lezhin.com/ko">Go Webtoon</a></p>
            </div>
        </div>
    </section>
    <!-- 플랫폼 이동 구간 끝 -->
    


    <!-- Start Featured Product -->
    <section class="bg-light">
        <div class="container py-5">
            <div class="row text-center py-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">Webtoon_search</h1>
                    <div class="input-group mb-1">
                        <!-- 웹툰 검색기능 -->
                        <input type="text" class="form-control" id="webtoon_searchid" name="webtoon_search" placeholder="Search ...">
                        <button onclick="webtoonSearch()" type="submit" class="input-group-text bg-success text-light">
                            <i class="fa fa-fw fa-search text-white"></i>
                        </button>
                        <!-- 검색기능끝 -->
                    </div>
                </div>
            </div>

           
            <!-- 웹툰이미지들어갈장소 -->
                
                <!-- 반복문 시작 -->
                <div id=websearch class="row">
                <%
					if(count > 0){
						int number = count - (currentPage -1) * pageSize;
						for(int i=0;i<web_arr.size();i++){
                %>
 					<div class="col-12 col-md-4 mb-4">
 						<div class="card h-100">
 							<a href="webtoonInfoGo.do?webtoon_se=<%=web_arr.get(i).getWebtoon_seq()%>&webtoon_ge=<%=web_arr.get(i).getWebtoon_genre()%>&webtoon_i=<%=dto.getUser_id()%>"><img src="<%=web_arr.get(i).getWebtoon_img()%>" class="card-img-top" alt="..."></a>
 							<div class="card-body">
 								<a href="<%=web_arr.get(i).getWebtoon_link() %>" class="h2 text-decoration-none text-dark"><%= web_arr.get(i).getWebtoon_name() %></a>
 								<ul class="list-unstyled d-flex justify-content-between">
									<li class="text-muted text-right"><%= web_arr.get(i).getWebtoon_writer() %></li>
								</ul>
 								<p class="card-text"><%= web_arr.get(i).getWebtoon_content() %></p>
								<p class="text-muted"><%= web_arr.get(i).getWebtoon_genre() %></p>

 							</div>
 						</div>
 					</div>               
                <%
							
						}
					}else{
						
                %>
                	<div class="col-12 col-md-4 mb-4">
 						<div class="card h-100">
 							<p class="card-text">데이터가 존재하지 않습니다.</p>
 						</div>
 					</div>     
                <%
					}
                %>
                </div>
                <!-- 페이징이 들어갈 스타일 -->
                <div class="list-paging-wrap">
                	<ul class="pagination">
                		<%
                			/* 페이징 처리 */
                			if(count > 0){
                				/* 총 페이지의 수 */
                				int pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
                				/* 한 페이지에 보여줄 페이지 블럭(링크) 수  */
                				int pageBlock = 10;
                				/* 한 페이지에 보여줄 시작 및 끝 번호 (예 : 1, 2, 3 ~ 10 / 11, 12, 13 ~ 20)*/
                				int startPage = ((currentPage-1)/pageBlock)	*	pageBlock+1;
                				int endPage = startPage	+	pageBlock-1;
                				
                				/* 마지막 페이지가 총 페이지 수 보다 크면 endPage를 pageCounr로 할당  */
                				if(endPage > pageCount){
                					endPage = pageCount;
                				}
                					
                				/* 페이지 블럭스보다 startPage가 클경우 이전 링크 생성  */
                				if(startPage > pageBlock){
                		%>
									<li class="page-item"><a href="main.jsp?pageNum=<%=startPage - 10%>" class="page-link">이전</a></li>
						<%
                				}
                				/* 페이지 블록 번호  */
                				for(int i = startPage; i <= endPage; i++){
                					/* 핸재 페이지에는 링크를 설정하지 않음  */
                					if(i == currentPage){
						%>
									<li class="page-item active"><a href="#" class="page-link" ><%= i %></a></li>
						<%
                					}else{
                						/* 현재 페이지가 아닌 경우 링크 설정  */
	                	%>
	                				<li class="page-item"><a href="main.jsp?pageNum=<%=i%>" class="page-link" ><%= i %></a></li>
	                	
	                	<%
                					}
                				}
                				
                				if(endPage < pageCount){
                					/* 현재 블록의 마지막 페이지보다 페이지 전체 블록수가 클경우 다음 링크 생성  */
						%>
									<li class="page-item"><a href="main.jsp?pageNum=<%=startPage + 10%>" class="page-link" >다음</a></li>
						<%
                				}
							}
						%>
					</ul>
                </div>
        </div>

    </section>
    <!-- End Featured Product -->


    <!-- Start Footer -->
    <footer class="bg-dark" id="tempaltemo_footer">
        <div class="container">
            <div class="row">

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-success border-bottom pb-3 border-light logo">AVG28</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li>
                            <i class="fas fa-map-marker-alt fa-fw"></i>
                            	광주 남구 송암로 60 광주CGI센터 2층
                        </li>
                        <li>
                            <i class="fa fa-phone fa-fw"></i>
                            <a class="text-decoration-none">062-655-3506,9 </a>
                        </li>
                        <li>
                            <i class="fa fa-envelope fa-fw"></i>
                            <a class="text-decoration-none">smhrd@smhrd.or.kr</a>
                        </li>
                    </ul>
                </div>

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Products</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none" href="#">Luxury</a></li>
                        <li><a class="text-decoration-none" href="#">Sport Wear</a></li>
                        <li><a class="text-decoration-none" href="#">Men's Shoes</a></li>
                        <li><a class="text-decoration-none" href="#">Women's Shoes</a></li>
                        <li><a class="text-decoration-none" href="#">Popular Dress</a></li>
                        <li><a class="text-decoration-none" href="#">Gym Accessories</a></li>
                        <li><a class="text-decoration-none" href="#">Sport Shoes</a></li>
                    </ul>
                </div>

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Further Info</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none" href="#">Home</a></li>
                        <li><a class="text-decoration-none" href="#">About Us</a></li>
                        <li><a class="text-decoration-none" href="#">Shop Locations</a></li>
                        <li><a class="text-decoration-none" href="#">FAQs</a></li>
                        <li><a class="text-decoration-none" href="#">Contact</a></li>
                    </ul>
                </div>

            </div>

            <div class="row text-light mb-4">
                <div class="col-12 mb-3">
                    <div class="w-100 my-3 border-top border-light"></div>
                </div>
                <div class="col-auto me-auto">
                    <ul class="list-inline text-left footer-icons">
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="http://facebook.com/"><i class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://www.linkedin.com/"><i class="fab fa-linkedin fa-lg fa-fw"></i></a>
                        </li>
                    </ul>
                </div>
                <div class="col-auto">
                    <label class="sr-only" for="subscribeEmail">Email address</label>
                    <div class="input-group mb-2">
                        <input type="text" class="form-control bg-dark border-light" id="subscribeEmail" placeholder="Email address">
                        <div class="input-group-text btn-success text-light">Subscribe</div>
                    </div>
                </div>
            </div>
        </div>

        <div class="w-100 bg-black py-3">
            <div class="container">
                <div class="row pt-2">
                    <div class="col-12">
                        <p class="text-left text-light">
                            Copyright &copy; 2021 Company Name 
                            | Designed by <a rel="sponsored" href="https://templatemo.com" target="_blank">TemplateMo</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>

    </footer>
    <!-- End Footer -->

    <!-- Start Script -->
    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/templatemo.js"></script>
    <script src="assets/js/custom.js"></script>
    
    			<!-- let id = 'dto.getUser_id()' ajax는 jsp를 싹다 정리후 보내는거기때문에 let에 새로 변수를 넣어주어 세션값을 불러옴-->
    			<script type="text/javascript">
				function webtoonSearch() {
					
					$.ajax({
						
						url : "searchWebtoon.do", // servlet으로 보낼꺼기 때문에 뒤에 확정자를 안붙여도됨.
						type : "get",

						data : {
							"webtoon_name" : $('input[name=webtoon_search]').val()
						},
						dataType : 'json', // JSON 데이터를 가져올때, jsoin으로 꼭 지정해야함.
						success : function(res){ // 서버에 요청한 결과가 매개변수안에 담김
							console.log(res);
							let id = '<%=dto.getUser_id()%>'
							$('#websearch').html(''); // tbody의 html코드를 초기화
							for(let i = 0; i < res.length; i++){
							
								
								// 태그 만들기
								let table = '';
								table += "<div class='col-12 col-md-4 mb-4'>";
								table += "<div class='card h-100'>";
								table += "<a href ='webtoonInfoGo.do?webtoon_se="+res[i].webtoon_seq+"&webtoon_ge="+res[i].webtoon_genre+"&webtoon_i="+id+"'>";
								table += "<img src='"+res[i].webtoon_img+"' class='card-img-top' alt='...'>";
								table += "<div class='card-body'>";							
								table += "</a>";								
								table += "<a href='shop-single.html' class='h2 text-decoration-none text-dark'>"+ res[i].webtoon_name +"</a>";
								table += "<ul class='list-unstyled d-flex justify-content-between'>";
								table += "<li class='text-muted text-right'>"+res[i].webtoon_writer+"</li>";
								table += "</ul>";
								table += "<p class='card-text'>"+ res[i].webtoon_content +"</p>";
								table += "<p class='text-muted'>"+ res[i].webtoon_genre +"</p>";
								table += "<p class='text-muted'>"+ res[i].webtoon_keyword +"</p>";			
								table += "</div>";
								table += "</div>";
								table += "</div>";


								
								$('#websearch').append(table);
								
							}
						
							
						},
						error : function() {
							alert("요청 실패!");
						}
							
					});
				}
				</script>
				
				
    <!-- End Script -->
    
    
</body>
</html>