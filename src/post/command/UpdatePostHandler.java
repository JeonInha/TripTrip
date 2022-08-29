package post.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import post.model.Post;
import post.service.ReadPostByPostNumService;
import post.service.WriteRequest;
import post.service.WrtieArticleService;
import user.model.UserAccount;

public class UpdatePostHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/WEB-INF/view/newPost.jsp";
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
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		UserAccount userAccount = (UserAccount)req.getSession(false).getAttribute("loginUser");
		WriteRequest writeReq = createWriteRequest(userAccount, req);
		System.out.println("wrtieReq 값 확인 포스트 번호" + writeReq.getPostNum() + "제목" + writeReq.getTitle());
		writeReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		// 값 심기 //////////
//		writeReq.setPostNum(postNum);
		
		int newPostNo = ws.writeAddPlan(writeReq);
		req.setAttribute("newPostNo", newPostNo);
		
		return "/WEB-INF/view/newPostSuccess.jsp";
	}
	
	private WriteRequest createWriteRequest(UserAccount userAccount, HttpServletRequest req) {
		return new WriteRequest(Integer.valueOf(req.getParameter("postnum")), new UserAccount(userAccount.getId(), userAccount.getName()), req.getParameter("title"), req.getParameter("contents"));
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		ReadPostByPostNumService pns = new ReadPostByPostNumService();
		int postid = (int) Integer.valueOf(req.getParameter("plan"));
		Post post = pns.readPostByNum(postid);
		req.setAttribute("post", post);
		
		return FORM_VIEW;
	}
}
