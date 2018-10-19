package com.yuansong.repository.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.resource.RabbitMQResource;

public class RabbitMQResourceRowMapper implements RowMapper<RabbitMQResource> {

	@Override
	public RabbitMQResource mapRow(ResultSet rs, int rowNum) throws SQLException {
		RabbitMQResource resource = new RabbitMQResource();
		resource.setId(rs.getString("FId"));
		resource.setName(rs.getString("FName"));
		resource.setDescription(rs.getString("FDescription"));
		resource.setInternetIp(rs.getString("FInternetIp"));
		resource.setIntranetIp(rs.getString("FIntranetIp"));
		resource.setPort(rs.getInt("FPort"));
		resource.setLoginName(rs.getString("FLoginName"));
		resource.setLoginPwd(rs.getString("FLoginPwd"));
		return resource;
	}

}
