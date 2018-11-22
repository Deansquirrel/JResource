package com.yuansong.resource;

import com.yuansong.form.RdsDbAdd;

public class RdsDbResource extends DbResource {
	
	private String rdsId;
	
	public RdsDbResource() {
		super();
	}
	
	public RdsDbResource(RdsDbAdd form) {
		super(form);
		this.setDbName(form.getDbName());
		this.setDbUser(form.getDbUser());
		this.setDbPwd(form.getDbPwd());
		this.rdsId = form.getRdsId();
	}
	
	@Override
	public String check() {
		StringBuilder sb = new StringBuilder(super.check());
		if(this.getDbName() == null || this.getDbName().equals("")) {
			sb.append("数据库名称不允许为空；");
		}
		if(this.getDbUser() == null || this.getDbUser().equals("")) {
			sb.append("数据库登录名不允许为空；");
		}
		if(this.getRdsId() == null || this.getRdsId().equals("")) {
			sb.append("所在RDS不允许为空；");
		}
		return sb.toString();
	}

//	public RdsResource getRdsResource() {
//		return rdsResource;
//	}
//
//	public void setRdsResource(RdsResource rdsResource) {
//		this.rdsResource = rdsResource;
//	}

	public String getRdsId() {
		return rdsId;
	}

	public void setRdsId(String rdsId) {
		this.rdsId = rdsId;
	}

}
