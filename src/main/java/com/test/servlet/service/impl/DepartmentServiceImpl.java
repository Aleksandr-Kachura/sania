package com.test.servlet.service.impl;

import com.test.servlet.dao.DepartmentDao;
import com.test.servlet.dao.impl.hiber.DepartmentDaoImpl;
import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Department;
import com.test.servlet.service.DepartmentService;
import com.test.servlet.util.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private ValidatorUtils util = new ValidatorUtils();

    @Autowired
    private DepartmentDaoImpl departmentDao ;

    @Override
    @Transactional(readOnly = true)
    public List<Department> findAll() throws SQLException {
        return departmentDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Department findDepartmentById(int id) throws SQLException {
        return departmentDao.findDepartmentById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Department findDepartmentByName(String name) throws SQLException {
        return departmentDao.findDepartmentByName(name.toString());
    }
    /** @deprecated */
    @Override
    @Transactional
    public void add(Department dep) throws SQLException, ValidationException {
        util.validate(dep);
        departmentDao.add(dep);
    }

    @Override
    @Transactional
    public void delete(Department dep) throws SQLException {
        departmentDao.delete(dep);
    }

    /** @deprecated */
    @Override
    @Transactional
    public void update(Department dep) throws SQLException, ValidationException {
        util.validate(dep);
        departmentDao.update(dep);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Department dep) throws SQLException, ValidationException
    {
        util.validate(dep);
        departmentDao.saveOrUpdate(dep);
    }

}
