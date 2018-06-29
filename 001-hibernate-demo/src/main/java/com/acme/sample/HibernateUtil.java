/*-
 *  File    :   HibernateUtil.java
 *  Version	:   1.0
 *	Date    :   Jun 23, 2018
 *  Author  :   Raviraj S Mahamuni
 *
 * Copyright (c) 1993-2015 Acme Infovision Private Limited, Satara. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Acme Infovision
 * Private Limited. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Acme.
 */


package com.acme.sample;


import java.util.HashMap;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.acme.sample.entity.Employee;


/**
 * @author Raviraj S Mahamuni
 * @date Jun 23, 2018
 * @since 1.0
 */
public class HibernateUtil {

    private static SessionFactory concreteSessionFactory;

    static {
        // concreteSessionFactory = anotherWayToCreateSessionFactory();
        concreteSessionFactory = bootStrapHibernate();
    }

    public static SessionFactory getSessionFactory() {
        return concreteSessionFactory;
    }

    public static Session getCurrentSession() {
        return concreteSessionFactory.getCurrentSession();
    }

    public static SessionFactory bootStrapHibernate() {

        HashMap<String, String> settings = new HashMap<>();
        settings.put("hibernate.connection.url",
                "jdbc:mysql://172.16.2.63:3306/sample_hibernate");
        settings.put("hibernate.connection.username", "AcmeInfi");
        settings.put("hibernate.connection.password", "ProteasLankans");
        settings.put("dialect", "org.hibernate.dialect.MySQLDialect");
        settings.put("hibernate.current_session_context_class", "thread");
        settings.put("hibernate.show_sql", "true");

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .applySettings(settings).build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addPackage("com.acme.sample.entity")
                .addAnnotatedClass(Employee.class)
                // .addResource("org/hibernate/example/Order.hbm.xml")
                // .addResource("org/hibernate/example/Product.orm.xml")
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(
                        ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
        /* .applyBeanManager(getBeanManagerFromSomewhere()) */.build();

        return sessionFactory;
    }

    private SessionFactory anotherWayToCreateSessionFactory() {

        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url",
                "jdbc:mysql://172.16.2.63:3306/sample_hibernate");
        prop.setProperty("hibernate.connection.username", "AcmeInfi");
        prop.setProperty("hibernate.connection.password", "ProteasLankans");
        prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        prop.setProperty("hibernate.current_session_context_class", "thread");
        prop.setProperty("hibernate.show_sql", "true");

        SessionFactory sessionFactory = new Configuration().addProperties(prop)
                .addPackage("com.acme.sample.entity")
                .addAnnotatedClass(Employee.class).buildSessionFactory();

        return sessionFactory;

    }

}
