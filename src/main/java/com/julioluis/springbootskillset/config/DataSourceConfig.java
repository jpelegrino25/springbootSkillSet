package com.julioluis.springbootskillset.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource getDataSource() throws NamingException,IllegalArgumentException{

        JndiObjectFactoryBean factoryBean=new JndiObjectFactoryBean();
        factoryBean.setJndiName(environment.getProperty("jdbc.url"));
        factoryBean.setProxyInterface(DataSource.class);
        factoryBean.setLookupOnStartup(false);
        factoryBean.afterPropertiesSet();
        return (DataSource) factoryBean.getObject();

    }

}
