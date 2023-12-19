<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home Page</title>
	<style>
		.headfooter{
			height: 25px;
			width: 96%;
			background-color: #E7BCDE;
			padding: 20px;
			
		}
		.bodydiv{
			height: 345px;
			width: 100%;
		}
		.regiloginbutton{
			padding-left: 800px;
			
			
		}
		button{
			background-color: #4CAF50;
			border-radius: 8px;
		}
		body{
			background-color: #5FBDFF;
		}
	</style>
	
	
</head>
<body>
	<div class="headfooter">
		<header ></header>
		<a href="getRegisterPage" class="regiloginbutton"><button>Register</button></a>
		<a href="getLoginPage" ><button>Login</button></a>
		<marquee>TAP Academy provides covid-vacccine for their students and staff</marquee>
	</div>
	<div class="bodydiv">
		<img alt="" src="https://dmawlawyers.com.au/assets/volumes/images/_800x418_crop_center-center_82_none/CRAFT-CMS-WIP-Website-Banner-Image-Size-5.jpg?mtime=1676602758" height="345px" width="100%">
	</div>
	<footer class="headfooter"></footer>
</body>
</html>