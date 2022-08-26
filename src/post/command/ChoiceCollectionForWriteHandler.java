package post.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import post.model.Post;
import post.service.ReadNoPostedPlanListService;
import user.model.UserAccount;

public class ChoiceCollectionForWriteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ReadNoPostedPlanListService rs = new ReadNoPostedPlanListService();
		
		HttpSession session = req.getSession();
		UserAccount user = (UserAccount) session.getAttribute("loginUser");
		List<Post> planList = rs.readList(user.getId());
		req.setAttribute("planList", planList);
		return "/WEB-INF/view/choiceCollectionForWrite.jsp";
	}

}
