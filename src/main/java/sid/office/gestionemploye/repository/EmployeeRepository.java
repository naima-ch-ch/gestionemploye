package sid.office.gestionemploye.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sid.office.gestionemploye.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Transactional
	void deleteEmployeeById(Long id);

	Optional<Employee> findEmployeeById(Long id);

}
