package com.shareki.world.rest.mvc.controllers;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.shareki.model.hybernate.entities.City;
import com.shareki.model.hybernate.entities.Country;

import com.shareki.model.hybernate.entities.Sharekinews;
import com.shareki.service.world.intf.ICityService;
import com.shareki.service.world.intf.ICountryService;
import com.shareki.service.world.intf.ISharekiNewsService;

//This is Spring MVC model

//The Controller implementation is non-public – this is because there is no need for it to be. 
//Usually the controller is the last in the chain of dependencies – it receives HTTP requests from 
//the Spring front controller (the DispathcerServlet) and simply delegate them forward to a service layer.
//If there is no use case where the controller has to be injected or manipulated through a direct reference,
//then I prefer not to declare it as public.

@Controller
 class NewsController{

	@Autowired
	ISharekiNewsService inewsService;
	   
	//getCountryByName(java.lang.String arg0)
	 //called on submitting the form data
     
	@RequestMapping(value="country/{countryName}/city/{cityName}/news", method = RequestMethod.GET)
    @ResponseBody
     public List<Sharekinews> getAllNewsInCity(@PathVariable String cityName,@PathVariable String countryName)
     {
    	 return inewsService.getAllNewsInCity(cityName, countryName);
     }
    
     @RequestMapping(value="country/{countryName}/city/{cityName}/village/{villageName}/news", method = RequestMethod.GET)
     @ResponseBody
     public List<Sharekinews> getAllNewsInNeighbour(@PathVariable String villageName,@PathVariable String cityName,@PathVariable String countryName)
     {
    	 return inewsService.getAllNewsInNeighbour(villageName, cityName, countryName);
     }
    
     @RequestMapping(value="user/{userId}/allnews", method = RequestMethod.GET)
     @ResponseBody
     public List<Sharekinews> getAllNewsOfUser(@PathVariable String userId)
     {
    	 return inewsService.getAllNewsOfUser(userId);
     }
 

     @RequestMapping(value="emergency/country/{countryName}/city/{cityName}/village/{villageName}/allnews", method = RequestMethod.GET)
     @ResponseBody
     public List<Sharekinews> getAllEmergencyInNeighbour(@PathVariable String villageName,@PathVariable String cityName,@PathVariable String countryName)
     {
    	 return inewsService.getAllEmergencyInNeighbour(villageName, cityName, countryName);
     }
    
     @RequestMapping(value="emergency/country/{countryName}/city/{cityName}/allnews", method = RequestMethod.GET)
     @ResponseBody
     public List<Sharekinews> getAllEmergencyInCity(@PathVariable String cityName,@PathVariable String countryName)
     {
    	 return inewsService.getAllEmergencyInCity(cityName, countryName);
     }
     
     @RequestMapping(value="emergency/country/{countryName}//allnews", method = RequestMethod.GET)
     @ResponseBody
     public List<Sharekinews> getAllEmergencyInCountry(@PathVariable String countryName)
     {
    	 return inewsService.getAllEmergencyInCountry(countryName);
     }
     
}
