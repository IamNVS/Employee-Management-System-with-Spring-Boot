package org.jsp.emp.Controller;

import java.util.List;

import org.jsp.emp.Entity.Employee;
import org.jsp.emp.ResponceBody.EmployeeResponceBody;
import org.jsp.emp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee")
	public EmployeeResponceBody<Employee> saveEmployee(@RequestBody Employee employee){
		return service.saveEmployee(employee);
	}
	
	@PutMapping("/employee")
	public EmployeeResponceBody<Employee> updateEmployee(@RequestBody Employee employee){
		return service.updateEmployee(employee);
	}
	
	@GetMapping("/employee")
	public EmployeeResponceBody<List<Employee>> findAllEmployee(){
		return service.findAllEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public EmployeeResponceBody<Employee> findByIdEmployee(@PathVariable int id){
		return service.findByIdEmployee(id);
	}
	
	@GetMapping("/employee/name/{name}")
	public EmployeeResponceBody<List<Employee>> findByNameEmployee(@PathVariable String name){
		return service.findByName(name);
	}

	@GetMapping("/employee/{email}/{password}")
	public EmployeeResponceBody<Employee> findByEmailAndPasswordEmployee(@PathVariable String email, @PathVariable String password){
		return service.findByEmailAndPassword(email,password);
	}

	@DeleteMapping("/employee/{id}")
	public EmployeeResponceBody<String> deleteByIdEmployee(@PathVariable int id){
		return service.deleteByIdEmployee(id);
	}
	
}
