package yuhan.kiosk.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.kiosk.dao.MemberDao;
import yuhan.kiosk.mvc.util.IKioskServiceString;

public class MemberJoinService implements IKioskServiceString {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String tel = request.getParameter("tel");
		
		MemberDao dao = new MemberDao();
		String check = dao.MemberJoin(id, password, tel);
		
		return check;
	}

}
