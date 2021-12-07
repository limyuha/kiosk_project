package yuhan.kiosk.cart.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import yuhan.kiosk.dao.CartDao;
import yuhan.kiosk.dao.MemberDao;
import yuhan.kiosk.mvc.util.IKioskServiceString;

public class CartInsertService implements IKioskServiceString {

	@Override
	public String execute(Model model) {
		//HttpSession session = null;
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String member_seq = request.getParameter("member_seq");
		String menu_seq = request.getParameter("menu_seq");
		String cup_size = request.getParameter("cup_size");
		String cup_choice = request.getParameter("cup_choice");
		
		CartDao dao = new CartDao();
		String check = dao.CartInsert(member_seq, menu_seq, cup_size, cup_choice);
		
		return check;
	}

}
