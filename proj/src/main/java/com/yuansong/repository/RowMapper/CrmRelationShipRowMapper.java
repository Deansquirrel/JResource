package com.yuansong.repository.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.relationship.CrmRelationShip;

public class CrmRelationShipRowMapper implements RowMapper<CrmRelationShip> {

	@Override
	public CrmRelationShip mapRow(ResultSet rs, int rowNum) throws SQLException {
		CrmRelationShip relationShip = new CrmRelationShip();
		relationShip.setId(rs.getString("FId"));
		relationShip.setName(rs.getString("FName"));
		relationShip.setDescription(rs.getString("FDescription"));
		
		relationShip.setCustomerId(rs.getString("FCustomerId"));
		
		relationShip.setBusinessNumber(rs.getString("FBusinessNumber"));
		relationShip.setAppid(rs.getString("FAppid"));
		relationShip.setCardId(rs.getString("FCardId"));
		relationShip.setRegisterLink(rs.getString("FRegisterLink"));
		
		relationShip.setExcepionlessId(rs.getString("FExceptionlessId"));
		relationShip.setExcepionlessKey(rs.getString("FExceptionlessKey"));
		relationShip.setTpProxyId(rs.getString("FTpProxyId"));
		relationShip.setDomain(rs.getString("FDomain"));

		relationShip.setRabbitMQId(rs.getString("FRabbitMQId"));
		relationShip.setVirtualHosts(rs.getString("FVirtualHosts"));

		relationShip.setSnoServerName(rs.getString("FSnoServerName"));
		relationShip.setSnoServerPort(rs.getInt("FsnoServerPort"));
		relationShip.setCrmDzName(rs.getString("FCrmDzName"));
		relationShip.setCrmDzPort(rs.getInt("FCrmDzPort"));
		relationShip.setYwDetaildzName(rs.getString("FYwDetaildzDzName"));
		relationShip.setYwDetaildzPort(rs.getInt("FYwDetaildzPort"));
		relationShip.setCrmWsName(rs.getString("FCrmWsName"));
		relationShip.setCrmWsPort(rs.getInt("FCrmWsPort"));
		relationShip.setCrmWebName(rs.getString("FCrmWebName"));
		relationShip.setCrmWebPort(rs.getInt("FCrmWebPort"));
		relationShip.setCrmManagerName(rs.getString("FCrmManagerName"));
		relationShip.setCrmManagerPort(rs.getInt("FCrmManagerPort"));
		relationShip.setCrmFengkName(rs.getString("FCrmFengkName"));
		relationShip.setCrmFengkPort(rs.getInt("FCrmFengkPort"));
		relationShip.setCrmJichShujName(rs.getString("FCrmJichuShujName"));
		relationShip.setCrmJichShujPort(rs.getInt("FCrmJichuShujPort"));
		relationShip.setCrmGuanDName(rs.getString("FCrmGuanDName"));
		relationShip.setCrmGuanDPort(rs.getInt("FCrmGuanDPort"));
		relationShip.setCrmPeiZhName(rs.getString("FCrmPeiZhName"));
		relationShip.setCrmPeiZhPort(rs.getInt("FCrmPeiZhPort"));
		relationShip.setCrmAccRecordName(rs.getString("FCrmAccRecordName"));
		relationShip.setCrmAccRecordAddName(rs.getString("FCrmAccRecordAddName"));
		relationShip.setCrmMQClientName(rs.getString("FCrmMQClientName"));
		relationShip.setCrmFengkMQClientName(rs.getString("FCrmFengkMQClientName"));
		relationShip.setDataSyncName(rs.getString("FdataSyncName"));
		relationShip.setWeixinCallBackName(rs.getString("FWeixinCallBackName"));
		relationShip.setRecordMonitorName(rs.getString("FRecordMonitorName"));
		relationShip.setRecordMonitorPort(rs.getInt("FRecordMonitorPort"));
		
		return relationShip;
	}

}
