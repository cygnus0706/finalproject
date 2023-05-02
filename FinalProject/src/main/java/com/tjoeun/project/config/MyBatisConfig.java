package com.tjoeun.project.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import lombok.extern.slf4j.Slf4j;


// javateacher
@Configuration
@Slf4j
public class MyBatisConfig {

	@Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSourceProperties dataSourceProp() {
        return new DataSourceProperties();
    }
	
    @Primary
    @Bean(name="dataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return dataSourceProp().initializeDataSourceBuilder().build();
    }
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		
	    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	    factoryBean.setDataSource(dataSource());
	    
	    return factoryBean.getObject();
	}
	
	@Bean(name="sqlSession")	
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		
		return new SqlSessionTemplate(sqlSessionFactory());
	}

}
