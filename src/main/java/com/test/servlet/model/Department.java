package com.test.servlet.model;


import com.test.servlet.util.UniqueUtils;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.ValidateWithMethod;
import org.hibernate.annotations.Filter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "department")
public class Department{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 6, nullable = false)
    private Integer id;

    @NotNull
    @NotEmpty(message = "Name is empty")
    @CheckWith(value = UniqueUtils.class,message = "Not Unique")
    @Column(name = "name")
    private String name;



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
