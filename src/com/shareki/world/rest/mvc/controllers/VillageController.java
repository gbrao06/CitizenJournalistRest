package com.shareki.world.rest.mvc.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shareki.model.hybernate.entities.Cityneighbour;
import com.shareki.model.hybernate.entities.Sharekinews;
import com.shareki.service.world.intf.ICityNeighbourService;

//This is Spring MVC model

//The Controller implementation is non-public – this is because there is no need for it to be. 
//Usually the controller is the last in the chain of dependencies – it receives HTTP requests from 
//the Spring front controller (the DispathcerServlet) and simply delegate them forward to a service layer.
//If there is no use case where the controller has to be injected or manipulated through a direct reference,
//then I prefer not to declare it as public.

@Controller
 class VillageController{

	@Autowired
	ICityNeighbourService ivillageService;
	   
	//getCountryByName(java.lang.String arg0)
	 //called on submitting the form data

	@RequestMapping(value="country/{countryName}/city/{cityName}/neighbours", method = RequestMethod.GET)
    @ResponseBody
	public List<Cityneighbour> getAllNeighboursOfCity(@PathVariable String cityName,@PathVariable String countryName)
	{
		System.out.println("Service:getAllNeighboursOfCity:City="+cityName+"::Countryw="+countryName);
		return ivillageService.getAllNeighboursOfCity(cityName, countryName);
	}
	
	@RequestMapping(value="country/{countryName}/city/{cityName}/village/{villageName}", method = RequestMethod.GET)
    @ResponseBody
    public Cityneighbour getCityneighbour(@PathVariable String villageName,@PathVariable String cityName,@PathVariable String countryName)
	{
		return ivillageService.getCityneighbour(villageName, cityName, countryName);
	}
	
	@RequestMapping(value="addneighbour/country/{countryName}/city/{cityName}/village/{villageName}", method = RequestMethod.GET)
    @ResponseBody
    public Cityneighbour addCityNeighbour(@PathVariable String villageName,@PathVariable String cityName,@PathVariable String countryName)
	{
		return ivillageService.addCityNeighbour(villageName, cityName, countryName);
	}

	@RequestMapping(value="addnews/country/{countryName}/city/{cityName}/village/{villageName}/title/{title}/news/{news}/image/ip/{ip}/port/{port}/context/{context}/dir/{dir}/filename/{filename}/who/{userPK}", method = RequestMethod.GET)
    @ResponseBody
    public Sharekinews addSharekiNew(@PathVariable String title,@PathVariable String news,@PathVariable String ip,@PathVariable String port,@PathVariable String context,@PathVariable String dir,@PathVariable String filename,@PathVariable String villageName,@PathVariable String cityName,@PathVariable String countryName,@PathVariable String userPK) throws Exception
	{
		System.out.println("ENTERED:REST:VillageController:addSharekiNew");
		String image="http";
		image+=":";
		image+="//";
		image+=ip;
		image+=":";
		image+=port;
		image+="/";
		image+=context;
		image+="/";
		image+=dir;
		image+="/";
		image+=filename;
		
		System.out.println(":REST:VillageController:addSharekiNew:URL Path:"+image);
		
		ImageReader reader=new ImageReader();
		byte[] data=null;
		try
		{
			data=reader.getBytes(image);
		}
		catch(Exception ee)
		{
			System.out.println("REST:VillageCOntroller:Exception:"+ee.getMessage());
		}
		if(data==null)
			System.out.println("REST:VillageCOntroller:DATA=NULL:");
		
		return ivillageService.addSharekiNew(title,news, data, villageName, cityName, countryName, userPK);
	}

	@RequestMapping(value="add/ehelp/country/{countryName}/city/{cityName}/village/{villageName}/title/{title}/news/{news}/who/{userPK}", method = RequestMethod.GET)
    @ResponseBody
    public Sharekinews addSharekiEHelp(@PathVariable String title,@PathVariable String news,@PathVariable String villageName,@PathVariable String cityName,@PathVariable String countryName,@PathVariable String userPK) throws Exception
	{
		System.out.println("ENTERED:REST:VillageController:addSharekiEHelp");
			
		return ivillageService.addSharekiEHelp(title,news,villageName, cityName, countryName, userPK);
	}

}
