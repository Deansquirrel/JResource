package com.yuansong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuansong.global.FixedListType;
import com.yuansong.relationship.CrmRelationShip;
import com.yuansong.repository.CrmRelationShipExRepository;
import com.yuansong.repository.CrmRelationShipRepository;
import com.yuansong.repository.EcsResourceRepository;
import com.yuansong.repository.RdsDbResourceRepository;
import com.yuansong.repository.TpProxyResourceRepository;
import com.yuansong.resource.EcsResource;
import com.yuansong.resource.RdsDbResource;
import com.yuansong.resource.TpProxyResource;

@Service
public class CrmRelationShipService {
	
	@Autowired
	private CrmRelationShipRepository crmRelationShipRepository;
	
	@Autowired
	private CrmRelationShipExRepository crmRelationShipExRepository; 
	
	@Autowired
	private RdsDbResourceRepository rdsDbResourceRepository;
	
	@Autowired
	private EcsResourceRepository ecsResourceRepository;
	
	@Autowired
	private TpProxyResourceRepository tpProxyResourceRepository;
	
	public CrmRelationShip getCrmRelationShipByCustomerId(String customerId) {
		return crmRelationShipRepository.getDataByCustomerId(customerId);
	}
	
	public List<RdsDbResource> getHxDbList(String crmRelationShipId){
		List<String> idList = crmRelationShipExRepository.getRidList(crmRelationShipId, FixedListType.CrmRelationShip, 3);
		List<RdsDbResource> dbList = new ArrayList<RdsDbResource>();
		for(String id : idList) {
			dbList.add(rdsDbResourceRepository.getResource(id));
		}
		return dbList;
	}
	
	public EcsResource getEcsInfo(String crmRelationShipId) {
		List<String> idList = crmRelationShipExRepository.getRidList(crmRelationShipId, FixedListType.CrmRelationShip, 0);
		if(idList.size() > 0) {
			return ecsResourceRepository.getResource(idList.get(0));
		}
		return null;
	}
	
	public TpProxyResource getTpProxyInfo(String crmRelationShipId) {
		return tpProxyResourceRepository.getResource(crmRelationShipRepository.getRelatonShip(crmRelationShipId).getTpProxyId());
	}

}
