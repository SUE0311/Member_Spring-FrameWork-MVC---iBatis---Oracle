package model;

public class Member33Bean {//setter,getter 
	
	private int mem_code; //아이디가 중복이냐,아니냐를 판단하는 변수
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_zip;
	private String mem_zip2;
	private String mem_addr;
	private String mem_addr2;
	private String mem_phone;
	private String mem_email;
	private String mem_regdate;
	private int mem_state; //가입회원 1,탈퇴회원 2
	private String mem_delcont; //탈퇴사유
	private String mem_deldate; //탈퇴날짜
	
	public int getMem_code() {
		return mem_code;
	}
	public void setMem_code(int mem_code) {
		this.mem_code = mem_code;
	}		
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_zip() {
		return mem_zip;
	}
	public void setMem_zip(String mem_zip) {
		this.mem_zip = mem_zip;
	}
	public String getMem_zip2() {
		return mem_zip2;
	}
	public void setMem_zip2(String mem_zip2) {
		this.mem_zip2 = mem_zip2;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_regdate() {
		return mem_regdate;
	}
	public void setMem_regdate(String mem_regdate) {
		this.mem_regdate = mem_regdate;
	}
	public int getMem_state() {
		return mem_state;
	}
	public void setMem_state(int mem_state) {
		this.mem_state = mem_state;
	}
	public String getMem_delcont() {
		return mem_delcont;
	}
	public void setMem_delcont(String mem_delcont) {
		this.mem_delcont = mem_delcont;
	}
	public String getMem_deldate() {
		return mem_deldate;
	}
	public void setMem_deldate(String mem_deldate) {
		this.mem_deldate = mem_deldate;
	}	
}
