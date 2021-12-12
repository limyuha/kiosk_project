package yuhan.kiosk.cart.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import yuhan.kiosk.dao.CartDao;
import yuhan.kiosk.mvc.util.IKioskService;

public class CartDeleteService implements IKioskService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String cart_seq = request.getParameter("cart_seq");

		CartDao dao = new CartDao();
		dao.CartDelete(cart_seq);
	}

}
