/*-
 *  File    :   Main.java
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


import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.Session;

import com.acme.sample.entity.Employee;


/**
 * @author Raviraj S Mahamuni
 * @date Jun 23, 2018
 * @since 1.0
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // BootStrap Hibernate

        Session session = HibernateUtil.getSessionFactory().openSession();

        Employee employee = new Employee("Raviraj", 12, LocalDate.now(),
                new BigDecimal("132.456"));

        System.out.println(employee);

        org.hibernate.Transaction tr = session.beginTransaction();
        Integer id = null;
        try {

            id = (Integer) session.save(employee);

        } catch (Exception e) {

            e.printStackTrace();
            tr.rollback();
        }

        tr.commit();

        session.get(Employee.class, id);

        System.out.println("saved " + employee);

    }
}
