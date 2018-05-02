package com.zzn.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@SpringBootApplication
@ComponentScan("com.zzn.demo.**")
@MapperScan("com.zzn.demo.mapper")//扫描
public class MyBlogApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(MyBlogApplication.class, args);		
	}
	
	@Bean
	public LogInterceptor logInterceptor() {
		return new LogInterceptor();
	}
	
	//接口拦截器配置
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(logInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/register","/allArticleList","/fiveAllArticleList","/artTotalCount");
//		registry.addInterceptor(logInterceptor()).addPathPatterns("/static/**").excludePathPatterns("/login","/register","/allArticleList");
	}
	
	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**");
	}*/
}
