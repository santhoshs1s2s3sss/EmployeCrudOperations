package com.cap.dao;

import com.cap.bean.Employee;

public interface EmployeeDaoI {

	Employee findEmployeeById(int id);

	Employee createEmployee(Employee emp);

	Employee createEmployee(String name);

	Employee updateEmployee(int id, String name);

	Employee updateEmployeeDetails(Employee emp);

	Employee deleteEmployee(int id);
}