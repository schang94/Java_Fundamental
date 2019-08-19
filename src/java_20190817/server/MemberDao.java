package java_20190817.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_20190730.StringBufferDemo;

public class MemberDao {
	private static MemberDao single;
	
	public MemberDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getInstance() {
		if (single == null) {
			single = new MemberDao();
		}
		return single;
	}
	
	public boolean Insert(MemberDto m) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO member(id,name)  ");
			sql.append("VALUES (?,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, m.getId());
			pstmt.setString(index, m.getName());
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return isSuccess;
	}
	
	public boolean Update(MemberDto m) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
		
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE member ");
			sql.append("Set name = ? ");
			sql.append("WHERE id = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, m.getName());
			pstmt.setString(index, m.getId());
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return isSuccess;
	}
	
	public boolean Delete(String id) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
		
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE ");
			sql.append("FROM member ");
			sql.append("WHERE id = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index, id);
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return isSuccess;
	}
	
	public ArrayList<MemberDto> Select(){
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT id,name ");
			sql.append("FROM member ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MemberDto(rs.getString(index++),rs.getString(index)));
				index = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
	public String PickSelect(String id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str = "";
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT id,name ");
			sql.append("FROM member ");
			sql.append("WhERE id = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				str = rs.getString(index++)+"#"+rs.getString(index);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return str;
	}
	
	public boolean Overlap(String id) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
		
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT id,name ");
			sql.append("FROM member ");
			sql.append("WhERE id = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index, id);
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				isSuccess = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return isSuccess;
	}
}
