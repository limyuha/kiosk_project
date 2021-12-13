package yuhan.kiosk.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import yuhan.kiosk.dto.MenuDto;
import yuhan.kiosk.dto.OrderDto;
import yuhan.kiosk.dto.OrderSubDto;
import yuhan.kiosk.mvc.util.ConstantTemplate;

public class OrderDao {
	JdbcTemplate template;
	DataSource dataSource; //2
	
	public OrderDao() {
		this.template = ConstantTemplate.template;
		
		try {
			Context context = new InitialContext(); //2
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public String Order(final String member_seq, String sum) {

		String sql ="select member_seq from cart where member_seq = '" + member_seq + "'";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int order_seq = 0;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //isBeforeFirst : 결과에 무언가 있는지 확인하고 커서 이동 X, rs.next() 사용하면 커서 이동하게 됨 => 안됨
				System.out.println("if 문 타기 시작");
				
				sql = "insert into kiosk_order(member_seq, sum, date)"
						+ "values(?, ?, now())"; //now 시분초까지
				
				/*this.template.update(sql, new PreparedStatementSetter() { //템플릿으로 넣으면 last_insert_id 값이 0

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1,  Integer.parseInt(member_seq));
						ps.setDate(2, date);
					}
				});
				*/
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(member_seq));
				pstmt.setInt(2, Integer.parseInt(sum));
				pstmt.executeUpdate();
				
				System.out.println("kiosk_order 테이블에 insert");
			} else {
				return "검색 값이 없다";
			}
			
			sql = "select last_insert_id()";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) { 
				order_seq = rs.getInt("last_insert_id()"); 
				System.out.println("order_seq : " + order_seq); 
			}
			
			sql = "select menu_seq, cup_size, cup_choice, ea from cart where member_seq = '" + member_seq + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sql = "insert into kiosk_order_menu(order_seq, menu_seq, cup_size, cup_choice, ea)"
						+ "values(?, ?, ?, ?, ?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, order_seq);
				pstmt.setInt(2, rs.getInt("menu_seq"));
				pstmt.setString(3, rs.getString("cup_size"));
				pstmt.setString(4, rs.getString("cup_choice"));
				pstmt.setInt(5, rs.getInt("ea"));
				pstmt.executeUpdate();
				
				System.out.println("kiosk_order_menu 테이블에 insert : " + rs.getInt("ea"));
			}
			
			sql = "delete from cart where member_seq = '" + member_seq + "'";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (Exception e) {

		}
		
		return "주문내역 테이블에 insert";
	}

	public ArrayList<OrderDto> OrderView(String member_seq) {
		
		ArrayList<OrderDto> order_dtos = null;
		
		String sql = "SELECT kiosk_order.seq, kiosk_order.sum, kiosk_order.date FROM kiosk_order WHERE kiosk_order.member_seq = '" + member_seq + "' order BY seq desc" ;
		
		order_dtos = (ArrayList<OrderDto>) template.query(sql, new BeanPropertyRowMapper<OrderDto>(OrderDto.class));
		
		return order_dtos;
	}

	public ArrayList<OrderSubDto> OrderDetailView(int seq) {
		
		ArrayList<OrderSubDto> order_sub_dtos = null;
		
		String sql = "SELECT kiosk_order_menu.order_seq, kiosk_order_menu.menu_seq, kiosk_order_menu.cup_size, kiosk_order_menu.cup_choice, kiosk_order_menu.ea, menu.name, menu.price, menu_img.img_url FROM menu, menu_img, kiosk_order_menu WHERE kiosk_order_menu.order_seq = '" +seq+ "'AND kiosk_order_menu.menu_seq = menu.seq AND kiosk_order_menu.menu_seq = menu_img.menu_seq";
		
		order_sub_dtos = (ArrayList<OrderSubDto>) template.query(sql, new BeanPropertyRowMapper<OrderSubDto>(OrderSubDto.class));
		
		return order_sub_dtos;
	}

	public void OrderBtn(String member_seq, String menu_seq, String cup_size, String cup_choice) {
		
		
	}
}
