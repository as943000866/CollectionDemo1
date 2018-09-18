package lmg.collection;

public class Employee implements Comparable{
	private String name;
	private Integer age;
	private MyDate birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	
	
	public Employee(String name, Integer age, MyDate birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}
	public int compareTo(Object o) {
		if(o instanceof Employee){
			Employee e = (Employee) o;
			return this.name.compareTo(e.name);
		}
		return 0;
	}
	
	
	
}
