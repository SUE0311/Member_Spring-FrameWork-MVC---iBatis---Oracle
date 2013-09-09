package dao;

import java.util.List;

import model.Guest33Bean;

public interface GuestDAO {
	/*
	 * �������̽��� �ü� �ִ°���
	 * 1. public static final�� ����� Ŭ������ �ٷ� ���� ������ ���� �����
	 * �ü� �ִ�. ����� ���� ������ �� ����.
	 * 2. �߻�޼��常 �ü� �ִ�. 
	 */
	void insertGuest(Guest33Bean g); //���� ����
	//public abstract�� ������. �߻�޼���
	List<Guest33Bean> getGuestList();//���� ���
	int listCount();                 //�� ���ڵ� ����
	Guest33Bean getGuestCont(int no);//���� ����
	void guestEdit(Guest33Bean eg);  //���� ����
	void deleteGuest(int no);        //���� ����
}
