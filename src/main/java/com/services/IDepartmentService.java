/**
 * 
 */
package com.services;

import java.util.List;

import com.model.Department;

/**
 * @author Fatih Totrakanlý
 *
 */

public interface IDepartmentService {
	

	
	public List<Department> findAll();
	
	public Department findById(int dep_id);
	
	public void deleteById(int dep_id);
	
}
