package com.shareki.world.rest.mvc.controllers;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shareki.model.hybernate.entities.Sharekiuser;
import com.shareki.service.world.intf.ISharekiUserService;

//This is Spring MVC model

//The Controller implementation is non-public – this is because there is no need for it to be. 
//Usually the controller is the last in the chain of dependencies – it receives HTTP requests from 
//the Spring front controller (the DispathcerServlet) and simply delegate them forward to a service layer.
//If there is no use case where the controller has to be injected or manipulated through a direct reference,
//then I prefer not to declare it as public.

@Controller
 class UserController{

	@Autowired
	ISharekiUserService iuserService;
	   
	//getCountryByName(java.lang.String arg0)
	 //called on submitting the form data
	       
	//for unwanted image sharing, make it as dirty
	@RequestMapping(value="users", method = RequestMethod.GET)
    @ResponseBody
    public List<Sharekiuser> getAllSharekiUsers()
     {
    	 return iuserService.getAllSharekiUsers();
     }
    
     @RequestMapping(value="add/user/userid/{userid}/firstname/{firstName}/lastname/{lastName}/citizenship/{citizenshipPK}/email/{email}/passwd/{passwd}",produces="application/json", method = RequestMethod.GET)
     @ResponseBody
     public Sharekiuser addSharekiUser(@PathVariable String userid,@PathVariable String firstName,@PathVariable String lastName,@PathVariable String citizenshipPK,@PathVariable String email,@PathVariable String passwd)//returns shareki user with pk
     {
    	 System.out.println("Entered:REST:addSharekiUser:UserId:"+userid);

    	 return iuserService.addSharekiUser(firstName, lastName, citizenshipPK, email, passwd, null, userid);
     }
   
   
     @RequestMapping(value="user/{userId}/passwd/{passwd}", method = RequestMethod.GET)
     @ResponseBody
     public Sharekiuser getSharekiUserByUserId(@PathVariable String userId,@PathVariable String passwd)//returns sharekiuser object
 	{
    	 System.out.println("Entered:REST:getSharekiUserByUserId:UserId:"+userId+"::pass:"+passwd);
    	 
    	 return iuserService.getSharekiUserByUserId(userId,passwd);
    }
  
}
