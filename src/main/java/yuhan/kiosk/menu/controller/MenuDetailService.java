package yuhan.kiosk.menu.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.kiosk.menu.dao.MenuDao;
import yuhan.kiosk.menu.dto.MenuDto;
import yuhan.kiosk.menu.service.IMenuService;

public class MenuDetailService implements IMenuService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String menu_seq = "";
		
		if(request.getParameter("menu_seq") != null) {
			menu_seq = request.getParameter("menu_seq");
		}
		
		MenuDao dao = new MenuDao();
		MenuDto dto = dao.MenuDetail(menu_seq);
		
		model.addAttribute("menu_detail", dto);
	}

}
