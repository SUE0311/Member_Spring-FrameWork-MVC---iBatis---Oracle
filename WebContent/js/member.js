
/*member_login.jsp 부분 */
function Login_check(){
	if($.trim($("#login_id").val())==""){
		alert("로그인 아이디를 입력하세요!");
		$("#login_id").val("").focus();
		return false;
	}
	if($.trim($("#login_pwd").val())==""){
		alert("로그인 비번을 입력하세요!");
		$("#login_pwd").val("").focus();
		return false;
	}
}

/*member_join.jsp */
function join_check(){
	if($.trim($("#mem_id").val())==""){
		alert("아이디를 입력하세요!");
		$("#mem_id").val("").focus();
	    return false;	
	}	
	if($.trim($("#mem_pwd").val())==""){
		alert("비밀번호를 입력하세요!");
		$("#mem_pwd").val("").focus();
	    return false;	
	}
	if($.trim($("#mem_pwd2").val())==""){
		alert("비밀번호확인을 입력하세요!");
		$("#mem_pwd2").val("").focus();
	    return false;	
	}
	if($.trim($("#mem_pwd").val()) != $.trim($("#mem_pwd2").val())){
		alert("비밀번호가 일치하지 않습니다!");
		$("#mem_pwd").val("");
		$("#mem_pwd2").val("");
		$("#mem_pwd").focus();
		return false;
	}
	if($.trim($("#mem_name").val())==""){
		alert("회원이름을 입력하세요!");
		$("#mem_name").val("").focus();
	    return false;	
	}
	if($.trim($("#mem_zip").val())==""){
		alert("우편번호를 입력하세요!");		
	    return false;	
	}
	if($.trim($("#mem_zip2").val())==""){
		alert("우편번호를 입력하세요!");		
	    return false;	
	}
	if($.trim($("#mem_addr").val())==""){
		alert("주소를 입력하세요!");		
	    return false;	
	}
	if($.trim($("#mem_addr2").val())==""){
		alert("나머지 주소를 입력하세요!");
		$("#mem_addr2").val("").focus();
	    return false;	
	}
	if($.trim($("#mem_phone01").val())==""){
		alert("휴대폰번호를 선택하세요!");
		$("#mem_phone01").focus();
	    return false;	
	}
	if($.trim($("#mem_phone02").val())==""){
		alert("휴대폰 번호를 입력하세요!");
		$("#mem_phone02").val("").focus();
	    return false;	
	}
	if($.trim($("#mem_phone03").val())==""){
		alert("휴대폰 번호를 입력하세요!");
		$("#mem_phone03").val("").focus();
	    return false;	
	}
	if($.trim($("#mail_id").val())==""){
		alert("멜주소를 입력하세요!");
		$("#mem_id").val("").focus();
	    return false;	
	}
	if($.trim($("#mail_domain").val())==""){
		alert("멜주소를 입력하세요!");
		$("#mail_domain").val("").focus();
	    return false;	
	}
}

/* 아이디 중복 체크*/
function id_check(){
	$("#idcheck").hide();
	//아이디 영역을 숨김
	var memid=$("#mem_id").val();
	//1.입력글자 길이 체크
	if($.trim($("#mem_id").val()).length < 4){
		var newtext='<font color="red"><b>아이디는 4자 이상이어야 합니다.</b></font>';
		$("#idcheck").text('');
		//idcheck 아이디 영역 문자열을 초기화
		$("#idcheck").show();
		//idcheck 아이디 영역을 보이게 함.
		$("#idcheck").append(newtext);
		//idcheck영역에 문자열을 추가
		$("#mem_id").val('').focus();
		return false;
	};
	if($.trim($("#mem_id").val()).length > 12){
		var newtext='<font color="red"><b>아이디는12자 이하이어야 합니다.</b></font>';
		$("#idcheck").text('');
		//idcheck 아이디 영역 문자열을 초기화
		$("#idcheck").show();
		//idcheck 아이디 영역을 보이게 함.
		$("#idcheck").append(newtext);
		//idcheck영역에 문자열을 추가
		$("#mem_id").val('').focus();
		return false;
	};
	//2.입력글자 확인
	if(!(validate_userid(memid))){
		var newtext='<font color="red"><b>아이디는 영문소문자,숫자,_조합만 가능합니다.</b></font>';
		$("#idcheck").text('');
		  $("#idcheck").show();
		  $("#idcheck").append(newtext);
		  $("#mem_id").val('').focus();
		  return false;
	};
	//아이디 중복확인
    $.ajax({
        type:"POST",
       //url:"./member/member_idcheck.jsp",    
        url:"mem_idcheck.do",
        data: {"memid":memid},  
        datatype:"post",
        success: function (data) {
      	  if(data==1){//중복 아이디가 있다면
      		var newtext='<font color="red"><b>중복 아이디입니다.</b></font>';
      		$("#idcheck").text('');
        	$("#idcheck").show();
        	$("#idcheck").append(newtext);          		
          	$("#mem_id").val('').focus();
          	return false;
	     
      	  }else{//중복 아이디가 아니면
      		var newtext='<font color="blue"><b>사용가능한 아이디입니다.</b></font>';
      		$("#idcheck").text('');
      		$("#idcheck").show();
      		$("#idcheck").append(newtext);
      		$("#mem_pwd").focus();
      	  }  	    	  
        },
    	  error:function(){
    		  alert("data error");
    	  }
      });//$.ajax	
};
/*아이디 중복 체크 끝*/

function validate_userid(memid)
{
  var pattern= new RegExp(/^[a-z0-9_]+$/);
  return pattern.test(memid);
};


/* 우편검색 * */
function post_check(){
	var url="zip_find.do";
	open(url,"","width=450px,height=150px,scrollbars=yes");
	//폭이 400,높이가 150이고,수직/수평 스크롤 바가
	//생성되는 새로운 공지창을 만듬.
	//open(공지창경로,공지창이름,공지창속성) 메서드는 새로운 공지창을 만듬.
}

/* 전자우편 선택*/
function domain_list(){
	var num=m.mail_list.selectedIndex;
	/*selectedIndex속성은 select객체 하위
	의 속성으로 해당 리스트 목록번호를 반환*/
	if(num==-1){
		//num==-1은 리스트목록이 없다
		return true;
	}
	if(m.mail_list.value=="직접입력"){
		m.mail_domain.value="";
		m.mail_domain.readOnly=false;
		//쓰기 가능
		m.mail_domain.focus();
	}
	//메일도메인주소를 직접입력하는부분
	else {
		//리스트에서 해당도메인주소를 선택
		m.mail_domain.value=m.mail_list.options[num].value;
		/*num변수에는 해당리스트목록번호저
		장.해당번호의 value값이 도메인주소창
		에 선택.options속성은 select객체하위
		의 속성으로서 해당리스트번호의 
		value값을 가져온다.*/
		m.mail_domain.readOnly=true;
	}
 }

/* pwd_find.jsp */
function pwd_check(){
	if($.trim($("#pwd_id").val())==""){
		alert("회원아이디를 입력하세요!");
		$("#pwd_id").val("").focus();
		return false;
	}
	if($.trim($("#pwd_name").val())==""){
		alert("회원이름을 입력하세요!");
		$("#pwd_name").val("").focus();
		return false;
	}
}

/* member_edit.jsp */
function edit_check(){
	if($.trim($("#mem_pwd").val())==""){
		alert("비밀번호를 입력하세요!");
		$("#mem_pwd").val("").focus();
	    return false;	
	}
	if($.trim($("#mem_pwd2").val())==""){
		alert("비밀번호확인을 입력하세요!");
		$("#mem_pwd2").val("").focus();
	    return false;	
	}
	if($.trim($("#mem_pwd").val()) != $.trim($("#mem_pwd2").val())){
		alert("비밀번호가 일치하지 않습니다!");
		$("#mem_pwd").val("");
		$("#mem_pwd2").val("");
		$("#mem_pwd").focus();
		return false;
	}
	if($.trim($("#mem_name").val())==""){
		alert("회원이름을 입력하세요!");
		$("#mem_name").val("").focus();
	    return false;	
	}
	if($.trim($("#mem_zip").val())==""){
		alert("우편번호를 입력하세요!");		
	    return false;	
	}
	if($.trim($("#mem_zip2").val())==""){
		alert("우편번호를 입력하세요!");		
	    return false;	
	}
	if($.trim($("#mem_addr").val())==""){
		alert("주소를 입력하세요!");		
	    return false;	
	}
	if($.trim($("#mem_addr2").val())==""){
		alert("나머지 주소를 입력하세요!");
		$("#mem_addr2").val("").focus();
	    return false;	
	}
	if($.trim($("#mem_phone01").val())==""){
		alert("휴대폰번호를 선택하세요!");
		$("#mem_phone01").focus();
	    return false;	
	}
	if($.trim($("#mem_phone02").val())==""){
		alert("휴대폰 번호를 입력하세요!");
		$("#mem_phone02").val("").focus();
	    return false;	
	}
	if($.trim($("#mem_phone03").val())==""){
		alert("휴대폰 번호를 입력하세요!");
		$("#mem_phone03").val("").focus();
	    return false;	
	}
	if($.trim($("#mail_id").val())==""){
		alert("멜주소를 입력하세요!");
		$("#mem_id").val("").focus();
	    return false;	
	}
	if($.trim($("#mail_domain").val())==""){
		alert("멜주소를 입력하세요!");
		$("#mail_domain").val("").focus();
	    return false;	
	}
}

/* member_DEL.jsp */
function del_check(){
	if($.trim($("#del_pwd").val())==""){
		alert("비번을 입력하세요!");
		$("#del_pwd").val("").focus();
		return false;
	}
	if($.trim($("#del_cont").val())==""){
		alert("탈퇴사유를 입력하세요!");
		$("#del_cont").val("").focus();
		return false;
	}
}



