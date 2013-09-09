<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../include/header.jsp" %>

<script src="./js/guest.js"></script>
<link rel="stylesheet" type="text/css" href="./css/guest.css" />

<div class="clear"></div>
  
<!-- 본문 내용 -->
<div id="article">

<%@ include file="../../include/left_menu.jsp" %>

<div id="article_c">

 <div id="gwrite_wrap">
  <h2 class="gwrite_title">방명록 글쓰기</h2>
  <form method="post" action="guest_write_ok.do"
  onsubmit="return write_check()">
   <table id="gwrite_t">
    <tr>
     <th>작성자</th>
     <td>
      <input name="guest_name" id="guest_name" size="14"
      class="box" value="${name }"/>
     </td>
    </tr>
    
    <tr>
     <th>제목</th>
     <td>
      <input name="guest_title" id="guest_title" size="36"
      class="box" />
     </td>
    </tr>
    
    <tr>
     <th>내용</th>
     <td>
     <textarea name="guest_cont" id="guest_cont" rows="9" cols="42"
     class="box" ></textarea>
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
   <div id="gwrite_menu">
   <input type="submit" value="저장" class="input_b" />
   <input type="reset" value="취소" class="input_b" 
   onclick="$('#guest_name').focus();" />
   </div>
  </form>
 </div>
  
</div><!-- end article_c -->  
  
</div><!-- end article -->

<div class="clear"></div>  
  
<%@ include file="../../include/footer.jsp" %>