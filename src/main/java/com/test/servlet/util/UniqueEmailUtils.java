package com.test.servlet.util;

import com.test.servlet.model.Department;
import com.test.servlet.model.Employee;
import com.test.servlet.service.DepartmentService;
import com.test.servlet.service.EmployeeService;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import com.test.servlet.service.impl.EmployeeServiceImpl;
import net.sf.oval.constraint.CheckWithCheck;

import java.sql.SQLException;

/**
 * Created on 08.04.16.
 */
public class UniqueEmailUtils implements CheckWithCheck.SimpleCheck {

    private EmployeeService emplService = new EmployeeServiceImpl();

    public boolean isSatisfied(Object validatedObject, Object value)
    {
        try
        {
           Employee validate = (Employee) validatedObject;
           Employee empl = emplService.findEmployeeByEmail(value.toString());
           String email = empl.getEmail();
            if(!value.equals(email))
            {
                return true;
            }
            else
            {
                if (empl.getId() == validate.getId())
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
