package controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Guest33Bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.Guest2DAO;
import dao.GuestDAO;

@Controller
public class GuestController {//방명록 컨트롤
	
	private GuestDAO guestService;	
	//인터페이스로 레퍼런스 변수 선언이 가능하다.
	
	private Guest2DAO guestService2;
	
    public void setGuestService(GuestDAO guestService) {
		this.guestService = guestService;
	}//spring DI 설정    

    public void setGuestService2(Guest2DAO guestService2) {
		this.guestService2 = guestService2;
	}//spring DI 설정    

	 /*방명록 목록*/
	 @RequestMapping(value="/guest_list.do")
	 public ModelAndView guest_list(HttpServletRequest request,
		 HttpServletResponse response) throws Exception{
	 
		 int count=this.guestService.listCount();
		 //총 레코드 개수
		 List<Guest33Bean> guestList=this.guestService.getGuestList();
		 //방명록 목록을 가져온다.
		 
		 Map listModel=new HashMap();
		 listModel.put("guestList",guestList);
		 //guestList키에 방명록 목록을 저장
		 
		 ModelAndView listM=new ModelAndView();
		 listM.setViewName("guest/guest_list");
		 //guest폴더에 guest_list.jsp파일이 실행
		 listM.addAllObjects(listModel);
		 //방명록 목록값을 저장한 해쉬맵 컬렉션 객체를 모델 앤드 뷰에 저장시킨다.
		 listM.addObject("total_count", count);
		 //total_count키값에 총 레코드 개수를 저장
		 return listM;
	 }

	/*방명록 글쓰기 폼*/
	@RequestMapping(value="/guest_write.do")
	public String guest_write(){
		return "guest/guest_write";
		//guest폴더의 guest_write.jsp 뷰페이지가 실행
	}	
		
	/* 방명록 저장*/
	@RequestMapping(value="/guest_write_ok.do",method=RequestMethod.POST)
	 public ModelAndView guest_write_ok(HttpServletRequest request,
			 HttpServletResponse response)
	throws Exception{
		String guest_name=request.getParameter("guest_name").trim();
		String guest_title=request.getParameter("guest_title").trim();
		String guest_cont=request.getParameter("guest_cont").trim();
		String guest_pwd=request.getParameter("guest_pwd").trim();
		
		Guest33Bean g=new Guest33Bean();
		g.setGuest_name(guest_name); g.setGuest_title(guest_title);
		g.setGuest_cont(guest_cont); g.setGuest_pwd(guest_pwd);
		
		this.guestService.insertGuest(g);//저장메서드 호출
		
		response.sendRedirect("guest_list.do");
		return null;
	  }
	 
	 /*방명록 내용보기*/
	 @RequestMapping(value="/guest_cont.do")
	 public ModelAndView guest_cont(HttpServletRequest request,
			 HttpServletResponse response) 
	 throws Exception{
		int no=Integer.parseInt(request.getParameter("no"));
		//get방식으로 넘어온 글번호를 parseInt()에 의해서 정수형 숫자로 바꿔서 저장
		
		Guest2DAO g2dao=new Guest2DAO();//오라클  디비 연동 클래스
		
		this.guestService2.hitUpdate(no);//번호를 기준으로 조회수 증가
		Guest33Bean g=g2dao.getCont(no);
	    //번호에 해당하는 방명록 내용을 디비로 부터 가져온다.			
		
		ModelAndView contM=new ModelAndView("guest/guest_cont");
		contM.addObject("g",g);
		//g키값에 저장
		return contM; 
	 } 
	 
	 /*방명록 수정폼*/
	 @RequestMapping(value="/guest_edit.do")
	 public ModelAndView guest_edit(HttpServletRequest request,
			 HttpServletResponse response)
	 throws Exception{
		 int no=Integer.parseInt(request.getParameter("no"));
		 
		 Guest33Bean g=this.guestService.getGuestCont(no);
		 //번호를 기준으로 디비로 부터 내용을 가져옴.
		 
		 ModelAndView editM=new ModelAndView("guest/guest_edit");
		 editM.addObject("editg",g);
		 //editg키값에 저장
		 return editM;
	 }
	 
	 /*방명록 수정*/
	 @RequestMapping(value="/guest_edit_ok.do",method=RequestMethod.POST)
	 public ModelAndView guest_edit_ok(HttpServletRequest request,
			 HttpServletResponse response) throws Exception{
	     response.setContentType("text/html;charset=UTF-8");
	     PrintWriter out=response.getWriter();
	     //출력스트림 객체 생성
		 int no=Integer.parseInt(request.getParameter("no"));
	     String guest_name=request.getParameter("guest_name").trim();
	     String guest_title=request.getParameter("guest_title").trim();
	     String guest_cont=request.getParameter("guest_cont").trim();
	     String guest_pwd=request.getParameter("guest_pwd").trim();
	     
	     Guest33Bean db_pwd=this.guestService.getGuestCont(no);
	     if(db_pwd.getGuest_pwd().equals(guest_pwd)){//비번이 같다면
	    	 Guest33Bean eg=new Guest33Bean();
	    	 eg.setGuest_no(no); eg.setGuest_name(guest_name);
	    	 eg.setGuest_title(guest_title);
	    	 eg.setGuest_cont(guest_cont);
	    	 eg.setGuest_pwd(guest_pwd);
	    	 
	    	 this.guestService.guestEdit(eg);//수정 메서드 호출
	    	 
	    	 response.sendRedirect("guest_cont.do?no="+no);
	    	 }else{
	    	 out.println("<script>");
	    	 out.println("alert('비밀번호가 다릅니다!')");
	    	 out.println("history.go(-1)");
	    	 out.println("</script>");
	     }
		 return null;
	 }
	 
	 /*방명록 삭제폼*/
	 @RequestMapping(value="/guest_del.do")
	 public ModelAndView guest_del(HttpServletRequest request,
			 HttpServletResponse response) 
	        throws Exception{
		 
		 int no=Integer.parseInt(request.getParameter("no"));
		 //get방식으로 넘어온 글번호를 정수형 숫자로 바꿔서 저장
		 
		 ModelAndView delM=new ModelAndView("guest/guest_del");
		 //guest폴더의 guest_del.jsp가 실행
		 delM.addObject("no",no);
		 //no키값에 번호값을 저장
		 return delM;
	 }
	 
	 /*방명록 삭제*/
	 @RequestMapping(value="/guest_del_ok.do",method=RequestMethod.POST)
	 public ModelAndView guest_del_ok(HttpServletRequest request,
			 HttpServletResponse response) 
	 throws Exception{
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out=response.getWriter();
		 
		 int no=Integer.parseInt(request.getParameter("no"));
		 String del_pwd=request.getParameter("del_pwd").trim();
		 Guest33Bean db_pwd=this.guestService2.getCont(no);
		 
		 if(db_pwd.getGuest_pwd().equals(del_pwd)){
			 this.guestService.deleteGuest(no);
			 //번호를 기준으로 레코드를 삭제
			 response.sendRedirect("guest_list.do");
		 }else{//비번이 다르다면
			 out.println("<script>");
			 out.println("alert('비번이 다릅니다!')");
			 out.println("history.go(-1)");
			 out.println("</script>");
		 }
		 return null;
	 }
}
