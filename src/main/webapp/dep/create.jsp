<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <title>Add new user</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
</head>
</head>
<body background="../res/img/406821.jpg">
<div class="container">
    <div class="col-md-6">
        <form method="POST" action='saveDep' name="frmAddUser" >
            <fieldset class="form-group" >

                Name : <input
                    type="text" name="name"
                    value="<c:out value="${department.name}" />" /> <br/>

                <p style="color: red"> ${error.get("name")}</p>
            </fieldset>
            <input type="hidden" name="id" value="<c:out value="${department.id}" />">
            <button type="submit"  class="btn btn-primary">Submit</button>
        </form>
     </div>
</div>

</body>
</html>
