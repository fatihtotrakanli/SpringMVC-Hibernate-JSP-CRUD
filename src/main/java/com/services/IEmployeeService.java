/**
 * 
 */
package com.services;

import java.util.List;

import com.model.Department;
import com.model.Employee;

/**
 * @author Fatih Totrakanlý
 *
 */
//interface sýnýflar içi boþ sýnýflarýn tanýmlandýðý sýnýflardýr. Implement edilecekleri sýnýflar için arayüz görevi görürler.
//EmployeeService' de kullanýlacak methodlar. Service, bütün Business-Logic katmanýndaki sýnýflar için kullanýlýr.
public interface IEmployeeService {

	public List<Employee> findAllWithJoinDepartmentsToEmployees();
	
	public List<Employee> findAll();
	
	public Employee findById(int emp_id);
	
	public void createEmployeeWithDepartmentInfo(Employee employee, Department department);
	
	public void deleteById(int emp_id);
}
