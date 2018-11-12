package com.yuansong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yuansong.global.Global;
import com.yuansong.relationship.CrmRelationShip;
import com.yuansong.resource.CustomerResource;
import com.yuansong.resource.EcsResource;
import com.yuansong.service.CrmRelationShipService;
import com.yuansong.service.ResourceService;

@Controller
@RequestMapping(value="/Crm")
public class CrmController {
	
	private final Logger logger = Logger.getLogger(CrmController.class);
	
	private Gson mGson = new Gson();
	
	@Autowired
	private CrmRelationShipService crmRelationShipService;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(value="/Info",method=RequestMethod.POST)
	public ModelAndView getCrmInfo(@RequestBody String crmInfoStr, Map<String, Object> model){
		
		FormCrmInfo crmInfo = mGson.fromJson(crmInfoStr, FormCrmInfo.class);
		
		CustomerResource customerResource = resourceService.getCustomerByCode(crmInfo.customerCode);
		if(customerResource == null) {
			return Global.getResponseData(-1,  "未找到编码为【" + crmInfo.customerCode + "】的客户信息");
		}
		CrmRelationShip crmRelationShip = crmRelationShipService.getCrmRelationShipByCustomerId(customerResource.getId());
		if(crmRelationShip == null) {
			return Global.getResponseData(-1,  "未找到客户编码【" + crmInfo.customerCode + "】对应的Crm关系信息");
		}
		
		Map<String, Object> rData = new HashMap<String, Object>();
		
		if(crmInfo.requiredInfo.contains("hxDb")) {
			rData.put("hxDb", crmRelationShipService.getHxDbList(crmRelationShip.getId()));			
		}
		
		if(crmInfo.requiredInfo.contains("ecs")) {
			rData.put("ecs", crmRelationShipService.getEcsInfo(crmRelationShip.getId()));
		}
		
		if(crmInfo.requiredInfo.contains("tpProxy")) {
			rData.put("tpProxy", crmRelationShipService.getTpProxyInfo(crmRelationShip.getId()));
		}
		
		if(crmInfo.requiredInfo.contains("appid")) {
			rData.put("appid", crmRelationShip.getAppid());
		}
		
		if(crmInfo.requiredInfo.contains("crmDzServiceAddress")) {
			EcsResource ecsResource = crmRelationShipService.getEcsInfo(crmRelationShip.getId());
			if(ecsResource != null) {
				rData.put("crmDzServiceAddress", "http://" + crmRelationShipService.getEcsInfo(crmRelationShip.getId()) .getInternetIp() + ":" + String.valueOf(crmRelationShip.getCrmDzPort()));				
			}
			else {
				rData.put("crmDzServiceAddress", "");
			}
		}
		
		
		
		logger.debug(mGson.toJson(rData));
		return Global.getResponseData(0, "", rData);
	}

	private class FormCrmInfo{
		String customerCode;
		List<String> requiredInfo;
	}

}
