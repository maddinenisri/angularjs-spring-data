package com.mdstech.sample.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mdstech.sample.domain.AddressEntity;
import com.mdstech.sample.domain.EmployeeEntity;
import com.mdstech.sample.model.EmployeeModel;
import com.mdstech.sample.repository.EmployeeRepository;

@Service("employeeService")
@Transactional
public class EmployeeService {

	@Inject
	private EmployeeRepository employeeRepository;
	private ModelMapper modelMapper = new ModelMapper();

	public List<EmployeeModel> findAllEmployees() {
		java.util.List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
		return employeeEntityList.stream().map(obj -> modelMapper.map(obj, EmployeeModel.class))
				.collect(Collectors.toList());
	}

	public EmployeeModel saveEmployee(EmployeeModel employeeModel) {
		EmployeeEntity employeeEntity = modelMapper.map(employeeModel, EmployeeEntity.class);
		List<AddressEntity> collection = employeeModel.getAddressModelList().stream()
				.map(obj -> modelMapper.map(obj, AddressEntity.class)).collect(Collectors.toList());
		employeeEntity.setAddressEntityList(collection);
		employeeRepository.save(employeeEntity);
		return modelMapper.map(employeeEntity, EmployeeModel.class);
	}

	public EmployeeModel findEmployeeById(Integer id) {
		EmployeeEntity employeeEntity = employeeRepository.findOne(id);
		return modelMapper.map(employeeEntity, EmployeeModel.class);
	}
}