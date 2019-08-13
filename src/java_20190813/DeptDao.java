package java_20190813;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDao {
	
	private static DeptDao single;

	private DeptDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static DeptDao getInstance() {
		if (single == null) {
			single = new DeptDao();
		}
		return single;
	}
	
	public boolean insert(DeptDto d) {
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO dept(DEPTNO,DNAME,LOC) ");
			sql.append("VALUES(?,?,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setInt(index++, d.getNo());
			pstmt.setString(index++, d.getName());
			pstmt.setString(index, d.getLoc());
			
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	
	public boolean update(DeptDto d) {
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE dept ");
			sql.append("SET DNAME = ?, LOC = ? ");
			sql.append("WHERE DEPTNO = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, d.getName());
			pstmt.setString(index++, d.getLoc());
			pstmt.setInt(index, d.getNo());
			
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return isSuccess;
	}
	public boolean delete(int no) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE ");
			sql.append("FROM dept ");
			sql.append("WHERE DEPTNO = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index++,no);
			
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return isSuccess;
	}
	
	public ArrayList<DeptDto> select(){
		ArrayList<DeptDto> list = new ArrayList<DeptDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT DEPTNO,DNAME,LOC ");
			sql.append("FROM dept ");
			sql.append("ORDER BY DEPTNO ASC");
			
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new DeptDto(rs.getInt(index++),rs.getString(index++),rs.getString(index)));
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

}
