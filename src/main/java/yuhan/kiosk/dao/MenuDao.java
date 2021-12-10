package yuhan.kiosk.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import yuhan.kiosk.dto.MenuDto;
import yuhan.kiosk.mvc.util.ConstantTemplate;

public class MenuDao {
	JdbcTemplate template;
	//DataSource dataSource;
	
	public MenuDao() {
		
		this.template = ConstantTemplate.template; //CONSTNA ������ Template�� ����� ������
	}
	
	public ArrayList<MenuDto> MenuList(String target) {
		
		ArrayList<MenuDto> dtos = null;
		
		String sql = "select menu.seq, menu.name, menu.price, menu_img.img_url from menu, menu_img where menu.seq = menu_img.menu_seq"; //target값 없으면 타게끔
		
		//String target = "";
		//String sql = "select * from menu";
		
		if(target.equals("coffee_menu")) { // == 은 주소값(자료의 위치값) 비교, equals는 객체끼리 내용 비교
			sql = "select menu.seq, menu.name, menu.price, menu_img.img_url from menu, menu_img where menu.category = 1 and menu.seq = menu_img.menu_seq";
		} else if (target.equals("non_coffee_menu")) {
			sql = "select menu.seq, menu.name, menu.price, menu_img.img_url from menu, menu_img where menu.category = 2 and menu.seq = menu_img.menu_seq";
		} else if (target.equals("dessert_menu")) {
			sql = "select menu.seq, menu.name, menu.price, menu_img.img_url from menu, menu_img where menu.category = 3 and menu.seq = menu_img.menu_seq";
		}

		dtos = (ArrayList<MenuDto>) template.query(sql, new BeanPropertyRowMapper<MenuDto>(MenuDto.class));
		return dtos;
	}

	public MenuDto MenuDetail(final String menu_seq) {
		
		String sql = "select name, price, provid, saturated_fat, protein, sodium, sugar, caffeine, allergy, context, menu_img.img_url from menu, menu_img where menu.seq = menu_img.menu_seq and menu.seq = " + menu_seq;
				
		MenuDto dto = (MenuDto) this.template.queryForObject(sql, 
									new BeanPropertyRowMapper<MenuDto>(MenuDto.class));
		
		return dto;
	}	
	
	public ArrayList<ListFormDto> CupSize() {
		
		//String sql = "select seq, name, value from list_form WHERE name = " + "cup_size";
		String sql = "select seq, name, value from list_form WHERE name = '" + "cup_size" + "'";
		
		ArrayList<ListFormDto> dtos = (ArrayList<ListFormDto>) template.query(sql, new BeanPropertyRowMapper<ListFormDto>(ListFormDto.class));
		return dtos;
	}
	
	public ArrayList<ListFormDto> CupChoice() {
		
		//String sql = "select seq, name, value from list_form WHERE name = " + "cup_choice";
		String sql = "select seq, name, value from list_form WHERE name = '" + "cup_choice" + "'";
		
		ArrayList<ListFormDto> dtos = (ArrayList<ListFormDto>) template.query(sql, new BeanPropertyRowMapper<ListFormDto>(ListFormDto.class));
		return dtos;
	}
}
