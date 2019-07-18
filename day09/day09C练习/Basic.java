package day09C练习;

import java.util.Scanner;

public class Basic {
	public void input(Student student) {
		System.out.print("输入你的姓名:  ");
		String name = new Scanner(System.in).nextLine();
		student.setName(name);
		System.out.print("输入你的年龄:  ");
		int age = new Scanner(System.in).nextInt();
		student.setAge(age);
		System.out.print("输入你的成绩:  ");
		int degree = new Scanner(System.in).nextInt();
		student.setDegree(degree);
	}
}
