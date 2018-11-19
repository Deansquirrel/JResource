package com.yuansong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuansong.repository.CommonDbResourceRepository;
import com.yuansong.repository.CustomerResourceRepository;
import com.yuansong.repository.EcsResourceRepository;
import com.yuansong.repository.ExceptionlessResourceRepository;
import com.yuansong.repository.MongoDBResourceRepository;
import com.yuansong.repository.RdsDbResourceRepository;
import com.yuansong.resource.CommonDbResource;
import com.yuansong.resource.CustomerResource;
import com.yuansong.resource.EcsResource;
import com.yuansong.resource.ExceptionlessResource;
import com.yuansong.resource.MongoDBResource;
import com.yuansong.resource.RdsDbResource;

@Service
public class ResourceService {
	
	@Autowired
	private CustomerResourceRepository customerResourceRepository;
	
	@Autowired
	private EcsResourceRepository ecsResourceRepository;
	
	@Autowired
	private RdsDbResourceRepository rdsDbResourceRepository;
	
	@Autowired
	private CommonDbResourceRepository commonDbResourceRepository;
	
	@Autowired
	private ExceptionlessResourceRepository exceptionlessResourceRepository; 
	
	@Autowired
	private MongoDBResourceRepository mongoDBResourceRepository;
	
	//------------------------------------------------------------------------------------------
	
	public int resourceAdd(CustomerResource resource) {
		return customerResourceRepository.addResource(resource);
	}
	
	public int resourceDel(CustomerResource resource) {
		return customerResourceRepository.delResource(resource);
	}
	
	public CustomerResource getCustomer(String id) {
		return customerResourceRepository.getResource(id);
	}
	
	public CustomerResource getCustomerByCode(String code) {
		return customerResourceRepository.getDataByCode(code);
	}
	
	public List<CustomerResource> 	getCustomerList(){
		return customerResourceRepository.getResourceList();
	}
	
	//------------------------------------------------------------------------------------------
	
	public int resourceAdd(EcsResource resource) {
		return ecsResourceRepository.addResource(resource);
	}
	
	public int resourceDel(EcsResource resource) {
		return ecsResourceRepository.delResource(resource);
	}
	
	public EcsResource getEcs(String id) {
		return ecsResourceRepository.getResource(id);
	}
	
	public List<EcsResource> 	getEcsList(){
		return ecsResourceRepository.getResourceList();
	}
	
	//------------------------------------------------------------------------------------------
	
	public int resourceAdd(CommonDbResource resource) {
		return commonDbResourceRepository.addResource(resource);
	}
	
	public int resourceDel(CommonDbResource resource) {
		return commonDbResourceRepository.delResource(resource);
	} 
	
	public CommonDbResource getCommonDb(String id) {
		return commonDbResourceRepository.getResource(id);
	}
	
	public List<CommonDbResource> 	getCommonDbList(){
		return commonDbResourceRepository.getResourceList();
	}
	
	//------------------------------------------------------------------------------------------
	
	public int resourceAdd(ExceptionlessResource resource) {
		return exceptionlessResourceRepository.addResource(resource);
	}
	
	public int resourceDel(ExceptionlessResource resource) {
		return exceptionlessResourceRepository.delResource(resource);
	} 
	
	public ExceptionlessResource getExceptionLess(String id) {
		return exceptionlessResourceRepository.getResource(id);
	}
	
	public List<ExceptionlessResource> 	getExceptionLessList(){
		return exceptionlessResourceRepository.getResourceList();
	}
	
	//------------------------------------------------------------------------------------------
	
	public int resourceAdd(MongoDBResource resource) {
		return mongoDBResourceRepository.addResource(resource);
	}
	
	public int resourceDel(MongoDBResource resource) {
		return mongoDBResourceRepository.delResource(resource);
	} 
	
	public MongoDBResource getMongoDB(String id) {
		return mongoDBResourceRepository.getResource(id);
	}
	
	public List<MongoDBResource> 	getMongoDBList(){
		return mongoDBResourceRepository.getResourceList();
	}
	
	//------------------------------------------------------------------------------------------
	
	public RdsDbResource getRds(String id) {
		return rdsDbResourceRepository.getResource(id);
	}
	
	
	
	
	
	
	
	
	

	

}
