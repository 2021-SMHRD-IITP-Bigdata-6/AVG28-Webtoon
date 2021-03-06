<%@page import="com.sun.istack.internal.NotNull"%>
<%@page import="com.webtoon.DTO.mywebtoonDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.usersDAO.webtoonDAO"%>
<%@page import="com.webtoon.DTO.webtoonDTO"%>
<%@page import="com.webtoon.DTO.usersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>상세 페이지</title>
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

    <!-- Slick -->
    <link rel="stylesheet" type="text/css" href="assets/css/slick.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/slick-theme.css">
<!--
    
TemplateMo 559 Zay Shop

https://templatemo.com/tm-559-zay-shop

-->
</head>

<body>
	<%
		usersDTO dto = (usersDTO)session.getAttribute("dto");
	
		webtoonDTO wdto1 = (webtoonDTO)session.getAttribute("wdto1");
		ArrayList<webtoonDTO> wdto_genre = (ArrayList<webtoonDTO>)session.getAttribute("wdto_genre");
		
		mywebtoonDTO mwdto = (mywebtoonDTO)session.getAttribute("mwdto");
		
		ArrayList<mywebtoonDTO> mwdto1 = (ArrayList<mywebtoonDTO>)session.getAttribute("mwdto1");
		
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
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>



    <!-- Open Content -->
    <section class="bg-light">
        <div class="container pb-5">
            <div class="row">
                <div class="col-lg-5 mt-5">

                    <!-- 웹툰의 이미지 사진이 들어오는 자리 -->
                    <div class="card mb-3"> 
                        <img class="card-img img-fluid" src="<%=wdto1.getWebtoon_img() %>" alt="Card image cap" id="product-detail">
                    </div>
                   
                </div>

                <!-- col end -->
                <div class="col-lg-7 mt-5">
                    <div class="card">
                        <div class="card-body">
                            <!-- 웹툰이름 들어가는 장소 -->
                            <h1 class="h2"><%=wdto1.getWebtoon_name() %></h1>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>platform:</h6>
                                </li>
                                <li class="list-inline-item">
                                    <p class="text-muted"><strong>Naver</strong></p>
                                </li>
                            </ul>
                            <p class="h3 py-2"><%=wdto1.getWebtoon_writer() %></p>
                            

                            <h6>content:</h6>
                            <p> 
                                <%=wdto1.getWebtoon_content() %>
                            </p>
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <h6>장르 :</h6>
                                </li>
                                <li class="list-inline-item">
                                    <!-- 장르가 들어갈 자리 -->
                                    <p class="text-muted"><strong><%=wdto1.getWebtoon_genre() %></strong></p>
                                </li>
                            </ul>





                                <input type="hidden" name="product-title" value="Activewear">

                                <div class="row pb-3">
                                    <div class="col d-grid">
             
                                    	<%if(mwdto==null){ %>
                                        <input type="button" onclick="location.href='myWebtoonInfojoin.do?mwebtoon_se=<%=wdto1.getWebtoon_seq()%>&muser_i=<%=dto.getUser_id()%>&mwebtoon_nam=<%=wdto1.getWebtoon_name()%>&mwebtoon_write=<%=wdto1.getWebtoon_writer() %>&mwebtoon_conten=<%=wdto1.getWebtoon_content() %>&mwebtoon_genr=<%=wdto1.getWebtoon_genre() %>&mwebtoon_im=<%=wdto1.getWebtoon_img() %>&mwebtoon_lin=<%=wdto1.getWebtoon_link() %>&mwebtoon_keywor=<%=wdto1.getWebtoon_keyword() %>'" value="찜하기" class="btn btn-success btn-lg" />
                                    	<%}else if(mwdto.getMwebtoon_seq().equals(wdto1.getWebtoon_seq())){ %>
                                    	<input type="button" onclick="location.href='myWebtoonInfoDeleteCon.do?muser_i=<%=dto.getUser_id()%>&mwebtoon_se=<%=wdto1.getWebtoon_seq() %>&mwebtoon_ge=<%=wdto1.getWebtoon_genre()%>'" value="찜삭제" class="btn btn-success btn-lg" />
                                    	<%} %>
                                    </div>
                                    <div class="col d-grid">
                                    	<input type="button" onclick="window.open('<%=wdto1.getWebtoon_link()%>')" value="웹툰보러가기" class="btn btn-success btn-lg" />
                                        
                                    </div>
                                </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Close Content -->

    <!-- Start Article -->
    <section class="py-5">
        <div class="container">
            <div class="row text-left p-2 pb-3">
                <h4>같은 장르의 다른작품</h4>
            </div>

			<section class="bg-light">
        <div class="container py-5">


            <!--Start Carousel Wrapper-->
            <div id="carousel-related-product">
            
            	
            	
			<%
				
			
            	for(int i = 0; i < wdto_genre.size(); i++){
            		// 장르에 따른 값 잘나왔는지 확인
            		boolean ismy = false;
            		for(int j=0;j<mwdto1.size();j++){
            			if(mwdto1.get(j).getMwebtoon_seq().equals(wdto_genre.get(i).getWebtoon_seq())){
            				ismy=true;
            				break;
            			}
            		}
            		out.print("<div class='p-2 pb-3'>");
            		out.print("<div class='product-wap card rounded-0'>");
            		out.print("<div class='card rounded-0'>");
            		out.print("<img class='card-img rounded-0 img-fluid' src='"+ wdto_genre.get(i).getWebtoon_img() +"'>");
            		out.print("<div class='card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center'>");
            		out.print("<ul class='list-unstyled'>");
            		if(mwdto1==null){
            			
            		}
            		else if(ismy){
            			out.print("<li><a class='btn btn-success text-white' href='myWebtoonDeleteCon.do?muser_i="+ dto.getUser_id() +"&mwebtoon_se="+wdto_genre.get(i).getWebtoon_seq()+"'>♥ </a></li>");	
            		}else{
            			out.print("<li><a class='btn btn-success text-white' href='myWebtoonjoin.do?mwebtoon_se="+ wdto_genre.get(i).getWebtoon_seq() +"&muser_i="+ dto.getUser_id() +"&mwebtoon_nam="+ wdto_genre.get(i).getWebtoon_name() +"&mwebtoon_write="+ wdto_genre.get(i).getWebtoon_writer() +"&mwebtoon_conten="+ wdto_genre.get(i).getWebtoon_content() +"&mwebtoon_genr="+ wdto_genre.get(i).getWebtoon_genre() +"&mwebtoon_im="+ wdto_genre.get(i).getWebtoon_img() +"&mwebtoon_lin="+ wdto_genre.get(i).getWebtoon_link() +"&mwebtoon_keywor="+ wdto_genre.get(i).getWebtoon_keyword() +"'><i class='far fa-heart'></i></a></li>");
            		}
            		out.print("</ul>");
            		out.print("</div>");
            		out.print("</div>");
            		out.print("<div class='card-body'>");
            		out.print("<a href='webtoonInfoGo.do?webtoon_se="+ wdto_genre.get(i).getWebtoon_seq() +"&webtoon_ge="+ wdto_genre.get(i).getWebtoon_genre() +"&webtoon_i="+ dto.getUser_id() +"' class='h3 text-decoration-none'>"+ wdto_genre.get(i).getWebtoon_name() +"</a>");
            		//out.print("<a href ='webtoonInfoGo.do?webtoon_se="+wdto_genre.get(i).getWebtoon_seq()+"&webtoon_ge="+wdto_genre.get(i).getWebtoon_genre()+"' class='h3 text-decoration-none'>"+ wdto_genre.get(i).getWebtoon_name() +"</a>");
            		out.print("<p>웹툰작가: "+ wdto_genre.get(i).getWebtoon_writer() +"</p>");
            		out.print("<p>웹툰장르: "+ wdto_genre.get(i).getWebtoon_genre() +"</p>");
            		out.print("<ul class='w-100 list-unstyled d-flex justify-content-between mb-0'>");

            		out.print("<li class='pt-2'>");
            		out.print("<span class='product-color-dot color-dot-red float-left rounded-circle ml-1'></span>");
            		out.print("<span class='product-color-dot color-dot-blue float-left rounded-circle ml-1'></span>");
            		out.print("<span class='product-color-dot color-dot-black float-left rounded-circle ml-1'></span>");
            		out.print("<span class='product-color-dot color-dot-light float-left rounded-circle ml-1'></span>");
            		out.print("<span class='product-color-dot color-dot-green float-left rounded-circle ml-1'></span>");
            		out.print("</li>");
            		out.print("</ul>");
            		out.print("</div>");
            		out.print("</div>");
            		out.print("</div>");
            		
            	}
            	
            
            %>			
				

				</div>
                </div>
    			</section>
				
		</div>
        
    </section>
    <!-- End Article -->


    <!-- Start Footer -->
    <footer class="bg-dark" id="tempaltemo_footer">
        <div class="container">
            <div class="row">

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-success border-bottom pb-3 border-light logo">Zay Shop</h2>
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

    <!-- Start Slider Script -->
    <script src="assets/js/slick.min.js"></script>
    <script>
        $('#carousel-related-product').slick({
            infinite: true,
            arrows: false,
            slidesToShow: 4,
            slidesToScroll: 3,
            dots: true,
            responsive: [{
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3
                    }
                },
                {
                    breakpoint: 600,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 3
                    }
                },
                {
                    breakpoint: 480,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 3
                    }
                }
            ]
        });
    </script>
    <!-- End Slider Script -->

	

</body>

</html>