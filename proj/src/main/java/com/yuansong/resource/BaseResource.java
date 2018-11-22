package com.yuansong.resource;

import com.yuansong.common.CommonFun;
import com.yuansong.form.BaseAddForm;

public abstract class BaseResource {
	
	//资源ID
	private String id;
	//名称
	private String name;
	//描述
	private String description;
	
	public BaseResource() {
		
	}
	
	public BaseResource(BaseAddForm form) {
		this.setId(CommonFun.UUID());
		this.setName(form.getName());
		this.setDescription(form.getDescription());
	}
	
	public String check() {
		StringBuilder sb = new StringBuilder();
		if(this.id == null || this.id.equals("")) {
			sb.append("ID不允许为空；");
		}
		if(this.name == null || this.name.equals("")) {
			sb.append("名称不允许为空；");
		}
		return sb.toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
