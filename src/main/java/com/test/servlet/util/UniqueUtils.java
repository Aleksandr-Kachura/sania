package com.test.servlet.util;


import com.test.servlet.model.Department;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created on 08.04.16.
 */
@Component
public class UniqueUtils  implements CheckWithCheck.SimpleCheck {

    @Autowired
    private DepartmentServiceImpl departmentService;

    public boolean isSatisfied(Object validatedObject, Object value)
    {
        try
        {
           Department validate = (Department) validatedObject;
           Department dep = departmentService.findDepartmentByName(value.toString());
           String name = dep.getName();
            if(!value.equals(name) || validate.getId().equals(dep.getId()))
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }catch (NullPointerException e)
        {
            return false;
        }

        return  false;

    }



}
