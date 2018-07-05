package mvn.EmployeeLibrary;

import java.util.ArrayList;

public interface EmployeeServiceInterface {

	public ArrayList<Employee> getEmpArray();
	
	public void readEmployees();
	
	public void saveEmployees(); 

	public boolean addEmployee(Employee e) throws InvalidSalaryException;

	public Employee getEmployee(int employeeId) throws EmployeeNotFoundException;

	public void updateEmployee(Employee e) throws InvalidSalaryException;

	public boolean checkForEmployee(int employeeId) throws EmployeeNotFoundException;

	public void deleteEmployee(int employeeId);

	public double calculateHra(int employeeId);

	public double calculateGrossSalary(int employeeId);

}
