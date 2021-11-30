package yuhan.kiosk.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import yuhan.kiosk.menu.service.IMenuService;
import yuhan.kiosk.menu.service.MenuListService;
import yuhan.kiosk.mvc.util.ConstantTemplate;

@Controller //��Ʈ�ѷ� ����
public class MenuController {
	
	IMenuService service = null; // �������̽� ����
	public JdbcTemplate template; //��� ��ü���� ����� �� �ְ� ���ø� ����
	
	@Autowired //��ü�� �ڵ����� �̿�
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		//��� Ŭ�������� ���
		ConstantTemplate.template = this.template; //this.template�� ConstantTemplate.template�� �־ ����ϰڴ�(�޸𸮿� �����ؼ� ���)
	}
	
	@RequestMapping("/main") //����
	public String main_menulist(Model model) {
		
		service = new MenuListService();
		service.execute(model);
		
		return "main";
	}
	
	
}