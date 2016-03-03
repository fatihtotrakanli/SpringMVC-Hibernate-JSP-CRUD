
package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Fatih Totrakanlý
 *
 */
//model sýnýflarý nesne tabanlý database modelinin tasarlandýðý sýnýflarýdýr.
@Entity
@Table(name = "department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Primary Key auto increment
	private int dep_id;
	@Column
	private String dep_name;
	@Column
	private String dep_description;
	
	@OneToOne(cascade = CascadeType.ALL)                    //Employee sýnýfýndan oluþturulan instance ve @onetoone anostasyonu ile sýnýflar arasýnda 1-1 iliþki
	private Employee emp;
	
	@OneToMany(mappedBy = "dep")  // Meeting sýnýfýndan oluþturulan instance ve @onetomany ile sýnýflar arasýnda 1-n iliþki
	private List<Meetings> meet;  // mappedby = onetomany e karþýlýk departman sýnýfýnda oluþturulacak "dep" instance'ýyla iliþkili olacaðýný gösterir.
								  //Ýliþki tanýmlamalarý sayesinde departman sýnýfýnda emp_id ve meetings sýnýfýnda dep_dep_id nesneleri hibernate için kolon oluþturmaktadýr.
	
	//Setter ve Getter
	public int getDep_id() {
		return dep_id;
	}

	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}

	public String getDep_description() {
		return dep_description;
	}

	public void setDep_description(String dep_description) {
		this.dep_description = dep_description;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public List<Meetings> getMeet() {
		return meet;
	}

	public void setMeet(List<Meetings> meet) {
		this.meet = meet;
	}

	//Default constructor
	public Department() {
		super();
	}
	

	
	



	
	

}
