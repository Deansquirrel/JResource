package com.yuansong.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yuansong.repository.RowMapper.ExceptionlessResourceRowMapper;
import com.yuansong.resource.ExceptionlessResource;

@Repository
public class ExceptionlessResourceRepository extends BaseResourceRepository<ExceptionlessResource> {
	
	private static final String GET_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FUrl]" + 
			"      ,[FLoginName]" + 
			"      ,[FLoginPwd]" + 
			"  FROM [ExceptionlessResource]" + 
			"  WHERE [FId] = ?";
	private static final String GET_LIST_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FUrl]" + 
			"      ,[FLoginName]" + 
			"      ,[FLoginPwd]" + 
			"  FROM [ExceptionlessResource]";
	private static final String ADD_SQL = ""
			+ "INSERT INTO [ExceptionlessResource]" + 
			"           ([FId]" + 
			"           ,[FName]" + 
			"           ,[FDescription]" + 
			"           ,[FUrl]" + 
			"           ,[FLoginName]" + 
			"           ,[FLoginPwd])" + 
			"     VALUES (?,?,?,?,?,?)";
	private static final String DEL_SQL = ""
			+ "DELETE FROM [ExceptionlessResource]" + 
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
	protected Object[] getAddParams(ExceptionlessResource resource) {
		return new Object[] {
				resource.getId(),
				resource.getName(),
				resource.getDescription(),
				resource.getUrl(),
				resource.getLoginName(),
				resource.getLoginPwd()
		};
	}

	@Override
	protected String getDelSql() {
		return DEL_SQL;
	}

	@Override
	protected Object[] getDelParams(ExceptionlessResource resource) {
		return new Object[] {resource.getId()};
	}

	@Override
	protected RowMapper<ExceptionlessResource> getRowMapper() {
		return new ExceptionlessResourceRowMapper();
	}

}
