package post.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import location.model.PlanLocation;
import location.service.LocationOperationService;
import mvc.command.CommandHandler;
import post.service.PostContentsNotFoundException;
import post.service.PostData;
import post.service.PostNotFoundException;
import post.service.ReadPostService;

public class ReadPostHandler implements CommandHandler {

	private ReadPostService readService = new ReadPostService();
	private LocationOperationService lo = new LocationOperationService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("여기에 값이 안담겼을껄?" + (String)req.getParameter("id"));
		String noVal = req.getParameter("id");
		int postNum = Integer.parseInt(noVal);
		try {
			PostData postData = readService.getPost(postNum, true);
			List<PlanLocation> plan = lo.printPlaceInPlan(postNum);
			req.setAttribute("postData", postData);
			req.setAttribute("planList", plan);
			return "/WEB-INF/view/readPost.jsp";
		} catch (PostNotFoundException | PostContentsNotFoundException e) {
			req.getServletContext().log("no post", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
