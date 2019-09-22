package com.onlineshop.config;


import java.util.EnumSet;

import javax.servlet.DispatcherType;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration implements WebApplicationInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
		rootContext.register(WebConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		
		addEncodingFilter(servletContext);
		//it will delegate to a bean named springSecurityFilterChain, which is defined implicitly by your use of the Spring Security XML namespace.
		//HttpServletRequest, and sends it through to the filter springSecurityFilterChain. This filter is a composite of numerous filters that deal with
        //different parts of the authentication/authorization process
		DelegatingFilterProxy filterProxy=new DelegatingFilterProxy("springSecurityFilterChain");
		
		DispatcherServlet dispatcherServlet=new DispatcherServlet(rootContext);
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		
		ServletRegistration.Dynamic registration=servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		
		
	 
        servletContext.addFilter("springSecurityFilterChain", filterProxy).addMappingForUrlPatterns(null, false, "/*");
        
        registration.setLoadOnStartup(1);
		registration.addMapping("/");
		
	}
	
	
	
	private void addEncodingFilter(ServletContext servletContext) {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        EnumSet<DispatcherType> dispatcherTypes
                = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ERROR);

        FilterRegistration.Dynamic characterEncoding
                = servletContext.addFilter("characterEncoding", characterEncodingFilter);
        characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
        characterEncoding.setAsyncSupported(true);
    }
	
}
