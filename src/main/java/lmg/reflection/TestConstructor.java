package lmg.reflection;

import org.junit.Test;

public class TestConstructor {
	@Test
	public void test1() throws Exception{
		String className = "lmg.reflection.Person";
		Class clazz = Class.forName(className);
		//创建对应的运行时类的对象。使用newInstance(),实际上就是调用了运行时类的空参构造器。
		//要想能够创建成功:①要求对应的运行时类要有空参的构造器。②构造器的权限修饰符的权限要足够。
		Object obj = clazz.newInstance();
		Person p = (Person)obj;
		System.out.println(p);
	}
}
