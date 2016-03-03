/**
 * 
 */
package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IEmployeeDao;
import com.model.Department;
import com.model.Employee;

/**
 * @author Fatih Totrakanlý
 *
 */


@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	// Bütün Business-Logic katmanýndaki sýnýflarda @service anostasyonu kullanýlmaktadýr.
	// @transactional veritabanýndaki verilerin doðru ve diðer verilerle tutarlý olmasýný saðlamak için kullanýlan bir yöntemdir.
	
	// @service anotasyonu ayný zamanda nesneleri otomatik olarak Bean olarak oluþturmaktadýr.
	// Aþaðýda Autowired ile IEmployeeDao interface'inden oluþturulan employeeDao Bean'i inject edilmiþtir.
	@Autowired
	private IEmployeeDao employeeDao;
	
	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
	public List<Employee> findAllWithJoinDepartmentsToEmployees(){
		return employeeDao.findAllWithJoinDepartmentsToEmployees();
	}
	public Employee findById(int emp_id) {
		return employeeDao.findById(emp_id);
	}

	
	public void createEmployeeWithDepartmentInfo(Employee employee, Department department) {
		try {
			employeeDao.createEmployeeWithDepartmentInfo(employee,department);
		} catch (Exception e) {
		
		}
		
	}

	
	public void deleteById(int emp_id) {
		try {
			employeeDao.deleteById(emp_id);
		} catch (Exception e) {
		
		}
		
	}
}
