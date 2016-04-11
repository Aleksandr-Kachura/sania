<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All Departments</title>
    <link href="<c:url value="" />" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
   <link href="<c:url value="../res/css/main.css" />" rel="stylesheet">
</head>
<body background="../res/img/406821.jpg">
<div class="container"  >
    <div class="row" >
            <table class="table table-sm" border="3" bgcolor="#556b2f"  >
                <thead>
                <tr>
                    <th bgcolor="#deb887">Dep Id</th>
                    <th bgcolor="#deb887">Name</th>
                    <th bgcolor="#deb887"  colspan=2>Action</th>
                </tr>
                </thead>
                <tbody b>
                <c:forEach items="${departments}" var="dep">
                    <tr bgcolor="silver">
                        <td ><c:out  value="${dep.id}" /></td>
                        <td><a  href="<c:url value="/showAllEmpl?depId=${dep.id}" />" role="button">${dep.name}</a></td>
                        <td style="padding: 10px">
                            <form method="post" action="/delDep">
                                <input type="hidden" name="id" value=${dep.id}>
                                <input  class="btn btn-danger" type="submit" value="Delete">
                            </form>
                        </td>
                        <td style="padding: 10px">
                            <form method="post" action="/editDep">
                                <input type="hidden" name="id" value=${dep.id}>
                                <input class="btn btn-success" type="submit" value="Update">
                            </form>
                        </td>


                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <p><a href="/addDep">Add Department</a></p>
    </div>
</div>

</body>
</html>