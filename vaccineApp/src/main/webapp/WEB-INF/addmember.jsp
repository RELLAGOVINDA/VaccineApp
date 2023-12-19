<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member</title>
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
			height: 250px;
			width: 36%;
			color: #2B2730;
			border-radius: 12px;
			background-color: #A0C49D;
		}
		.input{
			background-color: #F1EAFF;
			border-radius: 8px; 
		}
		.table{
			margin-left: 109%;
			margin-top: -270px;
			background-color: #A0C49D;
			border-radius: 8px;
		}
		main{
			height: 275px;
			padding: 30px;
		}
	</style>
</head>
<body>
	<header class="hf">
		<a href="getRegistermembers"><button class="input" style="background-color: #4CAF50;margin-left: 22px;">registered members</button></a>
	</header>
	<main>
		<aside class="form">
			<form action="savemember">
				<h3><ins>Add Family Members:</ins></h3>
				<table>
					<tr>
						<td>MEMBER NAME:</td>
						<td><input type="text" name="name" required class="input"></td>
					</tr>
					<tr>
						<td>GENDER:</td>
						<td><input type="text" name="gender" required class="input"></td>
					</tr>
					<tr>
						<td>DATE OF BIRTH:</td>
						<td><input type="date" name="dob" required class="input"></td>
					</tr>
					<tr>
						<td>ID PROOF:</td>
						<td>
							<select id="dropdown" name="idProof" class="input">
							    <option value="DRIVING LICENCE">DRIVING LICENCE</option>
							    <option value="AADHAAR">AADHAAR</option>
							    <option value="PAN">PAN</option>
							    <option value="VOTER CARD">VOTER CARD</option>
			  				</select>
			  			</td>
					</tr>
					<tr>
						<td>ID PROOF NUMBER:</td>
						<td><input type="text" name="idNumber" required class="input"></td>
					</tr>
					<tr>
						<td>VACCINE TYPE:</td>
						<td>
							<select id="dropdown" name="vaccineType" class="input">
							    <option value="COVISHIELD">COVISHIELD</option>
							    <option value="COVAXINE">COVAXINE</option>
			  				</select>
			  			</td>
					</tr>
					<tr>
						<td>DOSE:</td>
						<td>
							<select id="dropdown" name="dose" class="input">
							    <option value="1">1</option>
							    <option value="2">2</option>
							    <option value="3">3</option>
			  				</select>
			  			</td>
					</tr>
					<tr>
						<td><input type="submit" value="ADD" class="input" style="background-color: #4CAF50;"></td>
					</tr>
				</table>
				<h2>${save }</h2>
			
			</form>
			<table border="3px" class="table">
				<tr>
					<th>MEMBER ID</th>
					<th>NAME</th>
					<th>GENDER</th>
					<th>DOB</th>
					<th>ID PROOF</th>
					<th>ID PROOF NUMBER</th>
					<th>VACCINE TYPE</th>
					<th>DOSE</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="member" items="${members}" >
				<tr>
					<td>${member.memberId }</td>
					<td>${member.memberName }</td>
					<td>${member.gender }</td>
					<td>${member.dob }</td>
					<td>${member.idProof }</td>
					<td>${member.idProofNumber }</td>
					<td>${member.vaccineType}</td>
					<td>${member.dose}</td>
					<td><a href="editMemberDetails/${member.idProofNumber}">Edit</a></td>
					<td><a href="deleteMemberDetails/${member.idProofNumber}">Delete</a></td>
				</tr>
				
				</c:forEach>
			</table>
	
		</aside>
	</main>

	<footer class="hf"></footer>
	
	  
	
</body>
</html>