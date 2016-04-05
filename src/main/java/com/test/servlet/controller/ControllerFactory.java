package com.test.servlet.controller;

import com.test.servlet.controller.dep.AddDep;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

    private Map<String, InternalController> controllerMap = new HashMap<String, InternalController>();

    private InternalController defaultController = new DefController();


    {
        controllerMap.put("/", defaultController);
        controllerMap.put("/dep", new AddDep());
        //controllerMap.put("/showDep");
    }

    public InternalController getControllerByName(String name){
        return controllerMap.get(name);
    }

    public InternalController getDefaultController(){
        return defaultController;
    }

}
