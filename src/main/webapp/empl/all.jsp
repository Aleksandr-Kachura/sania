<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
    <title>Show All Employees</title>
</head>
<body background="../res/img/406821.jpg" >
<div class="container" >
    <div class="row">
        <table border="3" class="table table-sm"  >
            <thead>
            <tr>
                <th bgcolor="#deb887">Empl Id</th>
                <th bgcolor="#deb887" >firstName</th>
                <th bgcolor="#deb887" >secondName</th>
                <th bgcolor="#deb887" >birthday</th>
                <th bgcolor="#deb887" >Email</th>
                <th bgcolor="#deb887" colspan=2>Action</th>
            </tr>
            </thead>
            <tbody bgcolor="silver">
            <c:forEach items="${employees}" var="empl">
                <tr >
                    <td><c:out value="${empl.id}" /></td>
                    <td><c:out value="${empl.firstName}" /></td>
                    <td><c:out value="${empl.secondName}" /></td>
                    <td><c:out value="${empl.birthday}" /></td>
                    <td><c:out value="${empl.email}" /></td>
                    <td>
                        <form method="post" action="/delEmpl">
                            <input type="hidden" name="id" value=${empl.id}>
                            <input type="hidden" name="depId" value=${depId}>
                            <input type="hidden" name="object" value=${empl}>
                            <input type="submit" class="btn btn-danger"  value="Delete">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="/editEmpl">
                            <input type="hidden" name="id" value=${empl.id}>
                            <input type="hidden" name="depId" value=${depId}>
                            <input type="submit" class="btn btn-success" value="Update">
                        </form>
                    </td>


                </tr>
            </c:forEach>
            </tbody>
        </table>
        <td><a href="<c:url value="/addEmpl?depId=${depId}" />">Add Employees</a></td>
    </div>
</div>


</body>
</html>