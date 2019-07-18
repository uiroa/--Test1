package day09C练习;
/**
 * 定义一个学生类 , 其中包含姓名,年龄,成绩的属性
 * 之后由键盘输入学生的各种内容,并将内容保存在文件中
 * 
 * 要求全部的操作都使用反射机制完成 , 既不能使用通过关键字new创建学生类对象的操作
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
