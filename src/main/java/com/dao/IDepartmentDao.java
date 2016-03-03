/**
 * 
 */
package com.dao;

import java.util.List;

import com.model.Department;
import com.model.Employee;
import com.model.Meetings;


/**
 * @author Fatih Totrakanlý
 *
 */

//interface sýnýflar içi boþ sýnýflarýn tanýmlandýðý sýnýflardýr. Implement edilecekleri sýnýflar için arayüz görevi görürler.
//DepartmentDao' da kullanýlacak methodlar. Dao, Data eriþim katmanýdýr.
public interface IDepartmentDao {
	
	public void createMeetingsWithDepartments(Employee employee,Department department,Meetings meetings);
	
	public List<Department> findAll();
	
	public Department findById(int dep_id);
	
	public Meetings findMeetingsById(int meet_id);
	
	public void deleteById(int dep_id,int meet_id);
	
}
