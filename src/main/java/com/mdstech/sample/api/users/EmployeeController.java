package com.mdstech.sample.api.users;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mdstech.sample.model.EmployeeModel;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.inject.Inject;
import com.mdstech.sample.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Inject
	private EmployeeService employeeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<EmployeeModel>> findAllEmployees() {
		return new ResponseEntity<>(employeeService.findAllEmployees(),
				org.springframework.http.HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeModel employeeModel) {
		employeeModel = employeeService.saveEmployee(employeeModel);
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/employee/{id}")
                .buildAndExpand(employeeModel.getEmployeeId())
                .toUri()
        );
        return new ResponseEntity<>("Success", headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(employeeService.findEmployeeById(id), HttpStatus.OK);
	}
}