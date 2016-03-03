/**
 * 
 */
package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Fatih Totrakanl�
 *
 */
//model s�n�flar� nesne tabanl� database modelinin tasarland��� s�n�flar�d�r.
@Entity
@Table(name = "meetings")
public class Meetings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  // Primary Key Auto Increment
	private int meet_id;
	@Column
	private String meet_name;
	@Column
	private String meet_descrpition;
	
	@ManyToOne
	private Department dep;  // Departman s�n�f�yla 1-n ili�ki

	
	//Setter ve Getter
	public int getMeet_id() {
		return meet_id;
	}

	public void setMeet_id(int meet_id) {
		this.meet_id = meet_id;
	}

	public String getMeet_name() {
		return meet_name;
	}

	public void setMeet_name(String meet_name) {
		this.meet_name = meet_name;
	}

	public String getMeet_descrpition() {
		return meet_descrpition;
	}

	public void setMeet_descrpition(String meet_descrpition) {
		this.meet_descrpition = meet_descrpition;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public Meetings() {
		super();
	}
	

	
	
}
