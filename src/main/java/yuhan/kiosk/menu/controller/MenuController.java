package yuhan.kiosk.menu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yuhan.kiosk.menu.service.IMenuService;
import yuhan.kiosk.menu.service.MenuListService;
import yuhan.kiosk.mvc.util.ConstantTemplate;

@Controller //컨트롤러 선언
public class MenuController {
	
	IMenuService service = null; //인터페이스 선언
	public JdbcTemplate template; //모든 객체에서 이용할 수 있게 템플릿 선언
	
	@Autowired //객체를 자동으로 이용
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		//모든 클래스에서 사용
		ConstantTemplate.template = this.template; //this.template을 ConstantTemplate.template에 넣어서 사용하겠다(메모리에 상주해서 사용)
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET) //매핑 url
	public String main_menulist(Model model, HttpServletRequest request) { //, HttpServletRequest request 
		//top.jsp url 받음
		model.addAttribute("request", request); //null, coffee_menu, non_coffee_menu, dessert_menu
	
		service = new MenuListService();
		service.execute(model);
		
		/*
		if (target == "menu") {
			expage = "main";
		} else if (target == "coffee_menu") {
			expage = "coffee_menu";
		}
		*/
		//System.out.println(target);
		return "main"; //main.jsp
	}
	
	//@RequestMapping(value="/menu_detail", method = RequestMethod.GET)
	@RequestMapping("/menu_detail")
	public String menu_detail(Model model, HttpServletRequest request) {
		
		model.addAttribute("request", request); //menu.seq
		
		//String seq = request.getParameter("menu_seq");
		//System.out.println(seq);
		
		service = new MenuDetailService();
		service.execute(model);
		
		return "menu_detail";
	}
	
	@RequestMapping("login")
	public String login(Model model) {
		
		//service = new LoginService();
		//service.execute(model);
		
		return "login";
	}

}