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
import com.model.Meetings;
import com.mysql.fabric.Response;
import com.services.IDepartmentService;
import com.services.IEmployeeService;

/**
 * @author Fatih Totrakanl�
 *
 */

@Controller
public class IndexController {
	
	//Controller katman� MVC modelinde View ve Model aras�ndaki ba�lant�y� kurar diyebiliriz.
	// Model'in view'e aktar�lmas� veya view'daki mapping i�lemleri bu katmanda yap�l�r.
	
	//Olu�turulmu� Bean'ler Autowired ile ismine g�re direk bulunur.
	// @Autowired, Set methodu veya Constructor methodu �zerindede kullan�labilir. Bu kullan�mlar Spring Dependency Injection kullan�mlar�d�r.
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	//View katman�ndan g�nderilen "index" mapping'ine veri aktar�lmas�.
	@RequestMapping(value="/index")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("index");
		model.addObject("listofemployee", employeeService.findAllWithJoinDepartmentsToEmployees());
		return model;
		
	}
	
	//View katman�nda form'dan (action=add) g�nderilen bilgilerin POST methoduyla al�n�p veri taban�na kaydedilmesi.
	//@ModelAttribute ile tek tek veri almak yerine s�n�f tipinde bulunan bilgiler getirilmektedir.
	@RequestMapping(value="/add" , method = RequestMethod.POST )
	public ModelAndView newEmployeeandMeeting(@ModelAttribute("employee") Employee employee, @ModelAttribute("department") Department department
			,@ModelAttribute("meetings")Meetings meetings,HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView("index");
		departmentService.createMeetingsWithDepartments(employee, department, meetings);
		response.sendRedirect("index");
		return model;
	}
	
	//View katman�nda s�ralanm�� olan i��ilerin 'id' bilgisine g�re toplant� ve departman bilgileriyle birlikte veritaban�ndan silinmesi
	//@PathVariable ile URL ' den g�nderilmi� olan 'id' al�nmaktad�r.
	@RequestMapping(value="/delete/{id}" , method = RequestMethod.GET )
	public String newEmployee(@ModelAttribute("employee") Employee employee, @PathVariable("id") int id){
		ModelAndView model = new ModelAndView("index");
		departmentService.deleteById(id,id);
		employeeService.deleteById(id);
		return "redirect:/index";
	}
}
