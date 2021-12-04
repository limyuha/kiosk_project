package yuhan.kiosk.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import yuhan.kiosk.dto.MenuDto;
import yuhan.kiosk.mvc.util.ConstantTemplate;

public class MemberDao {

	JdbcTemplate template;
	DataSource dataSource; //2
	
	public MemberDao() {
		this.template = ConstantTemplate.template;
		
		try {
			Context context = new InitialContext(); //2
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public String MemberJoin(final String id, final String password, final String tel) {
		final Date date = new Date(System.currentTimeMillis()); //시분초까지 사용하려면 java.util.Date 사용
		String check = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select id from member where id = '" + id + "' ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = "아이디중복";
			} else {
				sql = "insert into member(id, password, tel, date) values(?, ?, ?, ?)";
				this.template.update(sql, new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, id);
						ps.setString(2, password);
						ps.setString(3, tel); //ps.setInt(3, Integer.parseInt(tel));
						ps.setDate(4, date);
					}
				});
			}
			
		} catch (Exception e) {

		}
		
		return check;
	}

	public String MemberLogin(String id, String password) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String check = "";
		
		try {
			conn = dataSource.getConnection();
			String sql = "select seq, id, password from member where id = ? and password = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			//check = "틀림";
			if(rs.next()) {
				check = rs.getString("id");
				System.out.println("로그인");
			}
			
		} catch (Exception e) {

		}
		
		return check;
	}
}
