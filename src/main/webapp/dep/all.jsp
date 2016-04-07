<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All Departments</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th bgcolor="#deb887">Dep Id</th>
        <th bgcolor="#deb887">Name</th>
        <th bgcolor="#deb887" colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${departments}" var="dep">
        <tr>
            <td><c:out value="${dep.id}" /></td>
            <td><a class="btn btn-lg btn-danger" href="<c:url value="/showAllEmpl?depId=${dep.id}" />" role="button">${dep.name}</a></td>
            <td>
                <form method="post" action="/delDep">
                    <input type="hidden" name="id" value=${dep.id}>
                    <input type="submit" value="Delete">
                </form>
            </td>
            <td>
                <form method="post" action="/editDep">
                    <input type="hidden" name="id" value=${dep.id}>
                    <input type="submit" value="Update">
                </form>
            </td>


        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="/addDep">Add Department</a></p>
</body>
</html>