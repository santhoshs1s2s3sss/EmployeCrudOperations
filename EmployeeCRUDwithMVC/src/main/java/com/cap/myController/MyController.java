package com.cap.myController;


import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cap.bean.Employee;
import com.cap.service.EmployeeServiceI;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
public class MyController {

	/**
	 *  object of DetailsServiceImpl class will be injected
	 */
	@Autowired
	private EmployeeServiceI service;

	public EmployeeServiceI getService() {
		return service;
	}
	public void setService(EmployeeServiceI service) {
		this.service = service;
	}
	private int i = 0;

	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		i++;
		ModelAndView mv = new ModelAndView("hellopage",
				"message", "Hello request count=" + i);
		return mv;
	}
	
	// it will get details of particular Employee after the /getdetails URL
	@RequestMapping(value = "/userdetails", method = RequestMethod.GET)
	public ModelAndView employeeDetails(@RequestParam ("id") int id) {
		Employee user = service.findEmployeeById(id);//
		if (user == null) {
			ModelAndView mv=new ModelAndView("usernotfound","id",id);
			return mv;
		}
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("id", id);
		modelMap.put("name", user.getName());
		ModelAndView mv = new ModelAndView("userdetails", modelMap);
		return mv;
	}
	
	// get Details of the Employee
	@RequestMapping("/getdetails")
	public ModelAndView detailsForm() {
		return new ModelAndView("detailsform");
	}
	
	// Create Employee
	@RequestMapping("/createuser")
	public ModelAndView createEmployeeForm(){
		ModelAndView mv=new ModelAndView("createuser");
		return mv;
	}
	
	// Process to create Employee 
	@RequestMapping("/createprocess")
	public ModelAndView createProcess(@RequestParam String name){
		Employee emp=service.createEmployee(name);
		Map<String,Object>map=new HashMap<>();
		map.put("id",emp.getId());
		map.put("name",emp.getName());
		ModelAndView mv=new ModelAndView("usercreated",map);
		return mv;
	}
	

	// update Employee details
	@RequestMapping("/updateUserDetails")
	public ModelAndView updateEmployee() {
		ModelAndView mv = new ModelAndView("updateDetails");
		return mv;
	}
	
	// Employee Details update Process
	@RequestMapping(value = "/updateProcess")
	public ModelAndView updateEmployeedetails(@RequestParam ("id") int id, @RequestParam("name") String name) {
		Employee emp = service.findEmployeeById(id);
		if (emp == null) {
			ModelAndView mv=new ModelAndView("usernotfound","id",id);
			return mv;
		}
		else
		{
			emp = service.updateEmployee( id, name);
			Map<String, Object> map = new HashMap<>();
			map.put("id", id);
			map.put("name", name);
			ModelAndView mv = new ModelAndView("usercreated",map);
			return mv;
		}
	}
	
	// update Employee details
		@RequestMapping("/deleteEmployeeDetails")
		public ModelAndView deleteEmployee() {
			ModelAndView mv = new ModelAndView("deleteDetails");
			return mv;
		}
		
	// delete Employee Details
	@RequestMapping(value = "/deleteProcess")
	public ModelAndView deleteDetails(@RequestParam ("id") int id) {
		Employee emp = service.findEmployeeById(id);
		if (emp == null) {
			ModelAndView mv=new ModelAndView("usernotfound","id",id);
			return mv;
		}
		else
		{
			emp = service.deleteEmployee(id);
			Map<String, Object> map = new HashMap<>();
			map.put("id", id);
			map.put("name", emp.getName());
			ModelAndView mv = new ModelAndView("userdeleted",map);
			return mv;
		}
	}
}