<%--
  Created by IntelliJ IDEA.
  User: bbu0704
  Date: 2022-03-16
  Time: 오후 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>${Title}</title>
</head>
<body>
${Content}

    <div>
        <form method="post" action="/user/register">
            <label>
                <input type="text" name="userId">
                <input type="password" name="userPw">
            </label>
        </form>
    </div>
</body>
</html>
