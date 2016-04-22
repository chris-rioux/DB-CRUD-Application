package data;

import java.util.List;

public interface EmployeeDAO {
	public Employee getEmployeeByLastName(String query);
	public List<Employee> getEmployees();
	public Demographics getDemographics();
	public List<String> getEmployeesHeaders(String query);
	public List<List<String>> getEmployeesResults(String query);
}
