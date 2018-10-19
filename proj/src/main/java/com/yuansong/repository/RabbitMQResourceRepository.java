package com.yuansong.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yuansong.repository.RowMapper.RabbitMQResourceRowMapper;
import com.yuansong.resource.RabbitMQResource;

@Repository
public class RabbitMQResourceRepository extends BaseResourceRepository<RabbitMQResource> {
	
	private static final String GET_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FInternetIp]" + 
			"      ,[FIntranetIp]" + 
			"      ,[FPort]" + 
			"      ,[FLoginName]" + 
			"      ,[FLoginPwd]" + 
			"  FROM [RabbitMQResource]" + 
			"  WHERE [FId] = ?";
	private static final String GET_LIST_SQL = ""
			+ "SELECT [FId]" + 
			"      ,[FName]" + 
			"      ,[FDescription]" + 
			"      ,[FInternetIp]" + 
			"      ,[FIntranetIp]" + 
			"      ,[FPort]" + 
			"      ,[FLoginName]" + 
			"      ,[FLoginPwd]" + 
			"  FROM [RabbitMQResource]";
	private static final String ADD_SQL = ""
			+ "INSERT INTO [RabbitMQResource]" + 
			"           ([FId]" + 
			"           ,[FName]" + 
			"           ,[FDescription]" + 
			"           ,[FInternetIp]" + 
			"           ,[FIntranetIp]" + 
			"           ,[FPort]" + 
			"           ,[FLoginName]" + 
			"           ,[FLoginPwd])" + 
			"     VALUES (?,?,?,?,?,?,?,?)";
	private static final String DEL_SQL = ""
			+ "DELETE FROM [RabbitMQResource]" + 
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
	protected Object[] getAddParams(RabbitMQResource resource) {
		return new Object[] {
				resource.getId(),
				resource.getName(),
				resource.getDescription(),
				resource.getInternetIp(),
				resource.getIntranetIp(),
				resource.getPort(),
				resource.getLoginName(),
				resource.getLoginPwd()
		};
	}

	@Override
	protected String getDelSql() {
		return DEL_SQL;
	}

	@Override
	protected Object[] getDelParams(RabbitMQResource resource) {
		return new Object[] {resource.getId()};
	}

	@Override
	protected RowMapper<RabbitMQResource> getRowMapper() {
		return new RabbitMQResourceRowMapper();
	}

}
