package post.model;

public class Post {
	
	private int post_id;
	private String title;
	private Integer contents_number;
	private Writer writer;
	
	public Post(String title, Integer contents_number, Writer writer) {
		super();
		this.title = title;
		this.contents_number = contents_number;
		this.setWriter(writer);
	}
	
	public Post(int post_id, String title, Integer contents_number, Writer writer) {
		super();
		this.setPost_id(post_id);
		this.title = title;
		this.contents_number = contents_number;
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

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}
}