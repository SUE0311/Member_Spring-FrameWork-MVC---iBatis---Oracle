<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../include/header.jsp" %>

<script src="./js/member.js"></script>
<link rel="stylesheet" type="text/css" href="./css/member.css" />

<div class="clear"></div>
  
<!-- 본문 내용 -->
<div id="article">

<%@ include file="../../include/left_menu.jsp" %>

<div id="article_c">

  <div id="del_wrap">
   <h2 class="del_title">회&nbsp;원&nbsp;탈&nbsp;퇴</h2>
   <form method="post" action="member_DEL_ok.do"
   onsubmit="return del_check();">
    <table id="del_t">
     <tr>
      <th>회원아이디</th>
      <td>${id}</td>
     </tr>
     
     <tr>
      <th>회원이름</th>
      <td>
       ${name}
      </td>
     </tr>
     
     <tr>
      <th>회원비번</th>
      <td>
       <input type="password" name="del_pwd" id="del_pwd" size="14"
       class="box" />
      </td>
     </tr>
     
     <tr>
      <th>탈퇴사유</th>
      <td>
       <textarea name="del_cont" rows="8" cols="36" id="del_cont"
       class="box"></textarea>
      </td>
     </tr>
    </table>
    <div id="del_menu">
     <input type="submit" value="탈퇴" class="input_b" />
     <input type="reset" value="취소" class="input_b"
     onclick="$('#del_pwd').focus();" />
    </div>
   </form>
  </div>

  </div><!-- end article_c -->  
  
</div><!-- end article -->

<div class="clear"></div>  
  
<%@ include file="../../include/footer.jsp" %>