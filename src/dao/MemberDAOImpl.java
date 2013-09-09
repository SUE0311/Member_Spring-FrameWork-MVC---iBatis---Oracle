package dao;

import ibatis.SqlMapLocator;

import java.sql.SQLException;
import java.util.List;

import model.Member33Bean;
import model.ZipcodeBean2;

public class MemberDAOImpl {//오라클 디비 연동 클래스 파일

	/*ibatis 메서드 정리
	 *  1. 한개 레코드값을 검색:queryForObject()
	 *  2. 한개 이상 레코드를 검색해서 컬렉션에 저장하고자 할때:
	 *  queryForList()
	 *  3. 레코드값을 저장:insert()
	 *  4. 레코드값을 수정:update()
	 *  5. 레코드값을 삭제:delete() 
	 */
	
	/* ibatis 중복아이디 체크*/
	public Member33Bean idCheck(String id) throws SQLException{
		Member33Bean db_id=null;
		db_id=(Member33Bean)SqlMapLocator.getMapper().queryForObject(
				"member_idcheck",id);
		return db_id;
	}

	/*우편번호 검색*/
	public List<ZipcodeBean2> findZipcode(String dong) 
	throws SQLException{
		List<ZipcodeBean2> list=SqlMapLocator.getMapper().queryForList(
				"zipcodeList",dong);
		return list;
	}

	/*중복 아이디 검색*/
	public Member33Bean idSearch(String mem_id) throws SQLException{
		Member33Bean db_id=null;
		db_id=(Member33Bean)SqlMapLocator.getMapper().queryForObject(
				"id_search",mem_id);
		return db_id;
	}

	/*회원 저장*/
	public void insertMember(Member33Bean m) throws SQLException{
		SqlMapLocator.getMapper().insert("memInsert",m);		
	}
	
	/*비번 찾기 */
	public Member33Bean findPwd(Member33Bean pm) 
	throws SQLException{
		Member33Bean m=null;
		m=(Member33Bean)SqlMapLocator.getMapper().queryForObject(
				"pwd_find",pm);
		return m;
	}
	
	/*정보수정*/
	public void editMember(Member33Bean m33) throws SQLException{
		SqlMapLocator.getMapper().update("memEdit",m33);		
	}
	
	/*회원삭제*/
	public void delMem(Member33Bean m) throws SQLException{
		SqlMapLocator.getMapper().update("memDEL",m);		
	}

}


