package mvn.EmployeeLibraryApp.EmployeeLibraryApp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import mvn.EmployeeLibrary.*;

public class EmployeeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		File file = new File("E://employee.csv");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		EmployeeServiceInterface eService = new EmployeeServiceImpl(file);
		
		eService.readEmployees();
		
		int ch = 0;
		while (ch != 8) {

			EmployeeUtil.displayEmployeeMenu();

			ch = sc.nextInt();
			Employee e = null;
			int employeeId;
			switch (ch) {
			case 1:
				try {
					e = EmployeeUtil.getEmployeeObject();
					if (eService.addEmployee(e)) {
						System.out.println("Employee created successfully");
					} else {
						System.out.println("Employee cannot be created");
					}
				} catch (InvalidSalaryException e2) {
					System.out.println(e2.getMessage());
				}
				break;
			case 2:
				employeeId = EmployeeUtil.getEmployeeId();
				try {
					Employee temp = eService.getEmployee(employeeId);
					if (temp == null) {
						System.out.println("No Such Employee in the system");
					} else {
						System.out.println(temp);
					}
				} catch (EmployeeNotFoundException e2) {
					System.out.println(e2.getMessage());
				}
				break;
			case 3:
				EmployeeUtil.viewAllEmployees(eService.getEmpArray());
				break;
			case 4:
				try {
					System.out.println("Enter Employee Data For Update");
					employeeId = EmployeeUtil.getEmployeeId();
					if (eService.checkForEmployee(employeeId)) {
						e = EmployeeUtil.getEmployeeObject(employeeId);
						eService.updateEmployee(e);
						System.out.println("Employee Updated Successfully");
					} else {
						System.out.println("No Such Employee in the system");
					}
				} catch (EmployeeNotFoundException e2) {
					System.out.println(e2.getMessage());
				} catch (InvalidSalaryException e2) {
					System.out.println(e2.getMessage());
				}
				break;
			case 5:
				try {
					System.out.println("Enter Employee Data For Delete");
					employeeId = EmployeeUtil.getEmployeeId();
					if (eService.checkForEmployee(employeeId)) {
						eService.deleteEmployee(employeeId);
						System.out.println("Employee Deleted Successfully");
					} else {
						System.out.println("No Such Employee in the system");
					}
				} catch (EmployeeNotFoundException e2) {
					System.out.println(e2.getMessage());
				}
				break;
			case 6:
				try {
					employeeId = EmployeeUtil.getEmployeeId();
					if (eService.checkForEmployee(employeeId)) {
						System.out.println("HRA = " + eService.calculateHra(employeeId));
					} else {
						System.out.println("No Such Employee in the system");
					}
				} catch (EmployeeNotFoundException e2) {
					System.out.println(e2.getMessage());
				}
				break;
			case 7:
				try {
					employeeId = EmployeeUtil.getEmployeeId();
					if (eService.checkForEmployee(employeeId)) {
						System.out.println("Gross Salary = " + eService.calculateGrossSalary(employeeId));
					} else {
						System.out.println("No Such Employee in the system");
					}
				} catch (EmployeeNotFoundException e2) {
					System.out.println(e2.getMessage());
				}
				break;
			case 8:
				eService.saveEmployees();
				sc.close();
				break;
			default:
				System.out.println("Invalid Option");
				break;
			}
		}
	}
}
