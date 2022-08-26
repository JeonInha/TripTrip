package post.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import post.service.WrtieArticleService;

///////////// 일단 먼저 해야하는게 있음 지금 ........... 하 ................
//////// 뭐해야하냐면 .... 리스트 보여주고 컬렉션 선택하는거 .... 
public class UpdatePostHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/WEB-INF/view/newArticleForm.jsp";
	private WrtieArticleService ws = new WrtieArticleService();
	
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

}
