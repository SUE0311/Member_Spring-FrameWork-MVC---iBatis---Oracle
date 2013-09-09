<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../../include/header.jsp" %>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
     uri="http://java.sun.com/jsp/jstl/core" %>  
     <!-- jstl 태그 라이브러리 -->   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 폼</title>
<script src="./js/jquery.js"></script>
</head>
<body> --%>


<script src="./js/member.js"></script>
<link rel="stylesheet" type="text/css" href="./css/member.css" />

<div class="clear"></div>
  
<!-- 본문 내용 -->
<div id="article">

<%@ include file="../../include/left_menu.jsp" %>

<div id="article_c">

  <div id="join_wrap">
   <h2 class="join_title">회&nbsp;원&nbsp;가&nbsp;입</h2>
   <form name="m" method="post" action="member_Join_Ok.do"
   onsubmit="return join_check()">
    <table id="join_t">
     <tr>
      <th>아이디</th>
      <td>
       <input name="mem_id" id="mem_id" size="14" class="box" />
       <input type="button" value="아이디중복체크" class="input_b"
       onclick="id_check();" />
       <br/>
       <span id="idcheck"></span>
      </td>
     </tr>
     
     <tr>
      <th>비밀번호</th>
      <td>
       <input type="password" name="mem_pwd" id="mem_pwd" size="14"
       class="box" />
      </td>
     </tr>
     
     <tr>
      <th>비밀번호확인</th>
      <td>
       <input type="password" name="mem_pwd2" id="mem_pwd2" size="14"
       class="box" />
      </td>
     </tr>
     
     <tr>
      <th>회원이름</th>
      <td>
       <input name="mem_name" id="mem_name" size="14" class="box" />
      </td>
     </tr>
     
     <tr>
      <th>우편번호</th>
      <td>
       <input name="mem_zip" id="mem_zip" size="3" maxlength="3"
       readonly  class="box" />-<input name="mem_zip2" id="mem_zip2" 
       size="3" maxlength="3" readonly class="box" />
       <input type="button" value="우편번호검색" class="input_b"
       onclick="post_check()" />
      </td>
     </tr>
     
     <tr>
      <th>주소</th>
      <td>
       <input name="mem_addr" id="mem_addr" size="40" readonly 
       class="box" />
      </td>
     </tr>
     
     <tr>
      <th>나머지 주소</th>
      <td>
      <input name="mem_addr2" id="mem_addr2" size="30" 
      class="box" />
      </td>
     </tr>
     
     <tr>
      <th>휴대폰 번호</th>
      <td>
      <%@ include file="../../include/phone_number.jsp" %>
       <select name="mem_phone01" id="mem_phone01">
        <option value="">=선택=</option>
        <c:forEach var="p" items="${phone}">
         <option value="${p}">${p}</option>
        </c:forEach>
       </select>-<input name="mem_phone02" id="mem_phone02"
       size="4" maxlength="4" class="box" />-<input name="mem_phone03"
       id="mem_phone03" size="4" maxlength="4" class="box" />
      </td>
     </tr>
     
     <tr>
      <th>전자우편</th>
      <td>
      <%@ include file="../../include/mail_domain.jsp" %>
      <input name="mail_id" id="mail_id" size="10" 
      class="box" />@<input name="mail_domain" id="mail_domain" 
      size="14" readonly class="box" />
      <select name="mail_list" onchange="domain_list()">
       <option value="">=선택=</option>
       <c:forEach var="m" items="${mail}">
        <option value="${m}">${m}</option>
       </c:forEach>
      </select>
      </td>
     </tr>
    </table>
    <div id="join_menu">
     <input type="submit" value="회원가입" class="input_b" />
     <input type="reset" value="가입취소" class="input_b"
     onclick="$('#mem_id').focus();" />
    </div>
   </form>
  </div>
  
</div><!-- end article_c -->  
  
</div><!-- end article -->

<div class="clear"></div>  
  
<%@ include file="../../include/footer.jsp" %>