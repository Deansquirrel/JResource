package com.yuansong.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yuansong.repository.RowMapper.RedisResourceRowMapper;
import com.yuansong.resource.RedisResource;

@Repository
public class RedisResourceRepository extends BaseResourceRepository<RedisResource> {
	
	private static final String GET_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FInstanceID]" + 
			"      ,[FArea]" + 
			"      ,[FHost]" + 
			"      ,[FPort]" + 
			"      ,[FPwd]" + 
			"  FROM [RedisResource]" + 
			"  WHERE [FId] = ?";
	private static final String GET_LIST_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FInstanceID]" + 
			"      ,[FArea]" + 
			"      ,[FHost]" + 
			"      ,[FPort]" + 
			"      ,[FPwd]" + 
			"  FROM [RedisResource]";
	private static final String ADD_SQL = ""
			+ "INSERT INTO [RedisResource]" + 
			"           ([FId]" + 
			"           ,[FName]" + 
			"           ,[FDescription]" + 
			"           ,[FInstanceID]" + 
			"           ,[FArea]" + 
			"           ,[FHost]" + 
			"           ,[FPort]" + 
			"           ,[FPwd])" + 
			"     VALUES (?,?,?,?,?,?,?,?)";
	private static final String DEL_SQL = ""
			+ "DELETE FROM [RedisResource]" + 
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
	protected Object[] getAddParams(RedisResource resource) {
		return new Object[] {
				resource.getId(),
				resource.getName(),
				resource.getDescription(),
				resource.getInstanceID(),
				resource.getArea(),
				resource.getHost(),
				resource.getPort(),
				resource.getPwd()
		};
	}

	@Override
	protected String getDelSql() {
		return DEL_SQL;
	}

	@Override
	protected Object[] getDelParams(RedisResource resource) {
		return new Object[] {resource.getId()};
	}

	@Override
	protected RowMapper<RedisResource> getRowMapper() {
		return new RedisResourceRowMapper();
	}

}
