package post.model;

public class Post {
	private String title;
	private Integer contents_number;
	private String user_id;
	
	public Post(String title, Integer contents_number, String user_id) {
		super();
		this.title = title;
		this.contents_number = contents_number;
		this.user_id = user_id;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Post [title=" + title + ", contents_number=" + contents_number + ", user_id=" + user_id + "]";
	}
}