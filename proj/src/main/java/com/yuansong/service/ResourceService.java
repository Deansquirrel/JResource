package com.yuansong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuansong.repository.CommonDbResourceRepository;
import com.yuansong.repository.CustomerResourceRepository;
import com.yuansong.repository.EcsResourceRepository;
import com.yuansong.repository.RdsDbResourceRepository;
import com.yuansong.resource.CommonDbResource;
import com.yuansong.resource.CustomerResource;
import com.yuansong.resource.EcsResource;
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
	
	public int resourceAdd(CustomerResource resource) {
		return customerResourceRepository.addResource(resource);
	}
	
	public int resourceDel(CustomerResource resource) {
		return customerResourceRepository.delResource(resource);
	}
	
	public int resourceAdd(EcsResource resource) {
		return ecsResourceRepository.addResource(resource);
	}
	
	public int resourceDel(EcsResource resource) {
		return ecsResourceRepository.delResource(resource);
	}
	
	public CustomerResource getCustomer(String id) {
		return customerResourceRepository.getResource(id);
	}
	
	public EcsResource getEcs(String id) {
		return ecsResourceRepository.getResource(id);
	}
	
	public CustomerResource getCustomerByCode(String code) {
		return customerResourceRepository.getDataByCode(code);
	}
	
	public List<CustomerResource> 	getCustomerList(){
		return customerResourceRepository.getResourceList();
	}
	
	public List<EcsResource> 	getEcsList(){
		return ecsResourceRepository.getResourceList();
	}
	
	public RdsDbResource getRds(String id) {
		return rdsDbResourceRepository.getResource(id);
	}
	
	public CommonDbResource getDb(String id) {
		return commonDbResourceRepository.getResource(id);
	}

}
