package com.yuansong.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.yuansong.relationship.BaseRelationShip;

@Repository
public abstract class BaseRelationShipRepository<T extends BaseRelationShip> {
	
	private final Logger logger = Logger.getLogger(BaseRelationShipRepository.class);
	
	private Gson mGson = null;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	protected abstract String getGetSql();
	protected abstract String getGetListSql();
	protected abstract String getAddSql();
	protected abstract Object[] getAddParams(T relatonShip);
	protected abstract String getDelSql();
	protected abstract Object[] getDelParams(T relatonShip);
	
	protected abstract RowMapper<T> getRowMapper();
	
	public BaseRelationShipRepository() {
		mGson = new Gson();
	}
	
	@Transactional
	public T getRelatonShip(String id) {
		List<T> list = jdbcTemplate.query(getGetSql(), new Object[] {id}, getRowMapper());			
		if(list.size() == 1 ) {
			return list.get(0);
		}
		else {
			if(list.size() == 0) {
				return null;
			}
			else {
				throw new RuntimeException("查询返回异常。【" + String.valueOf(list.size()) + "】");
			}
		}
	}
	
	@Transactional
	public List<T> getRelatonShipList(){
		return jdbcTemplate.query(getGetListSql(), getRowMapper());
	}
	
	@Transactional
	public int addRelatonShip(T relatonShip) {
		logger.info("AddRelatonShip - " + mGson.toJson(relatonShip));
		return jdbcTemplate.update(getAddSql(), getAddParams(relatonShip));
	}
	
	@Transactional
	public int delRelatonShip(T relatonShip) {
		logger.info("DelRelatonShip - " + mGson.toJson(relatonShip));
		return  jdbcTemplate.update(getDelSql(), getDelParams(relatonShip));
	}

}
