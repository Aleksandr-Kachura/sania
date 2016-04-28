package com.test.servlet.dao.impl.hiber;

import com.test.servlet.dao.DepartmentDao;
import com.test.servlet.model.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public DepartmentDaoImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }


    @SuppressWarnings("unchecked") //kill warning transform list
    public List<Department> findAll() throws SQLException {
        List<Department> departments;
        departments = currentSession().createCriteria(Department.class).list();
        return departments;
    }


    public Department findDepartmentById(Integer id) throws SQLException {
        Department department = new Department();
        Query query = currentSession().createQuery("from Department where id= :id");
        query.setParameter("id", id);
        if (query.uniqueResult() != null) {
            department = (Department) query.uniqueResult();
        }
        return department;

    }


    public Department findDepartmentByName(String name) throws SQLException {
        Department department = new Department();
        Query query = currentSession().createQuery("from Department where name= :name");
        query.setParameter("name", name);
        if (query.uniqueResult() != null) {

            department = (Department) query.uniqueResult();
        }


        return department;
    }


    public void delete(Department model) throws SQLException {
        currentSession().delete(model);
    }


    public void saveOrUpdate(Department model) throws SQLException {
        currentSession().merge(model);

    }


}
