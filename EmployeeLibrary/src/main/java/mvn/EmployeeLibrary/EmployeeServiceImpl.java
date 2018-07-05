package mvn.EmployeeLibrary;

import java.io.BufferedOutputStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeServiceInterface {

	private EmployeeCollectionOperationsInterface empArrayOperations;
	private File file;

	public EmployeeServiceImpl(File file) {
		super();
		this.empArrayOperations = new EmployeeCollectionOperations();
		this.file = file;
	}
	
	public void readEmployees() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String line = null;
			boolean keepReading = true;

			while (keepReading) {
				line = br.readLine();

				if (line == null || line.equals("")) {
					break;
				}
					
					Employee emp = parseLine(line);
					empArrayOperations.addEmployee(emp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void saveEmployees() {
		
		List<Employee> empArray = getEmpArray();
		
		file.delete();
		
		file = new File("E://employee.csv");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			file.createNewFile();
			
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			
			Iterator<Employee> iter = empArray.iterator();
			while(iter.hasNext()) {
				Employee emp = iter.next();
				String temp = emp.getEmployeeId()+","+emp.getName()+","+emp.getSalary()+","+emp.getAge()+"\n";
				bos.write(temp.getBytes());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bos.flush();
				fos.flush();
				bos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private Employee parseLine(String line) {
		String[] tokens = line.split(",");
		Employee emp = EmployeeUtil.createEmployee(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3]));
		return emp;
	}

	public boolean addEmployee(Employee e) throws InvalidSalaryException{
		if(e.getSalary() < 5000) {
			throw new InvalidSalaryException("Salary should be greater than 5000");
		}
		return empArrayOperations.addEmployee(e);
	}

	public Employee getEmployee(int employeeId) throws EmployeeNotFoundException {
		Employee emp = empArrayOperations.getEmployee(employeeId);
		if (emp == null) {
			throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");
		}
		return emp;
	}

	public ArrayList<Employee> getEmpArray() {
		return (ArrayList<Employee>) empArrayOperations.getEmpArray();
	}

	public void updateEmployee(Employee e) throws InvalidSalaryException{
		if(e.getSalary() < 5000) {
			throw new InvalidSalaryException("Salary should be greater than 5000");
		}
		empArrayOperations.updateEmployee(e);
	}

	public boolean checkForEmployee(int employeeId) throws EmployeeNotFoundException {
		boolean flag = empArrayOperations.checkForEmployee(employeeId);
		if (flag == false) {
			throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");
		} else {
			return empArrayOperations.checkForEmployee(employeeId);
		}
	}

	public void deleteEmployee(int employeeId) {
		empArrayOperations.deleteEmployee(employeeId);
	}

	public double calculateHra(int employeeId) {
		ArrayList<Employee> empArray = getEmpArray();
		Iterator<Employee> iter = empArray.iterator();
		while(iter.hasNext()) {
			Employee emp = iter.next();
			if(emp.getEmployeeId() == employeeId) {
				return emp.calculateHRA();
			}
		}
		return 0.0;
	}

	public double calculateGrossSalary(int employeeId) {
		double da, hra, grossSalary;
		Employee e = new Employee();
		ArrayList<Employee> empArray = getEmpArray();
		Iterator<Employee> iter = empArray.iterator();
		while(iter.hasNext()) {
			Employee emp = iter.next();
			if(emp.getEmployeeId() == employeeId) {
				e=emp;
				break;
			}
		}
		
		if (e.getSalary() < 10000) {
			da = e.getSalary() * 0.08;
			hra = e.getSalary() * 0.15;
			grossSalary = e.getSalary() + da + hra;
		} else if (e.getSalary() < 20000) {
			da = e.getSalary() * 0.10;
			hra = e.getSalary() * 0.20;
			grossSalary = e.getSalary() + da + hra;
		} else if (e.getSalary() < 30000 && e.getAge() >= 40) {
			da = e.getSalary() * 0.15;
			hra = e.getSalary() * 0.27;
			grossSalary = e.getSalary() + da + hra;
		} else if (e.getSalary() < 30000 && e.getAge() < 40) {
			da = e.getSalary() * 0.13;
			hra = e.getSalary() * 0.25;
			grossSalary = e.getSalary() + da + hra;
		} else {
			da = e.getSalary() * 0.17;
			hra = e.getSalary() * 0.30;
			grossSalary = e.getSalary() + da + hra;
		}
		return grossSalary;
	}

}
