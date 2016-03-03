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
	// @Repository Data Access katmanýndaki sýnýflar için kullanýlýr.
	// @Repository kullanýldýktan sonra her nesne bir Bean olarak tanýmlanýr ve @autowired özelliðiyle direk eriþilebilir.
	
	@PersistenceContext
	private EntityManager entityManager;

	// Tüm Ýþçilerin listelenmesi
	// Burada Criteria API kullanýlmýþtýr. Hibernate tarafýndan saðlanan bu API sayesinde HQL yazmadan veri tabaný sorgusu yapýlabilir.
	public List<Employee> findAll() {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery( Employee.class );
        Root<Employee> entityRoot = criteria.from( Employee.class );
        criteria.select(entityRoot);
        return getEntityManager().createQuery(criteria).getResultList();
	}
	
	// Bu methodda iki tablonun bir araya getirilmesi saðlanmýþtýr.
	// Fetch stratejilerinde OneToOne ve ManyToOne default olarak EAGER iken, ManyToMany ve OneToMany ise LAZY stratejisindedir.
	// LAZY : Tembel yükleme, asýl nesne çaðýrýmý sonrasýnda lazy iliþkili nesnelerden bilgi getirilmez.
	// EAGER : Direkt yükleme, asýl nesne çaðýrýmý ile birlikte iliþkili nesne bilgiside getirilir.
	// Burada "join fetch" kullanýlmasýnýn sebebi OneToMany 'nin LAZY stratejisinde olmasýndandýr. "join fetch" sayesinde tek sorguda çekilebilir.
	@SuppressWarnings("unchecked")
	public List<Employee> findAllWithJoinDepartmentsToEmployees(){
		
		return getEntityManager().createQuery("select a from Department a join fetch a.emp").getResultList();
	}
	
	// id'e göre iþçi bilgilerini getiren method
	public Employee findById(int emp_id) {
		return getEntityManager().getReference(Employee.class, emp_id);
	} 

	// Ýþçi bilgilerini güncelleme
	public void updateUsers(Employee employee) {
		getEntityManager().merge(employee);

	}

	// Ýþçileri çalýþma bölümüne göre oluþturma
	// Burada gelen iþçi bilgisindeki iliþki set edilerek departman sýnýfýnda bulunan nesneye 'id' bilgisi aktarýlmaktadýr.
	// Daha sonra veri tabanýna kaydedilmektedir.
	public void createEmployeeWithDepartmentInfo(Employee employee,Department department) {
		department.setEmp(employee);
		getEntityManager().persist(employee);		
		getEntityManager().persist(department);
	}
	
	//Silenecek iþçinin 'id' sine göre employee instance'ý oluþturulur ve silinir.
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
