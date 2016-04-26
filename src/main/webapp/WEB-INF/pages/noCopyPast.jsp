<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show Error Page</title>
</head>
<body background="../../res/img/1.jpg">
<h1>Opps...</h1>
<h3>${pageContext.exception.message}</h3> <!-- PageContex rrovide to namespace assoc with JSP-->
</body>
</html>