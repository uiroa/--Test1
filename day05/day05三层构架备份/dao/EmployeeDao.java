package day05三层构架备份.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day05三层构架备份.entity.DakaInfo;
import day05三层构架备份.entity.Employee;




public class EmployeeDao extends BaseDao<Employee> {
	static List<Employee> employees= new ArrayList<Employee>();

	
	//增添人员
	public void addEmployee(Employee e) throws IOException {
		
		System.out.print("请输入ID:");
		int ID=new Scanner(System.in).nextInt();
		e=selectEmloyee(ID);
		if(e!=null) {
			System.out.println("员工ID已存在,添加失败");
		}else {
			e.setId(ID);;
			System.out.print("请输入名字:");
			String name=new Scanner(System.in).nextLine();
			e.setName(name);
			employees.add(e);	
			super.writeFile("employeeinfo.txt", e);
			System.out.println("添加信息成功");
		}

	}
	
	//删除人员
	public void deleteEmploy(int ID) throws IOException {
		Employee employee=selectEmloyee(ID);
		if(null==employee) {
			
		}else {
			employees.remove(employee);
			super.writeFileByDelete("employeeinfo.txt", employees);
			System.out.println("删除信息成功");
		}
	}
	
	//查找员工
	public Employee selectEmloyee(int ID) {
		boolean flag1=true;
		if(employees.isEmpty()) {
			System.out.println("没有员工");
		}else {
			for (Employee e:employees) {
				if(e.getId()==ID) {
					flag1=false;
					return e;			
				}
				if(flag1==true) {
					System.out.println("无此ID员工.");
					return null;
				}
			}
		}
		return null;
	}
	
	//查看所有员工信息
	public List<Employee> selectAll() throws IOException{
		List<Employee> list = super.stringToList("employeeinfo.txt");
		return list;
	}
}
