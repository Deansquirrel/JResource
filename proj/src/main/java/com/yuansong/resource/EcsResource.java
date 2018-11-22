package com.yuansong.resource;

import java.util.Date;

import com.yuansong.common.CommonFun;
import com.yuansong.form.EcsAdd;

public class EcsResource extends BaseResource {
	
	public EcsResource() {
		super();
	}
	
	public EcsResource(EcsAdd form) {
		super();
		this.setId(CommonFun.UUID());
		this.setName(form.getName());
		this.setDescription(form.getDescription());
		this.setInstanceID(form.getInstanceID());
		this.setArea(form.getArea());
		this.setInternetIp(form.getInternetIp());
		this.setIntranetIp(form.getIntranetIp());
		this.setOs(form.getOs());
		this.setExpirationDate(form.getExpirationDate());
		if(form.getRdpPort() > 0) {
			this.setRdpPort(form.getRdpPort());			
		}
		else {
			this.setRdpPort(3389);
		}
		
		this.setLoginName(form.getLoginName());
		this.setLoginPwd(form.getLoginPwd());
	}
	
	@Override
	public String check() {
		StringBuilder sb = new StringBuilder(super.check());
		if(this.getInstanceID() == null || this.getInstanceID().equals("")) {
			sb.append("实例ID不允许为空；");
		}
		if(this.getArea()==null || this.getArea().equals("")) {
			sb.append("所在地域不允许为空；");
		}
		if(this.getInternetIp() == null || this.getInternetIp().equals("")) {
			sb.append("公网IP不允许为空；");
		}
		if(this.getIntranetIp() == null || this.getIntranetIp().equals("")){
			sb.append("私有IP不允许为空；");
		}
		if(this.getOs()==null || this.getOs().equals("")) {
			sb.append("操作系统不允许为空；");
		}
		if(this.getLoginName()==null || this.getLoginName().equals("")) {
			sb.append("登录名不允许为空；");
		}
		return sb.toString();
	}
	
	//实例ID
	private String instanceID;
	//所在地域，如华东1
	private String area;
	//公网IP
	private String internetIp;
	//私有IP
	private String intranetIp;
	//操作系统
	private String os;
	//过期日期
	private Date expirationDate;
	//远程桌面端口
	private int rdpPort;
	//操作系统登录名
	private String loginName;
	//操作系统登录密码
	private String loginPwd;
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getInternetIp() {
		return internetIp;
	}
	public void setInternetIp(String internetIp) {
		this.internetIp = internetIp;
	}
	public String getIntranetIp() {
		return intranetIp;
	}
	public void setIntranetIp(String intranetIp) {
		this.intranetIp = intranetIp;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
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
	public String getInstanceID() {
		return instanceID;
	}
	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}

	public int getRdpPort() {
		return rdpPort;
	}

	public void setRdpPort(int rdpPort) {
		this.rdpPort = rdpPort;
	}

}
