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

import org.springframework.stereotype.Repository;

import com.model.Department;
import com.model.Employee;


/**
 * @author Fatih Totrakanlý
 *
 */

@Repository
public class DepartmentDaoImpl implements IDepartmentDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Department> findAll() {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Department> criteria = builder.createQuery( Department.class );
        Root<Department> entityRoot = criteria.from( Department.class );
        criteria.select(entityRoot);
        return getEntityManager().createQuery(criteria).getResultList();
	}


	public Department findById(int dep_id) {
		return getEntityManager().getReference(Department.class, dep_id);
	}

	
	public void deleteById(int dep_id) {
		Department department = findById(dep_id);
		delete(department);
}

	public void delete(Department department) {
        getEntityManager().remove(department);
    }

	public EntityManager getEntityManager() {
		return entityManager;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	

	

}
