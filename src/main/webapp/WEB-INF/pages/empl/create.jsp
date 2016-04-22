<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <title>Add new user</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" >
</head>
<body background="../res/img/406821.jpg">
<div class="container">
    <div class="col-md-6">
<form method="post" action="/employeeSaveOrUpdate" >
            <fieldset class="form-group" >
                <p>firstName :</p>  <input type="text" name="firstName" value="<c:out value="${employee.firstName}" />" /> <br/>
                <p style="color: red"> ${error.get("firstName")}</p>
                <p>secondName :</p>  <input type="text" name="secondName" value="<c:out value="${employee.secondName}" />" /> <br/>
                <p style="color: red"> ${error.get("secondName")}</p>
                <p>Birthday :</p> <input type="date" name="birthday" id="dateInput" required value="${param['birthday'] eq null ? employee.birthday : param['birthday']}"/><br />

                <p style="color: red"> ${error.get("birthday")}</p>
                <p>Email :</p>  <input type="text" name="email" placeholder="email..." value="<c:out value="${employee.email}" />" /> <br/>


                <p style="color: red"> ${error.get("email")}</p>
                <input type="hidden" name="depId" value="<c:out value="${depId}" />" >
                <input type="hidden" name="id" value="<c:out value="${employee.id}" />">
                <input type="submit" value="Submit" />
            </fieldset>
</form>
    </div>
</div>
</body>
</html>
