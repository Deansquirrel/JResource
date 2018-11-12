package com.yuansong.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.yuansong.resource.BaseResource;

@Repository
public abstract class BaseResourceRepository<T extends BaseResource> {
	
	private final Logger logger = Logger.getLogger(BaseResourceRepository.class);
	
	private Gson mGson = null;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	protected abstract String getGetSql();
	protected abstract String getGetListSql();
	protected abstract String getAddSql();
	protected abstract Object[] getAddParams(T resource);
	protected abstract String getDelSql();
	protected abstract Object[] getDelParams(T resource);
	
	protected abstract RowMapper<T> getRowMapper();
	
	public BaseResourceRepository() {
		mGson = new Gson();
	}
	
	@Transactional
	public T getResource(String id) {
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
	public List<T> getResourceList(){
		return jdbcTemplate.query(getGetListSql(), getRowMapper());
	}
	
	@Transactional
	public int addResource(T resource) {
		logger.info("AddResource - " + mGson.toJson(resource));
		return jdbcTemplate.update(getAddSql(), getAddParams(resource));
	}
	
	@Transactional
	public int delResource(T resource) {
		logger.info("DelResource - " + mGson.toJson(resource));
		return  jdbcTemplate.update(getDelSql(), getDelParams(resource));
	}
	
	protected JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}
