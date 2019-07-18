package day05���㹹�ܱ���.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import day05���㹹�ܱ���.entity.DakaInfo;
import day05���㹹�ܱ���.entity.Employee;

public class DakaInfoDao extends BaseDao<DakaInfo> {
	static List<DakaInfo> dakaInfoList=new ArrayList<DakaInfo>();
	BaseDao<DakaInfo> baseDao = new BaseDao<DakaInfo>();
	
	//ǩ��
		public void qiandao(DakaInfo d) throws IOException{
			EmployeeDao employeedao=new EmployeeDao();
			System.out.print("������ǩ��Ա��ID: ");
			int ID=new Scanner(System.in).nextInt();
			Employee e=employeedao.selectEmloyee(ID);
			
			if(dakaInfoList.isEmpty()) {
					System.out.println("����:"+e.getId()+"       �򿨳ɹ�");
					DakaInfo dakaInfo=new DakaInfo(ID, null, null);
					dakaInfo.setId(e.getId());
					dakaInfo.setQdtime(new Date());
					dakaInfoList.add(dakaInfo);
					baseDao.writeFile("dakainfo.txt", dakaInfo);
			}else {
					for (DakaInfo d1:dakaInfoList) {
						while(e.getId()==d1.getId()) {
							System.out.println("�����Ѿ��������");
						}
					}
					System.out.println("����:"+e.getId()+"       �򿨳ɹ�");
					DakaInfo dakaInfo=new DakaInfo(ID, null, null);
					dakaInfo.setId(e.getId());
					dakaInfo.setQdtime(new Date());
					dakaInfoList.add(dakaInfo);	
					baseDao.writeFile("dakainfo.txt", dakaInfo);
			}
		}
		//ǩ��
		public void qiantui(DakaInfo d) throws IOException{
			EmployeeDao employeedao=new EmployeeDao();
			System.out.print("������ǩ��Ա��ID: ");
			int ID=new Scanner(System.in).nextInt();
			Employee e=employeedao.selectEmloyee(ID);
			
			for (DakaInfo d1:dakaInfoList) {
					if(d1.getQttime()==null) {
						if(e.getId()==d1.getId()) {
							System.out.println("����:"+e.getId()+"       ǩ�˳ɹ�");
							d1.setQttime(new Date());
							baseDao.writeFile("dakainfo.txt", d1);
						}else {
							System.out.println("����:"+e.getId()+"       ���컹û��ǩ�����޷�ǩ��");
						}
					}else {
						System.out.println("�����Ѿ�ǩ�˹���");
					}	
				}		
			}
		

		
		//�鿴ǩ����Ϣ
		public List<DakaInfo> chakan() throws IOException{
			List<DakaInfo> list = baseDao.stringToList("dakainfo.txt");
			return list;
		}
	
	
	
}
