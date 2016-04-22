package com.test.servlet.model;


import com.test.servlet.util.UniqueEmailUtils;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.DateRange;
import net.sf.oval.constraint.Email;
import net.sf.oval.constraint.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "depId")
    private Department department;

    @NotEmpty(message = "FirstName is empty")
    @Column(name = "firstName")
    private String firstName;

    @NotEmpty(message = "SecondName is empty")
    @Column(name = "secondName")
    private String secondName;


    @DateRange(format = "MM/DD/YYYY", message = "Invalid Format", min = "01/01/1900", max = "now")
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/DD/YYYY")
    private Date birthday;

    @NotEmpty(message = "Email is empty")
    @Email(message = "Invalid format")
    @CheckWith(value = UniqueEmailUtils.class, message = "Not Unique")
    @Column(name = "email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


}
