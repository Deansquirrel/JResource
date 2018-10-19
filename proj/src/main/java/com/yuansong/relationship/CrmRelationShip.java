package com.yuansong.relationship;

public class CrmRelationShip extends BaseRelationShip {
	
	//-----------------------------------------------------------------------------------
	//客户ID
	private String customerId;
	//-----------------------------------------------------------------------------------
	//商户号
	private String businessNumber;
	//服务号Appid
	private String appid;
	//微信卡ID
	private String cardId;
	//领卡连接
	private String registerLink;
	//-----------------------------------------------------------------------------------
	//Exceptionless ID
	private String excepionlessId;
	//Exceptionless Key
	private String excepionlessKey;
	//第三方代理 ID
	private String tpProxyId;
	//域名
	private String domain;
	//RabbitMQ
	private String rabbitMQId;
	//RabbitMQ中对应的Virtual Hosts
	private String virtualHosts;	
	//-----------------------------------------------------------------------------------
	private String snoServerName;
	private int snoServerPort;
	private String crmDzName;
	private int crmDzPort;
	private String ywDetaildzName;
	private int ywDetaildzPort;
	private String crmWsName;
	private int crmWsPort;
	private String crmWebName;
	private int crmWebPort;
	private String crmManagerName;
	private int crmManagerPort;
	private String crmFengkName;
	private int crmFengkPort;
	private String crmJichShujName;
	private int crmJichShujPort;
	private String crmGuanDName;
	private int crmGuanDPort;
	private String crmPeiZhName;
	private int crmPeiZhPort;
	private String crmAccRecordName;
	private String crmAccRecordAddName;
	private String crmMQClientName;
	private String crmFengkMQClientName;
	private String dataSyncName;
	private String weixinCallBackName;
	private String recordMonitorName;
	private int recordMonitorPort;
	//-----------------------------------------------------------------------------------
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getRegisterLink() {
		return registerLink;
	}
	public void setRegisterLink(String registerLink) {
		this.registerLink = registerLink;
	}
	public String getExcepionlessId() {
		return excepionlessId;
	}
	public void setExcepionlessId(String excepionlessId) {
		this.excepionlessId = excepionlessId;
	}
	public String getExcepionlessKey() {
		return excepionlessKey;
	}
	public void setExcepionlessKey(String excepionlessKey) {
		this.excepionlessKey = excepionlessKey;
	}
	public String getTpProxyId() {
		return tpProxyId;
	}
	public void setTpProxyId(String tpProxyId) {
		this.tpProxyId = tpProxyId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getVirtualHosts() {
		return virtualHosts;
	}
	public void setVirtualHosts(String virtualHosts) {
		this.virtualHosts = virtualHosts;
	}
	public int getSnoServerPort() {
		return snoServerPort;
	}
	public void setSnoServerPort(int snoServerPort) {
		this.snoServerPort = snoServerPort;
	}
	public int getCrmDzPort() {
		return crmDzPort;
	}
	public void setCrmDzPort(int crmDzPort) {
		this.crmDzPort = crmDzPort;
	}
	public int getYwDetaildzPort() {
		return ywDetaildzPort;
	}
	public void setYwDetaildzPort(int ywDetaildzPort) {
		this.ywDetaildzPort = ywDetaildzPort;
	}
	public int getCrmWsPort() {
		return crmWsPort;
	}
	public void setCrmWsPort(int crmWsPort) {
		this.crmWsPort = crmWsPort;
	}
	public int getCrmWebPort() {
		return crmWebPort;
	}
	public void setCrmWebPort(int crmWebPort) {
		this.crmWebPort = crmWebPort;
	}
	public int getCrmManagerPort() {
		return crmManagerPort;
	}
	public void setCrmManagerPort(int crmManagerPort) {
		this.crmManagerPort = crmManagerPort;
	}
	public int getCrmFengkPort() {
		return crmFengkPort;
	}
	public void setCrmFengkPort(int crmFengkPort) {
		this.crmFengkPort = crmFengkPort;
	}
	public int getCrmJichShujPort() {
		return crmJichShujPort;
	}
	public void setCrmJichShujPort(int crmJichShujPort) {
		this.crmJichShujPort = crmJichShujPort;
	}
	public int getCrmGuanDPort() {
		return crmGuanDPort;
	}
	public void setCrmGuanDPort(int crmGuanDPort) {
		this.crmGuanDPort = crmGuanDPort;
	}
	public int getCrmPeiZhPort() {
		return crmPeiZhPort;
	}
	public void setCrmPeiZhPort(int crmPeiZhPort) {
		this.crmPeiZhPort = crmPeiZhPort;
	}
	public int getRecordMonitorPort() {
		return recordMonitorPort;
	}
	public void setRecordMonitorPort(int recordMonitorPort) {
		this.recordMonitorPort = recordMonitorPort;
	}
	public String getSnoServerName() {
		return snoServerName;
	}
	public void setSnoServerName(String snoServerName) {
		this.snoServerName = snoServerName;
	}
	public String getCrmDzName() {
		return crmDzName;
	}
	public void setCrmDzName(String crmDzName) {
		this.crmDzName = crmDzName;
	}
	public String getYwDetaildzName() {
		return ywDetaildzName;
	}
	public void setYwDetaildzName(String ywDetaildzName) {
		this.ywDetaildzName = ywDetaildzName;
	}
	public String getCrmWsName() {
		return crmWsName;
	}
	public void setCrmWsName(String crmWsName) {
		this.crmWsName = crmWsName;
	}
	public String getCrmWebName() {
		return crmWebName;
	}
	public void setCrmWebName(String crmWebName) {
		this.crmWebName = crmWebName;
	}
	public String getCrmManagerName() {
		return crmManagerName;
	}
	public void setCrmManagerName(String crmManagerName) {
		this.crmManagerName = crmManagerName;
	}
	public String getCrmFengkName() {
		return crmFengkName;
	}
	public void setCrmFengkName(String crmFengkName) {
		this.crmFengkName = crmFengkName;
	}
	public String getCrmGuanDName() {
		return crmGuanDName;
	}
	public void setCrmGuanDName(String crmGuanDName) {
		this.crmGuanDName = crmGuanDName;
	}
	public String getCrmPeiZhName() {
		return crmPeiZhName;
	}
	public void setCrmPeiZhName(String crmPeiZhName) {
		this.crmPeiZhName = crmPeiZhName;
	}
	public String getCrmAccRecordName() {
		return crmAccRecordName;
	}
	public void setCrmAccRecordName(String crmAccRecordName) {
		this.crmAccRecordName = crmAccRecordName;
	}
	public String getCrmAccRecordAddName() {
		return crmAccRecordAddName;
	}
	public void setCrmAccRecordAddName(String crmAccRecordAddName) {
		this.crmAccRecordAddName = crmAccRecordAddName;
	}
	public String getCrmMQClientName() {
		return crmMQClientName;
	}
	public void setCrmMQClientName(String crmMQClientName) {
		this.crmMQClientName = crmMQClientName;
	}
	public String getCrmFengkMQClientName() {
		return crmFengkMQClientName;
	}
	public void setCrmFengkMQClientName(String crmFengkMQClientName) {
		this.crmFengkMQClientName = crmFengkMQClientName;
	}
	public String getDataSyncName() {
		return dataSyncName;
	}
	public void setDataSyncName(String dataSyncName) {
		this.dataSyncName = dataSyncName;
	}
	public String getWeixinCallBackName() {
		return weixinCallBackName;
	}
	public void setWeixinCallBackName(String weixinCallBackName) {
		this.weixinCallBackName = weixinCallBackName;
	}
	public String getRecordMonitorName() {
		return recordMonitorName;
	}
	public void setRecordMonitorName(String recordMonitorName) {
		this.recordMonitorName = recordMonitorName;
	}
	public String getRabbitMQId() {
		return rabbitMQId;
	}
	public void setRabbitMQId(String rabbitMQId) {
		this.rabbitMQId = rabbitMQId;
	}
	public String getCrmJichShujName() {
		return crmJichShujName;
	}
	public void setCrmJichShujName(String crmJichShujName) {
		this.crmJichShujName = crmJichShujName;
	}
}
