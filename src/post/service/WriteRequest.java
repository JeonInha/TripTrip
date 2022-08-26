package post.service;
import java.io.Writer;

import post.model.Post;
import user.model.UserAccount;

public class WriteRequest {
	
	private int postNum;
	private UserAccount writer;
	private String title;
	private String content;
	
	public WriteRequest(UserAccount writer, String title, String content) {
		super();
		this.setWriter(writer);
		this.title = title;
		this.content = content;
	}
	
	public WriteRequest(int postNum, UserAccount writer, String title, String content) {
		super();
		this.postNum = postNum;
		this.setWriter(writer);
		this.title = title;
		this.content = content;
	}


	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public UserAccount getWriter() {
		return writer;
	}

	public void setWriter(UserAccount writer) {
		this.writer = writer;
	}
	
}
