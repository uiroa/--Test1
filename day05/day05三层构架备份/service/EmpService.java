package day05���㹹�ܱ���.service;

import java.io.IOException;
import java.util.List;

import day05���㹹�ܱ���.dao.EmployeeDao;
import day05���㹹�ܱ���.entity.Employee;

public class EmpService {
	EmployeeDao dao = new EmployeeDao();
	
	public void addEmoloyee(Employee e) throws IOException {
		dao.addEmployee(e);
	}
	
	public void deleteEmployee(int id) throws IOException {
		dao.deleteEmploy(id);
	}
	
	public List<Employee> allInformation() throws IOException{
		return  dao.selectAll();
	}
	
	public Employee singleEmployee(int id) {
		return dao.selectEmloyee(id);
	}
}
