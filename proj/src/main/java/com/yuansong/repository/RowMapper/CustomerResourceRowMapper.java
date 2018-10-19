package com.yuansong.repository.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.resource.CustomerResource;

public class CustomerResourceRowMapper implements RowMapper<CustomerResource> {

	@Override
	public CustomerResource mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerResource resource = new CustomerResource();
		resource.setId(rs.getString("FId"));
		resource.setName(rs.getString("FName"));
		resource.setDescription(rs.getString("FDescription"));
		resource.setCode(rs.getString("FCode"));
		resource.setShowName(rs.getString("FShowName"));
		resource.setSimpleName(rs.getString("FSimpleName"));
		resource.setPinyinName(rs.getString("FPinyinName"));
		resource.setMisType(rs.getString("FMisType"));
		resource.setTongdCode(rs.getString("FTongdCode"));
		return resource;
	}

}
