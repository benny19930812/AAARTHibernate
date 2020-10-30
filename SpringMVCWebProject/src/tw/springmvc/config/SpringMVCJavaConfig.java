package tw.springmvc.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "tw.springmvc")
//@PropertySource("classpath:jdbc.properties")
public class SpringMVCJavaConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;

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
	
	@Bean
	public DataSource getJndiObjectFactoryBean() {
		JndiObjectFactoryBean factoryBean = new JndiObjectFactoryBean();
		factoryBean.setJndiName("java:comp/env/connectOracleJdbc/HibernateService");
		DataSource ds = (DataSource)factoryBean.getObject();
		return ds;
	}
	
	@Bean(destroyMethod = "destroy")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFacory = new LocalSessionFactoryBean();
		sessionFacory.setDataSource(getJndiObjectFactoryBean());
		sessionFacory.setPackagesToScan("tw.leonchen.model");
		
		Properties p1 = new Properties();
		p1.put("hibernate.dialect", org.hibernate.dialect.SQLServerDialect.class);
		p1.put("hibernate.current_session_context_class", "thread");
		p1.put("hibernate.show_sql", Boolean.TRUE);
		p1.put("hibernate.format_sql", Boolean.TRUE);
		
		sessionFacory.setHibernateProperties(p1); 
		
	    return sessionFacory;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images1/**").addResourceLocations("/WEB-INF/pages/images/");
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
