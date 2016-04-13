package com.test.servlet.dao.impl.hiber;

import com.test.servlet.dao.EmployeeDao;
import com.test.servlet.model.Department;
import com.test.servlet.model.Employee;
import com.test.servlet.util.DBConnectionUtils;
import com.test.servlet.util.HiberUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {


    Session session = HiberUtil.getSessionFactory().openSession();

    public List<Employee> findAllEmployee(int id) throws SQLException {
        session.beginTransaction();
        Query query = session.createQuery("from employee where depId= :depId");
        query.setParameter("depId", id);
        List<Employee> employees = query.list();
        session.getTransaction().commit();

        return employees;
    }

    public void delete(Employee model) throws SQLException {
        try {
            session.beginTransaction();
            session.load(Employee.class, model.getId());
            session.delete(model);
            session.getTransaction().commit();
        } finally {


            session.close();
        }
    }

    /** @deprecated */
    public void add(Employee model) throws SQLException {


        try {
            session.beginTransaction();
            session.load(Employee.class, model.getId());
            session.save(model);

            session.getTransaction().commit();
        } finally {


            session.close();
        }

    }

    /** @deprecated */
    public void update(Employee employee) throws SQLException {

        try {
            session.beginTransaction();
            session.load(Employee.class, employee.getId());
            session.update(employee);

            session.getTransaction().commit();
        } finally {


            session.close();
        }

    }


    public Employee findEmployeeById(int id) throws SQLException {
        Employee employee = new Employee();
        session.beginTransaction();
        Query query = session.createQuery("from employee where id= :id");
        query.setParameter("id", id);
        /* List<?> list= query.list();
        if (list.size() != 0) {
            employee = (Employee) list.get(0);
        }*/
       if ((Employee) query.uniqueResult()!=null)
        {

            employee =(Employee) query.uniqueResult();
        }

        session.getTransaction().commit();
        return  employee;

    }

    public Employee findEmployeeByEmail(String email) throws SQLException {
        Employee employee = new Employee();
        session.beginTransaction();
        Query query = session.createQuery("from employee where email= :email");
        query.setParameter("email",email);
      /* List<?> list= query.list();
        if (list.size() != 0) {
            employee = (Employee) list.get(0);
        }*/
        if ((Employee) query.uniqueResult()!=null)
        {

            employee =(Employee) query.uniqueResult();
        }
        session.getTransaction().commit();
        return  employee;
    }

  public void saveOrUpdate(Employee employee) throws SQLException {
        try {
            session.beginTransaction();
            session.merge(employee);
            session.getTransaction().commit();

        } finally {
            session.close();
        }

    }

    /*public void updateOrSave(Employee empl) throws SQLException
    {
        try {
            session.beginTransaction();
            session.merge(empl);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }*/


}
