package com.yuansong.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yuansong.repository.RowMapper.TpProxyResourceRowMapper;
import com.yuansong.resource.TpProxyResource;

@Repository
public class TpProxyResourceRepository extends BaseResourceRepository<TpProxyResource> {
	
	private static final String GET_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FUrl]" + 
			"      ,[FPort]" + 
			"      ,[FCrmDataCenterDbId]" + 
			"      ,[FCrmDataCenterDbType]" + 
			"      ,[FTpO2OProxyConfigDbId]" + 
			"      ,[FTpO2OProxyConfigDbType]" + 
			"  FROM [TpProxyResource]" + 
			"  WHERE [FId] = ?";
	private static final String GET_LIST_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FUrl]" + 
			"      ,[FPort]" + 
			"      ,[FCrmDataCenterDbId]" + 
			"      ,[FCrmDataCenterDbType]" + 
			"      ,[FTpO2OProxyConfigDbId]" + 
			"      ,[FTpO2OProxyConfigDbType]" + 
			"  FROM [TpProxyResource]";
	private static final String ADD_SQL = ""
			+ "INSERT INTO [TpProxyResource]" + 
			"           ([FId]" + 
			"           ,[FName]" + 
			"           ,[FDescription]" + 
			"           ,[FUrl]" + 
			"           ,[FPort]" + 
			"           ,[FCrmDataCenterDbId]" + 
			"           ,[FCrmDataCenterDbType]" + 
			"           ,[FTpO2OProxyConfigDbId]" + 
			"           ,[FTpO2OProxyConfigDbType])" + 
			"     VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String DEL_SQL = ""
			+ "DELETE FROM [TpProxyResource]" + 
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
	protected Object[] getAddParams(TpProxyResource resource) {
		return new Object[] {
				resource.getId(),
				resource.getName(),
				resource.getDescription(),
				resource.getUrl(),
				resource.getPort(),
				resource.getCrmDataCenterDbId(),
				resource.getCrmDataCenterDbType(),
				resource.getTpO2OProxyConfigDbId(),
				resource.getTpO2OProxyConfigDbType()
		};
	}

	@Override
	protected String getDelSql() {
		return DEL_SQL;
	}

	@Override
	protected Object[] getDelParams(TpProxyResource resource) {
		return new Object[] {resource.getId()};
	}

	@Override
	protected RowMapper<TpProxyResource> getRowMapper() {
		return new TpProxyResourceRowMapper();
	}

}
