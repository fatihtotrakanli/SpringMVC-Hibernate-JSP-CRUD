/**
 * 
 */
package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IDepartmentDao;
import com.model.Department;
import com.model.Employee;

/**
 * @author Fatih Totrakanlý
 *
 */

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService{

	@Autowired
	private IDepartmentDao departmentDao;
	
	public IDepartmentDao getDepartmentDao() {
		return departmentDao;
	}


	public void setDepartmentDao(IDepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}


	public List<Department> findAll() {
		return departmentDao.findAll();
	}


	public Department findById(int dep_id) {
		return departmentDao.findById(dep_id);
	}


	public void deleteById(int dep_id) {
		 departmentDao.deleteById(dep_id);
		
	}

}
