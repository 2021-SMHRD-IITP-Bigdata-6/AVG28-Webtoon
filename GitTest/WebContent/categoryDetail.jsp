<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Helios by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Left Sidebar - Helios by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assetss/css/main.css" />
	</head>
	<body >


			<h1>선택하신 장르입니다.</h1>
			<!-- Carousel -->
				<section class="carousel" class="left-sidebar is-preload">
					<div class="reel">
						<h1>장르1</h1>
						<%for(int i = 0; i <=10; i++){ %>
						<article>
							<a href="#" class="image featured"><img src="images/pic01.jpg" alt="" /></a>
							<header>
								<h3><a href="#"><%=i %></a></h3>
							</header>
						</article>
						<%} %>
						<br>
						<h1>장르2</h1>
						<%for(int i = 0; i <=10; i++){ %>
						<article>
							<a href="#" class="image featured"><img src="images/pic01.jpg" alt="" /></a>
							<header>
								<h3><a href="#">second<%=i %></a></h3>
							</header>
						</article>
						<%} %>
						<br>
						<h1>장르3</h1>
						<%for(int i = 0; i <=10; i++){ %>
						<article>
							<a href="#" class="image featured"><img src="images/pic01.jpg" alt="" /></a>
							<header>
								<h3><a href="#">thrid<%=i %></a></h3>
							</header>
						</article>
						<%} %>


		<!-- Scripts -->
			<script src="assetss/js/jquery.min.js"></script>
			<script src="assetss/js/jquery.dropotron.min.js"></script>
			<script src="assetss/js/jquery.scrolly.min.js"></script>
			<script src="assetss/js/jquery.scrollex.min.js"></script>
			<script src="assetss/js/browser.min.js"></script>
			<script src="assetss/js/breakpoints.min.js"></script>
			<script src="assetss/js/util.js"></script>
			<script src="assetss/js/main.js"></script>

	</body>
</html>