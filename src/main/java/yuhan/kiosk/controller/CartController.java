package yuhan.kiosk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yuhan.kiosk.cart.service.CartInsertService;
import yuhan.kiosk.mvc.util.ConstantTemplate;
import yuhan.kiosk.mvc.util.IKioskService;
import yuhan.kiosk.mvc.util.IKioskServiceString;

@Controller
public class CartController {
	
	IKioskService service = null; //인터페이스 선언
	IKioskServiceString service_string = null;
	
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
		
		return null;
	}
}
