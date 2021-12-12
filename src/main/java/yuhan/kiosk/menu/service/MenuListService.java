package yuhan.kiosk.menu.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.kiosk.dao.MenuDao;
import yuhan.kiosk.dto.MenuDto;
import yuhan.kiosk.mvc.util.IKioskService;

public class MenuListService implements IKioskService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String target = "";
		
		if(request.getParameter("target") != null) {
			target = request.getParameter("target");
		}
		
		MenuDao dao = new MenuDao();
		ArrayList<MenuDto> dtos = dao.MenuList(target);
		
		/*
		for(int i=0; i<dtos.size(); i++) {		
			ArrayList<MenuDto> dtos = dao.MenuList(dtos.get(i).getName());

			dtos.get(i).setItem(dtos);	
			//System.out.println(dtos.get(i).getItem());
		}
		*/
		
		model.addAttribute("menulist", dtos);
	}
}
