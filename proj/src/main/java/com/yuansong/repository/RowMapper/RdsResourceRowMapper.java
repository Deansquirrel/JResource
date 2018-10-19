package com.yuansong.repository.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.common.ConversionTool;
import com.yuansong.resource.RdsResource;

public class RdsResourceRowMapper implements RowMapper<RdsResource> {

	@Override
	public RdsResource mapRow(ResultSet rs, int rowNum) throws SQLException {
		RdsResource resource = new RdsResource();
		resource.setId(rs.getString("FId"));
		resource.setName(rs.getString("FName"));
		resource.setDescription(rs.getString("FDescription"));
		resource.setInstanceID(rs.getString("FInstanceID"));
		resource.setArea(rs.getString("FArea"));
		resource.setDbType(rs.getString("FDbType"));
		resource.setInternetIp(rs.getString("FInternetIp"));
		resource.setInternetPort(rs.getInt("FInternetPort"));
		resource.setIntranetIp(rs.getString("FIntranetIp"));
		resource.setIntranetPort(rs.getInt("FIntranetPort"));
		resource.setExpirationDate(ConversionTool.convertSqlDateToUtilDate(rs.getDate("FExpirationDate")));
		return resource;
	}

}
