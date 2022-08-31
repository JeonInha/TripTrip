package post.model;

import user.model.UserAccount;

public class Post {
	
	private int post_id;
	private String title;
	private Integer contents_number;
	private UserAccount writer;
	private int like_count;
	
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
	
	// 좋아요 카운트 추가
	public Post(int post_id, String title, UserAccount writer, int like_count) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.writer = writer;
		this.like_count = like_count;
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

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", title=" + title + ", contents_number=" + contents_number + ", writer="
				+ writer + ", like_count=" + like_count + "]";
	}


}