package com.yuansong.repository.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.resource.RedisResource;

public class RedisResourceRowMapper implements RowMapper<RedisResource> {

	@Override
	public RedisResource mapRow(ResultSet rs, int rowNum) throws SQLException {
		RedisResource resource = new RedisResource();
		resource.setId(rs.getString("FId"));
		resource.setName(rs.getString("FName"));
		resource.setDescription(rs.getString("FDescription"));
		resource.setInstanceID(rs.getString("FInstanceID"));
		resource.setArea(rs.getString("FArea"));
		resource.setHost(rs.getString("FHost"));
		resource.setPort(rs.getInt("FPort"));
		resource.setPwd(rs.getString("FPwd"));
		return resource;
	}

}
