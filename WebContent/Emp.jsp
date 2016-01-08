<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function () { $("[data-toggle='tooltip']").tooltip(); });
</script>
<title>Emp</title>
</head>
<body>
	<div class="container">
		<div style="margin: 0 auto; width: 900px; position: absolute;">
			<img alt="" src="img/header.jpg" style="width: 900px;height: 225px;"> <img alt=""
				src="img/navbanner.jpg" style="width: 900px; height: 37px;">
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
						<td>empno:<input type="text" name="empno"
							value="${sessionScope.empno}">
						</td>
						<td>ename:<input type="text" name="ename"
							value="${sessionScope.ename}">
						</td>
					</tr>
					<tr>
						<td>job:<input type="text" name="job"
							value="${sessionScope.job}">
						</td>
						<td>mgr:<input type="text" name="mgr"
							value="${sessionScope.mgr}">
						</td>
					</tr>
					<tr>
						<td>hiredate:<input type="text" name="hiredate"
							value="${sessionScope.hiredate}"></td>
						<td>sal:<input type="text" name="sal"
							value="${sessionScope.sal}">
						</td>
					</tr>
					<tr>
						<td>comm:<input type="text" name="comm"
							value="${sessionScope.comm}">
						</td>
						<td>deptno:<input type="text" name="deptno"
							value="${sessionScope.deptno}">
						</td>
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