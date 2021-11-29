<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detailview</title>
<link href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" rel="stylesheet"/> 
</head>
<body>
		<div class="div-container-main">
		<div class="div-flex-row">
			<strong>
			<a href="${pageContext.request.contextPath}/information">학사정보확인</a>
			</strong>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
			  <strong><a href="javascript:document.getElementById('logout').submit()">로그아웃</a></strong>
			</c:if>
			<form id="logout"  action="<c:url value="/logout" />"method="post">
			  <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
			</form>
		</div>
		<h1 class="h1-title"><c:out value="${year}"></c:out>년 <c:out value="${semester}"/>학기 상세 정보</h1>
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
					<td><c:out value="${year}"></c:out></td>
					<td><c:out value="${semester}"></c:out></td>
					<td><c:out value="${allClasses.classDegree }"></c:out></td>
					<td><c:out value="${allClasses.professor}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	

</body>
</html>