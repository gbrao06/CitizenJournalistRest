package com.shareki.world.rest.mvc.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shareki.model.hybernate.entities.State;
import com.shareki.service.world.intf.IStateService;

//This is Spring MVC model

//The Controller implementation is non-public – this is because there is no need for it to be. 
//Usually the controller is the last in the chain of dependencies – it receives HTTP requests from 
//the Spring front controller (the DispathcerServlet) and simply delegate them forward to a service layer.
//If there is no use case where the controller has to be injected or manipulated through a direct reference,
//then I prefer not to declare it as public.

@Controller
 class StateController{

	@Autowired
	IStateService istateService;
	   
	//getCountryByName(java.lang.String arg0)
	 //called on submitting the form data
     @RequestMapping(value="country/{countryName}/states", method = RequestMethod.GET)
     @ResponseBody
     public List<State> getAllStatesInCountry(@PathVariable String countryName)
     {
    	 return istateService.getAllStatesInCountry(countryName);
     }
    
     @RequestMapping(value="country/{countryName}/state/{stateName}", method = RequestMethod.GET)
     @ResponseBody
     public State getStateByName(@PathVariable String countryName,@PathVariable String stateName)
     {
    	 return istateService.getStateByName(stateName, countryName);
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
