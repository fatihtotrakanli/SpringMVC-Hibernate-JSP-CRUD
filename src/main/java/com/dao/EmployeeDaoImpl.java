/**
 * 
 */
package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Department;
import com.model.Employee;

/**
 * @author Fatih Totrakanlý
 *
 */
@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;


	public List<Employee> findAll() {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery( Employee.class );
        Root<Employee> entityRoot = criteria.from( Employee.class );
        criteria.select(entityRoot);
        return getEntityManager().createQuery(criteria).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllWithJoinDepartmentsToEmployees(){
		
		return getEntityManager().createQuery("select a from Department a join fetch a.emp").getResultList();
	}
	
	public Employee findById(int emp_id) {
		return getEntityManager().getReference(Employee.class, emp_id);
	} 


	public void updateUsers(Employee employee) {
		getEntityManager().merge(employee);

	}


	public void createEmployeeWithDepartmentInfo(Employee employee,Department department) {
		department.setEmp(employee);
		getEntityManager().persist(employee);		
		getEntityManager().persist(department);
	}

	public void deleteById(int emp_id) {
			Employee employee = findById(emp_id);
			delete(employee);
	}
	
	 public void delete(Employee employee) {
	        getEntityManager().remove(employee);
	    }
	
	public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
