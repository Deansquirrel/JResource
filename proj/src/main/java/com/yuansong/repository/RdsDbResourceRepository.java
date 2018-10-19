package com.yuansong.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yuansong.repository.RowMapper.RdsDbResourceRowMapper;
import com.yuansong.resource.RdsDbResource;

@Repository
public class RdsDbResourceRepository extends BaseResourceRepository<RdsDbResource> {
	
	private static final String GET_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FDbName]" + 
			"      ,[FDbUser]" + 
			"      ,[FDbPwd]" + 
			"      ,[FRdsId]" + 
			"  FROM [RdsDbResource]" + 
			"  WHERE [FId] = ?";
	private static final String GET_LIST_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FDbName]" + 
			"      ,[FDbUser]" + 
			"      ,[FDbPwd]" + 
			"      ,[FRdsId]" + 
			"  FROM [RdsDbResource]";
	private static final String ADD_SQL = ""
			+ "INSERT INTO [RdsDbResource]" + 
			"           ([FId]" + 
			"           ,[FName]" + 
			"           ,[FDescription]" + 
			"           ,[FDbName]" + 
			"           ,[FDbUser]" + 
			"           ,[FDbPwd]" + 
			"           ,[FRdsId])" + 
			"     VALUES (?,?,?,?,?,?,?)";
	private static final String DEL_SQL = ""
			+ "DELETE FROM [RdsDbResource]" + 
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
	protected Object[] getAddParams(RdsDbResource resource) {
		return new Object[] {
				resource.getId(),
				resource.getName(),
				resource.getDescription(),
				resource.getDbName(),
				resource.getDbUser(),
				resource.getDbPwd(),
				resource.getRdsId()
		};
	}

	@Override
	protected String getDelSql() {
		return DEL_SQL;
	}

	@Override
	protected Object[] getDelParams(RdsDbResource resource) {
		return new Object[] {resource.getId()};
	}

	@Override
	protected RowMapper<RdsDbResource> getRowMapper() {
		return new RdsDbResourceRowMapper();
	}

}
