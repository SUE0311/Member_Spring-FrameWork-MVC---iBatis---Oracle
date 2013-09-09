package dao;

import ibatis.SqlMapLocator;

import java.sql.SQLException;
import java.util.List;

import model.Member33Bean;
import model.ZipcodeBean2;

public class MemberDAOImpl {//����Ŭ ��� ���� Ŭ���� ����

	/*ibatis �޼��� ����
	 *  1. �Ѱ� ���ڵ尪�� �˻�:queryForObject()
	 *  2. �Ѱ� �̻� ���ڵ带 �˻��ؼ� �÷��ǿ� �����ϰ��� �Ҷ�:
	 *  queryForList()
	 *  3. ���ڵ尪�� ����:insert()
	 *  4. ���ڵ尪�� ����:update()
	 *  5. ���ڵ尪�� ����:delete() 
	 */
	
	/* ibatis �ߺ����̵� üũ*/
	public Member33Bean idCheck(String id) throws SQLException{
		Member33Bean db_id=null;
		db_id=(Member33Bean)SqlMapLocator.getMapper().queryForObject(
				"member_idcheck",id);
		return db_id;
	}

	/*�����ȣ �˻�*/
	public List<ZipcodeBean2> findZipcode(String dong) 
	throws SQLException{
		List<ZipcodeBean2> list=SqlMapLocator.getMapper().queryForList(
				"zipcodeList",dong);
		return list;
	}

	/*�ߺ� ���̵� �˻�*/
	public Member33Bean idSearch(String mem_id) throws SQLException{
		Member33Bean db_id=null;
		db_id=(Member33Bean)SqlMapLocator.getMapper().queryForObject(
				"id_search",mem_id);
		return db_id;
	}

	/*ȸ�� ����*/
	public void insertMember(Member33Bean m) throws SQLException{
		SqlMapLocator.getMapper().insert("memInsert",m);		
	}
	
	/*��� ã�� */
	public Member33Bean findPwd(Member33Bean pm) 
	throws SQLException{
		Member33Bean m=null;
		m=(Member33Bean)SqlMapLocator.getMapper().queryForObject(
				"pwd_find",pm);
		return m;
	}
	
	/*��������*/
	public void editMember(Member33Bean m33) throws SQLException{
		SqlMapLocator.getMapper().update("memEdit",m33);		
	}
	
	/*ȸ������*/
	public void delMem(Member33Bean m) throws SQLException{
		SqlMapLocator.getMapper().update("memDEL",m);		
	}

}


