<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSTL 태그라이브러리 -->
<%
//String zipcode,addr,addr2;
//String dong = (String)request.getAttribute("dong"); 
//List zipcodeList = (ArrayList)request.getAttribute("zipcodelist");
%>
<html>
<head>
<title>우편번호 검색</title>
<SCRIPT LANGUAGE="JavaScript">
<!--
function selectnow() {

	/* select 객체에서 검색된 동을 선택했을때 change 이벤트가 발생한다.
 	여기서 여러분들이 이해할것이 있다. 바로 form 객체가 두개 써였다는 것이다. 그 이유는 동을입력하지 않았을때 실행과 동을 입력하고 검색된 동을 선택할수 있도록 하기 위해서
	postform과 postform2 두개의 폼객체 네임 이름을 사용하였다. 유의 하기 바란다. zip 변수에 선택된 주소가 저장된다. 

	zip1 변수에는 우편번호 앞 세자리를 저장하고 zip2 변수에는 우편번호 뒷자리 세자리를 저장한다. 그리고
	addr1변수에는 나머지 주소를 저장시켜준다.

	여기서 length-1 을 해준 이유는 substring 메서드는 문자열 첫 시작이 0부터 시작하고 length 속성은 첫 시작이 1부터 시작하기 때문이다. 그리고 둘다 String 객체 하위의 구성요소라는 것을 꼭 알아주기 바란다.
	*/

	var zip=document.postform.post_list.value;
	var zip1=zip.substring(0,3);//0이상 3미만사이의 첫번째 우편번호
	var zip2=zip.substring(4,7);//4이상 7미만사이의 두번째 우편번호
	var addr2=zip.substring(7, (zip.length)); //7이상의 끝문자까지 나머지 주소값을 저장

	opener.document.m.mem_zip.value=zip1;
    //opener객체는 우편번호 공지창에서 본 회원가입창을 가리킨다. 
	/* 회원가입창에 첫번째 세자리 우편번호를 입력한다. */

	opener.document.m.mem_zip2.value=zip2;

	/* 회원가입창에 두번째 세자리 우편번호를 입력한다. */

	opener.document.m.mem_addr.value=addr2;

	/* 회원가입창에  주소를  입력한다. */

	
	parent.window.close();

	/* 그리고 윈도우 창을 닫아준다.  */

}

function check(form){
	if(form.dong.value==""){
		alert("동을 입력해 주세요!");
		form.dong.focus();
	return false;
	}
}

//-->
</SCRIPT>
<style type="text/css">
<!--
INPUT,SELECT{font-family: Dotum;font-size:9pt;;}
.style1 {
	color: #466D1B;
	font-weight: bold;
	font-size: 12px;
}
-->
</style>
</head>
<body onload="postform.dong.focus();" bgcolor="#FFFFFF" topmargin="0" leftmargin="0">
<form method="post" action="zip_find_ok.do" name="postform" onsubmit="return check(this)">
<table width="414" height="100" border="0" align="center" cellpadding="0" cellspacing="0">
 <tr> 
  <td bgcolor="#999999" align="center"><input type="image" src="images/ZipCode_img01.gif" width="413" height="58"></td>
 </tr>
 <tr> 
  <td bgcolor="f5ffea" align="center"> 
   <strong><font color="#466d1b"><span class="style1">[거주지의 면.동을 입력하고 '찾기'버튼을 누르세요!!!]</span></font></strong>
  </td>
 </tr>
 <tr height="30"> 
  <td bgcolor="f5ffea" align="center"><input type="text" name="dong"  size="10" maxlength="10">&nbsp;<input type="image"  src="images/m-i02.gif" width="69" height="19" align="absmiddle" onfocus="this.blur()"></td>
 </tr>
 <%//if(dong != null){ %>
 <c:if test="${!empty dong}"> 
 <!-- 동을 입력했다면 실행되는 JSTL if 문  -->
 <%//if(zipcodeList != null && zipcodeList.size() != 0){%>
 <c:if test="${!empty zipcodelist}"> 
 <!-- 검색결과 주소값이 있을 경우만 실행되는 JSTL if 문 -->
 <tr> 
  <td bgcolor="f5ffea" height="30" align="center">
   <SELECT NAME="post_list" onchange="selectnow()">
    <option value="">----주소를 선택하세요----</option>
	<%//for(int i = 0; i < zipcodeList.size(); i++) {	
		//String data=(String)zipcodeList.get(i);
		//StringTokenizer st = new StringTokenizer(data,",");
		//,쉼표를 기준으로 문자열을 파싱해준다.
		//zipcode = st.nextToken();//우편번호
		//addr = st.nextToken();//번지를 뺀 주소
		//addr2 = st.nextToken(); //번지를 포함한 주소
		//String totaladdr = zipcode + addr;
	%>		
	<%//}%>
   <c:forEach var="addr2" items="${zipcodelist}">       
   <!-- items 속성에는 검색결과 주소값을 담고 있는 키값을 기입 , addr2 변수에서 주소값을 받아서 저장-->
             <c:set var="totaladdr" value="${addr2.zipcode}${addr2.addr}" />   
             <!-- addr2.zipcode에는 ZipcodeBean 클래스의 getZipcode()메서드를 가져와 
             우편번호,addr.addr 에는 ZipcodeBean 클래스의 getAddr()메서드를 가져와 시도 구군 동,
             결국 새로운 변수 totaladdr에는 우편번호 시도 구군 동이 저장-->  
    <option value="${totaladdr}">[${addr2.zipcode}]&nbsp;${addr2.addr}</option>    

     </c:forEach>
     <!-- JSTL c:forEach 반복문 -->	
   </SELECT>    
     
  </td>
 </tr>
 <%//}else{ %>
 </c:if>
 <c:if test="${empty zipcodelist}"> 
 <!-- JSTL 에서 검색 주소값이 없을 경우 실행되는 if 문. -->
 <tr>
  <td bgcolor="f5ffea" height="30" align="center"><font color="#466d1b"><span class="style1">검색 결과가 없습니다.</span></font></td>
 </tr>
 <%//}}%>
 </c:if>
 </c:if>
 <tr> 
  <td bgcolor="508C0F" colspan="3" height="3"></td>
 </tr>
</table>
</form>
</body>
</html>