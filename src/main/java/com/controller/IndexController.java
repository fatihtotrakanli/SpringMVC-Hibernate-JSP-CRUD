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
 * @author Fatih Totrakanlý
 *
 */

@Controller
public class IndexController {
	
	//Controller katmaný MVC modelinde View ve Model arasýndaki baðlantýyý kurar diyebiliriz.
	// Model'in view'e aktarýlmasý veya view'daki mapping iþlemleri bu katmanda yapýlýr.
	
	//Oluþturulmuþ Bean'ler Autowired ile ismine göre direk bulunur.
	// @Autowired, Set methodu veya Constructor methodu üzerindede kullanýlabilir. Bu kullanýmlar Spring Dependency Injection kullanýmlarýdýr.
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	//View katmanýndan gönderilen "index" mapping'ine veri aktarýlmasý.
	@RequestMapping(value="/index")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("index");
		model.addObject("listofemployee", employeeService.findAllWithJoinDepartmentsToEmployees());
		return model;
		
	}
	
	//View katmanýnda form'dan (action=add) gönderilen bilgilerin POST methoduyla alýnýp veri tabanýna kaydedilmesi.
	//@ModelAttribute ile tek tek veri almak yerine sýnýf tipinde bulunan bilgiler getirilmektedir.
	@RequestMapping(value="/add" , method = RequestMethod.POST )
	public ModelAndView newEmployeeandMeeting(@ModelAttribute("employee") Employee employee, @ModelAttribute("department") Department department
			,@ModelAttribute("meetings")Meetings meetings,HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView("index");
		departmentService.createMeetingsWithDepartments(employee, department, meetings);
		response.sendRedirect("index");
		return model;
	}
	
	//View katmanýnda sýralanmýþ olan iþçilerin 'id' bilgisine göre toplantý ve departman bilgileriyle birlikte veritabanýndan silinmesi
	//@PathVariable ile URL ' den gönderilmiþ olan 'id' alýnmaktadýr.
	@RequestMapping(value="/delete/{id}" , method = RequestMethod.GET )
	public String newEmployee(@ModelAttribute("employee") Employee employee, @PathVariable("id") int id){
		ModelAndView model = new ModelAndView("index");
		departmentService.deleteById(id,id);
		employeeService.deleteById(id);
		return "redirect:/index";
	}
}
