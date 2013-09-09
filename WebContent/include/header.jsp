<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
  String id=(String)session.getAttribute("id"); 
%>

    <!-- html  주석문기호. 위 부분은 jsp(java server pages) 에서
    지시자라고 한다. 즉   jsp 정의문 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 화면</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/member.css" />
<!-- css 외부 포함파일을 불러오는 것. css는  디자인 UI 를 작성 -->
<script src="./js/jquery.js"></script>
<!-- jQuery 자바스크립트 라이브러리 외부 파일을 읽어온다 -->
</head>
<body>
 <div id="main_wrap">
  <!-- 상단 header -->
  
  <div id="header">
  
  	<c:if test="${!empty id}">
    	<div id="logo">
	     <a href="index.do" onfocus="this.blur()">
	     <img src="./images/jsnoteLogo.png" width="250" border="0" /></a>
	     <!-- 그림삽입 태그 -->
	    </div>
    </c:if>
    
    <c:if test="${empty id}">
    	<div id="logo">
	     <a href="index.jsp" onfocus="this.blur()">
	     <img src="./images/jsnoteLogo.png" width="250" border="0" /></a>
	     <!-- 그림삽입 태그 -->
	    </div>
    </c:if>
    
    <div id="top_menu">
     <ul>
      <li><a href="#" onfocus="this.blur()">공지사항</a>
      <!-- ul li 태그는 목록을 만드는 태그이다. a href 는 다른 주소로 이동
      하는 하이퍼링크를 거는 태그이다. -->
      <li>
      <a href="#"
         onfocus="this.blur()">게시판</a></li>
      <li>
       <a href="#" 
         onfocus="this.blur()">자료실</a></li>
      <li>
        <a href="./guest_list.do" 
           onfocus="this.blur()">방명록</a></li>
      <!-- onfocus는 포커스를 가졌을때 발생하는 자바스크립트 
      사건처리기 즉 이벤트 핸들러 이다. 클릭시 사각점선을 사라지게 함 --> 
     </ul>
    </div>
    
    <c:if test="${!empty id}">
    	<div id="top_login">
	     <ul>
	      <li>&nbsp;&nbsp;&nbsp;[${id }] 님</li>
	      <li><a href="index.do" onfocus="this.blur()">홈으로</a></li>
	      <!-- &nbsp;은 한칸 공백을 띄워준다 .-->
	     </ul> 
	    </div>
    </c:if>
    
    <c:if test="${empty id}">
    	<div id="top_login">
	     <ul>
	      <li><a href="index.jsp" onfocus="this.blur()">홈</a></li>
	       &nbsp;
	      <!-- &nbsp;은 한칸 공백을 띄워준다 .-->
	      <li><a href="./member_Login.do" 
	      onfocus="this.blur()">로그인</a></li>
	      <li><a href="./member_Join.do"
	      onfocus="this.blur()">회원가입</a></li>
	     </ul>    
	    </div>
    </c:if>
    
  </div>