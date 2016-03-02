/**
 * 
 */
package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Department;
import com.model.Employee;
import com.mysql.fabric.Response;
import com.services.IDepartmentService;
import com.services.IEmployeeService;

/**
 * @author Fatih Totrakanlý
 *
 */

@Controller
public class IndexController {

	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@RequestMapping(value="/index")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("index");
		model.addObject("listofemployee", employeeService.findAllWithJoinDepartmentsToEmployees());
		return model;
		
	}
	
	@RequestMapping(value="/add" , method = RequestMethod.POST )
	public ModelAndView newEmployee(@ModelAttribute("employee") Employee employee, @ModelAttribute("department") Department department,HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView("index");
		
		employeeService.createEmployeeWithDepartmentInfo(employee,department);
		response.sendRedirect("index");
		return model;
	}
	
	@RequestMapping(value="/delete/{id}" , method = RequestMethod.GET )
	public String newEmployee(@ModelAttribute("employee") Employee employee, @PathVariable("id") int id){
		ModelAndView model = new ModelAndView("index");
		departmentService.deleteById(id);
		employeeService.deleteById(id);
		return "redirect:/index";
	}
}
