package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUpdateDemo {
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true","kic12","kic12");
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE member ");
			sql.append("SET addr = ?, name = ? ");
			sql.append("WHERE num = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "미국");
			pstmt.setString(2, "조스");
			pstmt.setInt(3, 11);
			
			int resultCount = pstmt.executeUpdate();
			
			System.out.println("갱신된 행의 수 : " + resultCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
