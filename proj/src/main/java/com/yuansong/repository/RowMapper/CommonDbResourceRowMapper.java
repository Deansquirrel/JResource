package com.yuansong.repository.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.resource.CommonDbResource;

public class CommonDbResourceRowMapper implements RowMapper<CommonDbResource> {

	@Override
	public CommonDbResource mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommonDbResource resource = new CommonDbResource();
		resource.setId(rs.getString("FId"));
		resource.setName(rs.getString("FName"));
		resource.setDescription(rs.getString("FDescription"));
		resource.setDbName(rs.getString("FDbName"));
		resource.setDbUser(rs.getString("FDbUser"));
		resource.setDbPwd(rs.getString("FDbPwd"));
		resource.setAddress(rs.getString("FAddress"));
		resource.setPort(rs.getInt("FPort"));
		return resource;
	}

}
