<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <title>Add new user</title>
</head>
<body>
<form method="POST" action='saveDep' name="frmAddUser">
    Name : <input
        type="text" name="name"
        value="<c:out value="${department.name}" />" /> <br/>
    <c:forEach items="${error}" var="error">
        ${error.value} <br/>
    </c:forEach>

        <input type="hidden" name="id" value="<c:out value="${department.id}" />">
        <input type="submit" value="Submit" />
</form>
</body>
</html>
