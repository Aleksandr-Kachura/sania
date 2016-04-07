<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All Employees</title>
</head>
<body>
<table border="3" >
    <thead>
    <tr>
        <th bgcolor="#deb887">Empl Id</th>
        <th bgcolor="#deb887" >firstName</th>
        <th bgcolor="#deb887" >secondName</th>
        <th bgcolor="#deb887" >birthday</th>
        <th bgcolor="#deb887" colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="empl">
        <tr>
            <td><c:out value="${empl.id}" /></td>
            <td><c:out value="${empl.firstName}" /></td>
            <td><c:out value="${empl.secondName}" /></td>
            <td><c:out value="${empl.birthday}" /></td>
            <td>
                <form method="post" action="/delEmpl">
                    <input type="hidden" name="id" value=${empl.id}>
                    <input type="hidden" name="depId" value=${depId}>
                    <input type="submit" value="Delete">
                </form>
            </td>
            <td>
                <form method="post" action="/editEmpl">
                    <input type="hidden" name="id" value=${empl.id}>
                    <input type="hidden" name="depId" value=${depId}>
                    <input type="submit" value="Update">
                </form>
            </td>


        </tr>
    </c:forEach>
    </tbody>
</table>
<td><a class="btn btn-lg btn-danger" href="<c:url value="/addEmpl?depId=${depId}" />" role="button">Add Employees</a></td>

</body>
</html>