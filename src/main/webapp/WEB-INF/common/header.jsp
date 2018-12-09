<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<style>
	@import url('https://fonts.googleapis.com/css?family=Orbitron');
</style>
	<head>
    	<meta charset="UTF-8">
    	<c:url value="/css/decision.css" var="cssHref" />
    	<link rel="stylesheet" href="${cssHref}">
	</head>

<body>
	<header>
		<c:url value="/" var="homePageHref" />
		<h1>Arthur the Decisive Cat</h1>
		<a href="${homePageHref}">
			<img src="img/Arthur.jpg" alt="We'll help you decide"/>
		</a>
	</header>
	
		<nav>
			<ul>
				<li><a href="home">Home</a></li>
        		<li><a href="about">About The Creator</a></li>
			</ul>
		</nav>
	<br>
	<section class="main-content">
