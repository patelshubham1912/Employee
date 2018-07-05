package mvn.EmployeeLibrary;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeUtil {
	static Scanner sc = new Scanner(System.in);

	public static Employee highestSalariedEmployee(Employee e1, Employee e2) {
		return e1.getSalary() > e2.getSalary() ? e1 : e2;
	}

	public static void increaseSalary(Employee e1) {
		e1.setSalary(e1.getSalary() * 0.1 + e1.getSalary());
	}

	public static Employee createEmployee(int employeeId, String name, double salary, int age) {
		Employee e = new Employee();
		e.setEmployeeId(employeeId);
		e.setName(name);
		e.setSalary(salary);
		e.setAge(age);
		return e;
	}

	public static Employee returnOlderEmployee(Employee e1, Employee e2) {
		if (e1.getAge() < e2.getAge()) {
			return e2;
		}
		return e1;
	}

	public static void updateEmployeeSalary(Employee e) {
		if (e.getSalary() < 10000 && e.getAge() > 35) {
			e.setSalary(e.getSalary() * 0.15 + e.getSalary());
		} else if (e.getSalary() < 15000 && e.getAge() > 45) {
			e.setSalary(e.getSalary() * 0.20 + e.getSalary());
		} else if (e.getSalary() < 20000 && e.getAge() > 55) {
			e.setSalary(e.getSalary() * 0.25 + e.getSalary());
		}
	}

	public static void calculateGrossSalary(Employee e) {
		double da, hra, grossSalary;
		// avoid duplication of code by creating new methods
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
		System.out.println("hra = " + hra + ", da = " + da + ", gross salary = " + grossSalary);
	}

	public static int getNumberOfEmployees() {
		System.out.println("How Many Employees do you wish to create");
		int size = sc.nextInt();

		return size;
	}

	public static void displayEmployeeMenu() {
		System.out.println("");
		System.out.println("");
		System.out.println("\t||| MENU |||");
		System.out.println("1. Create Employee");
		System.out.println("2. Read(View) Employee");
		System.out.println("3. View All Employees");
		System.out.println("4. Update Employee");
		System.out.println("5. Delete Employee");
		System.out.println("6. Calculate HRA");
		System.out.println("7. Calculate Gross Salary");
		System.out.println("8. Exit");
		System.out.println("Select a Choice : ");
	}

	public static Employee getEmployeeObject() {
		int employeeId, age;
		String name;
		double salary;
		Employee e = null;
		sc = new Scanner(System.in);
		try {
			System.out.println("Enter Employee Id:");
			employeeId = sc.nextInt();
			System.out.println("Enter Employee Name:");
			name = sc.next();
			System.out.println("Enter Employee Salary:");
			salary = sc.nextDouble();
			System.out.println("Enter Employee Age:");
			age = sc.nextInt();

			e = createEmployee(employeeId, name, salary, age);
		} catch (InputMismatchException ex) {
			ex.printStackTrace();
		}
		return e;
	}

	public static Employee getEmployeeObject(int employeeId) {
		int age;
		String name;
		double salary;
		Employee e = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Enter Employee Name:");
			name = sc.next();
			System.out.println("Enter Employee Salary:");
			salary = sc.nextDouble();
			System.out.println("Enter Employee Age:");
			age = sc.nextInt();

			e = createEmployee(employeeId, name, salary, age);

		} catch (InputMismatchException ex) {
			ex.printStackTrace();
		}
		return e;
	}

	public static int getEmployeeId() {
		sc = new Scanner(System.in);
		int employeeId = 0;
		try {
			System.out.println("Enter Employee Id");
			employeeId = sc.nextInt();
		} catch (InputMismatchException ex) {
			ex.printStackTrace();
		}
		return employeeId;
	}

	public static void viewAllEmployees(ArrayList<Employee> empArray) {

		if (empArray.size() == 0) {
			System.out.println("No Employees in the system");
		} else {
			Iterator<Employee> iter = empArray.iterator();
			while (iter.hasNext()) {
				Employee tempEmp = iter.next();
				System.out.println(tempEmp);
			}
		}

	}
}
