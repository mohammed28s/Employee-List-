import { Employee } from './employee';

describe('Employee', () => {
  it('should create an instance', () => {
    const employee = new Employee();
    expect(employee).toBeTruthy();
  });
});
