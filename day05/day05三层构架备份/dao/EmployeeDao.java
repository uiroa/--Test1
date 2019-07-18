package day05���㹹�ܱ���.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day05���㹹�ܱ���.entity.DakaInfo;
import day05���㹹�ܱ���.entity.Employee;




public class EmployeeDao extends BaseDao<Employee> {
	static List<Employee> employees= new ArrayList<Employee>();

	
	//������Ա
	public void addEmployee(Employee e) throws IOException {
		
		System.out.print("������ID:");
		int ID=new Scanner(System.in).nextInt();
		e=selectEmloyee(ID);
		if(e!=null) {
			System.out.println("Ա��ID�Ѵ���,���ʧ��");
		}else {
			e.setId(ID);;
			System.out.print("����������:");
			String name=new Scanner(System.in).nextLine();
			e.setName(name);
			employees.add(e);	
			super.writeFile("employeeinfo.txt", e);
			System.out.println("�����Ϣ�ɹ�");
		}

	}
	
	//ɾ����Ա
	public void deleteEmploy(int ID) throws IOException {
		Employee employee=selectEmloyee(ID);
		if(null==employee) {
			
		}else {
			employees.remove(employee);
			super.writeFileByDelete("employeeinfo.txt", employees);
			System.out.println("ɾ����Ϣ�ɹ�");
		}
	}
	
	//����Ա��
	public Employee selectEmloyee(int ID) {
		boolean flag1=true;
		if(employees.isEmpty()) {
			System.out.println("û��Ա��");
		}else {
			for (Employee e:employees) {
				if(e.getId()==ID) {
					flag1=false;
					return e;			
				}
				if(flag1==true) {
					System.out.println("�޴�IDԱ��.");
					return null;
				}
			}
		}
		return null;
	}
	
	//�鿴����Ա����Ϣ
	public List<Employee> selectAll() throws IOException{
		List<Employee> list = super.stringToList("employeeinfo.txt");
		return list;
	}
}
