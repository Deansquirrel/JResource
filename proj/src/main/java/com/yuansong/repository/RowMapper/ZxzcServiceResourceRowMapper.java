package com.yuansong.repository.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.resource.ZxzcServiceResource;

public class ZxzcServiceResourceRowMapper implements RowMapper<ZxzcServiceResource> {

	@Override
	public ZxzcServiceResource mapRow(ResultSet rs, int rowNum) throws SQLException {
		ZxzcServiceResource resource = new ZxzcServiceResource();
		resource.setId(rs.getString("FId"));
		resource.setName(rs.getString("FName"));
		resource.setDescription(rs.getString("FDescription"));
		resource.setUrl(rs.getString("FUrl"));
		resource.setPort(rs.getInt("FPort"));
		resource.setServiceName(rs.getString("FServiceName"));
		resource.setDbId(rs.getString("FDbId"));
		resource.setDbType(rs.getInt("FDbType"));
		return resource;
	}

}
