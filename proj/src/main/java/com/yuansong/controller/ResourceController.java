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
import com.yuansong.form.CommonDbAdd;
import com.yuansong.form.CustomerAdd;
import com.yuansong.form.Del;
import com.yuansong.form.EcsAdd;
import com.yuansong.form.ExceptionLessAdd;
import com.yuansong.form.MongoDBAdd;
import com.yuansong.global.Global;
import com.yuansong.resource.BaseResource;
import com.yuansong.resource.CommonDbResource;
import com.yuansong.resource.CustomerResource;
import com.yuansong.resource.EcsResource;
import com.yuansong.resource.ExceptionlessResource;
import com.yuansong.resource.MongoDBResource;
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
			rData.put("ECS", resourceService.getEcsList());
			rData.put("CommonDb", resourceService.getCommonDbList());
			rData.put("ExceptionLess", resourceService.getExceptionLessList());
			rData.put("MongoDB", resourceService.getMongoDBList());
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());
		}
		return Global.getResponseData(0, "", rData);
	}
	
	//----------------------------------------------------------------------------------------------------------------
	//Customer
	@RequestMapping(value="/Customer/Add",method=RequestMethod.POST)
	public ModelAndView addCustomer(@RequestBody String data, Map<String, Object> model) {
		CustomerAdd form = null;
		CustomerResource resource = null;
		int rows = -1;
		try{
			form = mGson.fromJson(data, CustomerAdd.class);
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
		Del form = null;
		int rows = -1;
		try{
			form = mGson.fromJson(data, Del.class);
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
	//----------------------------------------------------------------------------------------------------------------
	//ECS
	@RequestMapping(value="/Ecs/Add",method=RequestMethod.POST)
	public ModelAndView addEcs(@RequestBody String data, Map<String, Object> model) {
		EcsAdd form = null;
		EcsResource resource = null;
		int rows = -1;
		try{
			form = mGson.fromJson(data, EcsAdd.class);
			resource = new EcsResource(form);
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
	
	@RequestMapping(value="/Ecs/Del",method=RequestMethod.POST)
	public ModelAndView delEcs(@RequestBody String data, Map<String, Object> model) {
		Del form = null;
		int rows = -1;
		try{
			form = mGson.fromJson(data, Del.class);
			EcsResource resource = new EcsResource();
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
	
	@RequestMapping(value="/Ecs/{id}",method=RequestMethod.GET)
	public ModelAndView getEcsResource(@PathVariable String id, Map<String, Object> model){
		logger.debug("ResourceController getEcsResource");
		EcsResource resource = null;
		try {
			resource = resourceService.getEcs(id);
			if(resource != null) {
				return Global.getResponseData(0, "", resource);		
			}
			else {
				return Global.getResponseData(-1, "获取Ecs信息失败【NULL】");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.debug(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());
		}
	}
	//----------------------------------------------------------------------------------------------------------------
	//CommonDb
	@RequestMapping(value="/CommonDb/Add",method=RequestMethod.POST)
	public ModelAndView addCommonDb(@RequestBody String data, Map<String, Object> model) {
		CommonDbAdd form = null;
		CommonDbResource resource = null;
		int rows = -1;
		try{
			form = mGson.fromJson(data, CommonDbAdd.class);
			resource = new CommonDbResource(form);
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
	
	@RequestMapping(value="/CommonDb/Del",method=RequestMethod.POST)
	public ModelAndView delCommonDb(@RequestBody String data, Map<String, Object> model) {
		Del form = null;
		int rows = -1;
		try{
			form = mGson.fromJson(data, Del.class);
			CommonDbResource resource = new CommonDbResource();
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
	
	@RequestMapping(value="/CommonDb/{id}",method=RequestMethod.GET)
	public ModelAndView getCommonDbResource(@PathVariable String id, Map<String, Object> model){
		logger.debug("ResourceController getCommonDbResource");
		CommonDbResource resource = null;
		try {
			resource = resourceService.getCommonDb(id);
			if(resource != null) {
				return Global.getResponseData(0, "", resource);		
			}
			else {
				return Global.getResponseData(-1, "获取数据库信息失败【NULL】");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.debug(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());
		}
	}
	//----------------------------------------------------------------------------------------------------------------
	//ExceptioinLess
	@RequestMapping(value="/ExceptionLess/Add",method=RequestMethod.POST)
	public ModelAndView addExceptionLess(@RequestBody String data, Map<String, Object> model) {
		ExceptionLessAdd form = null;
		ExceptionlessResource resource = null;
		int rows = -1;
		try{
			form = mGson.fromJson(data, ExceptionLessAdd.class);
			resource = new ExceptionlessResource(form);
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
	
	@RequestMapping(value="/ExceptionLess/Del",method=RequestMethod.POST)
	public ModelAndView delExceptionLess(@RequestBody String data, Map<String, Object> model) {
		Del form = null;
		int rows = -1;
		try{
			form = mGson.fromJson(data, Del.class);
			ExceptionlessResource resource = new ExceptionlessResource();
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
	
	@RequestMapping(value="/ExceptionLess/{id}",method=RequestMethod.GET)
	public ModelAndView getExceptionLessResource(@PathVariable String id, Map<String, Object> model){
		logger.debug("ResourceController getCommonDbResource");
		ExceptionlessResource resource = null;
		try {
			resource = resourceService.getExceptionLess(id);
			if(resource != null) {
				return Global.getResponseData(0, "", resource);		
			}
			else {
				return Global.getResponseData(-1, "获取ExceptionLess信息失败【NULL】");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.debug(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());
		}
	}
	
	//----------------------------------------------------------------------------------------------------------------
	//MongoDB
	@RequestMapping(value="/MongoDB/Add",method=RequestMethod.POST)
	public ModelAndView addMongoDB(@RequestBody String data, Map<String, Object> model) {
		MongoDBAdd form = null;
		MongoDBResource resource = null;
		int rows = -1;
		try{
			form = mGson.fromJson(data, MongoDBAdd.class);
			resource = new MongoDBResource(form);
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
	
	@RequestMapping(value="/MongoDB/Del",method=RequestMethod.POST)
	public ModelAndView delMongoDB(@RequestBody String data, Map<String, Object> model) {
		Del form = null;
		int rows = -1;
		try{
			form = mGson.fromJson(data, Del.class);
			MongoDBResource resource = new MongoDBResource();
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
	
	@RequestMapping(value="/MongoDB/{id}",method=RequestMethod.GET)
	public ModelAndView getMongoDBResource(@PathVariable String id, Map<String, Object> model){
		logger.debug("ResourceController getCommonDbResource");
		MongoDBResource resource = null;
		try {
			resource = resourceService.getMongoDB(id);
			if(resource != null) {
				return Global.getResponseData(0, "", resource);		
			}
			else {
				return Global.getResponseData(-1, "获取MongoDB信息失败【NULL】");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.debug(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());
		}
	}
	//----------------------------------------------------------------------------------------------------------------
	
	@RequestMapping(value="/Rds/{id}",method=RequestMethod.GET)
	public ModelAndView getRdsResource(@PathVariable String id, Map<String, Object> model){
		logger.debug("ResourceController getRdsResource");
		if(id == null || id.equals("")) {
			return Global.getResponseData(-1, "ID不能为空");
		}
		return Global.getResponseData(0, "", resourceService.getRds(id));
	}
	
//	@RequestMapping(value="/DB/{id}",method=RequestMethod.GET)
//	public ModelAndView getCommonDbResource(@PathVariable String id, Map<String, Object> model){
//		logger.debug("ResourceController getCommonDbResource");
//		if(id == null || id.equals("")) {
//			return Global.getResponseData(-1, "ID不能为空");
//		}
//		return Global.getResponseData(0, "", resourceService.getDb(id));
//	}	
}
