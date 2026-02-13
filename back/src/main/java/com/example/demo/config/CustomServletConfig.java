package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.controller.formatter.LocalDateFormatter;

@Configuration
public class CustomServletConfig implements WebMvcConfigurer {
	// configuration 어노테이션 때문에
	// controller에 가서 먼저 확인하고 온다.
	
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new LocalDateFormatter());
	}
	
	public void addCorsMappings(CorsRegistry registry) {
		// added cross Mapping ?
		registry.addMapping("/**")	// 어플리케이션으로부터 들어오는 모든 경로에 허용
		.allowedOrigins("*")		// 모든 출처 요청 허용
		.allowedMethods("HEAD", "POST", "GET", "PUT", "DELETE", "OPTIONS")	// 브라우저가 보낼 수 있는 메소드 허용
		.maxAge(300)	// 300s 기간 동안 허용
		.allowedHeaders("Authorization", "Cache-Control", "Content-Type");	// 인가요청, 캐시제어, 컨텐츠타입 헤더 허용 
	}
}
