package day09C��ϰ;

import java.util.Scanner;

public class Basic {
	public void input(Student student) {
		System.out.print("�����������:  ");
		String name = new Scanner(System.in).nextLine();
		student.setName(name);
		System.out.print("�����������:  ");
		int age = new Scanner(System.in).nextInt();
		student.setAge(age);
		System.out.print("������ĳɼ�:  ");
		int degree = new Scanner(System.in).nextInt();
		student.setDegree(degree);
	}
}
