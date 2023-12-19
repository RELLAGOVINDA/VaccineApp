<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EDIT</title>
	<style>
		.hf{
			height: 35px;
			width: 100%;
			background-color: #E7BCDE;
			padding: 16px;
		}
		body{
			background-color: #5FBDFF;
		}
		.form{
			border: 3px solid #092635;
			height: 270px;
			width: 36%;
			color: #2B2730;
			border-radius: 12px;
			background-color: #A0C49D;
			margin-left: 25%;
		}
		.input{
			background-color: #F1EAFF;
			border-radius: 8px; 
		}
		
		main{
			height: 275px;
			padding: 30px;
		}
	</style>
</head>
<body>
	<header class="hf"></header>
	
	<main>
		<form action="${pageContext.request.contextPath }/updateMemberDetails" class="form">
			<h3>EDIT MEMBER DETAILS</h3>
			<table>
				
				<tr>
					<td>MEMBER ID</td>
					<td><input type="number" value="${id}" name="id" class="input"></td>
				</tr>
				<tr>
					<td>MEMBER NAME</td>
					<td><input type="text" value="${name}" name="name" class="input"></td>
				</tr>
				<tr>
					<td>GENDER</td>
					<td><input type="text" value="${gender }" name="gender" class="input"></td>
				</tr>
				<tr>
					<td>DATE OF BIRTH</td>
					<td><input type="date" value="${dob}" name="dob" class="input"></td>
				</tr>
				<tr>
					<td>ID PROOF</td>
					<td>
						<select id="dropdown" value="${idProof }" name="idProof" class="input">
							   <option value="DRIVING LICENCE">DRIVING LICENCE</option>
							   <option value="AADHAAR">AADHAAR</option>
							   <option value="PAN">PAN CARD</option>
							   <option value="VOTER CARD">VOTER CARD</option>
				  	 	</select>
			  	 	</td>
				</tr>
				<tr>
					<td>ID PROOF NUMBER</td>
					<td><input type="text" value="${idNumber }" name="idNumber" class="input"></td>
				</tr>
				<tr>
					<td>VACCINE TYPE</td>
					<td>
						<select id="dropdown" value="${vaccineType }" name="vaccineType" class="input">
							   <option value="COVISHIELD">COVISHIELD</option>
							   <option value="COVAXINE">COVAXINE</option>
				  	 	</select>
			  	 	</td>
				</tr>
				<tr>
					<td>DOSE</td>
					<td>
						<select id="dropdown" value="${dose }" name="dose" class="input">
							   <option value="1">1</option>
							   <option value="2">2</option>
							   <option value="3">3</option>
				  	 	</select>
			  	 	</td>
				</tr>
				<tr>
					<td><input type="submit" value="UPDATE" class="input"></td>
				</tr>
			</table>
		</form>
		<h3>${update }</h3>
	</main>
	
	
	
	
	<footer class="hf"></footer>
</body>
</html>