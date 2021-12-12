package yuhan.kiosk.order.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import yuhan.kiosk.dao.OrderDao;
import yuhan.kiosk.dto.OrderDto;
import yuhan.kiosk.dto.OrderSubDto;
import yuhan.kiosk.mvc.util.IKioskService;

public class OrderViewService implements IKioskService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
	
		String member_seq = request.getParameter("member_seq");

		OrderDao dao = new OrderDao();
		ArrayList<OrderDto> order_dto = dao.OrderView(member_seq);
		
		for(int i=0; i<order_dto.size(); i++) {		
			ArrayList<OrderSubDto> order_sub_dto = dao.OrderDetailView(order_dto.get(i).getSeq());
			order_dto.get(i).setOrderitem(order_sub_dto);	
			
			//System.out.println(dtos.get(i).getItem());
		}
		
		model.addAttribute("order_list", order_dto);
	}

}
