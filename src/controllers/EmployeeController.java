package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.Employee;
import data.EmployeeDAO;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping("GetEmployeeData.do")
	public ModelAndView getEmployeesResults(String query) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editEmployee.jsp");
		mv.setViewName("index.jsp");
		
		// on page load
		mv.addObject("employees", employeeDAO.getEmployees());
		mv.addObject("initialEmp", employeeDAO.getEmployees().get(0));
		mv.addObject("employee", employeeDAO.getEmployeeByLastName(query));
		mv.addObject("empHeaders", employeeDAO.getEmployeesHeaders(query));
		mv.addObject("empData", employeeDAO.getEmployeesResults(query));
		
		mv.addObject("genderDemographics", employeeDAO.getGenderDemographics());
		mv.addObject("salaryDemographics", employeeDAO.getSalaryDemographics());
		mv.addObject("departmentDemographics", employeeDAO.getDeptDemographics());
		return mv;
	}
	
	@RequestMapping(path="GoToAdd.do")
	public ModelAndView goToAdd() {	
		long hgt = Math.round((100 * (2 + (int)(Math.random() * ((10 - 2) + 1)))));
		long wth = Math.round((100 * (2 + (int)(Math.random() * ((10 - 2) + 1)))));
		String url = "http://placecage.com/" + hgt + "/" + wth;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addEmployee.jsp");	
		mv.addObject("url", url);
		mv.addObject("initialEmp", employeeDAO.getEmployees().get(0));
		return mv;
	}
	
	@RequestMapping(path="AddEmployee.do")
	public ModelAndView addEmployee(String firstName, String lastName, String gender, int salary, String city, String state) {
		long hgt = Math.round((100 * (2 + (int)(Math.random() * ((10 - 2) + 1)))));
		long wth = Math.round((100 * (2 + (int)(Math.random() * ((10 - 2) + 1)))));
		String url = "http://placecage.com/" + hgt + "/" + wth;
		
		employeeDAO.addEmployee(firstName, lastName, gender, salary, city, state);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("GetEmployeeData.do");
		mv.addObject("url", url);
		return mv;
	}
	
	@RequestMapping(path="GoToEdit.do", params="id", method=RequestMethod.GET)
	public ModelAndView goToEdit(Employee e) {
		long hgt = Math.round((100 * (2 + (int)(Math.random() * ((10 - 2) + 1)))));
		long wth = Math.round((100 * (2 + (int)(Math.random() * ((10 - 2) + 1)))));
		String url = "http://placecage.com/" + hgt + "/" + wth;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editEmployee.jsp");
		mv.addObject("url", url);
		mv.addObject("employee", e);
		mv.addObject("employees", employeeDAO.getEmployees());
		return mv;
	}
	
	@RequestMapping(path="EditEmployee.do")
	public ModelAndView addEmployee(Employee e) {
		employeeDAO.editEmployee(e);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("GetEmployeeData.do");
		return mv;
	}
	
	@RequestMapping(path="DeleteEmployee.do", method=RequestMethod.POST)
	public ModelAndView deleteEmployee(int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("GetEmployeeData.do");
		employeeDAO.deleteEmployee(id);
		mv.addObject("employees", employeeDAO.getEmployees());
		return mv;
	}

}