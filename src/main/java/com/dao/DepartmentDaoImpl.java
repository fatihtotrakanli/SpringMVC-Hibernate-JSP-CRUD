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
import com.model.Meetings;


/**
 * @author Fatih Totrakanlý
 *
 */

@Repository
public class DepartmentDaoImpl implements IDepartmentDao{
	// @Repository Data Access katmanýndaki sýnýflar için kullanýlýr.
	// @Repository kullanýldýktan sonra her nesne bir Bean olarak tanýmlanýr ve @autowired özelliðiyle direk eriþilebilir.
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// Tüm Departmanlarýn listelenmesi
	// Burada Criteria API kullanýlmýþtýr. Hibernate tarafýndan saðlanan bu API sayesinde HQL yazmadan veri tabaný sorgusu yapýlabilir.
	public List<Department> findAll() {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Department> criteria = builder.createQuery( Department.class );
        Root<Department> entityRoot = criteria.from( Department.class );
        criteria.select(entityRoot);
        return getEntityManager().createQuery(criteria).getResultList();
	}

	// Ýstenen 'id' e göre departmanlarýn sýralanmasý
	public Department findById(int dep_id) {
		return getEntityManager().getReference(Department.class, dep_id);
	}
	
	public Meetings findMeetingsById(int meet_id) {
		return getEntityManager().getReference(Meetings.class, meet_id);
	}
	
	public void createMeetingsWithDepartments(Employee employee,Department department,Meetings meetings) {
		meetings.setDep(department);
		getEntityManager().persist(department);
		department.setEmp(employee);
		getEntityManager().persist(meetings);		
		
	}

	// Silinecek departmanýn önce id'sine göre bir instance içine alýnýyor ve daha sonra siliniyor.
	public void deleteById(int dep_id,int meet_id) {
		Department department = findById(dep_id);
		Meetings meetings = findMeetingsById(meet_id);
		delete(department,meetings);
}

	public void delete(Department department,Meetings meetings) {
		getEntityManager().remove(meetings);
        getEntityManager().remove(department);
    }

	public EntityManager getEntityManager() {
		return entityManager;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	

	

}
