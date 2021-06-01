package sid.office.gestionemploye.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sid.office.gestionemploye.exception.UserNotFoundException;
import sid.office.gestionemploye.model.Employee;
import sid.office.gestionemploye.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee addEmployee(Employee employe) {
		employe.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employe);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee findEmployeeById(Long id) {
		return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException ("user by id "+id+" not found"));
	}
	public Employee updateEmployee(Employee employe) {
		return employeeRepository.save(employe);
	}
	public void deleteEmlpoyee(Long id) {
		employeeRepository.deleteEmployeeById(id);		
	}

}
