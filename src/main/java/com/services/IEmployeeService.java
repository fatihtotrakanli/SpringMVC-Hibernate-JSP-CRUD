/**
 * 
 */
package com.services;

import java.util.List;

import com.model.Department;
import com.model.Employee;

/**
 * @author Fatih Totrakanl�
 *
 */
//interface s�n�flar i�i bo� s�n�flar�n tan�mland��� s�n�flard�r. Implement edilecekleri s�n�flar i�in aray�z g�revi g�r�rler.
//EmployeeService' de kullan�lacak methodlar. Service, b�t�n Business-Logic katman�ndaki s�n�flar i�in kullan�l�r.
public interface IEmployeeService {

	public List<Employee> findAllWithJoinDepartmentsToEmployees();
	
	public List<Employee> findAll();
	
	public Employee findById(int emp_id);
	
	public void createEmployeeWithDepartmentInfo(Employee employee, Department department);
	
	public void deleteById(int emp_id);
}
