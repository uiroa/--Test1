package day05���㹹�ܱ���.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import day05���㹹�ܱ���.entity.DakaInfo;
import day05���㹹�ܱ���.entity.Employee;
import day05���㹹�ܱ���.service.DakaService;
import day05���㹹�ܱ���.service.EmpService;



public class Main {
	private static void jiemian(){
		System.out.println("----------------------");
		System.out.println("1.��ѯԱ���б�");
		System.out.println("2.����Ա��");
		System.out.println("3.ɾ��Ա��");
		System.out.println("4.ǩ��");
		System.out.println("5.ǩ��");
		System.out.println("6.��ѯǩ����Ϣ");
		System.out.println("7.�˳�");
		System.out.println("----------------------");
		System.out.println("��ѡ�����:");
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
				System.out.println("������Ҫ����Ա����id");
				int id = new Scanner(System.in).nextInt();
				System.out.println("������Ҫ����Ա��������");
				String name =new Scanner(System.in).nextLine();
				Employee temp = new Employee(id, name);
				empService.addEmoloyee(temp);
			
				jiemian();
				i=new Scanner(System.in).nextInt();
				break;
			case 3:
				System.out.println("������Ҫɾ��Ա����id");
				int id1 = new Scanner(System.in).nextInt();
				empService.deleteEmployee(id1);
				
				jiemian();
				i=new Scanner(System.in).nextInt();
				break;
			case 4:
				System.out.println("������Ҫǩ��Ա����id");
				 id = new Scanner(System.in).nextInt();
			   	daka.qiandao(id);;
				
				jiemian();
				i=new Scanner(System.in).nextInt();
				break;	
			case 5:
				boolean flag1=true;
				DakaInfo dakaInfo=null;
				System.out.println("������Ҫǩ��Ա����id");
				 id = new Scanner(System.in).nextInt();
				 List<DakaInfo> listdDakaInfos=daka.chakanxinxi();
				 for(DakaInfo d:listdDakaInfos) {
					 while(id==d.getId()) {
						 dakaInfo=d;
						 flag1=false;
					 }
				 }
				 if(flag) {
					 System.out.println("��ID������");
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
