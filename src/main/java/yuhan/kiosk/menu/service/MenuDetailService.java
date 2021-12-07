package yuhan.kiosk.menu.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.kiosk.dao.ListFormDto;
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
		
		ArrayList<ListFormDto> cup_size = dao.CupSize();
		ArrayList<ListFormDto> cup_choice = dao.CupChoice();
		
		model.addAttribute("menu_detail", dto);
		model.addAttribute("cup_size", cup_size);
		model.addAttribute("cup_choice", cup_choice);
	}

}
