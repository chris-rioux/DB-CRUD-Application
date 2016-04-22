package data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private Date hireDate;
	private int salary;
	private int departmentId;
	private int jobId;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	
	public Employee(){
		
	}
	
	public Employee(int id, String firstName, String lastName, String gender, Date hireDate, int salary,
			int departmentId, int jobId, String address, String city, String state, String zipcode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.hireDate = hireDate;
		this.salary = salary;
		this.departmentId = departmentId;
		this.jobId = jobId;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
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
	public Date getHireDate() {
		return hireDate;
	}
	public int getSalary() {
		return salary;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public int getJobId() {
		return jobId;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZipcode() {
		return zipcode;
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
	public void setHireDate(String hireDate) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date date = format.parse(hireDate);
		this.hireDate = date;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", hireDate=" + hireDate + ", salary=" + salary + ", departmentId=" + departmentId + ", jobId="
				+ jobId + ", address=" + address + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	
}