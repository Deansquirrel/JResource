package com.yuansong.resource;

import com.yuansong.common.CommonFun;
import com.yuansong.form.ExceptionLessAdd;

public class ExceptionlessResource extends BaseResource {
	
	private String url;
	private String loginName;
	private String loginPwd;
	
	public ExceptionlessResource() {
		super();
	}
	
	public ExceptionlessResource(ExceptionLessAdd form) {
		super();
		this.setId(CommonFun.UUID());
		this.setName(form.getName());
		this.setDescription(form.getDescription());
		this.setUrl(form.getUrl());
		this.setLoginName(form.getLoginName());
		this.setLoginPwd(form.getLoginPwd());
	}
	
	public String check() {
		StringBuilder sb = new StringBuilder();
		if(this.getId() == null || this.getId().equals("")) {
			sb.append("ID不允许为空；");
		}
		if(this.getName() == null || this.getName().equals("")) {
			sb.append("名称不允许为空；");
		}
		if(this.getUrl() == null || this.getUrl().equals("")) {
			sb.append("URL不允许为空；");
		}
		if(this.getLoginName() == null || this.getLoginName().equals("")) {
			sb.append("登录名不允许为空；");
		}
		return sb.toString();
	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

}
