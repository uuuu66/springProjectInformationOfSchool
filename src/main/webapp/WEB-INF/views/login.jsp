<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>로그인</title>
  	<link href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" rel="stylesheet"/> 
  </head>
  <body>
     <div class="div-container-main">
     	
      <form class="form-signin" method="post" action="http://localhost:30001/bachelor/login">
        <h2 class="form-signin-heading">로그인하기</h2>
        <c:if test="${not empty errorMsg}"><strong class="strong-warn">${errorMsg}</strong></c:if>
      <p>
      	
          <label for="username" class="sr-only">학생 이름</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="username" required="" autofocus="">
        </p>
        <p>
          <label for="password" class="sr-only">비밀번호</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
        </p>
		<input name="_csrf" name="${_csrf.parameterName}"value="${_csrf.token}" hidden/>
        <button class="btn-lg" type="submit">로그인하기</button>
      </form>
</div>
</body></html>