package com.test.servlet.util;

import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Department;
import com.test.servlet.service.DepartmentService;

import com.test.servlet.service.impl.DepartmentServiceImpl;
import net.sf.oval.constraint.CheckWithCheck;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 08.04.16.
 */
public class UniqueUtils  implements CheckWithCheck.SimpleCheck {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    public boolean isSatisfied(Object validatedObject, Object value)
    {
        try
        {
           Department validate = (Department) validatedObject;
           Department dep = departmentService.findDepartmentByName(value.toString());
           String name = dep.getName();
            if(!value.equals(name))
            {
                return true;
            }
            else
            {
                if (dep.getId() == validate.getId())
                {
                    return true;
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  false;

    }



}
