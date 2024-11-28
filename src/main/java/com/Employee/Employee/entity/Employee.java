package com.Employee.Employee.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
            private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email")
    private String email;
    public Employee(){}
    public Employee(String first_name,String last_name,String email){
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
    }

}
