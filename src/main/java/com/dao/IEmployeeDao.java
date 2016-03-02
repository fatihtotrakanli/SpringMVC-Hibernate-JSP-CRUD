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
public interface IEmployeeDao {

	public List<Employee> findAllWithJoinDepartmentsToEmployees();
	
	public List<Employee> findAll();
	
	public Employee findById(int emp_id);
	
	public void updateUsers(Employee employee);
	
	public void createEmployeeWithDepartmentInfo(Employee employee,Department department);
	
	public void deleteById(int emp_id);
}
