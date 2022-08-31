package location.model;

public class Location {
	
	private int id;
	private String name;
	private double x;
	private double y;
	private String placeURL;
	private int kkoID;
	
	public Location(String name, double x, double y, String placeURL, int kkoID) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.placeURL = placeURL;
		this.kkoID = kkoID;
	}
	
	public Location(int id, String name, double x, double y, String placeURL, int kkoID) {
		super();
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y;
		this.placeURL = placeURL;
		this.kkoID = kkoID;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getPlaceURL() {
		return placeURL;
	}
	public void setPlaceURL(String placeURL) {
		this.placeURL = placeURL;
	}
	public int getKkoID() {
		return kkoID;
	}
	public void setKkoID(int kkoID) {
		this.kkoID = kkoID;
	}

	@Override
	public String toString() {
		return "Location [name=" + name + ", x=" + x + ", y=" + y + ", placeURL=" + placeURL + "]";
	}
	
}
