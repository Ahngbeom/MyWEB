<%--
  Created by IntelliJ IDEA.
  User: bbu0704
  Date: 2022-03-18
  Time: 오전 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<a href="/test2">test2</a>
${msg1}
<%--${msg2}--%>
</body>
</html>
<script type="text/javascript">
    $(document).ready(function () {
        let msg1 = '<c:out value="${msg1}" />';
        let msg2 = '<c:out value="${msg2}" />';

        console.log(msg1);
        console.log(msg2);
        alert("Crash!");
    });
</script>
