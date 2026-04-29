import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Employee {

  id: number;
  firstName: string;
  lastName: string;
  emailId: string;
}
