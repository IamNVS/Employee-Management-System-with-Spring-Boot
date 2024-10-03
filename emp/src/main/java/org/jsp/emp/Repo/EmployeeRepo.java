package org.jsp.emp.Repo;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Optional<Employee> findByEmailAndPassword(String email, String password);

	List<Employee> findByName(String name);

}
