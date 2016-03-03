/**
 * 
 */
package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Fatih Totrakanlý
 *
 */

//model sýnýflarý nesne tabanlý database modelinin tasarlandýðý sýnýflarýdýr.
@Entity
@Table(name="employee") //database tablo ismi
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Primary key auto increment
	@Column
	private int emp_id;
	@Column
	private String emp_name;
	@Column
	private String emp_surname;
	@Column
	private int emp_salary;
	
	//default constructor
	public Employee() {
		super();
	}

	// Setter ve Getter methodlarý
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_surname() {
		return emp_surname;
	}

	public void setEmp_surname(String emp_surname) {
		this.emp_surname = emp_surname;
	}

	public int getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(int emp_salary) {
		this.emp_salary = emp_salary;
	}



	
}
