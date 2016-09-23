package com.mdstech.sample.model;

import java.util.List;

public class EmployeeModel {

	private Integer employeeId;
	private String firstName;
	private String lastName;
	private List<AddressModel> addressModelList;

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

	public List<AddressModel> getAddressModelList() {
		return addressModelList;
	}

	public void setAddressModelList(List<AddressModel> addressModelList) {
		this.addressModelList = addressModelList;
	}
}