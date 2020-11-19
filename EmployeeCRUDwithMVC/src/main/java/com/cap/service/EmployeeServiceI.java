package com.cap.service;

import com.cap.bean.Employee;

public interface EmployeeServiceI {

	Employee findEmployeeById(int id);

	Employee createEmployee(Employee user);

	Employee createEmployee(String name);

	Employee updateEmployee(int id, String name);

	Employee updateUserDetails(Employee user);

	Employee deleteEmployee(int id);
}