package mvn.EmployeeLibrary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeCollectionOperations implements EmployeeCollectionOperationsInterface {

	private List<Employee> empArray;

	public EmployeeCollectionOperations() {
		super();
		this.empArray = new ArrayList<Employee>();
	}

	public ArrayList<Employee> getEmpArray() {
		return (ArrayList<Employee>) empArray;
	}

	public boolean addEmployee(Employee e) {
		return empArray.add(e);
	}
	
	public Employee getEmployee(int employeeId) {// EmployeeNotFound Exception
		Iterator<Employee> iter = empArray.iterator();
		while(iter.hasNext()) {
			Employee tempEmp = iter.next();
			if(tempEmp.getEmployeeId() == employeeId) {
				return tempEmp;
			}
		}
		return null;
	}
	
	public void updateEmployee(Employee e) {
			Iterator<Employee> iter = empArray.iterator();
			while(iter.hasNext()) {
				Employee tempEmp = iter.next();
				if(tempEmp.getEmployeeId() == e.getEmployeeId()) {
					int index = empArray.indexOf(tempEmp);
					empArray.set(index, e);
				}
			}
			
	}
	
	public boolean checkForEmployee(int employeeId) {
		Iterator<Employee> iter = empArray.iterator();
		while(iter.hasNext()) {
			Employee tempEmp = iter.next();
			if(tempEmp.getEmployeeId() == employeeId) {
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteEmployee(int employeeId) {
		Iterator<Employee> iter = empArray.iterator();
		while(iter.hasNext()) {
			Employee tempEmp = iter.next();
			if(tempEmp.getEmployeeId() == employeeId) {
				empArray.remove(tempEmp);
				break;
			}
		}
		return false;
	}
}
