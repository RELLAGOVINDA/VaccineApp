<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<style>
		.hf{
			height: 60px;
			width: 100%;
			background-color: #E7BCDE;
		}
		body{
			background-color: #5FBDFF;
		}
		main{
			height: 360px;
			width: 100%;
		}
		p{
		 text-align: right;
		 margin-top: -12px;
		 
		}
		.button{
		 	background-color:#4CAF50;
		 	border-radius: 8px;
		}
		.card-container {
            display: flex;
            justify-content: space-around;
        }

        .card {
            width: 200px;
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 10px;
            margin: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #C3E2C2;
        }

        .card img {
            width: 100%;
            border-radius: 4px;
            margin-bottom: 10px;
        }
        form{
        	margin-left: 20px;
        	padding-top: 13px;
        }
	</style>
</head>
<body>
	<header class="hf">
		<form action="getMemberPage">
			<input type="submit" value="AddMember" class="button">
		</form>
	    <p>${email}
		<a href="logout"><button class="button">Logout</button></a></p>
	</header>
	<main>
		   <div class="card-container">
        <div class="card">
            <h3>MEMBER COUNT :</h3>
            <h1 style="text-align: center; font-size: 70px">${memberCount}</h1>
        </div>

        <div class="card">
            <h3>VACCINES: </h3>
            <h3>1.SPUTNIK V</h3>
            <h3>2.COVAXIN</h3>
            <h3>3.COVISHIELD</h3>
        </div>
        
        <div class="card">
            <h3>DOSE :</h3>
            <h4>FIRST DOSE</h4>
            <h4>SECOND DOSE</h4>
            <h4>PRECAUTION DOSE</h4>
            
        </div>

        <div class="card">
            <pre>
<b>Protect yourself
and those around you:</b>

1.Get vaccinated as soon
 as it’s your turn and 
 follow local guidance 
 on vaccination.
 
2.Keep physical distance 
 of at least 1 metre from 
 others, even if they 
 don’t appear to be sick. 
 Avoid crowds and close
 contact.
            </pre>
        </div>

        
    </div>
 	</main>
 	<footer class="hf"></footer>
</body>
</html>