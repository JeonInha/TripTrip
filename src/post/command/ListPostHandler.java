package post.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import post.service.ListPostService;
import post.service.PostPage;

public class ListPostHandler implements CommandHandler {
	private ListPostService listService = new ListPostService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		System.out.println("결쿡 페이지 no = " + pageNo);
		PostPage postPage = listService.getPostPage(pageNo);
		req.setAttribute("postPage", postPage);
		return "/WEB-INF/view/listPost.jsp";
	}
	
	
}
