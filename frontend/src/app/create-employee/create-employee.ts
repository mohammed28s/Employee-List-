import { FormsModule } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './create-employee.html',
  styleUrl: './create-employee.css',
})
export class CreateEmployeeComponent implements OnInit {
  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService, private router: Router) {}

  ngOnInit(): void {}

  saveEmployee(): void {
    this.employeeService.createEmployee(this.employee).subscribe((data) => {
      console.log(data);
      this.goToEmployeeList();
    });
  }

  goToEmployeeList(): void {
    this.router.navigate(['/employees']);
  }

  onSubmit(): void {
    console.log(this.employee);
    this.saveEmployee();
  }
}
