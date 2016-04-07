package com.test.servlet.model;


import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.guard.Guarded;



@Guarded
public class Department extends Model{

    @NotNull
    @NotEmpty(message = "Name is empty")
     private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
