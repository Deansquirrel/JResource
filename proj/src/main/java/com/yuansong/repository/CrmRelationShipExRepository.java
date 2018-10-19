package com.yuansong.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yuansong.global.FixedListType;

@Repository
public class CrmRelationShipExRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String GET_RID = ""
			+ "SELECT [FRId]" + 
			"FROM [CrmRelationShipEx]" + 
			"WHERE FRelationShipId = ?" + 
			"	AND FType = ?" + 
			"	AND FTypeId = ?";
	
	@Transactional
	public List<String> getRidList(String crmRelationShipId, FixedListType type, Integer typeId){
		return jdbcTemplate.queryForList(GET_RID, String.class, new Object[] {crmRelationShipId,type.toString(),typeId});
	}

}
