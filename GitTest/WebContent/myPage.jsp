<%@page import="com.webtoon.DTO.webtoonDTO"%>
<%@page import="com.webtoon.DTO.usersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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
    <link rel="stylesheet" href="assets/css/Sqmedia.css">
    <link rel="stylesheet" href="assets/css/Sqstyle.css">
    <title>Insert title here</title>
<!--
    
TemplateMo 559 Zay Shop

https://templatemo.com/tm-559-zay-shop

-->
</head>

<body>
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
                    <%}else { %>
                    <a href = "selection.jsp" class="navbar-sm-brand text-light text-decoration-none">찜목록&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
                    <a href = "update.jsp" class="navbar-sm-brand text-light text-decoration-none">회원정보수정&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
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
                            <a class="nav-link" href="recommend.jsp">Recommand</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="community_list.jsp">게시글</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="myPage.jsp">마이페이지</a>
                        </li>
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
                <h1 class="h1">마이페이지</h1>
                <p>
                    My page
                </p>
            </div>
        </div>
        
    </section>



    <!-- Start Featured Product -->
    <section class="bg-light">
        <div class="container py-5">
            <!-- 게시판 들어가는 자리 -->
            
            
            <div class="board_wrap">
                <div class="board_title">
                    <strong>게시판에 쓴 글목록</strong>
                    <p>게시판에 입력한 글목록을 불러옵니다!</p>
                </div>
                <div class="board_list_wrap">
                    <div class="board_list">
                        <!-- 칼럼 -->
                        <div class="top">
                            <div class="num">번호</div>
                            <div class="title">제목</div>
                            <div class="writer">아이디</div>
                            <div class="date">입력날짜</div>
                            <div class="ctn1">삭제</div>
                        </div>
                        <!-- 칼럼끝 -->
                        
                        
                        
                        
                        <!-- 게시글 반복문 시작 -->
                        <div>
                            <!-- 글번호 -->
                            <div class="num">4</div>
                            <!--  글제목 클릭시 내용을 볼수있습니다. -->
                            <!-- 글링크 들어가야합니다 -->
                            <div class="title"><a href="community_view.html">무협 재미있는거 추천받는다.오타쿠만 입장</a></div>
                            <!-- 이름 -->
                            <div class="writer">문성주</div>
                            <!-- 작성일 -->
                            <div class="date">2021.12.24</div>
                            <!-- 조화수 -->
                            <div class="ctn1">
                                <button>삭제</button>
                            </div>
                        </div>
                        <!-- 게시글 반복문 끝 -->



                        <div>
                            <!-- 글번호 -->
                            <div class="num">3</div>
                            <!--  글제목 클릭시 내용을 볼수있습니다. -->
                            <!-- 글링크 들어가야합니다 -->
                            <div class="title"><a href="community_view.html">신의탑 꼭봐라</a></div>
                            <!-- 이름 -->
                            <div class="writer">문성주</div>
                            <!-- 작성일 -->
                            <div class="date">2021.12.24</div>
                            <!-- 조화수 -->
                            <div class="ctn1">
                                <button>삭제</button>
                            </div>
                        </div>
                        
                        <div>
                            <!-- 글번호 -->
                            <div class="num">2</div>
                            <!--  글제목 클릭시 내용을 볼수있습니다. -->
                            <!-- 글링크 들어가야합니다 -->
                            <div class="title"><a href="community_view.html">ㅋㅋㅋㅋㅋㅋ</a></div>
                            <!-- 이름 -->
                            <div class="writer">문성주</div>
                            <!-- 작성일 -->
                            <div class="date">2021.12.24</div>
                            <!-- 조화수 -->
                            <div class="ctn1">
                                <button>삭제</button>
                            </div>
                        </div>

                        <div>
                            <!-- 글번호 -->
                            <div class="num">1</div>
                            <!--  글제목 클릭시 내용을 볼수있습니다. -->
                            <!-- 글링크 들어가야합니다 -->
                            <div class="title"><a href="community_view.html">나혼랩 진짜 재밌던데</a></div>
                            <!-- 이름 -->
                            <div class="writer">문성주</div>
                            <!-- 작성일 -->
                            <div class="date">2021.12.24</div>
                            <!-- 조화수 -->
                            <div class="ctn1">
                                <button>삭제</button>
                            </div>
                        </div>
                    </div>
                    
                    <!-- 다음페이지로 넘어갈수있는 버튼 -->
                    <!-- 글목록 페이지 이동 -->
                    <div class="board_page">
                        <a href="#" class="bt first"><<</a>
                        <a href="#" class="bt prev"><</a>
                        <a href="#" class="num on">1</a>
                        <a href="#" class="num">2</a>
                        <a href="#" class="num">3</a>
                        <a href="#" class="num">4</a>
                        <a href="#" class="num">5</a>
                        <a href="#" class="bt next">></a>
                        <a href="#" class="bt last">>></a>
                    </div>
                    <!-- 글목록 페이지 이동 종료 -->
                    
                </div>
            </div>

            <!-- 게시판에 쓴글 목록 끝 -->



            <!-- 내가쓴 댓글목록 게시판 -->
            <div class="board_wrap">
                <div class="board_title">
                    <strong>게시판에 쓴 댓글목록</strong>
                    <p>게시판에 입력한 댓글목록을 불러옵니다!</p>
                </div>
                <div class="board_list_wrap">
                    <div class="board_list">
                        
                        <!-- 칼럼 -->
                        <div class="top">
                            <div class="num">번호</div>
                            <div class="title">제목</div>
                            <div class="writer">아이디</div>
                            <div class="date">입력날짜</div>
                            <div class="ctn1">삭제</div>
                        </div>
                        <!-- 칼럼끝 -->
                        
                        
                        
                        
                        <!-- 게시글 반복문 시작 -->
                        <div>
                            <!-- 글번호 -->
                            <div class="num">3</div>
                            <!--  글제목 클릭시 내용을 볼수있습니다. -->
                            <!-- 글링크 들어가야합니다 -->
                            <div class="title"><a href="community_view.html">ㅋㅋㅋㅋㅋㅋㅋ</a></div>
                            <!-- 이름 -->
                            <div class="writer">문성주</div>
                            <!-- 작성일 -->
                            <div class="date">2021.12.24</div>
                            <!-- 조화수 -->
                            <div class="ctn1">
                                <button>삭제</button>
                            </div>
                        </div>
                        <!-- 게시글 반복문 끝 -->




                        <div>
                            <!-- 글번호 -->
                            <div class="num">3</div>
                            <!--  글제목 클릭시 내용을 볼수있습니다. -->
                            <!-- 글링크 들어가야합니다 -->
                            <div class="title"><a href="community_view.html">ㅋㅋㅋㅋㅋㅋㅋ</a></div>
                            <!-- 이름 -->
                            <div class="writer">문성주</div>
                            <!-- 작성일 -->
                            <div class="date">2021.12.24</div>
                            <!-- 조화수 -->
                            <div class="ctn1">
                                <button>삭제</button>
                            </div>
                        </div>
                        
                        <div>
                            <!-- 글번호 -->
                            <div class="num">3</div>
                            <!--  글제목 클릭시 내용을 볼수있습니다. -->
                            <!-- 글링크 들어가야합니다 -->
                            <div class="title"><a href="community_view.html">ㅋㅋㅋㅋㅋㅋㅋ</a></div>
                            <!-- 이름 -->
                            <div class="writer">문성주</div>
                            <!-- 작성일 -->
                            <div class="date">2021.12.24</div>
                            <!-- 조화수 -->
                            <div class="ctn1">
                                <button>삭제</button>
                            </div>
                        </div>

                        <div>
                            <!-- 글번호 -->
                            <div class="num">3</div>
                            <!--  글제목 클릭시 내용을 볼수있습니다. -->
                            <!-- 글링크 들어가야합니다 -->
                            <div class="title"><a href="community_view.html">ㅋㅋㅋㅋㅋㅋㅋ</a></div>
                            <!-- 이름 -->
                            <div class="writer">문성주</div>
                            <!-- 작성일 -->
                            <div class="date">2021.12.24</div>
                            <!-- 조화수 -->
                            <div class="ctn1">
                                <button>삭제</button>
                            </div>
                        </div>
                    </div>
                    
                    <!-- 다음페이지로 넘어갈수있는 버튼 -->
                    <!-- 글목록 페이지 이동 -->
                    <div class="board_page">
                        <a href="#" class="bt first"><<</a>
                        <a href="#" class="bt prev"><</a>
                        <a href="#" class="num on">1</a>
                        <a href="#" class="num">2</a>
                        <a href="#" class="num">3</a>
                        <a href="#" class="num">4</a>
                        <a href="#" class="num">5</a>
                        <a href="#" class="bt next">></a>
                        <a href="#" class="bt last">>></a>
                    </div>
                    <!-- 글목록 페이지 이동 종료 -->
                    
                </div>
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
                            123 Consectetur at ligula 10660
                        </li>
                        <li>
                            <i class="fa fa-phone fa-fw"></i>
                            <a class="text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
                        </li>
                        <li>
                            <i class="fa fa-envelope fa-fw"></i>
                            <a class="text-decoration-none" href="mailto:info@company.com">info@company.com</a>
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
    <!-- End Script -->
</body>

</html>