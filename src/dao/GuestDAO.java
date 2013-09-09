package dao;

import java.util.List;

import model.Guest33Bean;

public interface GuestDAO {
	/*
	 * 인터페이스에 올수 있는것은
	 * 1. public static final로 선언된 클래스로 바로 접근 가능한 정적 상수만
	 * 올수 있다. 상수는 값이 변경할 수 없다.
	 * 2. 추상메서드만 올수 있다. 
	 */
	void insertGuest(Guest33Bean g); //방명록 저장
	//public abstract가 생략됨. 추상메서드
	List<Guest33Bean> getGuestList();//방명록 목록
	int listCount();                 //총 레코드 개수
	Guest33Bean getGuestCont(int no);//방명록 내용
	void guestEdit(Guest33Bean eg);  //방명록 수정
	void deleteGuest(int no);        //방명록 삭제
}
