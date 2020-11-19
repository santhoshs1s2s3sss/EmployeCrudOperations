package com.cap.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.bean.Employee;
import com.cap.dao.EmployeeDaoI;

import javax.transaction.Transactional;

/**
 * marking with @Service ,@Service is similar to @Component but used for service implementations
 *  Spring will create object of DetailsServiceImpl class and will keep in bean factory
 */
@Service//@Component
@Transactional
public class EmployeeService implements EmployeeServiceI {
	/**
	 * spring will inject with object of DetailsDaoImpl class because @Autowired is mentioned here
	 */
	@Autowired
	private EmployeeDaoI dao;

	public EmployeeDaoI getDao() {
		return dao;
	}

	public void setDao(EmployeeDaoI dao) {
		this.dao = dao;
	}

	@Override
	public Employee findEmployeeById(int id) {
		Employee emp= dao.findEmployeeById(id);
		return emp;
	}

	@Override
	public Employee createEmployee(Employee emp) {
		// transaction opened by spring
		emp= dao.createEmployee(emp);
		//transaction closed by spring
		return emp;
	}

	@Override
	public Employee createEmployee(String name) {
		return dao.createEmployee(name);
	}

	@Override
	public Employee updateEmployee(int id, String name) {
		Employee emp = dao.updateEmployee(id, name);
		return emp;
	}

	@Override
	public Employee updateUserDetails(Employee emp) {
		emp = dao.updateEmployeeDetails(emp);
		return emp;
	}

	@Override
	public Employee deleteEmployee(int id) {
		Employee emp = dao.deleteEmployee(id);
		return emp;
	}
}