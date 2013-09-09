package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Guest33Bean;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class GuestDAOImpl extends JdbcDaoSupport implements GuestDAO {
	//spring jdbc를 하기 위해서 JdbcDaoSupport클래스를 상속받는다.

	//방명록 저장
	private static final String GUEST_INSERT="insert into guest33 "
		+" (guest_no,guest_name,guest_title,guest_cont,guest_pwd, "
			+"guest_regdate) values(guest33_no_seq.nextval,?,?,?,?,"
		+"sysdate)";
	
	//static final로 선언하면 변수가 값을 수정할수 없는 상수화가 됨.
	private static final String GUEST_LIST="select * from guest33 "
			+" order by guest_no desc";
	
	//번호를 기준으로 내림차순(desc)하면서 큰숫자가 먼저 정렬된다.
	private static final String GUEST_COUNT="select count(guest_no) "
			+" from guest33";
	
	//총 레코드 개수
	private static final String GUEST_EDIT="select * from guest33 "
			+" where guest_no=?";
	
	//글번호를 기준으로 내용을 검색
	private static final String GUEST_EDIT_OK="update guest33 set "
			+" guest_name=?,guest_title=?,guest_cont=?,"
			+"guest_pwd=? where guest_no=?";
	
	//글번호를 기준으로 방명록을 수정
	private static final String GUEST_DEL_OK="delete from "
			+" guest33 where guest_no=?";
	
	//번호를 기준으로 방명록 레코드 삭제
	
	/*방명록 수정 값을 저장하기 위한 클래스 정의*/
	private class GuestEditOk implements PreparedStatementSetter{

		private Guest33Bean g;
		
		public GuestEditOk(Guest33Bean g){
			this.g=g;
		}
		@Override
		public void setValues(PreparedStatement pstmt) 
				throws SQLException {
		 pstmt.setString(1,this.g.getGuest_name());//1번 물음표에 수정할 이름 저장
		 pstmt.setString(2,this.g.getGuest_title());
		 pstmt.setString(3,this.g.getGuest_cont());
		 pstmt.setString(4,this.g.getGuest_pwd());
		 pstmt.setInt(5,this.g.getGuest_no());
		}		
	}
	
	/*글번호를 기준으로 검색한 레코드값을 저장할 클래스 정의*/
	private class GuestEditRs implements ResultSetExtractor{

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
		  //extractData()메서드는 검색 결과 레코드가 하나일때만 호출
			if(rs.next()){
			  	Guest33Bean g=new Guest33Bean();
			  	g.setGuest_no(rs.getInt("guest_no"));
			  	g.setGuest_name(rs.getString("guest_name"));
			  	g.setGuest_title(rs.getString("guest_title"));
			  	g.setGuest_cont(rs.getString("guest_cont"));
			  	g.setGuest_pwd(rs.getString("guest_pwd"));
			  	g.setGuest_hit(rs.getInt("guest_hit"));
			  	g.setGuest_regdate(rs.getString("guest_regdate"));
			  	return g;
			}else{
			return null;
			}
		}		
	}
	
	/*글번호 저장 클래스 정의*/
	private class GuestEditKey implements PreparedStatementSetter{

		private int no;
		
		public GuestEditKey(int no){
			this.no=no; //글번호를 저장
		}
		@Override
		public void setValues(PreparedStatement pstmt) 
				throws SQLException {
			pstmt.setInt(1,no);//1번 물음표에 글번호를 저장			
		}		
	}
	
	/*총 레코드 개수를 저장하기 위한  클래스 정의*/
	private class GuestCount implements ResultSetExtractor{

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			/*
			 * extractData()추상메서드 란?
			 * 1. 이 메서드는 select문에 의해서 한개 레코드값이 검색될때
			 * 사용한다. 한개 이상 레코드 값이 반환 될때는 사용되지 않는다.
			 */
			int count=0;//총 레코드 개수를 저장하기 위한 변수
			
			if(rs.next()){//검색 레코드값이 있을 경우
				count=rs.getInt(1);//총 레코드 개수를 저장
				return count;
			}
			return null;			
		}				
	}
	
	/*게시물 목록을 저장할 클래스 정의 */
	private class GuestList implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int rowNum)
				throws SQLException {
		/*
		 * mapRow()추상메서드 정의
		 * 1.쿼리문 즉 select문 한다음 반환된 레코드 행의 개수만큼 호출된다.
		 * 즉 레코드 행이 3개면 3번 호출한다는 뜻
		 * 2.하나이상의 레코드를 반환해서 컬렉션으로 반환할때만 이 메서드를
		 * 호출해야 한다.
		 */
			Guest33Bean g=new Guest33Bean();
			g.setGuest_no(rs.getInt("guest_no"));
			g.setGuest_name(rs.getString("guest_name"));
			g.setGuest_title(rs.getString("guest_title"));
			g.setGuest_cont(rs.getString("guest_cont"));
			g.setGuest_hit(rs.getInt("guest_hit"));
			g.setGuest_pwd(rs.getString("guest_pwd"));
			g.setGuest_regdate(rs.getString("guest_regdate"));
			return g;
		}		
	}
	
	/*방명록 저장할 클래스 정의*/
	private class GuestForInsert implements PreparedStatementSetter{

		private Guest33Bean g;
		
		public GuestForInsert(Guest33Bean g){
			this.g=g;
		}
		@Override
		public void setValues(PreparedStatement pstmt) 
				throws SQLException {
			//레코드값 설정하는 메서드
	      pstmt.setString(1,this.g.getGuest_name());//1번물음표에 이름 저장
          pstmt.setString(2,this.g.getGuest_title());
          pstmt.setString(3,this.g.getGuest_cont());
          pstmt.setString(4,this.g.getGuest_pwd());
		}		
	}
	
	@Override
	public void insertGuest(Guest33Bean g) {
		//방명록 저장
		getJdbcTemplate().update(GUEST_INSERT,
				new GuestForInsert(g));
		//메서드 첫번째 전달인자는 쿼리문을 저장하는 상수
		//두번째 전달인자는 생성자를 호출해서 저장할 레코드값
		//전달인자 1개자리 생성자를 호출
	}

	@Override
	public List<Guest33Bean> getGuestList() {
		//방명록 목록
		return getJdbcTemplate().query(GUEST_LIST,new GuestList());
		//첫번째 전달인자는 쿼리문이 저장된 상수
		//두번째 전달인자는 쿼리문을 실행한 레코드값을 저장하기 위한 생성자
		//호출부분
	}

	@Override
	public int listCount() {
		//총레코드 개수
		return getJdbcTemplate().query(GUEST_COUNT,new GuestCount());
	}

	@Override
	public Guest33Bean getGuestCont(int no) {
		//수정폼
		return (Guest33Bean)getJdbcTemplate().query(
				GUEST_EDIT,new GuestEditKey(no),new GuestEditRs());
		//첫번째 전달인자는 쿼리문
		//두번째 전달인자는 피라미터로 넘어온 글번호를 생성자를 호출해서 저장할 곳
		//세번째 전달인자는 글번호를 기준으로 디비로 부터
		//검색한 결과를 저장할 곳
	}

	@Override
	public void guestEdit(Guest33Bean eg) {
		//방명록 수정
		getJdbcTemplate().update(GUEST_EDIT_OK,new GuestEditOk(eg));
		//첫번째 전달인자는 쿼리문이 저장되는 상수
		//두번째 전달인자는 피라미터로 넘어온 것을 생성자 호출해서 저장하는
		//부분
	}

	@Override
	public void deleteGuest(int no) {//방명록 삭제
		getJdbcTemplate().update(GUEST_DEL_OK,new GuestEditKey(no));
		//첫번째 전달인자는 쿼리문이 저장된 상수
		//두번째 전달인자는 피라미터로 넘어온 글번호를 셋팅
	}
}
