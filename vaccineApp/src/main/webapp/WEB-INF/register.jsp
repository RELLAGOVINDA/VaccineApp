<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Register Page</title>
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
			border: 3px solid #272829;
			height: 300px;
			width: 36%;
			margin-left: 25%;
			color: #2B2730;
			border-radius: 16px;
			background-color: #A0C49D;
			
		}
		input{
			background-color: #F1EAFF;
			border-radius: 10px;
		}
		main{
			height: 290px;
			width: 100%;
			padding: 30px;
		}
	</style>
</head>
<body>
	<header class="hf"></header>
	<main>
		<div class="form">
			<h3><ins>Register</ins> :</h3>
			<form action="saveUserDetails" >
				<table>
					<tr>
						<td>NAME : </td>
						<td><input type="text" name="userName" required pattern="[a-zA-Z]{3-15}" placeholder="Rella Govinda"></td>
					</tr>
					<tr>
						<td>EMAIL : </td>
						<td><input type="text" name="email" required placeholder="rellagovinda@gmail.com"></td>
					</tr>
					<tr>
						<td>MOBILE NUMBER : </td>
						<td><input type="text" name="mobileNumber" required pattern="[6-9]{1}[0-9]{9}" placeholder="9182065223"></td>
					</tr>
					<tr>
						<td>DATE OF BIRTH : </td>
						<td><input type="date" name="dob" required></td>
					</tr>
					<tr>
						<td>GENDER : </td>
						<td>
							<input type="radio" name="gender" id="male" value="male">
							<label for="male">MALE</label>
							<input type="radio" name="gender" id="female" value="female">
							<label for="female">FEMALE</label>
						</td>
					</tr>
					<tr>
						<td>PASSWORD : </td>
						<td><input type="password" name="passwword" required id="passwword"></td>
					</tr>
					<tr>
						<td> CONFIRM PASSWORD : </td>
						<td><input type="password" name="confirmPasswword" required id="confirmPasswword"></td>
					</tr>
					<tr>
						<td><input type="submit" value="Register" style="background-color: #4CAF50"></td>
					</tr>
				</table>
				<h1>${save}</h1>
			
			</form>
		</div>
	</main>
	
	<footer class="hf"></footer>
</body>
</html>