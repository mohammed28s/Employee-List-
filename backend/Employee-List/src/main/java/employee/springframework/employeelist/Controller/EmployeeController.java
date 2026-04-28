package employee.springframework.employeelist.Controller;


import employee.springframework.employeelist.Expection.ResourceNotFoundException;
import employee.springframework.employeelist.Model.Employee;
import employee.springframework.employeelist.Repository.EmployeeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@CrossOrigin(origins = "http://localhost:4200")  // Angular
@Controller
@RestController
@RequestMapping("/api/v1/") // This is main path
public class EmployeeController {



    @Autowired
    public EmployeeRepository employeeRepository;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


    // get all employees
    @GetMapping("/fetch/all")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //create employee rest api
    @PostMapping("/create-emp")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }


    // get all employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :"+ id));

        return ResponseEntity.ok(employee);

    }

    // update employee rest api
    @PutMapping("/update-emp/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName((employeeDetails.getLastName()));
        employee.setEmailId(employeeDetails.getEmailId());

        Employee updatedEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(updatedEmployee);
    }

    // delete employee rest api
    @DeleteMapping("/delete-emp/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));


        employeeRepository.delete(employee);
        Map<String, Boolean> respone = new HashMap<>();
        respone.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(respone);
    }


}
