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
 * @author Fatih Totrakanl�
 *
 */
@Repository  
public class EmployeeDaoImpl implements IEmployeeDao {
	// @Repository Data Access katman�ndaki s�n�flar i�in kullan�l�r.
	// @Repository kullan�ld�ktan sonra her nesne bir Bean olarak tan�mlan�r ve @autowired �zelli�iyle direk eri�ilebilir.
	
	@PersistenceContext
	private EntityManager entityManager;

	// T�m ���ilerin listelenmesi
	// Burada Criteria API kullan�lm��t�r. Hibernate taraf�ndan sa�lanan bu API sayesinde HQL yazmadan veri taban� sorgusu yap�labilir.
	public List<Employee> findAll() {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery( Employee.class );
        Root<Employee> entityRoot = criteria.from( Employee.class );
        criteria.select(entityRoot);
        return getEntityManager().createQuery(criteria).getResultList();
	}
	
	// Bu methodda iki tablonun bir araya getirilmesi sa�lanm��t�r.
	// Fetch stratejilerinde OneToOne ve ManyToOne default olarak EAGER iken, ManyToMany ve OneToMany ise LAZY stratejisindedir.
	// LAZY : Tembel y�kleme, as�l nesne �a��r�m� sonras�nda lazy ili�kili nesnelerden bilgi getirilmez.
	// EAGER : Direkt y�kleme, as�l nesne �a��r�m� ile birlikte ili�kili nesne bilgiside getirilir.
	// Burada "join fetch" kullan�lmas�n�n sebebi OneToMany 'nin LAZY stratejisinde olmas�ndand�r. "join fetch" sayesinde tek sorguda �ekilebilir.
	@SuppressWarnings("unchecked")
	public List<Employee> findAllWithJoinDepartmentsToEmployees(){
		
		return getEntityManager().createQuery("select a from Department a join fetch a.emp").getResultList();
	}
	
	// id'e g�re i��i bilgilerini getiren method
	public Employee findById(int emp_id) {
		return getEntityManager().getReference(Employee.class, emp_id);
	} 

	// ���i bilgilerini g�ncelleme
	public void updateUsers(Employee employee) {
		getEntityManager().merge(employee);

	}

	// ���ileri �al��ma b�l�m�ne g�re olu�turma
	// Burada gelen i��i bilgisindeki ili�ki set edilerek departman s�n�f�nda bulunan nesneye 'id' bilgisi aktar�lmaktad�r.
	// Daha sonra veri taban�na kaydedilmektedir.
	public void createEmployeeWithDepartmentInfo(Employee employee,Department department) {
		department.setEmp(employee);
		getEntityManager().persist(employee);		
		getEntityManager().persist(department);
	}
	
	//Silenecek i��inin 'id' sine g�re employee instance'� olu�turulur ve silinir.
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
