<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${Title}</title>
</head>
<body>

<h1>
    Login
</h1>
<h2>
    <c:if test="${not empty Content}">
        ${Content}
    </c:if>
</h2>
<form method="post" action="${pageContext.request.contextPath}/loginProcess">
    <div>
        <label>
            ID : <input type="text" name="userId" />
        </label>
    </div>

    <div>
        <label>
            PW : <input type="password" name="userPw" />
        </label>
    </div>
    <input type="submit" value="${Title}" />
</form>
</body>
</html>
