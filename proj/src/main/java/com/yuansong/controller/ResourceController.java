package com.yuansong.controller;

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
import com.yuansong.global.Global;
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

	@RequestMapping(value="/Customer/Get",method=RequestMethod.GET)
	public ModelAndView getCustomerList(Map<String, Object> model){
		logger.debug("ResourceController getCustomerList");

		return Global.getResponseData(0, "", resourceService.getCustomerList());
	}
	
	@RequestMapping(value="/Customer/Add",method=RequestMethod.POST)
	public ModelAndView addCustomer(@RequestBody String data, Map<String, Object> model) {
		CustomerAddForm form = null;
		CustomerResource resource = null;
		try{
			form = mGson.fromJson(data, CustomerAddForm.class);
			resource = new CustomerResource(form);
			resourceService.resourceAdd(resource);
		}catch(Exception ex) {
			logger.debug(data);
			logger.debug(ex.getMessage());
			ex.printStackTrace();
			return Global.getResponseData(-1, "", ex.getMessage());
		}
		return Global.getResponseData(0, "");
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
