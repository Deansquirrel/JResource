package com.yuansong.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yuansong.relationship.CrmRelationShip;
import com.yuansong.repository.CommonDbResourceRepository;
import com.yuansong.repository.CrmRelationShipRepository;
import com.yuansong.repository.CustomerResourceRepository;
import com.yuansong.repository.EcsResourceRepository;
import com.yuansong.repository.ExceptionlessResourceRepository;
import com.yuansong.repository.MongoDBResourceRepository;
import com.yuansong.repository.RabbitMQResourceRepository;
import com.yuansong.repository.RdsDbResourceRepository;
import com.yuansong.repository.RdsResourceRepository;
import com.yuansong.repository.RedisResourceRepository;
import com.yuansong.repository.TpProxyResourceRepository;
import com.yuansong.repository.ZxzcServiceResourceRepository;
import com.yuansong.resource.CommonDbResource;
import com.yuansong.resource.CustomerResource;
import com.yuansong.resource.EcsResource;
import com.yuansong.resource.ExceptionlessResource;
import com.yuansong.resource.MongoDBResource;
import com.yuansong.resource.RabbitMQResource;
import com.yuansong.resource.RdsDbResource;
import com.yuansong.resource.RdsResource;
import com.yuansong.resource.RedisResource;
import com.yuansong.resource.TpProxyResource;
import com.yuansong.resource.ZxzcServiceResource;

@Service
public class TestService {
	
	private final Logger logger = Logger.getLogger(TestService.class);
	private Gson mGson = new Gson();
	
	@Autowired
	private CommonDbResourceRepository commonDbResourceRepository;
//	@Autowired
//	private CrmRelationShipExRepository crmRelationShipExRepository;
	@Autowired
	private CrmRelationShipRepository crmRelationShipRepository;
	@Autowired
	private CustomerResourceRepository customerResourceRepository;
	@Autowired
	private EcsResourceRepository ecsResourceRepository;
	@Autowired
	private ExceptionlessResourceRepository exceptionlessResourceRepository;
//	@Autowired
//	private FixedListRepository fixedListRepository;
	@Autowired
	private MongoDBResourceRepository mongoDBResourceRepository;
	@Autowired
	private RabbitMQResourceRepository rabbitMQResourceRepository;
	@Autowired
	private RdsDbResourceRepository rdsDbResourceRepository;
	@Autowired
	private RdsResourceRepository rdsResourceRepository;
	@Autowired
	private RedisResourceRepository redisResourceRepository;
	@Autowired
	private TpProxyResourceRepository tpProxyResourceRepository;
	@Autowired
	private ZxzcServiceResourceRepository zxzcServiceResourceRepository;
	
	
	public Map<String, Object> test() {
		
		Map<String, Object> rData = new HashMap<String, Object>();
		
//		RabbitMQResourceRepository
		for(RabbitMQResource r : rabbitMQResourceRepository.getResourceList()) {
			logger.debug(mGson.toJson(r));
		}
//		CommonDbResourceRepository
		for(CommonDbResource db : commonDbResourceRepository.getResourceList()) {
			logger.debug(mGson.toJson(db));
		}
//		CustomerResourceRepository
		for(CustomerResource r : customerResourceRepository.getResourceList()) {
			logger.debug(mGson.toJson(r));
		}
//		EcsResourceRepository
		for(EcsResource r : ecsResourceRepository.getResourceList()) {
			logger.debug(mGson.toJson(r));
		}
//		ExceptionlessResourceRepository
		for(ExceptionlessResource r : exceptionlessResourceRepository.getResourceList()) {
			logger.debug(mGson.toJson(r));
		}
//		MongoDBResourceRepository
		for(MongoDBResource r : mongoDBResourceRepository.getResourceList()) {
			logger.debug(mGson.toJson(r));
		}

//		RdsDbResourceRepository
		for(RdsDbResource r : rdsDbResourceRepository.getResourceList()) {
			logger.debug(mGson.toJson(r));
		}
//		RdsResourceRepository
		for(RdsResource r : rdsResourceRepository.getResourceList()) {
			logger.debug(mGson.toJson(r));
		}
//		RedisResourceRepository
		for(RedisResource r : redisResourceRepository.getResourceList()) {
			logger.debug(mGson.toJson(r));
		}
//		TpProxyResourceRepository
		for(TpProxyResource r : tpProxyResourceRepository.getResourceList()) {
			logger.debug(mGson.toJson(r));
		}
//		ZxzcServiceResourceRepository
		for(ZxzcServiceResource r : zxzcServiceResourceRepository.getResourceList()) {
			logger.debug(mGson.toJson(r));
		}
//		CrmRelationShipRepository
		List<CrmRelationShip> list = new ArrayList<CrmRelationShip>();
		for(CrmRelationShip crmRelationShip : crmRelationShipRepository.getRelatonShipList()) {
			logger.debug(mGson.toJson(crmRelationShip));
			list.add(crmRelationShip);
		}
		
		rData.put("CrmRelationShip", list);
		
//		CrmRelationShipExRepository

//		FixedListRepository
		
		
		return rData;
	}

}
