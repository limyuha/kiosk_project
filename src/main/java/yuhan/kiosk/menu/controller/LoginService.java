package yuhan.kiosk.menu.controller;

import org.springframework.ui.Model;

import yuhan.kiosk.menu.dao.MenuDao;
import yuhan.kiosk.menu.dto.MenuDto;
import yuhan.kiosk.menu.service.IMenuService;

public class LoginService implements IMenuService {

	@Override
	public void execute(Model model) {
		
		MenuDao dao = new MenuDao();
		MenuDto dto = new MenuDto();
	}

}
