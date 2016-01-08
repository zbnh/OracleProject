<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function () { $("[data-toggle='tooltip']").tooltip(); });
</script>
<title>Dept</title>
</head>
<body>
	<div class="container">
		<div style="margin: 0 auto; width: 900px; position: absolute;">
			<img alt="" src="img/header.jpg" style="width: 900px; height: 225px;">
			<img alt="" src="img/navbanner.jpg"
				style="width: 900px; height: 37px;">
			<div style="margin-top: -34px;">
				<a href="./EmpServlet?method=findAll" class="btn btn-primary"
					data-toggle="tooltip" title="view emp table">click to view emp</a> <a
					href="./DeptServlet?method=findAll" class="btn btn-primary" data-toggle="tooltip" title="view dept table">click
					to view dept</a> <a href="./EmpServlet?method=findAllWithDept"
					class="btn btn-primary" data-toggle="tooltip" title="view all information">click to view all</a> <a
					href="./EmpServlet?method=preinsert" class="btn btn-primary" data-toggle="tooltip" title="add employee information" >insert
					into emp</a> <a href="./DeptServlet?method=preinsert"
					class="btn btn-primary" data-toggle="tooltip" title="add department information">insert into dept</a> <a href="Login.jsp"
					class="btn btn-warning" data-toggle="tooltip" title="logout">Exit</a>

			</div>
			<form action="${sessionScope.action}" method="post">
				<table class="table table-hover table-striped">
					<tr>
						<td>deptno: <input type="text" name="deptno"
							value="${sessionScope.deptno}"></td>
						<td>dname: <input type="text" name="dname"
							value="${sessionScope.dname}"></td>
					</tr>
					<tr>
						<td>loc: <input type="text" name="loc"
							value="${sessionScope.loc}"></td>

					</tr>
					<tr>
						<td><input type="submit" name="submit" value="提交"
							class="btn btn-success"></td>
					</tr>
				</table>

			</form>

		</div>
	</div>
</body>
</html>