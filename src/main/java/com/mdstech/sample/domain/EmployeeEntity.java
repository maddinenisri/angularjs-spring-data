package com.mdstech.sample.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
public class EmployeeEntity {

	@Column(name = "EMP_ID", length = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	@Column(name = "F_NAME", length = 20)
	private String firstName;
	@Column(name = "L_NAME", length = 10)
	private String lastName;
	@OneToMany(mappedBy = "employeeEntity", cascade = CascadeType.ALL)
	private List<AddressEntity> addressEntityList;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<AddressEntity> getAddressEntityList() {
		return addressEntityList;
	}

	public void setAddressEntityList(List<AddressEntity> addressEntityList) {
		this.addressEntityList = addressEntityList;
	}
}