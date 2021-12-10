package yuhan.kiosk.cart.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.kiosk.dao.CartDao;
import yuhan.kiosk.dto.MenuCartDto;
import yuhan.kiosk.mvc.util.IKioskService;

public class CartDetailService implements IKioskService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String member_seq = request.getParameter("member_seq");

		CartDao dao = new CartDao();
		ArrayList<MenuCartDto> dtos = dao.CartDetail(member_seq);
		
		model.addAttribute("cart", dtos);
	}
}
