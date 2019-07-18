package day05三层构架备份.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import day05三层构架备份.entity.DakaInfo;
import day05三层构架备份.entity.Employee;
import day05三层构架备份.service.DakaService;
import day05三层构架备份.service.EmpService;



public class Main {
	private static void jiemian(){
		System.out.println("----------------------");
		System.out.println("1.查询员工列表");
		System.out.println("2.增加员工");
		System.out.println("3.删除员工");
		System.out.println("4.签到");
		System.out.println("5.签退");
		System.out.println("6.查询签到信息");
		System.out.println("7.退出");
		System.out.println("----------------------");
		System.out.println("请选择序号:");
	}
	public static void main(String[] args) throws IOException {
		EmpService empService = new EmpService();
		DakaService daka=new DakaService();
		jiemian();
		int i =new Scanner(System.in).nextInt();
		boolean flag = true;
		while(flag) {
			switch(i) {
			case 1:
				List<Employee> list = empService.allInformation();
				for (int j = 0; j < list.size(); j++) {
					System.out.println(list.get(j).toString());
				}
				
				jiemian();
				i=new Scanner(System.in).nextInt();
				break;
			case 2:
				System.out.println("请输入要增加员工的id");
				int id = new Scanner(System.in).nextInt();
				System.out.println("请输入要增加员工的姓名");
				String name =new Scanner(System.in).nextLine();
				Employee temp = new Employee(id, name);
				empService.addEmoloyee(temp);
			
				jiemian();
				i=new Scanner(System.in).nextInt();
				break;
			case 3:
				System.out.println("请输入要删除员工的id");
				int id1 = new Scanner(System.in).nextInt();
				empService.deleteEmployee(id1);
				
				jiemian();
				i=new Scanner(System.in).nextInt();
				break;
			case 4:
				System.out.println("请输入要签到员工的id");
				 id = new Scanner(System.in).nextInt();
			   	daka.qiandao(id);;
				
				jiemian();
				i=new Scanner(System.in).nextInt();
				break;	
			case 5:
				boolean flag1=true;
				DakaInfo dakaInfo=null;
				System.out.println("请输入要签退员工的id");
				 id = new Scanner(System.in).nextInt();
				 List<DakaInfo> listdDakaInfos=daka.chakanxinxi();
				 for(DakaInfo d:listdDakaInfos) {
					 while(id==d.getId()) {
						 dakaInfo=d;
						 flag1=false;
					 }
				 }
				 if(flag) {
					 System.out.println("此ID不存在");
				 }else{
					 	daka.qiantui(id,dakaInfo.getQdtime());
				 }
				jiemian();
				i= new Scanner(System.in).nextInt();
				break;	
			case 6:
				List<DakaInfo> list1 = daka.chakanxinxi();
				for (int j = 0; j < list1.size(); j++) {
					System.out.println(list1.get(j).toString());
				}
				
				jiemian();
				i= new Scanner(System.in).nextInt();
				break;
			default:
				flag= false;
				break;
			}
		}	
	}
}
