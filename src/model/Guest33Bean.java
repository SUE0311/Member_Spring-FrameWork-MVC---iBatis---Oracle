package model;

public class Guest33Bean {

	private int guest_no;
	private String guest_name;
	private String guest_title;
	private String guest_cont;
	private String guest_pwd;
	private int guest_hit;
	private String guest_regdate;
	
	public int getGuest_no() {
		return guest_no;
	}
	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}
	public String getGuest_name() {
		return guest_name;
	}
	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}
	public String getGuest_title() {
		return guest_title;
	}
	public void setGuest_title(String guest_title) {
		this.guest_title = guest_title;
	}
	public String getGuest_cont() {
		return guest_cont;
	}
	public void setGuest_cont(String guest_cont) {
		this.guest_cont = guest_cont;
	}
	public String getGuest_pwd() {
		return guest_pwd;
	}
	public void setGuest_pwd(String guest_pwd) {
		this.guest_pwd = guest_pwd;
	}
	public int getGuest_hit() {
		return guest_hit;
	}
	public void setGuest_hit(int guest_hit) {
		this.guest_hit = guest_hit;
	}
	public String getGuest_regdate() {
		return guest_regdate;
	}
	public void setGuest_regdate(String guest_regdate) {
		this.guest_regdate = guest_regdate.substring(0,10);
		//0이상 10미만 사이의 년월일 반환
	}	
}
