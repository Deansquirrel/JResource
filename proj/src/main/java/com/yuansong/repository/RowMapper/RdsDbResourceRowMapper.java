package com.yuansong.repository.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.resource.RdsDbResource;

public class RdsDbResourceRowMapper implements RowMapper<RdsDbResource> {

	@Override
	public RdsDbResource mapRow(ResultSet rs, int rowNum) throws SQLException {
		RdsDbResource resource = new RdsDbResource();
		resource.setId(rs.getString("FId"));
		resource.setName(rs.getString("FName"));
		resource.setDescription(rs.getString("FDescription"));
		resource.setDbName(rs.getString("FDbName"));
		resource.setDbUser(rs.getString("FDbUser"));
		resource.setDbPwd(rs.getString("FDbPwd"));
		resource.setRdsId(rs.getString("FRdsId"));
		return resource;
	}

}
