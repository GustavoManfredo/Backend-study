package com.api.carshop.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "employee_phone", nullable = false, unique = true, length = 16)
    private String employeePhone;

    @Column(name = "employee_cpf", nullable = false, unique = true, length = 11)
    private String employeeCPF;

    @Column(name = "employee_email", nullable = false, unique = true, length = 75)
    private String employeeEmail;

    @Column(name = "employee_jobTitle", nullable = false, length = 75)
    private String employeeJobTitle;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeCPF() {
        return employeeCPF;
    }

    public void setEmployeeCPF(String employeeCPF) {
        this.employeeCPF = employeeCPF;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeJobTitle() {
        return employeeJobTitle;
    }

    public void setEmployeeJobTitle(String employeeJobTitle) {
        this.employeeJobTitle = employeeJobTitle;
    }
}
