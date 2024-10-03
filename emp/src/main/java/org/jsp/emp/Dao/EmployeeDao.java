package org.jsp.emp.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.Entity.Employee;
import org.jsp.emp.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	public Employee saveEmployee(Employee employee) {	
		return employeeRepo.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {	
		return employeeRepo.save(employee);
	}
	
	
	public List<Employee> findAllEmployee(){		
		return employeeRepo.findAll();
	}
	
	public Optional<Employee> findByIdEmployee(int id) {
		return employeeRepo.findById(id);
	}
	
	public void deleteByIdEmployee(int id){
		employeeRepo.deleteById(id);
	}
	
	public Optional<Employee> findByEmailAndPassword(String email, String password){
		return employeeRepo.findByEmailAndPassword(email,password);
	}
	
	public List<Employee> findByName(String name){
		return employeeRepo.findByName(name);
	}
}
