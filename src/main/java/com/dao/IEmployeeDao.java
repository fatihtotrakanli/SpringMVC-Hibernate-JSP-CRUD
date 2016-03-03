/**
 * 
 */
package com.dao;

import java.util.List;

import com.model.Department;
import com.model.Employee;

/**
 * @author Fatih Totrakanl�
 *
 */

//interface s�n�flar i�i bo� s�n�flar�n tan�mland��� s�n�flard�r. Implement edilecekleri s�n�flar i�in aray�z g�revi g�r�rler.
//EmployeeDao' da kullan�lacak methodlar. Dao, Data eri�im katman�d�r.
public interface IEmployeeDao {

	public List<Employee> findAllWithJoinDepartmentsToEmployees();
	
	public List<Employee> findAll();
	
	public Employee findById(int emp_id);
	
	public void updateUsers(Employee employee);
	
	public void createEmployeeWithDepartmentInfo(Employee employee,Department department);
	
	public void deleteById(int emp_id);
}
