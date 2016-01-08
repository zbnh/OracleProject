<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
</head>
<body>

	<div class="container" style="width: 100%;height: 100%">
		<img alt="" src="img/loginbg.jpg" style="margin: 0 auto;">
		<div class="" style="margin: 0 auto;">
			<div class="span4"
				style="margin: 0 auto;margin-top:80px; height: 450px; width: 450px; 
				position: absolute; top: 0; left: 0; bottom: 0; right: 0;background: rgba(255,255,255,0.4);">
				<form action="./EmpServlet?method=checklogin" method="post"
					class="form-horizontal" style="margin: 100px;margin-left: -50px;">
					<div class="control-group">
						<div class="controls">
							UserName:<input type="text" name="uname" placeholder="UserName"
								class="input">
						</div>
						<br>
						<div class="controls">
							Password:<input type="password" name="upwd"
								placeholder="Password" class="input"> <br>
						</div>
						<br>
						<div class="controls">
							<input type="submit" name="submit" value="login" class="btn btn-success">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>