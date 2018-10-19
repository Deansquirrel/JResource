package com.yuansong.repository.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.resource.ExceptionlessResource;

public class ExceptionlessResourceRowMapper implements RowMapper<ExceptionlessResource> {

	@Override
	public ExceptionlessResource mapRow(ResultSet rs, int rowNum) throws SQLException {
		ExceptionlessResource resource = new ExceptionlessResource();
		resource.setId(rs.getString("FId"));
		resource.setName(rs.getString("FName"));
		resource.setDescription(rs.getString("FDescription"));
		resource.setUrl(rs.getString("FUrl"));
		resource.setLoginName(rs.getString("FLoginName"));
		resource.setLoginPwd(rs.getString("FLoginPwd"));
		return resource;
	}

}
