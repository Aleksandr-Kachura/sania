package com.test.servlet.util;

import com.test.servlet.model.Employee;
import com.test.servlet.service.impl.EmployeeServiceImpl;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created on 08.04.16.
 */
@Component
public class UniqueEmailUtils implements CheckWithCheck.SimpleCheck {

    @Autowired
    private EmployeeServiceImpl emplService ;

    public boolean isSatisfied(Object validatedObject, Object value)
    {
        try
        {
           Employee validate = (Employee) validatedObject;
           Employee empl = emplService.findEmployeeByEmail(value.toString());
           String email = empl.getEmail();
            if(!value.equals(email) || empl.getId().equals(validate.getId()))
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
