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
 * @author Fatih Totrakanl�
 *
 */

@Repository
public class DepartmentDaoImpl implements IDepartmentDao{
	// @Repository Data Access katman�ndaki s�n�flar i�in kullan�l�r.
	// @Repository kullan�ld�ktan sonra her nesne bir Bean olarak tan�mlan�r ve @autowired �zelli�iyle direk eri�ilebilir.
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// T�m Departmanlar�n listelenmesi
	// Burada Criteria API kullan�lm��t�r. Hibernate taraf�ndan sa�lanan bu API sayesinde HQL yazmadan veri taban� sorgusu yap�labilir.
	public List<Department> findAll() {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Department> criteria = builder.createQuery( Department.class );
        Root<Department> entityRoot = criteria.from( Department.class );
        criteria.select(entityRoot);
        return getEntityManager().createQuery(criteria).getResultList();
	}

	// �stenen 'id' e g�re departmanlar�n s�ralanmas�
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

	// Silinecek departman�n �nce id'sine g�re bir instance i�ine al�n�yor ve daha sonra siliniyor.
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
