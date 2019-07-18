package day05三层构架备份.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import day05三层构架备份.entity.DakaInfo;
import day05三层构架备份.entity.Employee;

public class BaseDao<T> {
	
	//读取文件,得到字符串
	public String readFile(String filename) throws IOException {
		File file=new File("e:"+File.separator+"txt"+File.separator+filename);
		FileInputStream in= new FileInputStream(file);

		byte[] bytes=new byte[in.available()];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i]=(byte)in.read();
		}
		
		String string=new String(bytes);
		
		return string;
		}
	
	//写入文件
	public void writeFile(String filename,T t)throws IOException {
		File file = new File("e:"+File.separator+filename); 
		FileOutputStream fos = new FileOutputStream(file,true);
		
		String string=t.toString();
		string="\r\n"+string;
		
		fos.write(string.getBytes());
		fos.close();
	}
	
	//将文件读出的String转成数组
	public List<T> stringToList(String filename) throws IOException{
		String string=readFile(filename);
		if("employeeinfo.txt".equals(filename)) {
			List<Employee> list=new ArrayList<Employee>();
			String[] split = string.split("\n");
			for (int i = 0; i < split.length; i++) {
				Employee employee=new Employee();
				 JSONObject object;
				 object=JSON.parseObject(split[i]);
				 employee.setId(object.getIntValue("id"));
				 employee.setName(object.getString("name"));
				 list.add(employee);
			}
			return (List<T>) list;
		}else if("dakainfo.txt".equals(filename)) {
			List<DakaInfo> list=new ArrayList<DakaInfo>();
			String[] split=string.split("\n");
			for (int i = 0; i < split.length; i++) {
				DakaInfo dakaInfo=new DakaInfo();
				 JSONObject object;
				 object=JSON.parseObject(split[i]);
				 dakaInfo.setId(object.getIntValue("id"));
				 dakaInfo.setQdtime(object.getDate("qdtime"));
				 dakaInfo.setQttime(object.getDate("qttime"));
				 list.add(dakaInfo);
			}
			return (List<T>) list;
		}
		return null;	
	}
	
	//更新文件,先清空文件,再录入
	public void writeFileByDelete(String filename,List<T> list) throws IOException {
		File file = new File("e:"+File.separator+filename); 
		FileOutputStream fos = new FileOutputStream(file);
		
		String str="";
		
		fos.write(str.getBytes());
		fos.close();
		System.out.println("文件清空");
		for (int i = 0; i < list.size(); i++) {
			writeFile(filename,list.get(i));
		}
	}
}
