<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../include/header.jsp" %>

<link rel="stylesheet" type="text/css" href="./css/guest.css" />
<script>
 function del_check(){
	 if($.trim($("#del_pwd").val())==""){
		 alert("삭제 비번을 입력하세요!");
		 $("#del_pwd").val("").focus();
		 return false;
	 }
 }
</script>

<div class="clear"></div>
  
<!-- 본문 내용 -->
<div id="article">

<%@ include file="../../include/left_menu.jsp" %>

<div id="article_c">

 <div id="gDel_wrap">
  <h2 class="gDel_title">방명록 삭제</h2>
  <form method="post" action="guest_del_ok.do" 
  onsubmit="return del_check()">
  <input type="hidden" name="no" value="${no}" />
   <table id="gDel_t">
    <tr>
     <th>비밀번호</th>
     <td>
      <input type="password" name="del_pwd" id="del_pwd"
      size="14" class="box" />
     </td>
    </tr>
   </table>
   <div id="gDel_menu">
   <input type="submit" value="삭제" class="input_b" />
   <input type="reset" value="취소" class="input_b"
   onclick="$('#del_pwd').focus();" />
   </div>
  </form>
 </div>
  
</div><!-- end article_c -->  
  
</div><!-- end article -->

<div class="clear"></div>  
  
<%@ include file="../../include/footer.jsp" %>