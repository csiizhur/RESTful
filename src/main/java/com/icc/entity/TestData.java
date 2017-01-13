package com.icc.entity;

import java.io.Serializable;

public class TestData implements Serializable{

	private static final long serialVersionUID = -8235325892959829439L;
	
	private int id;
	private String name;
	private String developers;
	private String opentime;
	private String type;
	private String floor;
	private String zhandiarea;
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
	public String getDevelopers() {
		return developers;
	}
	public void setDevelopers(String developers) {
		this.developers = developers;
	}
	public String getOpentime() {
		return opentime;
	}
	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getZhandiarea() {
		return zhandiarea;
	}
	public void setZhandiarea(String zhandiarea) {
		this.zhandiarea = zhandiarea;
	}

}
