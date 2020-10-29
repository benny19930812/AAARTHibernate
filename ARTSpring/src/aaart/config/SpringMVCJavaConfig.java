package aaart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "aaart")
//@PropertySource("classpath:jdbc.properties")
public class SpringMVCJavaConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;
	
	public SpringMVCJavaConfig() {
		
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//		addProperties();
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver myViewResolver = new InternalResourceViewResolver();
		myViewResolver.setPrefix("/WEB-INF/pages/");
		myViewResolver.setSuffix(".jsp");
		return myViewResolver;
	}
	
	private void addProperties() {
		String driverClassName = env.getRequiredProperty("datasource.driverClassName");
		String url = env.getRequiredProperty("datasource.url");
		String username = env.getRequiredProperty("datasource.username");
		String password = env.getRequiredProperty("datasource.password");
		
		System.out.println("driverClassName:" + driverClassName);
		System.out.println("url:" + url);
		System.out.println("username:" + username);
		System.out.println("password:" + password);
	}
	
}
