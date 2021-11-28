<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet"/> 
</head>
<body>
	<div class="div-container-main">
		<a><strong class="strong-button">>학사정보<</strong></a>
		<h1 class="title">학과소개</h1>
	
		<div class="div-introduce">
			<div class="div-explain">
				<img class="img-home"  src="${pageContext.request.contextPath}/resources/images/internship.jpg" alt="1">
				
				<strong>전공 심화 트랙</strong>	
				<p>	
					산업체 수요를 바탕으로 특성화 트랙을 선정하여 전공 심화 교육을 실시한다<br/>
					(모바일 소프트웨어, 웹 공학,<br/>
					빅 데이터, 디지털 컨텐츠 및 가상 현실)
				</p>
			</div>
			<div class="div-explain">
				<img class="img-home" src="${pageContext.request.contextPath}/resources/images/project.jpg" alt="2">
				
				<strong>전공 심화 트랙</strong>
				
				<p>
					산업체와 함께 프로젝트를 진행하여 현장 실무 능력과 융합적 사고력을 배양한다<br/>
							(캡스톤 디자인, 경진 대회,<br/>
								산학협력 프로젝트 )
				</p>
			</div>
			<div class="div-explain">
				<img class="img-home" src="${pageContext.request.contextPath}/resources/images/track.png" alt="3">
				
				<strong>현장 실습 교육</strong>
				<p>
				국내외 인턴쉽 프로그램을 통해 현장 적응력을 배양하고 취·창업을 지원한다<br/>
				(ICCEUSA 해외 인턴 사업, 취·창업 교육,<br/>
					IPP형 일학습 병행제)
				</p>
			</div>
		</div>
	</div>
</body>
</html>