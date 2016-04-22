<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <title>Add new user</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css">
</head>

<body background="../res/img/406821.jpg">
<div class="container">
    <div class="col-md-6">
        <form:form method="POST" action='/depSaveOrUpdate' modelAttribute="department" >
            <fieldset class="form-group" >

                Name : <input
                    type="text" name="name"
                    value="<c:out value="${department.name}" />" /> <br/>

                <p style="color: red"> ${error.get("name")}</p>
            </fieldset>
            <input type="hidden" name="id" value="<c:out value="${department.id}" />"> <!-- c.out protect input-->
            <button type="submit"  class="btn btn-primary">Submit</button>
        </form:form>
     </div>
</div>

</body>
</html>
