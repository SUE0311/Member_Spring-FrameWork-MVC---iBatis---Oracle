<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../include/header.jsp" %>

<link rel="stylesheet" type="text/css" href="./css/guest.css" />

<div class="clear"></div>
  
<!-- 본문 내용 -->
<div id="article">

<%@ include file="../../include/left_menu.jsp" %>

<div id="article_c">

  <div id="gCont_wrap">
   <h2 class="gCont_title">방명록 내용보기</h2>
   <table id="gCont_t">
    <tr>
     <th>제목</th>
     <td>${g.guest_title}</td>
    </tr>
    
    <tr>
     <th>글내용</th>
     <td>${g.guest_cont}</td>
    </tr>
    
    <tr>
     <th>조회수</th> <td>${g.guest_hit}</td>
    </tr>
   </table>
   <div id="gCont_menu">
   <input type="button" value="수정" class="input_b"
   onclick="location='guest_edit.do?no=${g.guest_no}'" />
   <input type="button" value="삭제" class="input_b"
   onclick="location='guest_del.do?no=${g.guest_no}'" />
   <input type="button" value="목록" class="input_b"
   onclick="location='guest_list.do'" />
   </div>
  </div>
  
</div><!-- end article_c -->  
  
</div><!-- end article -->

<div class="clear"></div>  
  
<%@ include file="../../include/footer.jsp" %>