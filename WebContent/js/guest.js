
 function write_check(){
	 if($.trim($("#guest_name").val())==""){
		 alert("작성자를 입력하세요!");
		 $("#guest_name").val("").focus();
		 return false;
	 }
	 if($.trim($("#guest_title").val())==""){
		 alert("제목을 입력하세요!");
		 $("#guest_title").val("").focus();
		 return false;
	 }
	 if($.trim($("#guest_cont").val())==""){
		 alert("내용을 입력하세요!");
		 $("#guest_cont").val("").focus();
		 return false;
	 }
	 if($.trim($("#guest_pwd").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#guest_pwd").val("").focus();
		 return false;
	 }
 }