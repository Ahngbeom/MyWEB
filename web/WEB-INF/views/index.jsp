<%@ page contentType="text/html;charset=UTF-8" %>

<%-- 특정 라이브러리의 tag 정의 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>${Title}</title> <%-- "Title" 이름을 가진 Data 추출 및 출력 --%>
</head>
<body>
<c:choose>
  <c:when test="${not empty USER}">
    <a href="${pageContext.request.contextPath}/user/info?userName=${USER.userId}"><h2>ID : ${USER.userId}</h2></a>
  </c:when>
  <c:otherwise>
    <a href="${pageContext.request.contextPath}/login">
      Login
    </a>
  </c:otherwise>
</c:choose>

<h3>${USER}</h3>

<h1>
  ${Content} <%-- "Content" 이름을 가진 Data 추출 및  --%>
</h1>

<div>
  <form method="post" action="/send">
    <label>
      익명 <input type="checkbox">
    </label>
    <label>
      <textarea cols="30" rows="10"></textarea>
    </label>

    <label>
      <input type="submit" value="Send">
    </label>

  </form>
</div>
</body>
</html>
