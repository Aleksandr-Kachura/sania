package com.test.servlet.model;


import com.test.servlet.util.UniqueUtils;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.guard.Guarded;




public class Department extends Model{

    @NotNull
    @NotEmpty(message = "Name is empty")
    @CheckWith(value = UniqueUtils.class,message = "Not Unique")
     private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
