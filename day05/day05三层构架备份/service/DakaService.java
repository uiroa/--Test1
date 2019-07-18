package day05三层构架备份.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import day05三层构架备份.dao.DakaInfoDao;
import day05三层构架备份.entity.DakaInfo;



public class DakaService {
	DakaInfoDao dao = new DakaInfoDao();
	
	public void qiandao(int temp1) throws IOException{
		DakaInfo qiandao = new DakaInfo(temp1,new Date(),null);
		dao.qiandao(qiandao);
	}
	
	public void qiantui(int empid,Date date) throws IOException {
		DakaInfo qiantui = new DakaInfo(empid,date,new Date());
		dao.qiantui(qiantui);
	}
	
	public List<DakaInfo> chakanxinxi() throws IOException{
		return dao.chakan();
	}
}
