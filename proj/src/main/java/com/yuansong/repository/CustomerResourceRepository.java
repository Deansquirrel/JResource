package com.yuansong.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yuansong.repository.RowMapper.CustomerResourceRowMapper;
import com.yuansong.resource.CustomerResource;

@Repository
public class CustomerResourceRepository extends BaseResourceRepository<CustomerResource> {

	private static final String GET_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FCode]" + 
			"      ,[FShowName]" + 
			"      ,[FSimpleName]" + 
			"      ,[FPinyinName]" + 
			"      ,[FMisType]" + 
			"      ,[FTongdCode]" + 
			"  FROM [CustomerResource]" + 
			"  WHERE [FId] = ?";
	private static final String GET_LIST_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FCode]" + 
			"      ,[FShowName]" + 
			"      ,[FSimpleName]" + 
			"      ,[FPinyinName]" + 
			"      ,[FMisType]" + 
			"      ,[FTongdCode]" + 
			"  FROM [CustomerResource]";
	private static final String ADD_SQL = ""
			+ "INSERT INTO [CustomerResource]" + 
			"           ([FId]" + 
			"           ,[FName]" + 
			"           ,[FDescription]" + 
			"           ,[FCode]" + 
			"           ,[FShowName]" + 
			"           ,[FSimpleName]" + 
			"           ,[FPinyinName]" + 
			"           ,[FMisType]" + 
			"           ,[FTongdCode])" + 
			"     VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String DEL_SQL = ""
			+ "DELETE FROM [CustomerResource]" + 
			"      WHERE [FId] = ?";
			
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
	protected Object[] getAddParams(CustomerResource resource) {
		return new Object[] {
				resource.getId(),
				resource.getName(),
				resource.getDescription(),
				resource.getCode(),
				resource.getShowName(),
				resource.getSimpleName(),
				resource.getPinyinName(),
				resource.getMisType(),
				resource.getTongdCode()
		};
	}

	@Override
	protected String getDelSql() {
		return DEL_SQL;
	}

	@Override
	protected Object[] getDelParams(CustomerResource resource) {
		return new Object[] {resource.getId()};
	}

	@Override
	protected RowMapper<CustomerResource> getRowMapper() {
		return new CustomerResourceRowMapper();
	}

}
