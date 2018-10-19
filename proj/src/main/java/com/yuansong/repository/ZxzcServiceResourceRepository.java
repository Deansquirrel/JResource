package com.yuansong.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yuansong.repository.RowMapper.ZxzcServiceResourceRowMapper;
import com.yuansong.resource.ZxzcServiceResource;

@Repository
public class ZxzcServiceResourceRepository extends BaseResourceRepository<ZxzcServiceResource> {
	
	private static final String GET_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FUrl]" + 
			"      ,[FPort]" + 
			"      ,[FServiceName]" + 
			"      ,[FDbId]" + 
			"      ,[FDbType]" + 
			"  FROM [ZxzcServiceResource]" + 
			"  WHERE [FId] = ?";
	private static final String GET_LIST_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FUrl]" + 
			"      ,[FPort]" + 
			"      ,[FServiceName]" + 
			"      ,[FDbId]" + 
			"      ,[FDbType]" + 
			"  FROM [ZxzcServiceResource]";
	private static final String ADD_SQL = ""
			+ "INSERT INTO [ZxzcServiceResource]" + 
			"           ([FId]" + 
			"           ,[FName]" + 
			"           ,[FDescription]" + 
			"           ,[FUrl]" + 
			"           ,[FPort]" + 
			"           ,[FServiceName]" + 
			"           ,[FDbId]" + 
			"           ,[FDbType])" + 
			"     VALUES (?,?,?,?,?,?,?,?)";
	private static final String DEL_SQL = ""
			+ "DELETE FROM [ZxzcServiceResource]" + 
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
	protected Object[] getAddParams(ZxzcServiceResource resource) {
		return new Object[] {
				resource.getId(),
				resource.getName(),
				resource.getDescription(),
				resource.getUrl(),
				resource.getPort(),
				resource.getServiceName(),
				resource.getDbId(),
				resource.getDbType()
		};
	}

	@Override
	protected String getDelSql() {
		return DEL_SQL;
	}

	@Override
	protected Object[] getDelParams(ZxzcServiceResource resource) {
		return new Object[] {resource.getId()};
	}

	@Override
	protected RowMapper<ZxzcServiceResource> getRowMapper() {
		return new ZxzcServiceResourceRowMapper();
	}

}
