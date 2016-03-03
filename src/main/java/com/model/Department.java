
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
 * @author Fatih Totrakanl�
 *
 */
//model s�n�flar� nesne tabanl� database modelinin tasarland��� s�n�flar�d�r.
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
	
	@OneToOne(cascade = CascadeType.ALL)                    //Employee s�n�f�ndan olu�turulan instance ve @onetoone anostasyonu ile s�n�flar aras�nda 1-1 ili�ki
	private Employee emp;
	
	@OneToMany(mappedBy = "dep")  // Meeting s�n�f�ndan olu�turulan instance ve @onetomany ile s�n�flar aras�nda 1-n ili�ki
	private List<Meetings> meet;  // mappedby = onetomany e kar��l�k departman s�n�f�nda olu�turulacak "dep" instance'�yla ili�kili olaca��n� g�sterir.
								  //�li�ki tan�mlamalar� sayesinde departman s�n�f�nda emp_id ve meetings s�n�f�nda dep_dep_id nesneleri hibernate i�in kolon olu�turmaktad�r.
	
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
