<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <title>Add new user</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css">
    <link href="<c:url value="/res/css/main.css" />" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="col-md-6">
        <form method="POST" action='/depSaveOrUpdate' >
            <fieldset class="form-group" >

                Name : <input
                    type="text" name="name"
                    value="<c:out value="${department.name}" />" /> <br/>

                <p class="error"> ${error.get("name")}</p>
            </fieldset>
            <input type="hidden" name="id" value="<c:out value="${department.id}" />"> <!-- c.out protect input-->
            <button type="submit"  class="btn btn-primary">Submit</button>
        </form>
     </div>
</div>

</body>
</html>
