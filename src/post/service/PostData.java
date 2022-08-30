package post.service;

import post.model.Post;
import post.model.Post_contents;

public class PostData {
	private Post post;
	private Post_contents contents;
	public PostData(Post post, Post_contents contents) {
		super();
		this.post = post;
		this.contents = contents;
	}
	public Post getPost() {
		return post;
	}
	public Post_contents getContents() {
		return contents;
	}
	
}
