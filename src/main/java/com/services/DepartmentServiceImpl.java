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
 * @author Fatih Totrakanlý
 *
 */

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService{

	
	// Bütün Business-Logic katmanýndaki sýnýflarda @service anostasyonu kullanýlmaktadýr.
	// @transactional veritabanýndaki verilerin doðru ve diðer verilerle tutarlý olmasýný saðlamak için kullanýlan bir yöntemdir.
	
	// @service anotasyonu ayný zamanda nesneleri otomatik olarak Bean olarak oluþturmaktadýr.
	// Aþaðýda Autowired ile IDepartmentDao interface'inden oluþturulan departmentDao Bean'i inject edilmiþtir.
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
