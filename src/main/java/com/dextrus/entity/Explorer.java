package com.dextrus.entity;

import java.util.ArrayList;
import java.util.List;

public class Explorer {

	private int id;
	private String name;
	private String type;
	private Integer parentId;
	private List<Explorer> children = new ArrayList<>();
	

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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public List<Explorer> getChildren() {
		return children;
	}
	public void setChildren(List<Explorer> children) {
		this.children = children;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	
	
}
