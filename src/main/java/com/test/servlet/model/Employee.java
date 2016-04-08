package com.test.servlet.model;


import com.test.servlet.util.DateUtils;
import com.test.servlet.util.UniqueUtils;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.guard.Guarded;

import java.util.Date;


public class Employee extends Model {

    private  int depId;

    @NotEmpty(message = "FirstName is empty")
    private String firstName;

    @NotEmpty(message = "SecondName is empty")
    private String secondName;

    @CheckWith(value = DateUtils.class,message = "Invalid format")
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
