package com.yuansong.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yuansong.repository.RowMapper.CommonDbResourceRowMapper;
import com.yuansong.resource.CommonDbResource;

@Repository
public class CommonDbResourceRepository extends BaseResourceRepository<CommonDbResource> {
	
	private static final String GET_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FDbName]" + 
			"      ,[FDbUser]" + 
			"      ,[FDbPwd]" + 
			"      ,[FAddress]" + 
			"      ,[FPort]" + 
			"  FROM [CommonDbResource]" + 
			"  WHERE [FId] = ?";
	private static final String GET_LIST_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FDbName]" + 
			"      ,[FDbUser]" + 
			"      ,[FDbPwd]" + 
			"      ,[FAddress]" + 
			"      ,[FPort]" + 
			"  FROM [CommonDbResource]";
	private static final String ADD_SQL = ""
			+ "INSERT INTO [CommonDbResource]" + 
			"           ([FId]" + 
			"           ,[FName]" + 
			"           ,[FDescription]" + 
			"           ,[FDbName]" + 
			"           ,[FDbUser]" + 
			"           ,[FDbPwd]" + 
			"           ,[FAddress]" + 
			"           ,[FPort])" + 
			"     VALUES (?,?,?,?,?,?,?,?)";
	private static final String DEL_SQL = ""
			+ "DELETE FROM [CommonDbResource]" + 
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
	protected Object[] getAddParams(CommonDbResource resource) {
		return new Object[] {
				resource.getId(),
				resource.getName(),
				resource.getDescription(),
				resource.getDbName(),
				resource.getDbUser(),
				resource.getDbPwd(),
				resource.getAddress(),
				resource.getPort()
		};
	}

	@Override
	protected String getDelSql() {
		return DEL_SQL;
	}

	@Override
	protected Object[] getDelParams(CommonDbResource resource) {
		return new Object[] {
				resource.getId()
		};
	}

	@Override
	protected RowMapper<CommonDbResource> getRowMapper() {
		return new CommonDbResourceRowMapper();
	}

}
