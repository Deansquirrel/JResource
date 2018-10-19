package com.yuansong.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FixedListRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String GET_LIST_BY_TYPE = ""
			+ "SELECT [FName],[FId]" + 
			"FROM [FixedList]" + 
			"WHERE [FType] = ?";
	
	@Transactional
	public Map<String, Integer> getFiexedList(String type){
		List<FixedObject> list = jdbcTemplate.query(GET_LIST_BY_TYPE, new Object[] {type}, new RowMapper<FixedObject>() {
			@Override
			public FixedObject mapRow(ResultSet rs, int rowNum) throws SQLException {
				FixedObject obj = new FixedObject();
				obj.name = rs.getString("FName");
				obj.id = rs.getInt("FId");
				return obj;
			}
		});
		Map<String, Integer> rData = new HashMap<String, Integer>();
		for(FixedObject obj : list) {
			rData.put(obj.name, obj.id);
		}
		return rData;
	}
	
	private class FixedObject{
		String name;
		int id;
	}

}
