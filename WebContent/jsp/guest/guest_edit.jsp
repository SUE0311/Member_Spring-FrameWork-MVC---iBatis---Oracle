<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../include/header.jsp" %>

<script src="./js/guest.js"></script>
<link rel="stylesheet" type="text/css" href="./css/guest.css" />

<div class="clear"></div>
  
<!-- 본문 내용 -->
<div id="article">

<%@ include file="../../include/left_menu.jsp" %>

<div id="article_c">

 <div id="gEdit_wrap">
  <h2 class="gEdit_title">방명록 수정폼</h2>
  <form method="post" action="guest_edit_ok.do"
  onsubmit="return write_check();">
   <input type="hidden" name="no" value="${editg.guest_no}" />
   <table id="gEdit_t">
    <tr>
     <th>작성자</th>
     <td>
      <input name="guest_name" id="guest_name" size="14" 
      class="box" value="${editg.guest_name}" />
     </td>
    </tr>
    
    <tr>
     <th>제목</th>
     <td>
      <input name="guest_title" id="guest_title" size="30"
      class="box" value="${editg.guest_title}" />
     </td>
    </tr>
    
    <tr>
     <th>글내용</th>
     <td>
      <textarea name="guest_cont" id="guest_cont" rows="9"
      cols="43" class="box" >${editg.guest_cont}</textarea>
     </td>
    </tr>
    
    <tr>
     <th>비밀번호</th>
     <td>
      <input type="password" name="guest_pwd" id="guest_pwd"
      size="14" class="box" />
     </td>
    </tr>
   </table>
   <div id="gEdit_menu">
    <input type="submit" value="수정" class="input_b" />
    <input type="reset" value="취소" class="input_b"
    onclick="$('#guest_name').focus();" />
   </div>
  </form>
 </div>
  
</div><!-- end article_c -->  
  
</div><!-- end article -->

<div class="clear"></div>  
  
<%@ include file="../../include/footer.jsp" %>