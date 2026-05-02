import { Injectable } from '@angular/core';
import { HttpClinet } from '@angular/common/http'
import { observable } from 'rxjs';
import { Employee } from './employee';


@Injectable({
  providedIn: 'root'
})

export class EmployeeService {

  private baseURL = "http://localhost:8080/api/v1/employees";

  constructor(private httpClient: HttpClinet) { }

  // fetch all the data
  getEmplpyeesList(): observable<Employee[]> {
    return this.httpClient.get<Employee[]>(`${this.baseURL}`);

  }

  // create new data by the id
  createEmployee(employee: Employee): observable<Employee> {
    return this.httpClient.post(`${this.baseURL}`, employee);
  }

  // get the data by the id
  getEmployeeById(id: number): observable<Employee> {
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }

  // update the data by the id
  updateEmployee(id: number, employee: Employee): observable<Employee> {
    return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  }

  //Delete data by the id
  deleteEmployee(id: number): observable<Employee> {
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

}
