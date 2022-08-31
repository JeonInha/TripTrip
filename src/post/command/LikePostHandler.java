package post.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

public class LikePostHandler implements CommandHandler{
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("요청받은 아이디 값은 ??" + (String)req.getParameter("user_id"));
		System.out.println("요청받은 포스트 번호 값은 ??" + (String)req.getParameter("location_post_number"));
		return null;
	}
	
}
