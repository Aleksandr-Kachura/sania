package com.test.servlet.model;

/**
 * Created by user on 04.04.16.
 */
public class Department extends Model{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
