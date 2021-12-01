package yuhan.kiosk.project;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

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
	
	IMenuService service = null; // �������̽� ����
	public JdbcTemplate template; //��� ��ü���� ����� �� �ְ� ���ø� ����
	
	@Autowired //��ü�� �ڵ����� �̿�
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		//��� Ŭ�������� ���
		ConstantTemplate.template = this.template; //this.template�� ConstantTemplate.template�� �־ ����ϰڴ�(�޸𸮿� �����ؼ� ���)
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		service = new MenuListService();
		service.execute(model);
		
		return "main";
	}
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		model.addAttribute("request", request);
		
		String target = "";
		if(request.getParameter("target") == null) { 
			target = "menu";
		} else {
			target = request.getParameter("target");
		}
		
		service = new MenuListService();
		service.execute(model);
		
		String expage = "main";

		return expage;
	}

}
