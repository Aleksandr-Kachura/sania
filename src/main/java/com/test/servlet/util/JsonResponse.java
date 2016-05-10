package com.test.servlet.util;


import com.test.servlet.model.Department;
import com.test.servlet.model.Employee;

import java.util.List;
import java.util.Map;

public class JsonResponse {

    private String status = null;

    private Map<String,String> error = null;

    private  List<Department> department =null;

    private  List<Employee> employee =null;

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }




    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public Map<String, String> getError() {
        return error;
    }

    public void setError(Map<String, String> error) {
        this.error = error;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
