package com.yuansong.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yuansong.common.DateTool;
import com.yuansong.repository.RowMapper.EcsResourceRowMapper;
import com.yuansong.resource.EcsResource;

@Repository
public class EcsResourceRepository extends BaseResourceRepository<EcsResource> {
	
	private static final String GET_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FInstanceID]" + 
			"      ,[FArea]" + 
			"      ,[FInternetIp]" + 
			"      ,[FIntranetIp]" + 
			"      ,[FOs]" + 
			"      ,[FExpirationDate]" +
			"      ,[FRdpPort]" +
			"      ,[FLoginName]" + 
			"      ,[FLoginPwd]" + 
			"  FROM [EcsResource]" + 
			"  WHERE [FId] = ?";
	private static final String GET_LIST_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FInstanceID]" + 
			"      ,[FArea]" + 
			"      ,[FInternetIp]" + 
			"      ,[FIntranetIp]" + 
			"      ,[FOs]" + 
			"      ,[FExpirationDate]" + 
			"      ,[FRdpPort]" +
			"      ,[FLoginName]" + 
			"      ,[FLoginPwd]" + 
			"  FROM [EcsResource]";
	private static final String ADD_SQL = ""
			+ "INSERT INTO [EcsResource]" + 
			"           ([FId]" + 
			"           ,[FName]" + 
			"           ,[FDescription]" + 
			"           ,[FInstanceID]" + 
			"           ,[FArea]" + 
			"           ,[FInternetIp]" + 
			"           ,[FIntranetIp]" + 
			"           ,[FOs]" + 
			"           ,[FExpirationDate]" + 
			"      ,[FRdpPort]" +
			"           ,[FLoginName]" + 
			"           ,[FLoginPwd])" + 
			"     VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DEL_SQL = ""
			+ "DELETE FROM [EcsResource]" + 
			"	WHERE [FId] = ?";

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
	protected Object[] getAddParams(EcsResource resource) {
		return new Object[] {
				resource.getId(),
				resource.getName(),
				resource.getDescription(),
				resource.getInstanceID(),
				resource.getArea(),
				resource.getInternetIp(),
				resource.getIntranetIp(),
				resource.getOs(),
				DateTool.getDateStr(resource.getExpirationDate(), "yyyy-MM-dd"),
				resource.getRdpPort(),
				resource.getLoginName(),
				resource.getLoginPwd()
		};
	}

	@Override
	protected String getDelSql() {
		return DEL_SQL;
	}

	@Override
	protected Object[] getDelParams(EcsResource resource) {
		return new Object[] {resource.getId()};
	}

	@Override
	protected RowMapper<EcsResource> getRowMapper() {
		return new EcsResourceRowMapper();
	}

}
