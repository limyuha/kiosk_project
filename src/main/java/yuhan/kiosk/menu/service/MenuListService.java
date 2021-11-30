package yuhan.kiosk.menu.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import yuhan.kiosk.menu.dao.MenuDao;
import yuhan.kiosk.menu.dto.MenuDto;

public class MenuListService implements IMenuService {

	@Override
	public void execute(Model model) {
		
		MenuDao dao = new MenuDao();
		ArrayList<MenuDto> dtos = dao.main_menulist();
		
		model.addAttribute("menulist", dtos);
	}
}
