package day05三层构架备份.entity;

import java.util.Date;

public class DakaInfo {
	private int id;// employee  id
	private Date qdtime;
	private Date qttime;
	
	public DakaInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DakaInfo(int id, Date qdtime, Date qttime) {
		super();
		this.id = id;
		this.qdtime = qdtime;
		this.qttime = qttime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getQdtime() {
		return qdtime;
	}

	public void setQdtime(Date qdtime) {
		this.qdtime = qdtime;
	}

	public Date getQttime() {
		return qttime;
	}

	public void setQttime(Date qttime) {
		this.qttime = qttime;
	}

	@Override
	public String toString() {
		return "DakaInfo [id=" + id + ", qdtime=" + qdtime + ", qttime=" + qttime + "]";
	}
		
}
