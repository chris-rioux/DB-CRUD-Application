package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import data.Employee;
import data.EmployeeDAO;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping("getEmployeeData.do")
	public ModelAndView getEmployeesResults(String query) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");

		// on page load
		mv.addObject("employees", employeeDAO.getEmployees());
		mv.addObject("demographics", employeeDAO.getDemographics());
		
		mv.addObject("employee", employeeDAO.getEmployeeByLastName(query));
		mv.addObject("empHeaders", employeeDAO.getEmployeesHeaders(query));
		mv.addObject("empData", employeeDAO.getEmployeesResults(query));
		
		return mv;
	}

}