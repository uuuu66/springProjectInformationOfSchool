<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>information</title>
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
			<form id="logout"  action="<c:url value="/logout" />" method="post">
			  <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
			</form>
		</div>
		<h1 class="h1-title"><c:out value="${username}"/>의 학사 정보</h1>
		<table>
			<thead>
				<tr>
					<th>연도</th><th>학기</th><th>학점 합계</th><th>상세보기</th>
				</tr>
			</thead>
				<tbody>
					<c:forEach  var="allClasses" items="${allClasses}">
					<tr>
						<td><c:out value="${allClasses.registerYear}"></c:out></td>
						<td><c:out value="${allClasses.semester}"></c:out></td>
						<td><c:out value="${allClasses.classDegree}"></c:out></td>
						<td><a href="${pageContext.request.contextPath}/getDetailView?year=${allClasses.registerYear}&semester=${allClasses.semester}">상세보기</a></td>
					</tr>
					</c:forEach>
				</tbody>
		</table>
	</div>
</body>
</html>