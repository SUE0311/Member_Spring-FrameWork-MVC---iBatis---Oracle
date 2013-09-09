package controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member33Bean;
import model.ZipcodeBean;
import model.ZipcodeBean2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAOImpl;


@Controller
public class MemberController {//ȸ������ ��Ʈ�� Ŭ����

	private MemberDAOImpl memService;	

	//setter DI �������� �����ϴ� �κ�
    public void setMemService(MemberDAOImpl memService) {
		this.memService = memService;
	}

	/* �α��� �Է��� */
	@RequestMapping(value="/member_Login.do",method=RequestMethod.GET)
		public String mem_Login(){
			return "member/member_login";
			//webContent/jsp/member/member_login.jsp������ ����
		}
	
	/*ȸ��������*/
	@RequestMapping(value="/member_Join.do")
	    public String mem_Join(){//mem_Join()�޼���� ����� ���� �޼���
		   return "member/member_join";
	    }
	
	/*���̵� �ߺ� üũ*/
	@RequestMapping(value="/mem_idcheck.do",method=RequestMethod.POST)
	    public ModelAndView mem_idcheck(HttpServletRequest request,
	    		HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		//���� ���̴� �ѱ��� �ȱ����� �ϱ� ���ؼ�
		PrintWriter out=response.getWriter();
		//��½�Ʈ�� ��ü ����
		
		String id=request.getParameter("memid");//�Է¾��̵� ���� �޾ƿ´�.
		 
	    Member33Bean db_id=this.memService.idCheck(id);//�ߺ����̵� üũ
	
	      int re=0;
	      if(db_id!=null){//�ߺ� ���̵��� �ִٸ�
		    re=1;
	      }//1�̸� �ߺ� -1�̸� ��밡�� ���̵�
	
		 out.println(re);
		return null;
	   }
	
	  /*�����ȣ �˻� �Է�â*/
	  @RequestMapping(value="/zip_find.do")
	  public String zip_find(){
		  return "member/member_post";
		  //member������ member_post.jsp���������� ����
	  }
	  
	  /*�����ȣ �˻� ���*/
	  @RequestMapping(value="/zip_find_ok.do",method=RequestMethod.POST)
	  public ModelAndView zip_find_ok(HttpServletRequest request,
			  HttpServletResponse response) throws Exception{
		    String dong=request.getParameter("dong");
			List<ZipcodeBean2> zipcodeList=new ArrayList<ZipcodeBean2>();
	
			zipcodeList=this.memService.findZipcode("%"+dong+"%");
			//���� �������� �ּҸ� �˻��ؼ� �÷��ǿ� ����
			//%�� �ϳ� �Ǵ� �ϳ��̻��� ������ ���ڿ� ����
	
			List<ZipcodeBean> zipcodeList2=new ArrayList<ZipcodeBean>();
	
			for(int i=0; i<zipcodeList.size();i++){
				ZipcodeBean2 zipcode_addr=zipcodeList.get(i);
	
				String zipcode=zipcode_addr.getZipcode();//�����ȣ ����
				String sido=zipcode_addr.getSido(); //�����,��⵵ ����
				String gugun=zipcode_addr.getGugun();//��,��
				String dong2=zipcode_addr.getDong(); //��
				String addr=sido+" "+gugun+" "+dong2;//����� ���ʱ� ���ʵ�
				//String addr2=sido+" "+gugun+" "+dong2+" "+bunji;//�������� ����
				//zipcodeList.add(zipcode+","+addr+","+addr2);
	
				ZipcodeBean zip=new ZipcodeBean();
				zip.setZipcode(zipcode);
				zip.setAddr(addr);
	
				zipcodeList2.add(zip);
				//�÷��ǿ� �ּҸ� ��Ұ����� ����
			}
	
			ModelAndView zipcodeM=new ModelAndView("member/member_post");
			//������ ���������� member/member_post�� ���� member������ ��������
			//member_post.jsp������ ����
			zipcodeM.addObject("zipcodelist",zipcodeList2);
			//���� zipcodelistŰ���� ������ �÷��� �����ȣ�� �ּҰ��� ����
			zipcodeM.addObject("dong",dong);		
	        //dongŰ�� �Է� ���鵿�� ����.
			return zipcodeM;	
	  }
	  /* ȸ�� ����*/
	  @RequestMapping(value="/member_Join_Ok.do",method=RequestMethod.POST)
	  public ModelAndView mem_join_ok(HttpServletRequest request,
			  HttpServletResponse response) throws Exception{
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out=response.getWriter();
		  
		  String mem_id=request.getParameter("mem_id").trim();
		  Member33Bean db_id=this.memService.idSearch(mem_id);
		  //�ߺ� ���̵� �˻�
		  
		  if(db_id != null){//�ߺ� ���̵� �ִ� ���
			  out.println("<script>");
			  out.println("alert('���� ���̵� �Դϴ�!')");
			  out.println("history.go(-1)");
			  out.println("</script>");
		  }else{//�ߺ� ���̵� ���� ��� ȸ������
		  String mem_pwd=request.getParameter("mem_pwd").trim();
		  String mem_name=request.getParameter("mem_name").trim();
		  String mem_zip=request.getParameter("mem_zip").trim();
		  String mem_zip2=request.getParameter("mem_zip2").trim();
		  String mem_addr=request.getParameter("mem_addr").trim();
		  String mem_addr2=request.getParameter("mem_addr2").trim();
		  String phone01=request.getParameter("mem_phone01").trim();
		  String phone02=request.getParameter("mem_phone02").trim();
		  String phone03=request.getParameter("mem_phone03").trim();
		  String mem_phone=phone01+"-"+phone02+"-"+phone03;
		  String mail_id=request.getParameter("mail_id").trim();
		  String mail_domain=request.getParameter("mail_domain").trim();
		  String mem_email=mail_id+"@"+mail_domain;
		  
		  Member33Bean m=new Member33Bean();
		  m.setMem_id(mem_id); m.setMem_pwd(mem_pwd);
		  m.setMem_name(mem_name); m.setMem_zip(mem_zip);
		  m.setMem_zip2(mem_zip2); m.setMem_addr(mem_addr);
		  m.setMem_addr2(mem_addr2); m.setMem_phone(mem_phone);
		  m.setMem_email(mem_email);
		  
		  this.memService.insertMember(m);//����޼��� ȣ��
		  
		  response.sendRedirect("member_Login.do");
		  }
		  return null;
	  }
	  
	  /* ##### 3��° �߰� ######## */
	  
	  /* ���ã�� �Է��� */
	  @RequestMapping(value="/pwd_Find.do")
	  public ModelAndView pwd_find(){
		  ModelAndView pwdM=new ModelAndView();
		  pwdM.setViewName("member/pwd_find");
		  //member������ pwd_find.jsp�� ����
		  return pwdM;
	  }
	  
	  /*���ã�� ���*/
	  @RequestMapping(value="/pwd_Find_ok.do",method=RequestMethod.POST)
	  public ModelAndView pwd_find_ok(HttpServletRequest request,
			  HttpServletResponse response) throws Exception{
		  response.setContentType("text/html;charset=UTF-8");
		  //���� ���̴� �ѱ��� �ȱ����� �ϱ� ���� �ѱ� ����ڵ� Ÿ�� ����
		  PrintWriter out=response.getWriter();//��½�Ʈ�� ��ü ����
		  
		  String pwd_id=request.getParameter("pwd_id").trim();
		  //ȸ�����̵� ����
		  String pwd_name=request.getParameter("pwd_name").trim();
		  //ȸ���̸� ����
		  
		  Member33Bean pm=new Member33Bean();
		  pm.setMem_id(pwd_id); pm.setMem_name(pwd_name);
		  
		  Member33Bean member=this.memService.findPwd(pm);
		  //���̵�� �̸��� �������� ����� �˻�
		  
		  if(member != null){//�˻� ����� �ִٸ�
			  ModelAndView pwdOkM=new ModelAndView("member/pwd_find_ok");
			  pwdOkM.addObject("passwd",member.getMem_pwd());
			  //passwdŰ���� ��񿡼� ������ ����� ����
			  return pwdOkM;
		  }else{//�˻� ����� ���ٸ�
			  out.println("<script>");
			  out.println("alert('�˻� ����� �����ϴ�!')");
			  out.println("history.go(-1)");
			  out.println("</script>");
		  }
		  return null;
	  }  
	  
	  /* �α��� ���� üũ */
	  @RequestMapping(value="/member_Login_ok.do",method=RequestMethod.POST)
	  public ModelAndView login_ok(HttpServletRequest request,
			  HttpServletResponse response,HttpSession session) 
	  throws Exception{
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out=response.getWriter();
		  session=request.getSession();//���� ��ü�� ����
		  
		  String id=request.getParameter("login_id").trim();
		  String pass=request.getParameter("login_pwd").trim();
		  
		  Member33Bean db_pwd=this.memService.idSearch(id);
		  //���� ����� �˻�
		  if(db_pwd != null){//�˻� ����� �ִ� ���
			if(db_pwd.getMem_pwd().equals(pass)){//����� ���� ���
				session.setAttribute("id",id);
				session.setAttribute("name",db_pwd.getMem_name());
				//nameŰ���� ȸ���̸��� ����
				//ModelAndView loginM=new ModelAndView("index");
				//index.jsp�� �̵�
				//return loginM;
				response.sendRedirect("index.do");
			}else{//����� �ٸ� ���
				out.println("<script>");
				out.println("alert('����� �ٸ��ϴ�!')");
				out.println("history.go(-1)");
				out.println("</script>");
			}
		  }else{//�˻� ��� �� ȸ���� ���� ���
			  out.println("<script>");
			  out.println("alert('�������� ���� ȸ���Դϴ�!')");
			  out.println("history.back()");
			  out.println("</script>");
		  }	  
		  return null;
	  }
	  
	  /*���� ȭ��*/
	  @RequestMapping(value="/index.do")
	  public ModelAndView index(HttpServletRequest request,
			  HttpServletResponse response,HttpSession session)
	  throws Exception{
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out=response.getWriter();
		  session=request.getSession();
		  
		  String id=(String)session.getAttribute("id");
		  
		  if(id==null){
			  out.println("<script>");
			  out.println("alert('�ٽ� �α��� �ϼ���!')");
			  out.println("location='member_Login.do'");
			  out.println("</script>");
		  }else{
			  ModelAndView indexM=new ModelAndView("index");
			  return indexM;
		  }
		  return null;
	  }
	  
	  /* �α� �ƿ� */
	  @RequestMapping(value="/member_Logout.do",method=RequestMethod.POST)
	  public ModelAndView mem_Logout(HttpServletRequest request,
			  HttpServletResponse response,HttpSession session)
	  throws Exception{
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out=response.getWriter();
		  session=request.getSession();//���� ��ü�� ����
		  
		  session.invalidate();//������ ����
		  
		  out.println("<script>");
		  out.println("alert('�α׾ƿ� �Ǿ����ϴ�!')");
		  out.println("location='member_Login.do'");
		  out.println("</script>");
		  
		  return null;
	  }
	  
	  /*���� ���� �� */
	  @RequestMapping(value="/member_Edit.do")
	  public ModelAndView mem_edit(HttpServletRequest request,
			  HttpServletResponse response,HttpSession session)
	  throws Exception{
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out=response.getWriter();
		  session=request.getSession();
		  
		  String id=(String)session.getAttribute("id");
		  //���� ���̵��� ������
		  
		  if(id==null){
			  out.println("<script>");
			  out.println("alert('�ٽ� �α��� ���ּ���!')");
			  out.println("location='member_Login.do'");
			  out.println("</script>");
		  }else{
			  Member33Bean m=this.memService.idSearch(id);
			  //���̵� �ش��ϴ� ȸ�������� ������
			  
			  StringTokenizer p=
					  new StringTokenizer(m.getMem_phone(), "-");
			  //-�� �������� ����ȣ�� �и�
			  String phone01=p.nextToken();//ù��° ����ȣ ����
			  String phone02=p.nextToken();//�ι�° ����ȣ ����
			  String phone03=p.nextToken(); //����° ����ȣ ����
			  
			  StringTokenizer em=
					  new StringTokenizer(m.getMem_email(),"@");
			  //@�� �������� ���ڿ��� �ּҸ� �и�
			  String mail_id=em.nextToken();
			  String mail_domain=em.nextToken();
			  
			  ModelAndView editM=new ModelAndView("member/member_edit");
			  editM.addObject("edit",m);
			  //editŰ�� m��ü�� ����
			  editM.addObject("phone01",phone01);
			  editM.addObject("phone02",phone02);
			  editM.addObject("phone03",phone03);
			  editM.addObject("mail_id",mail_id);
			  editM.addObject("mail_domain",mail_domain);
			  return editM;
		  }
		  return null;
	  }
	  
	  /*��������*/
	  @RequestMapping(value="/member_Edit_ok.do",method=RequestMethod.POST)
	  public ModelAndView mem_edit_ok(HttpServletRequest request,
			  HttpServletResponse response,HttpSession session)
	  throws Exception{
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out=response.getWriter();
		  session=request.getSession();
		  
		  String id=(String)session.getAttribute("id");
		  if(id == null){
			  out.println("<script>");
			  out.println("alert('�ٽ� �α��� �ϼ���!')");
			  out.println("location='member_Login.do'");
			  out.println("</script>");
		  }else{
			  String mem_pwd=request.getParameter("mem_pwd").trim();
			  String mem_name=request.getParameter("mem_name").trim();
			  String mem_zip=request.getParameter("mem_zip").trim();
			  String mem_zip2=request.getParameter("mem_zip2").trim();
			  String mem_addr=request.getParameter("mem_addr").trim();
			  String mem_addr2=request.getParameter("mem_addr2").trim();
			  String mem_phone01=
					  request.getParameter("mem_phone01");
			  String mem_phone02=
					  request.getParameter("mem_phone02").trim();
			  String mem_phone03=
					  request.getParameter("mem_phone03").trim();				  
			  String mem_phone=mem_phone01+"-"+mem_phone02+"-"+mem_phone03;
			  String mail_id=request.getParameter("mail_id").trim();
			  String mail_domain=request.getParameter("mail_domain").trim();
			  String mem_email=mail_id+"@"+mail_domain;
			  
			  Member33Bean m33=new Member33Bean();
			  m33.setMem_id(id); m33.setMem_pwd(mem_pwd);
			  m33.setMem_name(mem_name); m33.setMem_zip(mem_zip);
			  m33.setMem_zip2(mem_zip2); m33.setMem_addr(mem_addr);
			  m33.setMem_addr2(mem_addr2); m33.setMem_phone(mem_phone);
			  m33.setMem_email(mem_email);
			  
			  this.memService.editMember(m33); //���� �޼��� ȣ��
			  
			  response.sendRedirect("member_Login.do");
		  }
		  return null;
	  }
	  
	  /*ȸ�� ������*/
	  @RequestMapping(value="/member_DEL.do")
	  public ModelAndView mem_DEL(HttpServletRequest request,
			  HttpServletResponse response,HttpSession session)
	  throws Exception{
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out=response.getWriter();
		  session=request.getSession();
		  
		  String id=(String)session.getAttribute("id");
		  if(id==null){
			  out.println("<script>");
			  out.println("alert('�ٽ� �α��� �ϼ���!')");
			  out.println("location='member_Login.do'");
			  out.println("</script>");
		  }else{
		    ModelAndView delM=new ModelAndView("member/member_DEL");
		    return delM;
		  }
		  return null;
	  }
	  
	  /*ȸ�� ����*/
	  @RequestMapping(value="/member_DEL_ok.do",method=RequestMethod.POST)
	  public ModelAndView mem_del_ok(HttpServletRequest request,
			  HttpServletResponse response, HttpSession session)
	  throws Exception{
		  response.setContentType("text/html;charset=UTF-8");
		  //���� ���̴� ����ڵ� Ÿ�� ����
		  PrintWriter out=response.getWriter();//��½�Ʈ�� ��ü ����
		  session=request.getSession(); //���� ��ü ����
		  
		  String id=(String)session.getAttribute("id");
		  //���� ���̵� ����� ���̵��� ������.
		  if(id==null){
			  out.println("<script>");
			  out.println("alert('�ٽ� �α��� �ϼ���!')");
			  out.println("location='member_Login.do'");
			  out.println("</script>");
		  }else{
			  Member33Bean db_pwd=this.memService.idSearch(id);
			  //���̵� �ش��ϴ� ȸ������ �� ����� ������.
			  String del_pwd=request.getParameter("del_pwd").trim();
			  String del_cont=request.getParameter("del_cont").trim();
			  if(db_pwd.getMem_pwd().equals(del_pwd)){//����� ���ٸ�
				  Member33Bean m=new Member33Bean();
				  m.setMem_id(id); m.setMem_delcont(del_cont);
				  
				  this.memService.delMem(m);//���� �޼��� ȣ��
				  session.invalidate();//������ ����
				  
				  response.sendRedirect("member_Login.do");
			  }else{//����� �ٸ��ٸ�
				  out.println("<script>");
				  out.println("alert('����� �ٸ��ϴ�!')");
				  out.println("history.go(-1)");
				  out.println("</script>");
			  }
		  }
		  return null;
	  }  
}

