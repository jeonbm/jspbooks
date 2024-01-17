package ch09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	final String JDBC_DRIVER="org.h2.Driver";
	final String JDBC_URL="jdbc:h2:tcp://localhost/~/test";
	
	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"sa","");
		}catch(Exception e) {
			System.out.println("db오류 : "+e);
		}
	}
	
	public void close() {
		try {
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("db오류");
		}
	}
	
	public void insert(StudentDto _s) {
		open();
		String sql = "insert into student(username,univ,birth,email) values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _s.getUsername());
			pstmt.setString(2, _s.getUniv());
			pstmt.setDate(3, _s.getBirth());
			pstmt.setString(4, _s.getEmail());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("쿼리실행 오류");
			
		} finally {
			close();
		}
	}
	
	public List<StudentDto> getAll(){
		open();
		List<StudentDto> result = new ArrayList<>();
		try {
			
			pstmt = conn.prepareStatement("select * from student");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDto s = new StudentDto();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
				
				result.add(s);
			}
			
		}catch(Exception e) {
			System.out.println("데이터베이스 오류");
			
		}finally {
			close();
		}
		return result;
	}

}
