package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeDbDAO implements EmployeeDAO {
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/companydb";
	
	@Override
	public Employee getEmployeeByLastName(String query) {
		Employee emp = null;
		String sql = "SELECT e.id AS 'ID', e.firstname AS 'First', e.lastname AS 'Last', e.gender AS 'Sex', e.salary AS 'Salary', d.name AS 'Dept.', a.name AS 'Project', e.city AS 'City', e.state AS 'State' FROM employees e LEFT JOIN departments d ON e.department_id = d.id LEFT JOIN assignments a ON e.id = a.employee_id WHERE lastname LIKE " + "'" + query + "'";
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
			
			rs.close();
			statement.close();
			conn.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return emp;
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		Employee emp = null;
		String sql = "SELECT e.id AS 'ID', e.firstname AS 'First', e.lastname AS 'Last', e.gender AS 'Sex', e.salary AS 'Salary', d.name AS 'Dept.', a.name AS 'Project', e.city AS 'City', e.state AS 'State' FROM employees e LEFT JOIN departments d ON e.department_id = d.id LEFT JOIN assignments a ON e.id = a.employee_id WHERE e.id = " + id;
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
			
			rs.close();
			statement.close();
			conn.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return emp;
	}
	
	@Override
	public List<Employee> getEmployees() {
		ArrayList<Employee> emps = new ArrayList<>();
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			
			// get all employees in table
			String sql = "SELECT e.id AS 'ID', e.firstname AS 'First', e.lastname AS 'Last', e.gender AS 'Sex', e.salary AS 'Salary', d.name AS 'Dept.', a.name AS 'Project', e.city AS 'City', e.state AS 'State' FROM employees e LEFT JOIN departments d ON e.department_id = d.id LEFT JOIN assignments a ON e.id = a.employee_id ORDER BY lastname";
			ResultSet rs = statement.executeQuery(sql);
			
			// create arraylist of employees in order to display them in drop down on index.jsp
			while (rs.next()) {	
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				emps.add(e);
			}
			
			rs.close();
			statement.close();
			conn.close();
			
		} catch (Exception e) {
			System.err.println(e);		
		}		
		return emps;
	}
	
	@Override
	public void addEmployee(String firstName, String lastName, String gender, Integer salary, String city, String state) {
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			
			String sql = "INSERT INTO employees (firstname, lastname, gender, salary, city, state, department_id, job_id) VALUES ('" + firstName + "', '" + lastName + "', '" + gender + "', " + salary + ", '" + city + "', '" + state + "', 1, 1)";
			statement.executeUpdate(sql);
			
			statement.close();
			conn.close();
			
		} catch (Exception e) {
			System.err.println(e);		
		}		
	}
	
	@Override
	public void editEmployee(Employee employee) {
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		String gender = employee.getGender();
		Integer salary = employee.getSalary();
		String city = employee.getCity();
		String state = employee.getState();
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			
			String sql = "UPDATE employees SET firstname = '" + firstName + "', lastname = '" + lastName + "', gender = '" + gender + "', salary = " + salary + ", city = '" + city + "', state = '" + state + "' WHERE id = " + employee.getId();
			statement.executeUpdate(sql);
			
			statement.close();
			conn.close();
			
		} catch (Exception e) {
			System.err.println(e);		
		}		
	}
	
	@Override
	public void deleteEmployee(int id) {
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			
			String sql = "DELETE FROM assignments WHERE employee_id = " + id;
			statement.executeUpdate(sql);
			
			sql = "DELETE FROM employees WHERE id = " + id;
			statement.executeUpdate(sql);
			
			statement.close();
			conn.close();
			
		} catch (Exception e) {
			System.err.println(e);		
		}		
	}
	
	@Override
	public List<String> getEmployeesHeaders(String query) {
		List<String> empHeaders = new ArrayList<String>();
		String sql = "SELECT e.id AS 'ID', e.firstname AS 'First', e.lastname AS 'Last', e.gender AS 'Sex', e.salary AS 'Salary', d.name AS 'Dept.', a.name AS 'Project', e.city AS 'City', e.state AS 'State' FROM employees e LEFT JOIN departments d ON e.department_id = d.id LEFT JOIN assignments a ON e.id = a.employee_id WHERE lastname LIKE " + "'" + query + "'";

		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			// get headers and add to ListList
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				empHeaders.add(rsmd.getColumnName(i));
			}
			
			rs.close();
			statement.close();
			conn.close();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		return empHeaders;
	}
	
	@Override
	public List<List<String>> getEmployeesResults(String query) {
		List<List<String>> empData = new ArrayList<List<String>>();
		String sql = "SELECT e.id AS 'ID', e.firstname AS 'First', e.lastname AS 'Last', e.gender AS 'Sex', e.salary AS 'Salary', d.name AS 'Dept.', a.name AS 'Project', e.city AS 'City', e.state AS 'State' FROM employees e LEFT JOIN departments d ON e.department_id = d.id LEFT JOIN assignments a ON e.id = a.employee_id WHERE lastname LIKE " + "'" + query + "'";
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			// get column values and add to ListList
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				List<String> allValues = new ArrayList<String>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					allValues.add(rs.getString(i));
				}
				empData.add(allValues);
			}
			
			rs.close();
			statement.close();
			conn.close();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		return empData;
	}

	@Override
	public Demographics getGenderDemographics() {
		Demographics d = new Demographics();
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			
			// get gender counts in employees table
			String sql = "SELECT gender, COUNT(*) FROM employees GROUP BY gender";
			ResultSet rs = statement.executeQuery(sql);
			
			HashMap<String, Integer> genderCounts = new HashMap<>();
			while (rs.next()) {	
				switch (rs.getString(1)) {
				case "F":
					genderCounts.put("Female", rs.getInt(2));
					break;
				case "M":
					genderCounts.put("Male", rs.getInt(2));
					break;
				default:
					genderCounts.put(rs.getString(1), rs.getInt(2));
					break;
				}
			}
			d.setGenderCount(genderCounts);
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return d;
	}
	
	@Override
	public Demographics getSalaryDemographics() {
		Demographics d = new Demographics();
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			
			// get gender counts in employees table
			String sql = "SELECT gender, SUM(salary) FROM employees GROUP BY gender";
			ResultSet rs = statement.executeQuery(sql);
			
			HashMap<String, Integer> salaryTotals = new HashMap<>();
			while (rs.next()) {	
				switch (rs.getString(1)) {
				case "F":
					salaryTotals.put("Female", rs.getInt(2));
					break;
				case "M":
					salaryTotals.put("Male", rs.getInt(2));
					break;
				default:
					salaryTotals.put(rs.getString(1), rs.getInt(2));
					break;
				}
			}
			d.setSalaryTotal(salaryTotals);
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return d;
	}
	
	@Override
	public Demographics getDeptDemographics() {
		Demographics d = new Demographics();
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			
			// get gender counts in employees table
			String sql = "SELECT d.name, COUNT(e.id) FROM employees e LEFT JOIN departments d ON e.department_id = d.id GROUP BY d.name";
			ResultSet rs = statement.executeQuery(sql);
			
			HashMap<String, Integer> deptTotals = new HashMap<>();
			while (rs.next()) {	
				deptTotals.put(rs.getString(1), rs.getInt(2));
			}
			d.setGenderCntByDept(deptTotals);
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return d;
	}
	
}