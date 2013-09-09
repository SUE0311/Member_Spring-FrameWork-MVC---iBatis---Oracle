<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>메인 화면</title>

<link rel="stylesheet" type="text/css" href="css/main.css" />
<script src="./js/jquery.js"></script>

</head>
<body>
 <div id="main_wrap">
 
  <!-- 상단 header -->
  
  <div id="header">
    <div id="logo">
     <a href="index.jsp" onfocus="this.blur()">
     <img src="./images/jsnoteLogo.png" width="250" border="0" /></a>
     <!-- 그림삽입 태그 -->
    </div>
    
    <div id="top_menu">
     <ul>
      <li><a href="#" onfocus="this.blur()">공지사항</a>
      <li>
      <a href="#"
         onfocus="this.blur()">게시판</a></li>
      <li>
       <a href="#" 
         onfocus="this.blur()">자료실</a></li>
      <li>
        <a href="./guest_list.do" 
           onfocus="this.blur()">방명록</a></li>
    </div>
    
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
  </div>
  
  <div class="clear"></div>
  
    <!-- 본문 내용 -->
    <div id="article">
     <div id="left_menu">
      <script language="javascript">

       function login_check(){//함수 정의
    	   if(window.document.f.id.value==""){
    		   //아무것도 입력하지 않았다면
    		    alert("아이디를 입력하세요!");//경고창 띄운다.
    		    f.id.focus();//포커스를 이동
    		    return false;
    	   }
           if($.trim($("#pwd").val())==""){
        	   //trim()을 사용하여 양쪽 공백을 제거
        	   alert("비번을 입력하세요!");
        	   $("#pwd").val("").focus();//초기화 하고 포커스 이동
        	   return false;
       	   }
       }       
      </script>
     
      <form name="f" method="post" action="member_Login_ok.do"
      onsubmit="return login_check()">

        <table id="login_t">
         <tr>
          <th>아이디</th>
          <td>
          <input type="text" name="login_id" id="id" 
         	 class="input_box" size="14" />
          </td>
         </tr>
         
         <tr>
           <th>비밀번호</th>
           <td>
            <input type="password" name="login_pwd" id="pwd" 
           	 size="14" class="input_box" />
           </td>
         </tr>
        </table>
        <div id="login_menu">
         <input type="submit" value="로그인" class="input_b" />
         <input type="button" value="비번찾기" class="input_b" 
         	onclick='location.href="./pwd_Find.do"' />
         <!-- 클릭이벤트를 발생해서   pwd_find()함수 호출 -->
        </div>
      </form>
     </div>
     
     <div id="article_c">
     	<!-- 최신 공지사항 목록보기 메뉴 추가 -->		
       <p class="article_cont">
       	<a href="#">
			[[[ 최신 공지사항 보기  ]]]
		</a>
		<br>
		<br>
		<br>
		<div id="contentList">
			<center>
       		<h3>스프링 MVC 프로젝트 구현 내용</h3>
       		</center>
       		<div id="leftList">
	       		<h4>1. 회원관리</h4>
	       			<p>1) Spring Framework + iBatis + Oracle11g
	       			<ul>
	       				<li>회원 가입</li>
	       				<li>비밀번호 찾기</li>
	       				<li>로그인/로그아웃</li>
	       				<li>회원 정보 수정</li>
	       				<li>회원 탈퇴</li>
	       			</ul>
       		</div>
       		<div id="rightList">
	       		<h4>2. 방명록</h4>
	       			<p>1) Spring Framework + Jdbc + Oracle11g
		       			<ul>
		       				<li>리스트 보기</li>
		       				<li>총 레코드 개수</li>
		       				<li>게시물 수정</li>
		       				<li>게시물 삭제</li>
		       			</ul>
	       			<p>2) Spring Framework + iBatis + Oracle11g
		       			<ul>
		       				<li>조회수 증가</li>
		       			</ul>
		       		<p>3) Model2 + JDBC + Oracle11g
		       			<ul>
		       				<li>게시물 내용 보기</li>
		       			</ul>	
       		</div>	
       	</div>	
       </p> 
     </div>
    </div>
    
    <div class="clear"></div>
    
    <!-- 하단 내용 -->
    <div id="footer">
      <h2 class="footer_title">
    	<center>Spring 3.0 MVC PROJECT<br>
    	하이브리드 웹앱 게임 개발자 과정 / 중앙정보처리학원 / 김진성 교수님</center>  
     </h2>
     <!-- 관리자 전용 메뉴 -->
     <a href="#" onfocus="this.blur()">
	     <div id="admin_menu">
	       		관리자 전용 
	     </div>
     </a>
    </div>
 </div>
</body>
</html>