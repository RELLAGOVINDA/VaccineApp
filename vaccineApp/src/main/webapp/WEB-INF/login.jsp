<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Page</title>
	<style>
		.hf{
			height: 60px;
			width: 100%;
			background-color: #E7BCDE;
		}
		body{
			background-color: #5FBDFF;
		}
		.form{
			border: 3px solid #092635;
			height: 150px;
			width: 100%;
			margin-left: 75%;
			text-align:center;
			color: #2B2730;
			border-radius: 16px;
			background-color: #A0C49D;
		}
		input{
			background-color: #F1EAFF;
			border-radius: 10px;
		}
		main{
			height: 200px;
			width: 30%;
			padding: 80px;
		}
	</style>
</head>
<body>
    <header class="hf"></header>
    <main>
		<div class="form">
			<h2><ins>LOGIN </ins></h2>
			<form action="userlogin">
				<table>
					<tr>
						<td>USER EMAIL</td>
						<td><input type="text" name="email" required ></td>
					</tr>
					<tr>
						<td>PASSWORD</td>
						<td><input type="password" name="password" required ></td>
					</tr>
					<tr>
						<td><a href="getResetPasswordPage">forgotpassword?</a></td>
						<td><input type="submit" value="LOGIN" style="background-color: #4CAF50"></td>
					</tr>
					
				</table>
				<h1>${coupling}</h1>
			</form>
		</div>
	</main>
	
	<footer class="hf"></footer>
</body>
</html>