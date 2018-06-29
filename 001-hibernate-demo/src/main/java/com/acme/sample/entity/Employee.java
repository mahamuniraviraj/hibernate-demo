

package com.acme.sample.entity;


// Generated Jun 23, 2018 5:45:04 PM by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


/**
 * Employee generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Employee", catalog = "sample_hibernate")
public class Employee implements java.io.Serializable {

    private Integer empId;
    private String name;
    private Integer age;
    private LocalDate dateOfBirth;
    private BigDecimal salary;

    public Employee() {
    }

    public Employee(String name, Integer age, LocalDate dateOfBirth,
                    BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "empId", unique = true, nullable = false)
    public Integer getEmpId() {
        return this.empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Column(name = "name", length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age")
    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // @Temporal(TemporalType.DATE)
    @Type(type = "org.hibernate.type.LocalDateType")
    @Column(name = "dateOfBirth", length = 10)
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "salary", precision = 10)
    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + ", age=" + age
                + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + "]";
    }

}