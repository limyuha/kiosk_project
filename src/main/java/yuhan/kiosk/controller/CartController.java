package yuhan.kiosk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yuhan.kiosk.cart.service.CartAllDeleteService;
import yuhan.kiosk.cart.service.CartDeleteService;
import yuhan.kiosk.cart.service.CartDetailService;
import yuhan.kiosk.cart.service.CartInsertService;
import yuhan.kiosk.cart.service.EaUpDownService;
import yuhan.kiosk.mvc.util.ConstantTemplate;
import yuhan.kiosk.mvc.util.IKioskService;
import yuhan.kiosk.mvc.util.IKioskServiceInt;
import yuhan.kiosk.mvc.util.IKioskServiceString;

@Controller
public class CartController {
	
	IKioskService service = null; //인터페이스 선언
	IKioskServiceString service_string = null;
	IKioskServiceInt service_int = null;
	
	public JdbcTemplate template; //모든 객체에서 이용할 수 있게 템플릿 선언
	
	@Autowired //객체를 자동으로 이용
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		//모든 클래스에서 사용
		ConstantTemplate.template = this.template; //this.template을 ConstantTemplate.template에 넣어서 사용하겠다(메모리에 상주해서 사용)
	}
	
	@RequestMapping(value="/cart.do", produces = "text/html; charset=UTF-8")
	public @ResponseBody String cart_insert(Model model, HttpServletRequest request, HttpSession session) {
		if((String)session.getAttribute("id") == null) {
			return "<script>"
					+ " if(confirm('이 서비스는 회원전용으로 제공됩니다.\\n로그인 하시겠습니까?')) {"
					+ "		parent.location.href='/project/login'; "
					+ " } "
					+ "</script>";
		} 
		//"<script>parent.confirm('이 서비스는 회원전용으로 제공됩니다.\n로그인 하시겠습니까?');"
		//history.back();
		
		model.addAttribute("request", request); //id(session), menu_seq, cup_size, cup_choice
		
		service_string = new CartInsertService();
		String check = service_string.execute(model);
		
		if(check == "수량 추가") {
			return "<script>parent.alert('수량이 추가되었습니다.');</script>";
		} else {
			return "<script>parent.alert('장바구니에 추가되었습니다');</script>";
		}
		
	}
	
	@RequestMapping("/cart")
	public String cart_view(Model model, HttpServletRequest request) {
		
		model.addAttribute("request", request); //member_seq
		
		service = new CartDetailService();
		service.execute(model);
		
		return "cart";
	}
	
	@RequestMapping(value="/updwon", method = RequestMethod.POST, produces = "text/html; charset=UTF-8") //ajax 사용하려면 @ResponseBody 필요
	public @ResponseBody String ea_updown(Model model, HttpServletRequest request) {

		model.addAttribute("request", request); //cart_seq, ea
		
		service = new EaUpDownService();
		service.execute(model);
		
		return "수량 변경";
	}
	
	@RequestMapping(value="/cart_delete", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public @ResponseBody String cart_delete(Model model, HttpServletRequest request) {
		
		model.addAttribute("request", request); //member_seq
		
		service = new CartDeleteService();
		service.execute(model);
		
		return "<script>parent.alert('장바구니에서 삭제되었습니다.'); parent.location.reload();</script>";
	}
	
	@RequestMapping(value="/cart_all_delete", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public @ResponseBody String cart_all_delete(Model model, HttpServletRequest request) {
		model.addAttribute("request", request); //member_seq
		
		service = new CartAllDeleteService();
		service.execute(model);
		
		return "<script>parent.alert('장바구니를 비웠습니다.'); parent.location.reload();</script>";
	}
}
