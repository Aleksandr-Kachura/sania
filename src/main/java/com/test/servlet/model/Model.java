package com.test.servlet.model;

/**
 * Created by user on 04.04.16.
 */
import java.io.Serializable;

public class Model implements Serializable {
    private int id;

    public Model() {

    }


    public Model(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}



