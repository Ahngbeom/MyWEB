<%@ page contentType="text/html;charset=UTF-8" %>

<%-- 특정 라이브러리의 tag 정의 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>${Title}</title> <%-- "Title" 이름을 가진 Data 추출 및 출력 --%>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<c:choose>
<%--  <jsp:useBean id="USER" scope="session" type="org.zerock.domain.UserVO"/>--%>
  <c:when test="${not empty USER}">
    <form name="userInfoForm" method="get" action="${pageContext.request.contextPath}/user/info">
      <input type="hidden" name="userId" value="${USER.userId}" />
<%--      <input type="hidden" name="userPw" value="${USER.userPw}" />--%>
<%--      <input type="hidden" name="userName" value="${USER.userName}" />--%>
      <h2>
<%--        계정 : <input type="submit" value="${USER.userId}" />--%>
        계정 : <a href="javascript: submitForm()">${USER.userId}</a>
      </h2>
    </form>
    <form method="post" action="${pageContext.request.contextPath}/logout">
      <input type="submit" value="Logout" />
    </form>
  </c:when>
  <c:otherwise>
    <a href="${pageContext.request.contextPath}/login">
      Login
    </a>
  </c:otherwise>
</c:choose>

<h3>${USER}</h3>

<h1>
  <div id="pageContent">

  </div>
<%--  ${Content} &lt;%&ndash; "Content" 이름을 가진 Data 추출 및  &ndash;%&gt;--%>
</h1>

<div>
  <form method="post" action="${pageContext.request.contextPath}/board/create">
    <div>
        <c:choose>
          <c:when test="${not empty USER}">
            <label>
              작성자 : <input type="text" value="${USER.userName}" disabled>
            </label>
            <label>
              익명 <input type="checkbox">
            </label>
          </c:when>
          <c:otherwise>
            <label>
              작성자 : <input type="text" disabled>
            </label>
            <label>
              익명 <input type="checkbox" checked disabled>
            </label>
          </c:otherwise>
        </c:choose>
    </div>

    <br>

    <div>
      <label>
        내용 : <textarea cols="30" rows="10"></textarea>
      </label>
      <label>
        <input type="submit" value="등록">
      </label>
    </div>

    <div>

    </div>

  </form>
</div>

</body>

</html>

<script type="text/javascript">
  $(document).ready(function () {

    console.log("Hello");
    let result = '<c:out value="${Content}" />';
    console.log(result);

    displayMessage(result);

    function displayMessage(result) {
      $("#pageContent").html(result);
    }
  });

  function submitForm() {
    document.userInfoForm.submit();
  }

</script>
