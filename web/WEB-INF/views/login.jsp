<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${Title}</title>
</head>
<body>
<h1>${Content}</h1>
<form method="post" action="${pageContext.request.contextPath}/login">
    <label>
        ID : <input type="text" name="userId" />
    </label>
    <label>
        PW : <input type="password" name="userPw" />
    </label>
    <input type="submit" value="${Title}" />
</form>
</body>
</html>
