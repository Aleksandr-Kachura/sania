package com.test.servlet.dao.impl.hiber;

import com.test.servlet.dao.DepartmentDao;
import com.test.servlet.model.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {


    @Autowired
    private SessionFactory sessionFactory;

    public List<Department> findAll() throws SQLException {

        List<Department> departments = new ArrayList<Department>();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            departments = session.createCriteria(Department.class).list();
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return departments;
    }


    public Department findDepartmentById(int id) throws SQLException {
        Department department = new Department();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Department where id= :id");
        query.setParameter("id", id);
        if (query.uniqueResult() != null) {
            department = (Department) query.uniqueResult();
        }
        return department;

    }

    public Department findDepartmentByName(String name) throws SQLException {
        Department department = new Department();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Department where name= :name");
        query.setParameter("name", name);
        if (query.uniqueResult() != null) {

            department = (Department) query.uniqueResult();
        }


        return department;
    }


    public void delete(Department model) throws SQLException {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(model);
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }


    /**
     * @deprecated
     */
    public void add(Department model) throws SQLException {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();

        } finally {
            session.close();
        }

    }


    /**
     * @deprecated
     */
    public void update(Department model) throws SQLException {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(model);
            session.getTransaction().commit();

        } finally {
            session.close();
        }


    }

    public void saveOrUpdate(Department model) throws SQLException {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.merge(model);
        session.getTransaction().commit();
    }


}
