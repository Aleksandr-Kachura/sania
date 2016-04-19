package com.test.servlet.dao.impl.hiber;

import com.test.servlet.dao.EmployeeDao;
import com.test.servlet.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {



    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }


    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployee(Integer id) throws SQLException {
        Query query = currentSession().createQuery("from Employee where department.id= :depId");
        query.setParameter("depId", id);
        List<Employee> employees = query.list();
        return employees;
    }

    public void delete(Employee model) throws SQLException {
        currentSession().delete(model);
    }



    public Employee findEmployeeById(Integer id) throws SQLException {
        Employee employee = new Employee();
        Query query = currentSession().createQuery("from Employee where id= :id");
        query.setParameter("id", id);
        if (query.uniqueResult() != null) {

            employee = (Employee) query.uniqueResult();
        }
        return employee;

    }

    public Employee findEmployeeByEmail(String email) throws SQLException {
        Employee employee = new Employee();

        Query query = currentSession().createQuery("from Employee where email= :email");
        query.setParameter("email", email);
        if (query.uniqueResult() != null) {

            employee = (Employee) query.uniqueResult();
        }
         return employee;
    }

    public void saveOrUpdate(Employee employee) throws SQLException {

        currentSession().merge(employee);

    }


}
