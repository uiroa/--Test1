package day05三层构架备份.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import day05三层构架备份.entity.DakaInfo;
import day05三层构架备份.entity.Employee;

public class DakaInfoDao extends BaseDao<DakaInfo> {
	static List<DakaInfo> dakaInfoList=new ArrayList<DakaInfo>();
	BaseDao<DakaInfo> baseDao = new BaseDao<DakaInfo>();
	
	//签到
		public void qiandao(DakaInfo d) throws IOException{
			EmployeeDao employeedao=new EmployeeDao();
			System.out.print("请输入签到员工ID: ");
			int ID=new Scanner(System.in).nextInt();
			Employee e=employeedao.selectEmloyee(ID);
			
			if(dakaInfoList.isEmpty()) {
					System.out.println("卡号:"+e.getId()+"       打卡成功");
					DakaInfo dakaInfo=new DakaInfo(ID, null, null);
					dakaInfo.setId(e.getId());
					dakaInfo.setQdtime(new Date());
					dakaInfoList.add(dakaInfo);
					baseDao.writeFile("dakainfo.txt", dakaInfo);
			}else {
					for (DakaInfo d1:dakaInfoList) {
						while(e.getId()==d1.getId()) {
							System.out.println("今天已经打过卡了");
						}
					}
					System.out.println("卡号:"+e.getId()+"       打卡成功");
					DakaInfo dakaInfo=new DakaInfo(ID, null, null);
					dakaInfo.setId(e.getId());
					dakaInfo.setQdtime(new Date());
					dakaInfoList.add(dakaInfo);	
					baseDao.writeFile("dakainfo.txt", dakaInfo);
			}
		}
		//签退
		public void qiantui(DakaInfo d) throws IOException{
			EmployeeDao employeedao=new EmployeeDao();
			System.out.print("请输入签退员工ID: ");
			int ID=new Scanner(System.in).nextInt();
			Employee e=employeedao.selectEmloyee(ID);
			
			for (DakaInfo d1:dakaInfoList) {
					if(d1.getQttime()==null) {
						if(e.getId()==d1.getId()) {
							System.out.println("卡号:"+e.getId()+"       签退成功");
							d1.setQttime(new Date());
							baseDao.writeFile("dakainfo.txt", d1);
						}else {
							System.out.println("卡号:"+e.getId()+"       今天还没有签到，无法签退");
						}
					}else {
						System.out.println("今天已经签退过了");
					}	
				}		
			}
		

		
		//查看签到信息
		public List<DakaInfo> chakan() throws IOException{
			List<DakaInfo> list = baseDao.stringToList("dakainfo.txt");
			return list;
		}
	
	
	
}
