package com.zc.eurekaclient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by zhuCan on 2018/12/3.
 * Project parent.
 * Date 2018/12/3 : 14:23.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactorySecondary",
transactionManagerRef = "transactionManagerSecondary",
basePackages = "com.zc.eurekaclient.secondaryDomain")
public class SecondaryDataSourceConfig {

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource secondaryDataSource;

    @Bean(name = "entityManagerSecondary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){

        return entityManagerFactorySecondary(builder).getObject().createEntityManager();
    }

    @Value("${jpa.properties.hibernate.secondary-dialect}")
    private String dialect;

    @Bean(name = "entityManagerFactorySecondary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(EntityManagerFactoryBuilder builder){

        return builder
                .dataSource(secondaryDataSource)
                .properties(getVendorProperties(secondaryDataSource))
                .packages("com.zc.eurekaclient.secondaryDomain")
                .persistenceUnit("secondaryPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String ,String> getVendorProperties(DataSource dataSource){
        jpaProperties.getProperties().put("hibernate.dialect",dialect);
        return jpaProperties.getProperties();
    }

    @Bean
    PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder){
        return  new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
    }

}
