package yuhan.kiosk.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import yuhan.kiosk.dto.CartDto;
import yuhan.kiosk.dto.MenuCartDto;
import yuhan.kiosk.dto.MenuDto;
import yuhan.kiosk.mvc.util.ConstantTemplate;

public class CartDao {
	JdbcTemplate template;
	
	public CartDao() {
		
		this.template = ConstantTemplate.template;
	}

	public String CartInsert(final String member_seq, final String menu_seq, final String cup_size, final String cup_choice) {
		
		final Date date = new Date(System.currentTimeMillis());
		String sql = "select ea from cart where member_seq = '" + member_seq + "'and menu_seq = '" + menu_seq +"'and cup_size = '" + cup_size + "'and cup_choice = '" + cup_choice + "' " ;

		try {
			final int ea = template.queryForObject(sql, Integer.class); //장바구니에 담긴 같은 조건의 음료 수(ea)
			
			sql = "update cart set ea = ? where member_seq =? and menu_seq = ? and cup_size = ? and cup_choice = ?";
			
			this.template.update(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException { //익명 클래스
					ps.setInt(1, ea+1);
					ps.setInt(2,  Integer.parseInt(member_seq));
					ps.setInt(3, Integer.parseInt(menu_seq));
					ps.setString(4, cup_size);
					ps.setString(5, cup_choice);
				}
			});
			
			return "수량 추가";
			
		} catch (EmptyResultDataAccessException e) { //결과값이 0 또는 1이상일 때 에러나기 때문에 잡아주기 , null 처리
			System.out.println("값이 없다!");
			
			sql = "insert into cart(member_seq, menu_seq, cup_size, cup_choice, ea, date)"
					+ "values(?, ?, ?, ?, ?, ?)";
			
			this.template.update(sql, new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException { //익명 클래스
					ps.setInt(1,  Integer.parseInt(member_seq)); //final 지시어(메서드,클래스,파라미터 앞) 필요 = 파라미터 값에서는 상수화(데이터 값을 바꿀 수 없게 정의) 시켜주는 역할
					ps.setInt(2, Integer.parseInt(menu_seq)); //final 지시어 필요
					ps.setString(3, cup_size); //final 지시어 필요
					ps.setString(4, cup_choice);
					ps.setInt(5, 1);
					ps.setDate(6, date);
				}
				
			});
		
			return "장바구니에 추가";
		}
	}

	public ArrayList<MenuCartDto> CartDetail(String member_seq) {
		
		String sql ="SELECT menu_img.img_url, menu.name, menu.price, cart.seq, cart.cup_size, cart.cup_choice, cart.ea FROM menu_img, menu, cart WHERE cart.member_seq = '" + member_seq + "' AND menu_img.menu_seq = cart.menu_seq AND cart.menu_seq = menu.seq";

		ArrayList<MenuCartDto> dtos = (ArrayList<MenuCartDto>) template.query(sql, new BeanPropertyRowMapper<MenuCartDto>(MenuCartDto.class));

		return dtos;
	}

	public void EaInsert(final String cart_seq, final String ea) {
		String sql = "update cart set ea = ? where seq = ?";
		
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException { //익명 클래스
				ps.setInt(1, Integer.parseInt(ea));
				ps.setInt(2,  Integer.parseInt(cart_seq));
			}
		});
		System.out.println("수량 변경");
	}
}
