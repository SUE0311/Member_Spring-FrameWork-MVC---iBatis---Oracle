<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="left_menu">
	<script language="javascript">
       //자바스크립트는 클라이언트 스크립트 언어로서 c언어 문법을따라간다.
       function login_check(){//함수 정의
    	   if(window.document.f.id.value==""){
    		   //자바스크립트 최상위 객체는  window이다.아무것도 입력하지
    		   //않았다면
    		    alert("아이디를 입력하세요!");//경고창 띄운다.
    		    f.id.focus();//포커스를 이동
    		    return false;
    	   }
           if($.trim($("#pwd").val())==""){
        	   //$는 jQuery 이다.trim()을 사용하여 양쪽 공백을 제거
        	   alert("비번을 입력하세요!");
        	   $("#pwd").val("").focus();//초기화 하고 포커스 이동
        	   return false;
       	   }
       }       
       /* 공지창 띄위기 */
       //function pwd_find() { // 함수정의
    	//   window.open("./pwd_Find.do", "비번찾기", "width=320px, height=250px scrollbars=yes");
       //자스에서  window 객체의 open() 메서드로 새로운 공지창을 만듬
       // open("공지창파일경로", "공지창이름", "공지창 속성")
       // 폭 300, 높이 300, 스크롤바가 생성되는 공지창을 만듬
       //}
      </script>
      
      <c:if test="${!empty id}">
      
      <div id="index_wrap">
		 <form method="post" action="member_Logout.do">
		     <table id="index_t">
		     	<tr>
		       <th>
		        [${id }] 님 <br>로그인을 환영합니다!
		       </th>
		      </tr>	
		      <tr>
		       <th>
		        <input type="button" value="정보수정" class="input_b"
		        onclick="location='member_Edit.do'" />
		        <input type="button" value="회원탈퇴" class="input_b"
		        onclick="location='member_DEL.do'" />
		        <input type="submit" value="로그아웃" class="input_b" />
		       </th>
		       </tr>
		     </table>
		  </form>
	   </div>	  
	  </c:if>
	  
	  <c:if test="${empty id}">
	      <form name="f" method="post" action="member_Login_ok.do"
	      onsubmit="return login_check()">
	        <!-- form태그는 사용자에서 입력한 정보를 서버로 보내는 태그이다.
	        method=post방식으로 보내면 보안이 좋다.웹주소창에 노출이 안됨.
	        action="서버파일주소"를 지정한다. -->
	        <table id="login_t">
	         <tr>
	          <th>아이디</th>
	          <!-- th태그는 열을 만들고 글자를 중앙 정렬,진하게 해준다. -->
	          <td>
	          <input type="text" name="login_id" id="id" 
	          class="input_box" size="14" />
	          <!-- text 는 한줄 입력필드를 만든다. -->
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
       </c:if>
</div><!-- end left_menu -->