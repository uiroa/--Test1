package day09C练习;

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
			Class<?> class1 = Class.forName("day09C练习.Student");
			Class<?> class2 = Class.forName("day09C练习.Basic");
			
			Student student = (Student)class1.newInstance();
			Basic basic = (Basic)class2.newInstance();
			
			FileWriter fileWriter = new FileWriter("e:\\txt\\student.txt",true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			
			while(true) {
				basic.input(student);
				System.out.print("是否要继续输入,继续请输入1,结束输入0: ");
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
