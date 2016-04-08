package com.test.servlet.model;


import net.sf.oval.constraint.DateRange;
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
