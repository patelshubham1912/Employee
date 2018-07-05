package mvn.EmployeeLibrary;

import java.util.ArrayList;

public interface EmployeeCollectionOperationsInterface {

	public ArrayList<Employee> getEmpArray();
	
	public boolean addEmployee(Employee e);
	
	public Employee getEmployee(int employeeId);
	
	public void updateEmployee(Employee e);
	
	public boolean checkForEmployee(int employeeId);
	
	public boolean deleteEmployee(int employeeId);
	
	
	
}
