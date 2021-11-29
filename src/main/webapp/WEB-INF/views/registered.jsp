<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" rel="stylesheet"/> 
</head>
<body>
	<div class="div-container-main">
		<div class="div-flex-row">
			<strong>
			<a href="${pageContext.request.contextPath}/">홈으로</a>
			<a href="${pageContext.request.contextPath}/register">수강신청하기</a>
			<a href="${pageContext.request.contextPath}/registered">수강신청조회</a>
			</strong>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
			  <strong><a href="javascript:document.getElementById('logout').submit()">로그아웃</a></strong>
			</c:if>
			<form id="logout"  action="<c:url value="/logout" />"method="post">
			  <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
			</form>
		</div>
		<h1 class="h1-title">수강 신청 상세 정보</h1>
		<table>
		<thead>
			<tr>
				<th>코드</th><th>이름</th><th>분류</th><th>연도</th><th>학기</th><th>학점</th><th>교수</th>
			</tr>
		</thead>
			<tbody>
				<c:forEach  var="allClasses" items="${allClasses}">
				<tr>
					<td><c:out value="${allClasses.classCode}"></c:out></td>
					<td><c:out value="${allClasses.className}"></c:out></td>
					<td><c:out value="${allClasses.classClassification}"></c:out></td>
					<td><c:out value="${allClasses.registerYear}"></c:out></td>
					<td><c:out value="${allClasses.semester}"></c:out></td>
					<td><c:out value="${allClasses.classDegree }"></c:out></td>
					<td><c:out value="${allClasses.professor}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>