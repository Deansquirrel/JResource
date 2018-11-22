package com.yuansong.resource;

import com.yuansong.form.BaseAddForm;

public abstract class DbResource extends BaseResource {
	
	private String dbName;
	private String dbUser;
	private String dbPwd;
	
	public DbResource() {
		super();
	}
	
	public DbResource(BaseAddForm form) {
		super(form);
	}
	
	@Override
	public String check() {
		return super.check();
	}

	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPwd() {
		return dbPwd;
	}
	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}
}
