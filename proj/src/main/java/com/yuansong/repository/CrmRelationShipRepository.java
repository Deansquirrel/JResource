package com.yuansong.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yuansong.relationship.CrmRelationShip;
import com.yuansong.repository.RowMapper.CrmRelationShipRowMapper;

@Repository
public class CrmRelationShipRepository extends BaseRelationShipRepository<CrmRelationShip> {
	
	private static final String GET_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FCustomerId]" + 
			"      ,[FBusinessNumber]" + 
			"      ,[FAppid]" + 
			"      ,[FCardId]" + 
			"      ,[FRegisterLink]" + 
			"      ,[FExceptionlessId]" + 
			"      ,[FExceptionlessKey]" + 
			"      ,[FTpProxyId]" + 
			"      ,[FDomain]" + 
			"      ,[FRabbitMQId]" + 
			"      ,[FVirtualHosts]" + 
			"      ,[FSnoServerName]" + 
			"      ,[FsnoServerPort]" + 
			"      ,[FCrmDzName]" + 
			"      ,[FCrmDzPort]" + 
			"      ,[FYwDetaildzDzName]" + 
			"      ,[FYwDetaildzPort]" + 
			"      ,[FCrmWsName]" + 
			"      ,[FCrmWsPort]" + 
			"      ,[FCrmWebName]" + 
			"      ,[FCrmWebPort]" + 
			"      ,[FCrmManagerName]" + 
			"      ,[FCrmManagerPort]" + 
			"      ,[FCrmFengkName]" + 
			"      ,[FCrmFengkPort]" + 
			"      ,[FCrmJichuShujName]" + 
			"      ,[FCrmJichuShujPort]" + 
			"      ,[FCrmGuanDName]" + 
			"      ,[FCrmGuanDPort]" + 
			"      ,[FCrmPeiZhName]" + 
			"      ,[FCrmPeiZhPort]" + 
			"      ,[FCrmAccRecordName]" + 
			"      ,[FCrmAccRecordAddName]" + 
			"      ,[FCrmMQClientName]" + 
			"      ,[FCrmFengkMQClientName]" + 
			"      ,[FdataSyncName]" + 
			"      ,[FWeixinCallBackName]" + 
			"      ,[FRecordMonitorName]" + 
			"      ,[FRecordMonitorPort]" + 
			"  FROM [CrmRelationShip]" + 
			"  WHERE [FId] = ?";
	private static final String GET_LIST_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FCustomerId]" + 
			"      ,[FBusinessNumber]" + 
			"      ,[FAppid]" + 
			"      ,[FCardId]" + 
			"      ,[FRegisterLink]" + 
			"      ,[FExceptionlessId]" + 
			"      ,[FExceptionlessKey]" + 
			"      ,[FTpProxyId]" + 
			"      ,[FDomain]" + 
			"      ,[FRabbitMQId]" + 
			"      ,[FVirtualHosts]" + 
			"      ,[FSnoServerName]" + 
			"      ,[FsnoServerPort]" + 
			"      ,[FCrmDzName]" + 
			"      ,[FCrmDzPort]" + 
			"      ,[FYwDetaildzDzName]" + 
			"      ,[FYwDetaildzPort]" + 
			"      ,[FCrmWsName]" + 
			"      ,[FCrmWsPort]" + 
			"      ,[FCrmWebName]" + 
			"      ,[FCrmWebPort]" + 
			"      ,[FCrmManagerName]" + 
			"      ,[FCrmManagerPort]" + 
			"      ,[FCrmFengkName]" + 
			"      ,[FCrmFengkPort]" + 
			"      ,[FCrmJichuShujName]" + 
			"      ,[FCrmJichuShujPort]" + 
			"      ,[FCrmGuanDName]" + 
			"      ,[FCrmGuanDPort]" + 
			"      ,[FCrmPeiZhName]" + 
			"      ,[FCrmPeiZhPort]" + 
			"      ,[FCrmAccRecordName]" + 
			"      ,[FCrmAccRecordAddName]" + 
			"      ,[FCrmMQClientName]" + 
			"      ,[FCrmFengkMQClientName]" + 
			"      ,[FdataSyncName]" + 
			"      ,[FWeixinCallBackName]" + 
			"      ,[FRecordMonitorName]" + 
			"      ,[FRecordMonitorPort]" + 
			"  FROM [CrmRelationShip]";
	private static final String ADD_SQL = ""
			+ "INSERT INTO [CrmRelationShip]" + 
			"           ([FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FCustomerId]" + 
			"      ,[FBusinessNumber]" + 
			"      ,[FAppid]" + 
			"      ,[FCardId]" + 
			"      ,[FRegisterLink]" + 
			"      ,[FExceptionlessId]" + 
			"      ,[FExceptionlessKey]" + 
			"      ,[FTpProxyId]" + 
			"      ,[FDomain]" + 
			"      ,[FRabbitMQId]" + 
			"      ,[FVirtualHosts]" + 
			"      ,[FSnoServerName]" + 
			"      ,[FsnoServerPort]" + 
			"      ,[FCrmDzName]" + 
			"      ,[FCrmDzPort]" + 
			"      ,[FYwDetaildzDzName]" + 
			"      ,[FYwDetaildzPort]" + 
			"      ,[FCrmWsName]" + 
			"      ,[FCrmWsPort]" + 
			"      ,[FCrmWebName]" + 
			"      ,[FCrmWebPort]" + 
			"      ,[FCrmManagerName]" + 
			"      ,[FCrmManagerPort]" + 
			"      ,[FCrmFengkName]" + 
			"      ,[FCrmFengkPort]" + 
			"      ,[FCrmJichuShujName]" + 
			"      ,[FCrmJichuShujPort]" + 
			"      ,[FCrmGuanDName]" + 
			"      ,[FCrmGuanDPort]" + 
			"      ,[FCrmPeiZhName]" + 
			"      ,[FCrmPeiZhPort]" + 
			"      ,[FCrmAccRecordName]" + 
			"      ,[FCrmAccRecordAddName]" + 
			"      ,[FCrmMQClientName]" + 
			"      ,[FCrmFengkMQClientName]" + 
			"      ,[FdataSyncName]" + 
			"      ,[FWeixinCallBackName]" + 
			"      ,[FRecordMonitorName]" + 
			"      ,[FRecordMonitorPort]" + 
			"     VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DEL_SQL = ""
			+ "DELETE FROM [CrmRelationShip]" + 
			"  WHERE [FId] = ?";

	@Override
	protected String getGetSql() {
		return  GET_SQL;
	}

	@Override
	protected String getGetListSql() {
		return GET_LIST_SQL;
	}

	@Override
	protected String getAddSql() {
		return ADD_SQL;
	}

	@Override
	protected Object[] getAddParams(CrmRelationShip relationShip) {
		return new Object[] {
				relationShip.getId(),
				relationShip.getName(),
				relationShip.getDescription(),
				relationShip.getCustomerId(),
				relationShip.getBusinessNumber(),
				relationShip.getAppid(),
				relationShip.getCardId(),
				relationShip.getRegisterLink(),
				relationShip.getExcepionlessId(),
				relationShip.getExcepionlessKey(),
				relationShip.getTpProxyId(),
				relationShip.getDomain(),
				relationShip.getRabbitMQId(),
				relationShip.getVirtualHosts(),
				relationShip.getSnoServerName(),
				relationShip.getSnoServerPort(),
				relationShip.getCrmDzName(),
				relationShip.getCrmDzPort(),
				relationShip.getYwDetaildzName(),
				relationShip.getYwDetaildzPort(),
				relationShip.getCrmWsName(),
				relationShip.getCrmWsPort(),
				relationShip.getCrmWebName(),
				relationShip.getCrmWebPort(),
				relationShip.getCrmManagerName(),
				relationShip.getCrmManagerPort(),
				relationShip.getCrmFengkName(),
				relationShip.getCrmFengkPort(),
				relationShip.getCrmJichShujName(),
				relationShip.getCrmJichShujPort(),
				relationShip.getCrmGuanDName(),
				relationShip.getCrmGuanDPort(),
				relationShip.getCrmPeiZhName(),
				relationShip.getCrmPeiZhPort(),
				relationShip.getCrmAccRecordName(),
				relationShip.getCrmAccRecordAddName(),
				relationShip.getCrmMQClientName(),
				relationShip.getCrmFengkMQClientName(),
				relationShip.getDataSyncName(),
				relationShip.getWeixinCallBackName(),
				relationShip.getRecordMonitorName(),
				relationShip.getRecordMonitorPort()
		};
	}

	@Override
	protected String getDelSql() {
		return DEL_SQL;
	}

	@Override
	protected Object[] getDelParams(CrmRelationShip relationShip) {
		return new Object[] {relationShip.getId()};
	}

	@Override
	protected RowMapper<CrmRelationShip> getRowMapper() {
		return new CrmRelationShipRowMapper();
	}

}
