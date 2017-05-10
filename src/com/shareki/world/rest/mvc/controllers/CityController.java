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
import com.shareki.service.world.intf.ICityService;
import com.shareki.service.world.intf.ICountryService;

//This is Spring MVC model

//The Controller implementation is non-public – this is because there is no need for it to be. 
//Usually the controller is the last in the chain of dependencies – it receives HTTP requests from 
//the Spring front controller (the DispathcerServlet) and simply delegate them forward to a service layer.
//If there is no use case where the controller has to be injected or manipulated through a direct reference,
//then I prefer not to declare it as public.

@Controller
 class CityController{

	@Autowired
	ICityService icityService;
	   
	//getCountryByName(java.lang.String arg0)
	 //called on submitting the form data
     @RequestMapping(value="country/{countryName}/cities", method = RequestMethod.GET)
     @ResponseBody
     public List<City> getAllCitiesInCountry(@PathVariable String countryName)
     {
    	 return icityService.getAllCitiesInCountry(countryName);
     }
    
    
     @RequestMapping(value="country/{countryName}/state/{stateName}/cities", method = RequestMethod.GET)
     @ResponseBody
     public List<City> getAllCitiesInState(@PathVariable String countryName,@PathVariable String stateName)
     {
    	 return icityService.getAllCitiesInState(stateName, countryName);
     }
    
     @RequestMapping( value = "country/{countryName}/city/{cityName}",method = RequestMethod.GET )
     @ResponseBody 
     public City getCityByName(@PathVariable String countryName,@PathVariable String cityName)
     {
    	 //return  RestPreconditions.checkNotNull(countryservice.getCountryByName(countryName));
    	  
    	 return icityService.getCityByName(cityName,countryName);
     }
 
     /*
     @RequestMapping( value = "country",method = RequestMethod.POST )
     @ResponseStatus( HttpStatus.CREATED )
     @ResponseBody
     public Long create( @RequestBody Country entity ){
    	 RestPreconditions.checkNotNullFromRequest( entity );
     		return this.service.create( entity );
     }
     
     @RequestMapping( value = "country",method = RequestMethod.PUT )
     @ResponseStatus( HttpStatus.OK )
     public void update( @RequestBody Country entity ){
	     RestPreconditions.checkNotNullFromRequest( entity );
	     RestPreconditions.checkNotNull( this.countryservice.getById( entity.getId() ) );
	     this.countryservice.update( entity );
	  }
     
     @RequestMapping( value = "country/{name}",method = RequestMethod.DELETE )
     @ResponseStatus( HttpStatus.OK )
     public void delete( @PathVariable( "name" ) String countryName ){
    	 this.countryservice.deleteById( name );
     }
    */
     
}
