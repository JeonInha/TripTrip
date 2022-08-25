package user.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import user.model.UserAccount;
import user.service.LoginFailExcepion;
import user.service.LoginService;

public class LoginHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/loginForm.jsp";
	private LoginService ls = new LoginService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String id = trim(req.getParameter("id"));
		String pw = trim(req.getParameter("pw"));
		HttpSession session = req.getSession();
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if (id == null || id.isEmpty()) {
			errors.put("id", true);
		}
		if (pw == null || pw.isEmpty()) {
			errors.put("pw", true);
		}
		if (! errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
		UserAccount user = ls.login(id, pw);
		session.setAttribute("LoginUser", user);
		res.sendRedirect(req.getContextPath() + "/index.jsp");
		return null;
		
		} catch (LoginFailExcepion e) {
			errors.put("notMatch", true);
			return FORM_VIEW;
		}	
	}

	private String trim(String str) {
		return str == null ? null:str.trim();
	}


}
