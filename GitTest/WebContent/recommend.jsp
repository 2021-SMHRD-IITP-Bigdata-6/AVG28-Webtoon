<%@page import="com.webtoon.DTO.usersDTO"%>
<%@page import="com.webtoon.DTO.webtoonDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<script src="jquery-3.6.0.min.js"></script>
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


    
    
    
    <div  class="tag_select">
        <!-- 해시태그 검색 만들기 -->
        <h2>캐릭터에 관한 태그</h2>
        <div class="tag_select2">
            <table align="center">    
                <tr>
                    <td><button class="tag_btn">멍한</button></td>
                    <td><button class="tag_btn">귀여운</button></td>
                    <td><button class="tag_btn">착한</button></td>
                    <td><button class="tag_btn">아름다운</button></td>
                    <td><button class="tag_btn">똑똑한</button></td>
                </tr>
                <tr>
                    <td><button class="tag_btn">강한</button></td>
                    <td><button class="tag_btn">섹시한</button></td>
                    <td><button class="tag_btn">사랑스러운</button></td>
                    <td><button class="tag_btn">멋있는</button></td>
                    <td><button class="tag_btn">멍청한</button></td>
                </tr>
            </table>
        </div>



        <h2>스토리에 관한 태그</h2>
        <div class="tag_select2">
            <table align="center">    
                <tr>
                    <td><button class="tag_btn">빠른</button></td>
                    <td><button class="tag_btn" value="#">어려운</button></td>
                    <td><button class="tag_btn" value="#">자연스러운</button></td>
                    <td><button class="tag_btn" value="#">흥미진진한</button></td>
                    <td><button class="tag_btn" value="#">현실적인</button></td>
                </tr>
                <tr>
                    <td><button class="tag_btn" value="#">성장하는</button></td>
                    <td><button class="tag_btn" value="#">뜬금없는</button></td>
                    <td><button class="tag_btn" value="#">유일한</button></td>
                    <td><button class="tag_btn" value="#">정치적인</button></td>
                    <td><button class="tag_btn" value="#">인정하는</button></td>
                    
                </tr>
            </table>
        </div>
        <h2>분위기에 관한태그</h2>
        <div class="tag_select2"> 
        <table align="center">    
            <tr>
                <td><button class="tag_btn">무서운</button></td>
                <td><button class="tag_btn">행복한</button></td>
                <td><button class="tag_btn">소름돋는</button></td>
                <td><button class="tag_btn">밝은</button></td>
                <td><button class="tag_btn">제대로된</button></td>
            </tr>
            <tr>
                <td><button class="tag_btn">빛나는</button></td>
                <td><button class="tag_btn">달콤한</button></td>
                <td><button class="tag_btn">신선한</button></td>
                <td><button class="tag_btn">심각한</button></td>
                <td><button class="tag_btn">훈훈한</button></td>
            </tr>
        </table>
        </div>


            <div>
            <button id = btn1>검색하기</button>
            </div>

        </div>

        <script>
        // 클릭한 값을 가져오는 스크립트 매소드

        $('.tag_btn').on('click', function(){
            var className = $(this).attr('class');

            if($(this).hasClass('unclicked')){
                $(this).removeClass('unclicked');
                $(this).addClass('clicked');
            }else{
                $(this).removeClass('clicked');
                $(this).addClass('unclicked');
            }
        });

        var list = [];

        $('#btn1').on('click', function(){
            list=[]; // list 초기화

            var button = document.getElementsByClassName('clicked');

            for(btn1 of button){
                list.push(btn1.innerHTML);
            }
            console.log(list);
        });
        
        </script>
    
    
    
    
    
    
    
    
    
   

    <!-- Start Featured Product -->
    <section class="bg-light">
        <div class="container py-5">
            
           
           
            
           
            <!-- 필터된 웹툰이미지들어갈장소 -->
            <div class="row">
                <!-- 반복문 시작 -->
                <div class="col-12 col-md-4 mb-4">
                    <div class="card h-100">
                        <!-- 웹툰링크 들어갈 장소 -->
                        <a href="shop-single.html">
                            <!-- 웹툰이미지 들어갈 장소 -->
                            <img src="./assets/img/feature_prod_01.jpg" class="card-img-top" alt="...">
                        </a>
                        <div class="card-body">
                            <!-- 여기도 웹툰 링크 들어갈 장소 -->
                            <a href="shop-single.html" class="h2 text-decoration-none text-dark">여신강림</a>
                            <ul class="list-unstyled d-flex justify-content-between">
                                <li class="text-muted text-right">웹툰 작가이름</li>
                            </ul>
                            <!-- 웹툰이름 -->
                            <p class="card-text">
                                <!-- 웹툰내용 -->
                                네웹 대표 글로벌 인기작! 주경, 수호, 서준. 세 청춘의 두근두근 눈호강 로맨스~♡<br>
                                메이크업으로 여신이 된 주경이는 꿈과 사랑을 이룰 수 있을까?
                            </p>
                            <p class="text-muted">로맨스</p>
                        </div>
                    </div>
                </div>
                <!-- 웹툰이미지 반복문 -->
                



                
               
               
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