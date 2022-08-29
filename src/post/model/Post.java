package post.model;

import user.model.UserAccount;

public class Post {
	
	private int post_id;
	private String title;
	private Integer contents_number;
	private UserAccount writer;
	
	public Post(String title, Integer contents_number, UserAccount writer) {
		super();
		this.title = title;
		this.contents_number = contents_number;
		this.setWriter(writer);
	}
	
	public Post(int post_id, String title, Integer contents_number, UserAccount writer) {
		super();
		this.setPost_id(post_id);
		this.title = title;
		this.contents_number = contents_number;
		this.setWriter(writer);
	}
	
	public Post(int post_id, String title, UserAccount writer) {
		super();
		this.setPost_id(post_id);
		this.title = title;
		this.setWriter(writer);
	}
	
	public Post(String title, UserAccount writer) {
		super();
		this.setPost_id(post_id);
		this.title = title;
		this.setWriter(writer);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getContents_number() {
		return contents_number;
	}
	
	public void setContents_number(Integer contents_number) {
		this.contents_number = contents_number;
	}
	
	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public UserAccount getWriter() {
		return writer;
	}

	public void setWriter(UserAccount writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return String.format("[id: %d][title: %s][contentNum: %d]", post_id, title, contents_number) + writer;
	}
	
	

}