package day09C��ϰ;
/**
 * ����һ��ѧ���� , ���а�������,����,�ɼ�������
 * ֮���ɼ�������ѧ���ĸ�������,�������ݱ������ļ���
 * 
 * Ҫ��ȫ���Ĳ�����ʹ�÷��������� , �Ȳ���ʹ��ͨ���ؼ���new����ѧ�������Ĳ���
 * 
 * @author Administrator
 *
 */
public class Student {
	private String name;
	private int age;
	private int degree;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, int degree) {
		super();
		this.name = name;
		this.age = age;
		this.degree = degree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", degree=" + degree + "]";
	}
		
}
