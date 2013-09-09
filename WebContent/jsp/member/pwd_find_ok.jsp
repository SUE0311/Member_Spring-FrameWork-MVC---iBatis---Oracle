<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../include/header.jsp" %>

<script src="./js/member.js"></script>
<link rel="stylesheet" type="text/css" href="./css/member.css" />

<div class="clear"></div>
  
<!-- 본문 내용 -->
<div id="article">

<%@ include file="../../include/left_menu.jsp" %>

<div id="article_c">

  <div id="pwdok_wrap">
   <h2 class="pwdok_title">비번찾기결과</h2>
   <table id="pwdok_t">
    <tr>
     <th>비밀번호:</th>
     <td>&nbsp;${passwd}</td>
    </tr>
   </table>
   <div id="pwdok_menu">
   <input type="button" value="돌아가기" class="input_b"
   onclick="location='pwd_Find.do'" />
   </div>  
  </div>  
  
</div><!-- end article_c -->  
  
</div><!-- end article -->

<div class="clear"></div>  
  
<%@ include file="../../include/footer.jsp" %>