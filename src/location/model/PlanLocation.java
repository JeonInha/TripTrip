package location.model;

import java.sql.Date;
import java.time.LocalDate;

public class PlanLocation {
	private Location location;
	private int orderby;
	private Date plandate;
	private String userMemo;
	
	public PlanLocation(Location location, int orderby, Date plandate, String userMemo) {
		super();
		this.location = location;
		this.orderby = orderby;
		this.plandate = plandate;
		this.userMemo = userMemo;
	}
	
	public PlanLocation(Location location, int orderby) {
		super();
		this.location = location;
		this.orderby = orderby;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getOrderby() {
		return orderby;
	}
	public void setOrderby(int orderby) {
		this.orderby = orderby;
	}
	
	public String getUserMemo() {
		return userMemo;
	}
	public void setUserMemo(String userMemo) {
		this.userMemo = userMemo;
	}
	
	public void setPlandate(Date plandate) {
		this.plandate = plandate;
	}

	public Date getPlandate() {
		return plandate;
	}

	public void memo(Date plandate) {
		this.plandate = plandate;
	}

	@Override
	public String toString() {
		return "PlanLocation [location=" + location + ", orderby=" + orderby + ", plandate=" + plandate + ", userMemo="
				+ userMemo + "]";
	}
}
