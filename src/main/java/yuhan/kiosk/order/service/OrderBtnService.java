package yuhan.kiosk.order.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.kiosk.dao.OrderDao;
import yuhan.kiosk.mvc.util.IKioskService;

public class OrderBtnService implements IKioskService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
	
		String member_seq = request.getParameter("member_seq");
		String menu_seq = request.getParameter("menu_seq");
		String cup_size = request.getParameter("cup_size");
		String cup_choice = request.getParameter("cup_choice");

		OrderDao dao = new OrderDao();
		dao.OrderBtn(member_seq, menu_seq, cup_size, cup_choice);

	}
}
