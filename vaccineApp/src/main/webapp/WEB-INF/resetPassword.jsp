<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>RESET</title>
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
			height: 170px;
			width: 38%;
			margin-left: 25%;
			color: #2B2730;
			border-radius: 16px;
			background-color: #A0C49D;
		}
		main{
			height: 250px;
			width: 100%;
			padding: 50px;
		}
		input{
			background-color: #F1EAFF;
			border-radius: 10px;
		}
	</style>
</head>
<body>
   	<header class="hf"></header>
   	<main>
   		
		<form action="resetPasswordrequestHandler" class="form">
			<h2><ins>RESET PASSWORD</ins></h2>
		  	<table>
		  		<tr>
		  			<td>USER EMAIL</td>
		  			<td><input type="text" name="email" required></td>
		  		</tr>
		  		<tr>
		  			<td>PASSWORD</td>
		  			<td><input type="password" name="password" required id="password"> </td>
		  		</tr>
		  		<tr>
		  			<td>CONFIRM PASSWORD</td>
		  			<td><input type="password" name="confirmpassword" required id="confirmpassword"></td>
		  		</tr>
		  		<tr>
		  			<td><input type="submit" value="RESET" onclick="equals()" style="background-color: #4CAF50"></td>
		  		</tr>
		  	</table>
		  	<h2>${update}</h2>
		</form>
	</main>
	<footer class="hf"></footer>
	
	<script>
		function equals(){
			var password = document.getElementById("password").value
			var confirmpassword = document.getElementById("confirmpassword").value
			if(confirmpassword != password){
				alert("password and confirmpassword should be same")
			}
		}
	</script>
	
</body>
</html>