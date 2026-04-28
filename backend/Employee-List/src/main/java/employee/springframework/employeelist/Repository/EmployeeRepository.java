package employee.springframework.employeelist.Repository;


import employee.springframework.employeelist.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {



}
