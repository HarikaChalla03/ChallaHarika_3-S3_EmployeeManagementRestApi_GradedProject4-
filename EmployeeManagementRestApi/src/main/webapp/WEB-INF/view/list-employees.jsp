<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Employees Directory</title>
</head>

<body>
	<div class="container">

		<h3>Employees Directory</h3>
		<hr>

		<!-- Add a search form -->
		<form action="/EmployeeManagementRestApi/employees/search"
			class="form-inline">

			<!-- Add a button -->
			<a href="/EmployeeManagementRestApi/employees/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Employee </a>
		</form>

		<table class="table table-bordered table-striped">
			<tr>
				<th>EmployeeId</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Department</th>
				<th>Country</th>
				<th>Action</th>
			</tr>
			</thead>

			<tbody>
				<c:forEach items="${ListofEmployees}" var="tempEmployee">
					<tr>
						<td><c:out value="${tempEmployee.empId}" /></td>
						<td><c:out value="${tempEmployee.firstName}" /></td>
						<td><c:out value="${tempEmployee.lastName}" /></td>
						<td><c:out value="${tempEmployee.email}" /></td>
					    <td>
							<!-- Add "update" button/link --> <a
							href="/EmployeeManagementRestApi/employees/showFormForUpdate?employeeId=${tempEmployee.empId}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a
							href="/EmployeeManagementRestApi/employees/delete?employId=${tempStudent.empId}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete
						</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

		<a href=/EmployeeManagementRestApi/employees/showFormForAdd>REGISTER
			NEW STUDENT</a>

	</div>

</body>
</html>