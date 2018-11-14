package com.yuansong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yuansong.form.CustomerAddForm;
import com.yuansong.form.DelForm;
import com.yuansong.global.Global;
import com.yuansong.resource.BaseResource;
import com.yuansong.resource.CustomerResource;
import com.yuansong.service.ResourceService;

@Controller
@RequestMapping(value="/Resource")
public class ResourceController {
	
	private final Logger logger = Logger.getLogger(ResourceController.class);
	
	private Gson mGson = null;
	
	@Autowired
	private ResourceService resourceService;
	
	public ResourceController() {
		mGson = new Gson();
	}
	
	@RequestMapping(value="/List",method=RequestMethod.GET)
	public ModelAndView getBaseResourceList(Map<String, Object> model) {
		Map<String, List<? extends BaseResource>> rData = new HashMap<String, List<? extends BaseResource>>();
		try {
			rData.put("Customer", resourceService.getCustomerList());	
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());
		}
		return Global.getResponseData(0, "", rData);
	}
	
	@RequestMapping(value="/Customer/Add",method=RequestMethod.POST)
	public ModelAndView addCustomer(@RequestBody String data, Map<String, Object> model) {
		CustomerAddForm form = null;
		CustomerResource resource = null;
		int rows = -1;
		try{
			form = mGson.fromJson(data, CustomerAddForm.class);
			resource = new CustomerResource(form);
			String checkStr = resource.check();
			if(checkStr.equals("")) {
				rows = resourceService.resourceAdd(resource);				
			}
			else {
				return Global.getResponseData(-1, checkStr);				
			}
		}catch(Exception ex) {
			logger.debug(data);
			logger.debug(ex.getMessage());
			ex.printStackTrace();
			return Global.getResponseData(-1, "", ex.getMessage());
		}
		return Global.getResponseData(0, "", rows);
	}
	
	@RequestMapping(value="/Customer/Del",method=RequestMethod.POST)
	public ModelAndView delCustomer(@RequestBody String data, Map<String, Object> model) {
		DelForm form = null;
		int rows = -1;
		try{
			form = mGson.fromJson(data, DelForm.class);
			CustomerResource resource = new CustomerResource();
			resource.setId(form.getId());
			rows = resourceService.resourceDel(resource);
			
		}catch(Exception ex) {
			logger.debug(data);
			logger.debug(ex.getMessage());
			ex.printStackTrace();
			return Global.getResponseData(-1, "", ex.getMessage());
		}
		return Global.getResponseData(0, "", rows);
	}
	
	@RequestMapping(value="/Customer/{id}",method=RequestMethod.GET)
	public ModelAndView getCustomerResource(@PathVariable String id, Map<String, Object> model){
		logger.debug("ResourceController getCustomerResource");
		CustomerResource resource = null;
		try {
			resource = resourceService.getCustomer(id);
			if(resource != null) {
				return Global.getResponseData(0, "", resource);		
			}
			else {
				return Global.getResponseData(-1, "获取客户信息失败【NULL】");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.debug(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());
		}
	}

	@RequestMapping(value="/Customer/Get",method=RequestMethod.GET)
	public ModelAndView getCustomerList(Map<String, Object> model){
		logger.debug("ResourceController getCustomerList");

		return Global.getResponseData(0, "", resourceService.getCustomerList());
	}
	
	@RequestMapping(value="/Rds/{id}",method=RequestMethod.GET)
	public ModelAndView getRdsResource(@PathVariable String id, Map<String, Object> model){
		logger.debug("ResourceController getRdsResource");
		if(id == null || id.equals("")) {
			return Global.getResponseData(-1, "ID不能为空");
		}
		return Global.getResponseData(0, "", resourceService.getRds(id));
	}
	
	@RequestMapping(value="/DB/{id}",method=RequestMethod.GET)
	public ModelAndView getCommonDbResource(@PathVariable String id, Map<String, Object> model){
		logger.debug("ResourceController getCommonDbResource");
		if(id == null || id.equals("")) {
			return Global.getResponseData(-1, "ID不能为空");
		}
		return Global.getResponseData(0, "", resourceService.getDb(id));
	}	
}
