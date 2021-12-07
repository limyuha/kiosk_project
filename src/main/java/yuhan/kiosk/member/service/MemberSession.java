package yuhan.kiosk.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.kiosk.dao.MemberDao;
import yuhan.kiosk.mvc.util.IKioskServiceInt;

public class MemberSession implements IKioskServiceInt {

	@Override
	public int execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberDao dao = new MemberDao();
		int member_seq = dao.MemberSession(id, password);
		
		return member_seq;
	}
}
