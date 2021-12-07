package yuhan.kiosk.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import yuhan.kiosk.mvc.util.ConstantTemplate;

public class CartDao {
	JdbcTemplate template;
	
	public CartDao() {
		
		this.template = ConstantTemplate.template;
	}

	public String CartInsert(String member_seq, String menu_seq, String cup_size, String cup_choice) {
		
		String sql = "select member_seq, cup_size, cup_choice, eq from cart where member_seq = '" + member_seq + "'and menu_seq = '" + menu_seq +"'and cup_size = '" + cup_size + "'and cup_choice = '" + cup_choice + "' " ;
		
		return null;
	}
}
