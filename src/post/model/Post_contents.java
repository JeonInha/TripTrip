package post.model;

public class Post_contents {
	private Integer number;
	private String contents;
	
	public Post_contents(Integer number, String contents) {
		super();
		this.number = number;
		this.contents = contents;
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
}
