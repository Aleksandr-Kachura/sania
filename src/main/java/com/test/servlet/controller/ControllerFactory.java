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
        controllerMap.put("/addDep", new AddDep());
        controllerMap.put("/saveDep", new SaveDep());
        controllerMap.put("/showAllDep",new ShowAllDep());
        controllerMap.put("/delDep",new DelDep());
        controllerMap.put("/editDep",new EditDep());
        controllerMap.put("/showAllEmpl",new ShowAllEmpl());
        controllerMap.put("/addEmpl", new AddEmpl());
        controllerMap.put("/saveEmpl", new SaveEmpl());
        controllerMap.put("/delEmpl",new DelEmpl());
        controllerMap.put("/editEmpl",new EditEmpl());

    }

    public InternalController getControllerByName(String name){
        return controllerMap.get(name);
    }

    public InternalController getDefaultController(){
        return defaultController;
    }

}
