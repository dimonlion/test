package com.onlineshop.config;



import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.web.bind.support.AuthenticationPrincipalArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;






@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan(basePackages = "com.onlineshop")
@Import({ApplicationContext.class,SecurityConfig.class})
@PropertySource("classpath:mysql-connection.properties")
//@PropertySource("classpath:h2.properties")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	 @Bean
	    public ViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }
	
	 @Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			
			registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
			
		}
	 
	 @Bean
	 public MessageSource messageSource() {
	     ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	     source.setBasename("i18n/messages");
	     source.setDefaultEncoding("UTF-8");
	     return source;
	 }
	 
}
