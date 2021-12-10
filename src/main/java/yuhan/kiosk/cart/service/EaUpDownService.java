package yuhan.kiosk.cart.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.kiosk.dao.CartDao;
import yuhan.kiosk.dto.CartDto;
import yuhan.kiosk.mvc.util.IKioskService;

public class EaUpDownService implements IKioskService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String cart_seq = request.getParameter("cart_seq");
		String ea = request.getParameter("ea");
		
		CartDao dao = new CartDao();
		dao.EaInsert(cart_seq, ea);
	}
}
