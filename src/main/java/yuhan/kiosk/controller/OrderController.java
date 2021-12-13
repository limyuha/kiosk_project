package yuhan.kiosk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yuhan.kiosk.mvc.util.ConstantTemplate;
import yuhan.kiosk.mvc.util.IKioskService;
import yuhan.kiosk.mvc.util.IKioskServiceString;
import yuhan.kiosk.order.service.OrderBtnService;
import yuhan.kiosk.order.service.OrderService;
import yuhan.kiosk.order.service.OrderViewService;

@Controller
public class OrderController {
	
	IKioskService service = null;
	IKioskServiceString service_string = null;
	
	public JdbcTemplate template;
	
	@Autowired //객체를 자동으로 이용
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		//모든 클래스에서 사용
		ConstantTemplate.template = this.template;
	}
	
	@RequestMapping(value="/order_btn", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public @ResponseBody String order_btn(Model model, HttpServletRequest request) {
		
		model.addAttribute("request", request); 
		
		service = new OrderBtnService();
		service.execute(model);
		
		return "";
	}

	@RequestMapping(value="/order", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public @ResponseBody String cart_all_delete(Model model, HttpServletRequest request) {

		model.addAttribute("request", request); //member_seq
		
		service_string = new OrderService();
		String check = service_string.execute(model);
		
		if(check == "검색 값이 없다") {
			return "<script>parent.alert('장바구니가 비었습니다.\\n상품을 장바구니에 담고 주문해주세요!');</script>";
		} else {
			return "<script>parent.alert('주문이 완료되었습니다.\\n결제는 카운터에서 해주세요.'); parent.location.reload();</script>";
		}
	}
	
	@RequestMapping("/kiosk_order")
	public String order_view(Model model, HttpServletRequest request) {

		model.addAttribute("request", request); //member_seq
		service = new OrderViewService();
		service.execute(model);
		
		return "kiosk_order";
	}
}
