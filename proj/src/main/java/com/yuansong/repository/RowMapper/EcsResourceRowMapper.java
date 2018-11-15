package com.yuansong.repository.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yuansong.common.ConversionTool;
import com.yuansong.resource.EcsResource;

public class EcsResourceRowMapper implements RowMapper<EcsResource> {

	@Override
	public EcsResource mapRow(ResultSet rs, int rowNum) throws SQLException {
		EcsResource resource = new EcsResource();
		resource.setId(rs.getString("FId"));
		resource.setName(rs.getString("FName"));
		resource.setDescription(rs.getString("FDescription"));
		resource.setInstanceID(rs.getString("FInstanceID"));
		resource.setArea(rs.getString("FArea"));
		resource.setInternetIp(rs.getString("FInternetIp"));
		resource.setIntranetIp(rs.getString("FIntranetIp"));
		resource.setOs(rs.getString("FOs"));
		resource.setExpirationDate(ConversionTool.convertSqlDateToUtilDate(rs.getDate("FExpirationDate")));
		resource.setRdpPort(rs.getInt("FRdpPort"));
		resource.setLoginName(rs.getString("FLoginName"));
		resource.setLoginPwd(rs.getString("FLoginPwd"));
		return resource;
	}

}
