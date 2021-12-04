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

import yuhan.kiosk.member.service.MemberJoinService;
import yuhan.kiosk.member.service.MemberLoginService;
import yuhan.kiosk.mvc.util.ConstantTemplate;
import yuhan.kiosk.mvc.util.IKioskService;
import yuhan.kiosk.mvc.util.IKioskServiceString;

@Controller
public class MemberController {

	IKioskService service = null; //인터페이스 선언
	IKioskServiceString service_string = null;
	
	public JdbcTemplate template; //모든 객체에서 이용할 수 있게 템플릿 선언
	
	@Autowired //객체를 자동으로 이용
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
		//모든 클래스에서 사용
		ConstantTemplate.template = this.template; //this.template을 ConstantTemplate.template에 넣어서 사용하겠다(메모리에 상주해서 사용)
	}
	
	@RequestMapping("/login")
	public String login_view() {
		
		return "login";
	}

	@RequestMapping(value="/login.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST) //iframe에서 작동중
	public @ResponseBody String login(Model model, HttpServletRequest request, HttpSession session ) { //@ResponseBody  : return 값 마크업으로 사용, alert 사용하기위해 작성
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		if(id == "") { //null 체크
			return "<script>parent.alert('아이디를 입력해주세요.');</script>"; //if   rame은 자식요소, 부모한테 결과(alert) 넘김
		}
		if(password == "") {
			return "<script>parent.alert('패스워드를 입력해주세요.');</script>"; 
		}
			
		model.addAttribute("request", request); //menu.seq
		
		service_string = new MemberLoginService();
		String check = service_string.execute(model);
		
		if(check == "") { 
			return "<script>parent.alert('아이디 또는 패스워드가 틀렸습니다.');</script>";
		}
		else {
			session.setAttribute("id", check);
		}
		
		//return "redirect:main"; //login.do 아닌 main.jsp로 그냥 main하면 url은 login.do 화면은 main
		return "<script>parent.location.href='/project/main';</script>"; //@ResponseBody 사용하면 마크업으로 이동
	}
	
	@RequestMapping("join")
	public String join_view() {
		
		return "join";
	}
	
	@RequestMapping(value="/join.do", produces = "text/html; charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody String join(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String tel = request.getParameter("tel");
		
		if(id == "") { //null 체크
			return "<script>parent.alert('아이디를 입력해주세요.');</script>";
		}
		if(password == "") {
			return "<script>parent.alert('패스워드를 입력해주세요.');</script>"; 
		}
		if(tel == "") {
			return "<script>parent.alert('전화번호를 입력해주세요.');</script>"; 
		}
		
		model.addAttribute("request", request); //menu.seq
		
		service_string = new MemberJoinService();
		String check = service_string.execute(model);
		
		if(check == "아이디중복") {
			return "<script>parent.alert('사용할 수 없는 아이디입니다.');</script>";
		}
		
		return "<script>parent.alert('회원가입 되었습니다!'); parent.location.href='/project/login'; </script>";
	}
	
	@RequestMapping(value="/logout", produces = "text/html; charset=UTF-8")
	public @ResponseBody String logout(HttpSession session) {
		session.invalidate();
		
		return "<script>alert('로그아웃 되었습니다.'); location.href='/project/login'; </script>";
	}
}
