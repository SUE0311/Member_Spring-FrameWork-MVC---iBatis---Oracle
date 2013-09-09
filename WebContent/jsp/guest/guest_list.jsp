<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../include/header.jsp" %>

<link rel="stylesheet" type="text/css" href="./css/guest.css" />

<div class="clear"></div>
  
<!-- 본문 내용 -->
<div id="article">

<%@ include file="../../include/left_menu.jsp" %>

<div id="article_c">

 <div id="gList_wrap">
  <h2 class="gList_title">방명록 목록</h2>
  <div id="gList_count">총 게시물 수: ${total_count} 개</div>
  <table id="gList_t">
   <tr>
    <th>번호</th> <th>글제목</th> <th>작성자</th> <th>등록날짜</th>
    <th>조회수</th>
   </tr>
   <c:forEach var="gList" items="${guestList}">
     <tr align="center" valign="middle" bordercolor="#333333"
		onmouseover="this.style.backgroundColor='#FFFFCC'"
		onmouseout="this.style.backgroundColor=''">
      <th>${gList.guest_no}</th>
      <td style="padding-left:10px;">
       <a href="guest_cont.do?no=${gList.guest_no}" 
       onfocus="this.blur();">${gList.guest_title}</a>
       <!-- *.do?no=번호값은 웹주소창에 값을 노출하면서 get방식으로
       no피라미터에 글번호를 담아서 넘김. -->
      </td>
      <th>${gList.guest_name}</th>
      <th>${gList.guest_regdate}</th>
      <th>${gList.guest_hit}</th>
     </tr>
   </c:forEach>
  </table>
  <div id="gList_menu">
  <input type="button" value="글쓰기" class="input_b"
  onclick="location='guest_write.do'" />
  </div>
 </div>
  
</div><!-- end article_c -->  
  
</div><!-- end article -->

<div class="clear"></div>  
  
<%@ include file="../../include/footer.jsp" %>