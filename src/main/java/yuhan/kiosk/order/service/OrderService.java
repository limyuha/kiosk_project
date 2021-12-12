package yuhan.kiosk.order.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.kiosk.dao.OrderDao;
import yuhan.kiosk.mvc.util.IKioskServiceString;

public class OrderService implements IKioskServiceString {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
	
		String member_seq = request.getParameter("member_seq");
		String sum = request.getParameter("sum");

		OrderDao dao = new OrderDao();
		String check = dao.Order(member_seq, sum);
		
		return check;
	}
}
