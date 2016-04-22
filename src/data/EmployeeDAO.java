package data;

import java.util.List;

public interface EmployeeDAO {
	public Employee getEmployeeByLastName(String query);
	public List<Employee> getEmployees();
	public List<String> getEmployeesHeaders(String query);
	public List<List<String>> getEmployeesResults(String query);
	
	public Demographics getGenderDemographics();
	public Demographics getSalaryDemographics();
}
