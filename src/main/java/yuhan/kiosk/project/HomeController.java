package yuhan.kiosk.project;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yuhan.kiosk.menu.service.IMenuService;
import yuhan.kiosk.menu.service.MenuListService;
import yuhan.kiosk.mvc.util.ConstantTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	IMenuService service = null; // 인터페이스 선언
	public JdbcTemplate template; //모든 객체에서 사용할 수 있게 템플릿 선언
	
	@Autowired //객체를 자동으로 이용
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		//모든 클래스에서 사용
		ConstantTemplate.template = this.template; //this.template을 ConstantTemplate.template에 넣어서 사용하겠다(메모리에 상주해서 사용)
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		service = new MenuListService();
		service.execute(model);
		
		return "main";
	}

}
