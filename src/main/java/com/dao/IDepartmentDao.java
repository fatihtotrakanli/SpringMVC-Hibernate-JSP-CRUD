/**
 * 
 */
package com.dao;

import java.util.List;

import com.model.Department;
import com.model.Employee;
import com.model.Meetings;


/**
 * @author Fatih Totrakanl�
 *
 */

//interface s�n�flar i�i bo� s�n�flar�n tan�mland��� s�n�flard�r. Implement edilecekleri s�n�flar i�in aray�z g�revi g�r�rler.
//DepartmentDao' da kullan�lacak methodlar. Dao, Data eri�im katman�d�r.
public interface IDepartmentDao {
	
	public void createMeetingsWithDepartments(Employee employee,Department department,Meetings meetings);
	
	public List<Department> findAll();
	
	public Department findById(int dep_id);
	
	public Meetings findMeetingsById(int meet_id);
	
	public void deleteById(int dep_id,int meet_id);
	
}
