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
import com.model.Meetings;

/**
 * @author Fatih Totrakanl�
 *
 */

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService{

	
	// B�t�n Business-Logic katman�ndaki s�n�flarda @service anostasyonu kullan�lmaktad�r.
	// @transactional veritaban�ndaki verilerin do�ru ve di�er verilerle tutarl� olmas�n� sa�lamak i�in kullan�lan bir y�ntemdir.
	
	// @service anotasyonu ayn� zamanda nesneleri otomatik olarak Bean olarak olu�turmaktad�r.
	// A�a��da Autowired ile IDepartmentDao interface'inden olu�turulan departmentDao Bean'i inject edilmi�tir.
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


	public void deleteById(int dep_id,int meet_id) {
		 departmentDao.deleteById(dep_id,meet_id);
		
	}
	
	public void createMeetingsWithDepartments(Employee employee,Department department,Meetings meetings){
		departmentDao.createMeetingsWithDepartments(employee, department, meetings);
		
	}


	public Meetings findMeetingsById(int meet_id) {
		return departmentDao.findMeetingsById(meet_id);
	}

}
