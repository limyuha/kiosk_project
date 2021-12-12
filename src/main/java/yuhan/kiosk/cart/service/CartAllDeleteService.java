package yuhan.kiosk.cart.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.kiosk.dao.CartDao;
import yuhan.kiosk.mvc.util.IKioskService;

public class CartAllDeleteService implements IKioskService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String member_seq = request.getParameter("member_seq");

		CartDao dao = new CartDao();
		dao.CartAllDelete(member_seq);
	}
}
