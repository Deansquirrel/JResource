package com.yuansong.resource;

import com.yuansong.common.CommonFun;
import com.yuansong.form.CustomerAdd;

public class CustomerResource extends BaseResource {
	
	public CustomerResource() {
		super();
	}
	
	public CustomerResource(CustomerAdd form) {
		super();
		this.setId(CommonFun.UUID());
		this.setName(form.getName());
		this.setDescription(form.getDescription());
		this.setCode(form.getCode());
		this.setShowName(form.getShowname());
		this.setSimpleName(form.getSimplename());
		this.setPinyinName(form.getPinyinname());
		this.setMisType(form.getMistype().toUpperCase());
		this.setTongdCode(form.getTongdcode());
	}
	
	@Override
	public String check() {
		StringBuilder sb = new StringBuilder(super.check());
		if(this.getCode() == null || this.getCode().equals("")) {
			sb.append("编码不允许为空；");
		}
		if(this.getShowName() == null || this.getShowName().equals("")) {
			sb.append("显示名称不允许为空；");
		}
		if(this.getSimpleName() == null || this.getSimpleName().equals("")) {
			sb.append("简称不允许为空；");
		}
		if(this.getPinyinName() == null || this.getPinyinName().equals("")) {
			sb.append("拼音名称不允许为空；");
		}
		if(this.getMisType() == null || this.getMisType().equals("")) {
			sb.append("系统类型不允许为空；");
		}
		else {
			if(!this.getMisType().equals("Z5") && !this.getMisType().equals("Z9")) {
				sb.append("系统类型不合法【仅允许Z5或Z9】；");
			}
		}
		if(this.getTongdCode() == null || this.getTongdCode().equals("")) {
			sb.append("通道识别码（tongdCode）不允许为空");
		}
		return sb.toString();
	}
	
	//客户编码
	private String code;
	//显示名称
	private String showName;
	//简称
	private String simpleName;
	//拼音简称
	private String pinyinName;
	
	//Z5 or Z9
	private String misType;
	//通道码
	private String tongdCode;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getSimpleName() {
		return simpleName;
	}
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	public String getTongdCode() {
		return tongdCode;
	}
	public void setTongdCode(String tongdCode) {
		this.tongdCode = tongdCode;
	}
	public String getMisType() {
		return misType;
	}
	public void setMisType(String misType) {
		this.misType = misType;
	}
	public String getPinyinName() {
		return pinyinName;
	}
	public void setPinyinName(String pinyinName) {
		this.pinyinName = pinyinName;
	}

}
