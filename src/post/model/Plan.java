package post.model;

import java.util.HashMap;
import java.util.Map;

import location.model.Location;

public class Plan {
	
	private String title;
	Map<Integer, Location> locaList = new HashMap<>();
	
	public Plan(String title, Map<Integer, Location> locaList) {
		super();
		this.title = title;
		this.locaList = locaList;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Map<Integer, Location> getLocaList() {
		return locaList;
	}
	public void setLocaList(Map<Integer, Location> locaList) {
		this.locaList = locaList;
	}
	
}
