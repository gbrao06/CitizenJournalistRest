package com.shareki.annotation.springconfig;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import org.springframework.cglib.*;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
 
//1. This is replacement for web.xml where servletname is defined and the sping look at name-servlet.xml for beans.
//2. Don't forget to override getServletMappings with "/", else URL requests will not be redirected to Spring Dispatcher 
  
	//WebMvcConfigurationSupport is the actual class which enables @EnableWebMVC. If it is enabled no need to extend
	@Configuration
    
    @ComponentScan(basePackages={"com.shareki.world.rest.mvc.controllers","com.shareki.model.world.hybernate.util","com.shareki.model.hybernate.entities","com.shareki.service.world.intf","com.shareki.service.world.impl","com.shareki.model.world.hybernate.dao.intf","com.shareki.model.world.hybernate.dao.impl"})
	
    public class RestWebMvcConfig extends WebMvcConfigurationSupport  {

    	//to add jackson mapper

    	@Override
		public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    		System.out.println("Inside WebMVCConfig::configureMessageConverters");
    	
    		converters.add(jsonJacksonConvertor());
            addDefaultHttpMessageConverters(converters);
        }
    	
    	@Bean
        public InternalResourceViewResolver viewResolver() {
            
    		System.out.println("Inside WebAppConfig::viewResolver");
    		InternalResourceViewResolver resolver = 
                        new InternalResourceViewResolver();
            //resolver.setPrefix("/WEB-INF/");
    		resolver.setPrefix("/");//keep the jsps outside WEB-INF
            resolver.setSuffix(".jsp");
           
            return resolver;
        }
    	
    	
    	@Bean
        public CommonsMultipartResolver multipartResolver() {
            
    		System.out.println("Inside WebAppConfig::viewResolver");
    		CommonsMultipartResolver resolver = 
                        new CommonsMultipartResolver();
            //resolver.setPrefix("/WEB-INF/");
    		
            resolver.setMaxUploadSize(10000000);
            return resolver;
        }

    	@Override
        @Bean
        public HandlerMapping resourceHandlerMapping() {
    		System.out.println("Inside WebAppConfig::resourceHandlerMapping");
    		AbstractHandlerMapping handlerMapping = (AbstractHandlerMapping) super.resourceHandlerMapping();
            handlerMapping.setOrder(-1);
            return handlerMapping;
        }
    	
    	//Stores registrations of resource handlers for serving static resources such as images, css files and others through Spring MVC including setting cache headers optimized for efficient loading in a web browser. Resources can be served out of locations under web application root, from the classpath, and others.
    	@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
    		System.out.println("Inside WebAppConfig::addResourceHandler");
    	    registry.addResourceHandler("/images/**").addResourceLocations("/images/");
    	}
    	
    	/*
    	//equalent to <mvc:resources mapping="/resources/**" location="/resources/" /> in web.xml
    	@Override
    	public void addResourceHandlers(ResourceHandlerRegistry registry) {

    		System.out.println("Inside WebAppConfig::addResourceHandler");
    	    registry.addResourceHandler("/images/**").addResourceLocations("/images/");
    	}
    	*/
    	
    	@Bean
    	public MappingJacksonHttpMessageConverter jsonJacksonConvertor()
    	{
    		System.out.println("Inside WebAppConfig::jsonJackson1");
        	
    		MappingJacksonHttpMessageConverter convertor=new MappingJacksonHttpMessageConverter();
			//convertor.setSupportedMediaTypes(MediaType.APPLICATION_JSON);
    		
    		return convertor;
    		
    	}
    	
    	
    }

