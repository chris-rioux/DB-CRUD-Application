package data;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private Integer salary;
	private String dept;
	private String project;
	private String city;
	private String state;
		
	public Employee() {
	}

	public Employee(int id, String firstName, String lastName, String gender, Integer salary, String dept, String project,
			String city, String state) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.salary = salary;
		this.dept = dept;
		this.project = project;
		this.city = city;
		this.state = state;
	}

	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getGender() {
		return gender;
	}
	public Integer getSalary() {
		return salary;
	}
	public String getDept() {
		return dept;
	}
	public String getProject() {
		return project;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", salary=" + salary + ", dept=" + dept + ", project=" + project + ", city=" + city + ", state="
				+ state + "]";
	}
	
}