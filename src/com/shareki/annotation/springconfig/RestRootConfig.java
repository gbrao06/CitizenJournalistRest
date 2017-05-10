package com.shareki.annotation.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 
//1. This is replacement for web.xml where servletname is defined and the sping look at name-servlet.xml for beans.
//2. Don't forget to override getServletMappings with "/", else URL requests will not be redirected to Spring Dispatcher 
    @Configuration
    //@ComponentScan(basePackages={"com.shareki.world.rest.mvc.controllers", "com.shareki.service.world.*","com.shareki.model.world.hybernate.dao.*"})
    @ComponentScan(basePackages={"com.shareki.world.rest.mvc.controllers","com.shareki.model.world.hybernate.util","com.shareki.model.hybernate.entities","com.shareki.service.world.intf","com.shareki.service.world.impl","com.shareki.model.world.hybernate.dao.intf","com.shareki.model.world.hybernate.dao.impl"})
    public class RestRootConfig {

    		
    }

