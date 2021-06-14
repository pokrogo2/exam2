package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.util.DBConnector;
import dto.MemberDTO;

public class MemberDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {
		con = DBConnector.getInstance().getConnection();
	}
	public static MemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}
	public void close(Connection con,PreparedStatement ps,ResultSet rs) {
		try {
		if(con!=null) {con.close();}
		if(ps!=null) {ps.close();}
		if(rs!=null) {rs.close();}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public MemberDTO login(MemberDTO dto) {
		 MemberDTO login = null;
		try {
			sql="SELECT ID,NAME,GRADE,POINT FROM MEMBER_TABLE WHERE ID=? AND NAME=?";
			ps= con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			rs = ps.executeQuery();
			if(rs.next()) {
				login = new MemberDTO();
				login.setId(rs.getString(1));
				login.setName(rs.getString(2));
				login.setGrade(rs.getString(3));
				login.setPoint(rs.getInt(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con,ps,rs);
		}
		
		return login;
	}
	public int join(MemberDTO dto) {
		int result=0;
		try {
			sql="INSERT INTO MEMBER_TABLE VALUES (MEMBER_SEQ.NEXTVAL,?,?,'bronze',1000)";
			ps= con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			
			result= ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, null);
		}
		return result;
		
	}
	public int delete(MemberDTO dto) {
		int result=0;
		try {
			sql="DELETE MEMBER_TABLE WHERE NAME=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, null);
		}
		return result;
	}
	public int update(MemberDTO dto) {
		int result=0;
		try {
			sql="UPDATE MEMBER_TABLE SET NAME=?,GRADE=?,POINT=? WHERE ID=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getGrade());
			ps.setInt(3, dto.getPoint());
			ps.setString(4, dto.getId());
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, null);
		}
		return result;
	}
}
