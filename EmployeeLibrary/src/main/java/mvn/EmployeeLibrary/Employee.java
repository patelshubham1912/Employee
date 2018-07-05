package mvn.EmployeeLibrary;

public class Employee {
	private int employeeId;
	private String name;
	private double salary;
	private int age;
	public static String COMPANY_NAME;
	
	public Employee() {
		salary = 10000;
	}
	
	static{
		COMPANY_NAME="XYZ";
	}
	
	public static String getCompanyName() {
		return COMPANY_NAME;
	}
	
	public void setInfo(int employeeId, String name, double salary) {
		this.employeeId=employeeId;
		this.name=name;
		this.salary=salary;
	}
	
	public double calculateHRA() {
		return salary * 0.20;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	

	@Override
	public String toString() {
		return "Employee [Id=" + employeeId + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
