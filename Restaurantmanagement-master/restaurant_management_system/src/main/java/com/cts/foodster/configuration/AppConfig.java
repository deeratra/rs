package com.cts.foodster.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value={@ComponentScan("com.cts.foodster.dao"),
		@ComponentScan("com.cts.foodster.service")
})
public class AppConfig {
	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory(){
	LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	Properties properties = new Properties();	
	properties.put(org.hibernate.cfg.Environment.DRIVER, environment.getProperty("mysql.driver"));
	properties.put(org.hibernate.cfg.Environment.URL, environment.getProperty("mysql.url"));
	properties.put(org.hibernate.cfg.Environment.USER, environment.getProperty("mysql.user"));
	properties.put(org.hibernate.cfg.Environment.PASS, environment.getProperty("mysql.password"));
	//hibernate settings
	
	properties.put(org.hibernate.cfg.Environment.SHOW_SQL, environment.getProperty("hibernate.show_sql"));
	properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, environment.getProperty("hibernate.hbm2ddl.auto"));
	
	
	
	properties.put(org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE, 
            environment.getProperty("hibernate.c3p0.min_size"));
      properties.put(org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE, 
            environment.getProperty("hibernate.c3p0.max_size"));
      properties.put(org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT,
            environment.getProperty("hibernate.c3p0.acquire_increment"));
      properties.put(org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT, 
            environment.getProperty("hibernate.c3p0.timeout"));
      properties.put(org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS, 
            environment.getProperty("hibernate.c3p0.max_statements"));

      sessionFactoryBean.setHibernateProperties(properties);
  	sessionFactoryBean.setPackagesToScan("com.cts.foodster.bean");
	
	return sessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(){
		HibernateTransactionManager transaction = new HibernateTransactionManager();
		transaction.setSessionFactory(getSessionFactory().getObject());
		return transaction;
	}
	
}
