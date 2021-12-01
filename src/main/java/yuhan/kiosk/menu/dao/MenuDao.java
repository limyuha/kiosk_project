package yuhan.kiosk.menu.dao;

import java.util.ArrayList;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import yuhan.kiosk.menu.dto.MenuDto;
import yuhan.kiosk.mvc.util.ConstantTemplate;

public class MenuDao {
	JdbcTemplate template;
	DataSource dataSource;
	
	public MenuDao() {
		
		this.template = ConstantTemplate.template; //CONSTNA ������ Template�� ����� ������
	}
	
	public ArrayList<MenuDto> main_menulist(String target) {
		ArrayList<MenuDto> dtos = null;
		
		String sql = "select menu.name, menu.price, menu_img.img from menu, menu_img where menu.seq = menu_img.menu_seq"; //target값 없으면 타게끔
		
		//String target = "";
		//String sql = "select * from menu";
		
		
		if(target.equals("coffee_menu")) { // == 은 주소값(자료의 위치값) 비교, equals는 객체끼리 내용 비교
			sql = "select menu.name, menu.price, menu_img.img from menu, menu_img where menu.category = 1 and menu.seq = menu_img.menu_seq";
		}
		
		dtos = (ArrayList<MenuDto>) template.query(sql, new BeanPropertyRowMapper<MenuDto>(MenuDto.class));
		return dtos;
	}
}
