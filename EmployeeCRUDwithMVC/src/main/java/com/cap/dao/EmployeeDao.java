package com.cap.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cap.bean.Employee;


/**
 * marking with @Repository is similar to @Component but used for Dao implementation classes,
 * spring will keep instance of DetailsDaoImpl and the object will be kept in bean factory
 *
 */
@Repository//@Service,@Component,@Entity
public class EmployeeDao implements EmployeeDaoI {

	@PersistenceContext
	private EntityManager em;

	public EmployeeDao(){
	}

	@Override
	public Employee findEmployeeById(int id) {
		Employee e = em.find(Employee.class,id);
		return e;
	}

	@Override
	public Employee createEmployee(Employee emp){
		emp = em.merge(emp);
		return emp;
	}

	@Override
	public Employee createEmployee(String name) {
		Employee emp = new Employee();
		emp.setName(name);
		emp = em.merge(emp);
		return emp;
	}

	@Override
	public Employee updateEmployee(int id, String name) {
		Employee e = em.find(Employee.class, id);
		e.setName(name);
		em.merge(e);
		return e;
	}

	@Override
	public Employee updateEmployeeDetails(Employee emp) {
		Employee e = em.find(Employee.class, emp.getId());
		e.setName(emp.getName());
		em.merge(e);
		return e;
	}

	@Override
	public Employee deleteEmployee(int id) {
		Employee e = em.find(Employee.class, id);
		em.remove(e);
		return e;
	}
}