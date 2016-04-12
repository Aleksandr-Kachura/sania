package com.test.servlet.model;


import com.test.servlet.util.UniqueUtils;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import javax.persistence.*;
import java.util.Set;


@Entity(name="department")
public class Department{

    private Integer id;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    @NotNull
    @NotEmpty(message = "Name is empty")
    @CheckWith(value = UniqueUtils.class,message = "Not Unique")
    private String name;

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
