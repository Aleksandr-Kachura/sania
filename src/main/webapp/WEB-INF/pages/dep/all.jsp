<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> <!-- jstl fech-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> <!-- morf sintacs-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All Departments</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" >
    <link href="<c:url value="/res/css/main.css" />" rel="stylesheet">
</head>
<body >
<div class="container"  >
    <div class="row" >
            <table class="table table-sm" border="3" >
                <thead>
                <tr class="tabHead">
                    <th >Dep Id</th>
                    <th >Name</th>
                    <th colspan="2" >Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${departments}" var="dep">
                    <tr class="tabBody" >
                        <td ><c:out  value="${dep.id}" /></td>
                        <td><a  href="<c:url value="/showAllEmpl?depId=${dep.id}" />" >${dep.name}</a></td> <!-- for correcr attrib-->
                        <td>
                            <form method="post" action="/delDep">
                                <input type="hidden" name="id" value=${dep.id}>
                                <input  class="btn btn-danger" type="submit" value="Delete">
                            </form>
                        </td>
                        <td>
                            <form method="post" action="/editOrAddDep">
                                <input type="hidden" name="id" value=${dep.id}>
                                <input class="btn btn-success" type="submit" value="Update">
                            </form>
                        </td>


                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <p><a href="/editOrAddDep">Add Department</a></p>
    </div>
</div>

</body>
</html>