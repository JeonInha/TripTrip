package user.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import user.model.UserAccount;
import user.service.SignUpService;
import util.UserSignUpVaildator;

public class signUpHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/WEB-INF/view/signUpForm.jsp";
	private SignUpService ss = new SignUpService();
	private UserSignUpVaildator uv = new UserSignUpVaildator();

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
	
	// 회원가입 버튼
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		String confirmpw = req.getParameter("confirmpw");
		
		Map<String, Boolean> errors = new HashMap<>();
		uv.vaildate(errors, id, pw, name, confirmpw);
		
		if (! errors.isEmpty()) {
			req.setAttribute("errors", errors);
			return FORM_VIEW;
		}
		
		ss.signUp(new UserAccount(id, name, pw));
		return "/";
	}

	// 회원가입하러 가기
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

}
