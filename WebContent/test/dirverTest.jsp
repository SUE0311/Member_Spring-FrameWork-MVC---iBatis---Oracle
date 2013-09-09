<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<% 
   Connection con = null;
   
   try{
	   String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	   String uid="scott";
	   String pwd="tiger";
	   String driver = "oracle.jdbc.driver.OracleDriver";
	   
	   Class.forName(driver);  // db 연동 과정
	   con=DriverManager.getConnection(url,uid,pwd);
	   // getConnection(오라클url,사용자 id, 사용자 비밀번호);
	   out.println("DB연결에 성공하였습니다.");
   }catch(Exception e){
	   e.printStackTrace();
	   out.println("연결에 실패하였습니다.");
   }
%>



