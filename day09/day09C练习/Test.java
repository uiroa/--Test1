package day09C��ϰ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		try {
			Class<?> class1 = Class.forName("day09C��ϰ.Student");
			Class<?> class2 = Class.forName("day09C��ϰ.Basic");
			
			Student student = (Student)class1.newInstance();
			Basic basic = (Basic)class2.newInstance();
			
			FileWriter fileWriter = new FileWriter("e:\\txt\\student.txt",true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			
			while(true) {
				basic.input(student);
				System.out.print("�Ƿ�Ҫ��������,����������1,��������0: ");
				String string = student.toString();
				
				bw.write(string);
				bw.newLine();
				bw.flush();
				int key= new Scanner(System.in).nextInt();
				if(0==key) {
					break;
				}
			}
			bw.close();

			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}	
