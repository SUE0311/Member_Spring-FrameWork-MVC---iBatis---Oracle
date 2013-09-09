package dao;

import ibatis.SqlMapLocator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Guest33Bean;

public class Guest2DAO {//����Ŭ ��� ���� Ŭ����
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	DataSource ds=null;
	String sql=null;
	
	public Guest2DAO(){
		try{
	     Context ctx=new InitialContext();
	     ds=(DataSource)ctx.lookup("java:comp/env/jdbc/orcl");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*���� ���뺸��*/
	public Guest33Bean getCont(int no){
		Guest33Bean g=null;
		try{
			con=ds.getConnection();//����Ŭ ��� ���� ��ü�� ����
			sql="select * from guest33 where guest_no=?";
			pstmt=con.prepareStatement(sql);//������ ���� ��ü�� ����
			pstmt.setInt(1,no);//1�� ����ǥ�� ��ȣ�� ����
			rs=pstmt.executeQuery(); //������ ����
			if(rs.next()){
			  g=new Guest33Bean();
			  g.setGuest_no(rs.getInt("guest_no"));
			  g.setGuest_name(rs.getString("guest_name"));
			  g.setGuest_title(rs.getString("guest_title"));
			  g.setGuest_cont(rs.getString("guest_cont"));
			  g.setGuest_pwd(rs.getString("guest_pwd"));
			  g.setGuest_hit(rs.getInt("guest_hit"));
			  g.setGuest_regdate(rs.getString("guest_regdate"));
			}			
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return g;
	}

	/*��ȸ�� ����*/
	public void hitUpdate(int no) throws SQLException{
      	SqlMapLocator.getMapper().update("guest_hit",no);
	}
}








