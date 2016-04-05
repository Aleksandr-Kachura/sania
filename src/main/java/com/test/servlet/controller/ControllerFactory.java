package com.test.servlet.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

    private Map<String, InternalController> controllerMap = new HashMap<String, InternalController>();

    private InternalController defaultController = new ShowAllDepartmentsController();


    {
        controllerMap.put("/", defaultController);
        //controllerMap.put("/showDep");
    }

    public InternalController getControllerByName(String name){
        return controllerMap.get(name);
    }

    public InternalController getDefaultController(){
        return defaultController;
    }

}
