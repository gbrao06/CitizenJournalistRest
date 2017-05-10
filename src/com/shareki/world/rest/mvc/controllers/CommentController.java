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
import com.shareki.model.hybernate.entities.Sharekicomment;
import com.shareki.model.hybernate.entities.Sharekinews;
import com.shareki.service.world.intf.ICityService;
import com.shareki.service.world.intf.ICountryService;
import com.shareki.service.world.intf.ISharekiNewsCommentService;
import com.shareki.service.world.intf.ISharekiNewsService;

//This is Spring MVC model

//The Controller implementation is non-public – this is because there is no need for it to be. 
//Usually the controller is the last in the chain of dependencies – it receives HTTP requests from 
//the Spring front controller (the DispathcerServlet) and simply delegate them forward to a service layer.
//If there is no use case where the controller has to be injected or manipulated through a direct reference,
//then I prefer not to declare it as public.

@Controller
 class CommentController{

	@Autowired
	ISharekiNewsCommentService icommentService;
	   
	//getCountryByName(java.lang.String arg0)
	 //called on submitting the form data
	       
	//for unwanted image sharing, make it as dirty
	@RequestMapping(value="news/{newsPK}", method = RequestMethod.GET)
    @ResponseBody
     public List<Sharekicomment> getAllComments(@PathVariable String newsPK)
	 {
    	 return icommentService.getAllComments(newsPK);
     }
    
     @RequestMapping(value="news/dirty/{dirtyFlag}", method = RequestMethod.GET)
     @ResponseBody
     public List<Sharekinews> getAllNewsByDirtyFlag(@PathVariable byte dirtyFlag)
     {
    	 return icommentService.getAllNewsByDirtyFlag(dirtyFlag);
     }
   
     @RequestMapping(value="comments/dirty/{dirtyFlag}", method = RequestMethod.GET)
     @ResponseBody
     public List<Sharekicomment> getAllCommentsByDirtyFlag(@PathVariable byte dirtyFlag)
 	 {
    	 return icommentService.getAllCommentsByDirtyFlag(dirtyFlag);
     }
    
     @RequestMapping(value="add/comment/{comment}/news/{newsPK}/user/{userPK}/flag/{dirtyFlag}", method = RequestMethod.GET)
     @ResponseBody
     public Sharekicomment addSharekiComment(@PathVariable String comment,@PathVariable String newsPK,@PathVariable String userPK,@PathVariable byte dirtyflag)
	 {
    	 return icommentService.addSharekiComment(comment, newsPK, userPK, dirtyflag);
     }
    
}
