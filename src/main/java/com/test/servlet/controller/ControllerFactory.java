package com.test.servlet.controller;

import com.test.servlet.controller.dep.*;
import com.test.servlet.controller.empl.*;



import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

    private Map<String, InternalController> controllerMap = new HashMap<String, InternalController>();

    private InternalController defaultController = new DefController();

    {
        controllerMap.put("/", defaultController);
        controllerMap.put("/addDep", new addDep());
        controllerMap.put("/saveDep", new saveDep());
        controllerMap.put("/showAllDep",new showAllDep());
        controllerMap.put("/delDep",new delDep());
        controllerMap.put("/editDep",new editDep());
        controllerMap.put("/showAllEmpl",new showAllEmpl());
        controllerMap.put("/addEmpl", new addEmpl());
        controllerMap.put("/saveEmpl", new saveEmpl());
        controllerMap.put("/delEmpl",new delEmpl());
        controllerMap.put("/editEmpl",new editEmpl());

    }

    public InternalController getControllerByName(String name){
        return controllerMap.get(name);
    }

    public InternalController getDefaultController(){
        return defaultController;
    }

}
