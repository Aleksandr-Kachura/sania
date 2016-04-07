<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <title>Add new user</title>
</head>
<body>
<form method="POST" action='saveEmpl' name="frmAddUser">
   <p>firstName :</p>  <input type="text" name="firstName" value="<c:out value="${employee.firstName}" />" /> <br/>
   <p>secondName :</p>  <input type="text" name="secondName" value="<c:out value="${employee.secondName}" />" /> <br/>
    <p>Birthday :</p> <input type="date" name="birthday" id="dateInput" placeholder="MM/DD/YYYY" value="${employee.birthday}"/><br />
   <input type="hidden" name="depId" value="<c:out value="${depId}" />" >
   <input type="hidden" name="id" value="<c:out value="${employee.id}" />">
   <input type="submit" value="Submit" />
</form>
</body>
</html>
