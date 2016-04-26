package data;

import java.util.List;

public interface EmployeeDAO {
	public Employee getEmployeeByLastName(String query);
	public Employee getEmployeeById(int id);
	public List<Employee> getEmployees();
	public List<String> getEmployeesHeaders(String query);
	public List<List<String>> getEmployeesResults(String query);
	
	public void addEmployee(String firstName, String lastName, String gender, Integer salary, String city, String state);
	public void editEmployee(Employee employee);
	public void deleteEmployee(int id);
	
	public Demographics getGenderDemographics();
	public Demographics getSalaryDemographics();
	public Demographics getDeptDemographics();
}
