package java_20190814;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeDao {
	// 1. singleton
	// 1-1. static 변수로 self 자료형 변수를 선언하고 접근 한정자는 private로
	private static NoticeDao single;
	// 1-2. 디폴트 생생성자의 접근 한정자는 private으로 선언
	//      외부에서 객체 생성을 못하게 하기 위해서
	private NoticeDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 1-3. 객체생성할 수 잇는 getInstance() 메서드 선언
	//      이때 single 변수의 null 체크를 하여 null인 경우에만 객체를 생성한다.
	//		이렇게 함으로서 다중 클라이언트가 접근하더라도 한개의 객체를 공유해서 사용할 수 있다.
	public static NoticeDao getInstance() {
		if(single == null) {
			// 객체를 생성할 수 있는 이유는 생성자의 접근 한정자가 private이기 때문에
			// 클래스내에서만 객체를 생성할 수 있다.
			single = new NoticeDao();
		}
		return single;
	}
	
	public boolean insert(NoticeDto n) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO notice(writer,title,content,regdate) ");
			sql.append("VALUES (?,?,?,NOW())");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, n.getWriter());
			pstmt.setString(index++, n.getTitle());
			pstmt.setString(index, n.getContent());
			
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
				e2.printStackTrace();
			}
		}
		return isSuccess;
	}
	public boolean update(NoticeDto n,int num) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE notice ");
			sql.append("SET writer = ?, title = ?, content = ?, regdate = NOW() ");
			sql.append("WHERE num = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, n.getWriter());
			pstmt.setString(index++, n.getTitle());
			pstmt.setString(index++, n.getContent());
			pstmt.setInt(index, num);
			
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} try {
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		return isSuccess;
	}
	public boolean delete(int num) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("Delete ");
			sql.append("FROM notice ");
			sql.append("WHERE num = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index, num);
			
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
				e2.printStackTrace();
			}
		}
		return isSuccess;
	}
	public ArrayList<NoticeDto> select(){
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			StringBuffer sql = new StringBuffer();
			
			sql.append("SELECT writer,title,content,DATE_FORMAT(regdate,'%Y-%m-%d') ");
			sql.append("FROM notice ");
			
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new NoticeDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) rs.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return list;
	}

}
