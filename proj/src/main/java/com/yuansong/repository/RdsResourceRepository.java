package com.yuansong.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yuansong.common.DateTool;
import com.yuansong.repository.RowMapper.RdsResourceRowMapper;
import com.yuansong.resource.RdsResource;

@Repository
public class RdsResourceRepository extends BaseResourceRepository<RdsResource> {
	
	private static final String GET_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FInstanceID]" + 
			"      ,[FArea]" + 
			"      ,[FDbType]" + 
			"      ,[FInternetIp]" + 
			"      ,[FInternetPort]" + 
			"      ,[FIntranetIp]" + 
			"      ,[FIntranetPort]" + 
			"      ,[FExpirationDate]" + 
			"  FROM [RdsResource]" +
			"  WHERE [FId] = ?";
	private static final String GET_LIST_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FInstanceID]" + 
			"      ,[FArea]" + 
			"      ,[FDbType]" + 
			"      ,[FInternetIp]" + 
			"      ,[FInternetPort]" + 
			"      ,[FIntranetIp]" + 
			"      ,[FIntranetPort]" + 
			"      ,[FExpirationDate]" + 
			"  FROM [RdsResource]";
	private static final String ADD_SQL = ""
			+ "INSERT INTO [RdsResource]" + 
			"           ([FId]" + 
			"           ,[FName]" + 
			"           ,[FDescription]" + 
			"           ,[FInstanceID]" + 
			"           ,[FArea]" + 
			"           ,[FDbType]" + 
			"           ,[FInternetIp]" + 
			"           ,[FInternetPort]" + 
			"           ,[FIntranetIp]" + 
			"           ,[FIntranetPort]" + 
			"           ,[FExpirationDate])" + 
			"     VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DEL_SQL = ""
			+ "DELETE FROM [RdsResource]" + 
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
	protected Object[] getAddParams(RdsResource resource) {
		return new Object[] {
				resource.getId(),
				resource.getName(),
				resource.getDescription(),
				resource.getInstanceID(),
				resource.getArea(),
				resource.getDbType(),
				resource.getInternetIp(),
				resource.getInternetPort(),
				resource.getIntranetIp(),
				resource.getIntranetPort(),
				DateTool.getDateStr(resource.getExpirationDate(), "yyyy-MM-dd")
		};
	}

	@Override
	protected String getDelSql() {
		return DEL_SQL;
	}

	@Override
	protected Object[] getDelParams(RdsResource resource) {
		return new Object[] {resource.getId()};
	}

	@Override
	protected RowMapper<RdsResource> getRowMapper() {
		return new RdsResourceRowMapper();
	}

}
