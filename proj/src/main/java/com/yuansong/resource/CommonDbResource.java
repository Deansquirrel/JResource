package com.yuansong.resource;

import com.yuansong.common.CommonFun;
import com.yuansong.form.CommonDbAdd;

public class CommonDbResource extends DbResource {
	
	private String address;
	private int port;
	
	public CommonDbResource() {
		super();
	}
	
	public CommonDbResource(CommonDbAdd form) {
		super();
		this.setId(CommonFun.UUID());
		this.setName(form.getName());
		this.setDescription(form.getDescription());
		this.setDbName(form.getDbName());
		this.setDbUser(form.getDbUser());
		this.setDbPwd(form.getDbPwd());
		this.setAddress(form.getAddress());
		this.setPort(form.getPort());		
	}
	
	@Override
	public String check() {
		StringBuilder sb = new StringBuilder(super.check());
		if(this.getDbName() == null ||this.getDbName().equals("")) {
			sb.append("数据库名称不允许为空");
		}
		if(this.getDbUser() == null || this.getDbUser().equals("")) {
			sb.append("登录名不允许为空");
		}
		if(this.getAddress() == null || this.getAddress().equals("")) {
			sb.append("地址不允许为空");
		}
		
		return sb.toString();
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

}
