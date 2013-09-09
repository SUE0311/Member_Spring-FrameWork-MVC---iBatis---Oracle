<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../include/header.jsp" %>

<script src="./js/member.js"></script>
<link rel="stylesheet" type="text/css" href="./css/member.css" />

<div class="clear"></div>
  
<!-- 본문 내용 -->
<div id="article">

<%@ include file="../../include/left_menu.jsp" %>

<div id="article_c">

  <div id="login_wrap">
   <h2 class="login_title">로&nbsp;그&nbsp;인</h2>
   <form method="post" action="member_Login_ok.do"
   onsubmit="return Login_check();">
    <table id="login_t">
     <tr>
      <th>아이디</th>
      <td>
       <input name="login_id" id="login_id" size="14"
       class="box" />
      </td>
      <th rowspan="2">
       <input type="submit" value="로그인" class="input_Login" />       
      </th>
     </tr>
     
     <tr>
      <th>비밀번호</th>
      <td>
       <input type="password" name="login_pwd" id="login_pwd" 
       size="14" class="box" />
      </td>
     </tr>
     
     <tr>
      <th colspan="3">
       <input type="button" value="회원가입" class="input_b"
       onclick="location='member_Join.do'" />
       <input type="button" value="비번찾기" class="input_b"
       onclick="location='pwd_Find.do'" />
      </th>
     </tr>
    </table>
   </form>
  </div>
  
</div><!-- end article_c -->  
  
</div><!-- end article -->

<div class="clear"></div>  
  
<%@ include file="../../include/footer.jsp" %>