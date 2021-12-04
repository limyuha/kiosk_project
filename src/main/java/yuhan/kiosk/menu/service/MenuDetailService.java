package yuhan.kiosk.menu.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.kiosk.dao.MenuDao;
import yuhan.kiosk.dto.MenuDto;
import yuhan.kiosk.mvc.util.IKioskService;

public class MenuDetailService implements IKioskService {

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
