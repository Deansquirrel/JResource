package com.yuansong.repository.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.resource.TpProxyResource;

public class TpProxyResourceRowMapper implements RowMapper<TpProxyResource> {

	@Override
	public TpProxyResource mapRow(ResultSet rs, int rowNum) throws SQLException {
		TpProxyResource resource = new TpProxyResource();
		resource.setId(rs.getString("FId"));
		resource.setName(rs.getString("FName"));
		resource.setDescription(rs.getString("FDescription"));
		resource.setUrl(rs.getString("FUrl"));
		resource.setPort(rs.getInt("FPort"));
		resource.setCrmDataCenterDbId(rs.getString("FCrmDataCenterDbId"));
		resource.setCrmDataCenterDbType(rs.getInt("FCrmDataCenterDbType"));
		resource.setTpO2OProxyConfigDbId(rs.getString("FTpO2OProxyConfigDbId"));
		resource.setTpO2OProxyConfigDbType(rs.getInt("FTpO2OProxyConfigDbType"));
		return resource;
	}

}
