package lmg.reflection;

@MyAnnotation(value = "lmg.reflection")
public class Person extends Creature<String> implements Comparable,MyInterface{
	public String name;
	private int age;
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
	
	
	public Person() {
		super();
		System.out.println("newInstance时调用空参的构造器");
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@MyAnnotation(value = "adc")
	public void show() {
		System.out.println("我是一个人");
	}
	
	public void display(String name) throws Exception{
		System.out.println("我的国籍是:"+name);
	}
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
