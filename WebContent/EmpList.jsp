<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employees</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function () { $("[data-toggle='tooltip']").tooltip(); });
</script>
</head>
<body>

	<div class="container" style="">

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

			<table class="table table-hover table-striped">
				<tr class="info">
					<th>empno</th>
					<th>ename</th>
					<th>job</th>
					<th>mgr</th>
					<th>hiredate</th>
					<th>sal</th>
					<th>comm</th>
					<th>deptno</th>
					<th>operation</th>
				</tr>
				<c:forEach items="${sessionScope.empList}" var="emp">
					<tr>
						<td>${emp.empno}</td>
						<td>${emp.ename}</td>
						<td>${emp.job}</td>
						<td>${emp.mgr}</td>
						<td>${emp.hiredate}</td>
						<td>${emp.sal}</td>
						<td>${emp.comm}</td>
						<td>${emp.deptno}</td>
						<td><a href="./EmpServlet?method=delete&empid=${emp.empno}"
							class="btn btn-danger">delete</a> <a
							href="./EmpServlet?method=preupdate&empno=${emp.empno}"
							class="btn btn-info">update</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>