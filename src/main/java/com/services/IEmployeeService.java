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

public interface IEmployeeService {

	public List<Employee> findAllWithJoinDepartmentsToEmployees();
	
	public List<Employee> findAll();
	
	public Employee findById(int emp_id);
	
	public void createEmployeeWithDepartmentInfo(Employee employee, Department department);
	
	public void deleteById(int emp_id);
}
