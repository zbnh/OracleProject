<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function () { $("[data-toggle='tooltip']").tooltip(); });
</script>
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
			<table class="table table-hover table-striped">
				<tr class="info">
					<th>deptno</th>
					<th>dname</th>
					<th>loc</th>
					<th>operation</th>
				</tr>
				<c:forEach items="${sessionScope.deptList}" var="dept">
					<tr>
						<td>${dept.deptno}</td>
						<td>${dept.dname}</td>
						<td>${dept.loc}</td>
						<td><a
							href="./DeptServlet?method=delete&deptId=${dept.deptno}"
							class="btn btn-danger">delete</a> <a
							href="./DeptServlet?method=preupdate&deptId=${dept.deptno}"
							class="btn btn-info">update</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>


</html>