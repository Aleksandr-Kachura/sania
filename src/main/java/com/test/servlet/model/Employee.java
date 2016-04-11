package com.test.servlet.model;


import com.test.servlet.util.UniqueEmailUtils;
import com.test.servlet.util.UniqueUtils;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.DateRange;
import net.sf.oval.constraint.Email;
import net.sf.oval.constraint.NotEmpty;

import java.util.Date;


public class Employee extends Model {

    private  int depId;

    @NotEmpty(message = "FirstName is empty")
    private String firstName;

    @NotEmpty(message = "SecondName is empty")
    private String secondName;


    @DateRange( format = "MM/DD/YYYY", message="Invalid Format", min="01/01/1900",max = "now")
    private Date birthday;

    @NotEmpty(message = "Email is empty")
    @Email(message = "Invalid format")
    @CheckWith(value = UniqueEmailUtils.class,message = "Not Unique")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
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


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }



}
