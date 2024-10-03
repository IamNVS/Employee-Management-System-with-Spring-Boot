package org.jsp.emp.Service;

import java.util.List;
import java.util.Optional;
import org.jsp.emp.Dao.EmployeeDao;
import org.jsp.emp.Entity.Employee;
import org.jsp.emp.ResponceBody.EmployeeResponceBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

	@Autowired 
	private EmployeeDao dao;
	
	public EmployeeResponceBody<Employee> saveEmployee(Employee employee) {
		
		employee = dao.saveEmployee(employee);
		EmployeeResponceBody<Employee> responceBody = new EmployeeResponceBody<>();
		responceBody.setStatus(HttpStatus.CREATED.value());
		responceBody.setMsg("Employee Data is save in database");
		responceBody.setBlock(employee);
		return responceBody;
	}
	
	public EmployeeResponceBody<Employee> updateEmployee(Employee employee) {
		
		employee = dao.updateEmployee(employee);
		EmployeeResponceBody<Employee> responceBody = new EmployeeResponceBody<>();
		responceBody.setStatus(HttpStatus.OK.value());
		responceBody.setMsg("Employee Data is update in database");
		responceBody.setBlock(employee);
		return responceBody;
	}
	
	public EmployeeResponceBody<List<Employee>> findAllEmployee(){
		
		List<Employee> list = dao.findAllEmployee();
		EmployeeResponceBody<List<Employee>> responceBody = new EmployeeResponceBody<>();
		if(list.isEmpty()) {
			responceBody.setStatus(HttpStatus.NOT_FOUND.value());
			responceBody.setMsg("Employee Data base is empty");
			responceBody.setBlock(list);
			return responceBody;
		}
		responceBody.setStatus(HttpStatus.OK.value());
		responceBody.setMsg("Employee Data is below");
		responceBody.setBlock(list);
		return responceBody;
	}
	
	public EmployeeResponceBody<Employee> findByIdEmployee(int id){
		
		Optional<Employee> employee = dao.findByIdEmployee(id);
		EmployeeResponceBody<Employee> responceBody = new EmployeeResponceBody<>();
		if (employee.isEmpty()) {
			responceBody.setStatus(HttpStatus.NOT_FOUND.value());
			responceBody.setMsg("Given Id id invalide ");
			responceBody.setBlock(null);
			return responceBody;
		}
		Employee employee2 = employee.get();
		responceBody.setStatus(HttpStatus.OK.value());
		responceBody.setMsg("Given Id data is below");
		responceBody.setBlock(employee2);
		return responceBody;
	}
	
	
	public EmployeeResponceBody<String> deleteByIdEmployee(int id){
		Optional<Employee> employee = dao.findByIdEmployee(id);
		EmployeeResponceBody<String> responceBody = new EmployeeResponceBody<>();
		if (employee.isEmpty()) {
			responceBody.setStatus(HttpStatus.BAD_REQUEST.value());
			responceBody.setMsg("Given Id is invalide ");
			responceBody.setBlock("Unable to delete ");
			return responceBody;
		}
		dao.deleteByIdEmployee(id);
		responceBody.setStatus(HttpStatus.OK.value());
		responceBody.setMsg("Given Id data is below");
		responceBody.setBlock("Given Id data is deleted");
		return responceBody;
	}
	
	public EmployeeResponceBody<Employee> findByEmailAndPassword(String email, String password){
		EmployeeResponceBody<Employee> responceBody = new EmployeeResponceBody<>();
		Optional<Employee> optional = dao.findByEmailAndPassword(email, password);
		if(optional.isEmpty()) {
			responceBody.setStatus(HttpStatus.NOT_FOUND.value());
			responceBody.setMsg("Given email and password is invalide ");
			responceBody.setBlock(null);
			return responceBody;
		}
		Employee employee = optional.get();
		responceBody.setStatus(HttpStatus.OK.value());
		responceBody.setMsg("Given Id data is below");
		responceBody.setBlock(employee);
		return responceBody;
	}

	public EmployeeResponceBody<List<Employee>> findByName(String name){
		EmployeeResponceBody<List<Employee>> responceBody = new EmployeeResponceBody<>();
		List<Employee> employees = dao.findByName(name);
		if(employees.isEmpty()) {
			responceBody.setStatus(HttpStatus.NOT_FOUND.value());
			responceBody.setMsg("Given name is invalide ");
			responceBody.setBlock(employees);
			return responceBody;
		}
		responceBody.setStatus(HttpStatus.OK.value());
		responceBody.setMsg("Given Id data is below");
		responceBody.setBlock(employees);
		return responceBody;
	}

}
