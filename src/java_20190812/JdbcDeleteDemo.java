package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDeleteDemo {
	public static void main(String[] args) {
		// 1. 드라이브 로드
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver Load Succuss");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Load Fail");
		}
		// 2. Connection 객체 생성
		Connection con = null;
		
		
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/kic?autoReconnect=true","kic12","kic12");
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("Delete From member WHERE num = ?");
			
			// 3. PreparedStatement 객체 생성
			pstmt = con.prepareStatement(sql.toString());
			
			// 3-1. 바인딩 변수가 있다면 바인디 변수 설정
			pstmt.setInt(1, 12);
			
			// 4. executeUpdate() 메서드로 SQL(insert,update,delete)문 전송
			int resultCount = pstmt.executeUpdate();
			
			System.out.println("삭제된 행의 수 : "+ resultCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null ) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
		
	}
}
