/**
 * Project name: LoginSecurity
 * Package name: com.example.demo.config
 * File name: WebMvcConfig.java
 * Author: ptphuong.
 * Created date: Jan 15, 2019
 * Created time: 9:48:35 AM
 */

package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * @author ptphuong.
 * Created date: Jan 15, 2019
 * Created time: 9:48:35 AM
 * Description: TODO - 
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	return bCryptPasswordEncoder;

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/webjars/**", "/images/**", "/css/**", "/js/**").addResourceLocations(
		"classpath:/META-INF/resources/webjars/", "classpath:/static/images/", "classpath:/static/css/",
		"classpath:/static/js/");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(loginInterceptor);
    }

}