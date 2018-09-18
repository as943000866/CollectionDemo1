package lmg.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	@Test
	public void test1(){
		Class clazz = Person.class;
		//1.getFields():只能获取到运行时类中及其父类声明为public的属性
		Field[] fields = clazz.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i]);
		}
		System.out.println();
		//2.getDeclaredFields():获取运行时类本身声明的所有属性
		Field[] fields1 = clazz.getDeclaredFields();
		for (Field field : fields1) {
			System.out.println(field.getName());
		}
	}
	//权限修饰符 变量类型 变量名
	//获取属性的各个部分的内容
	@Test
	public void test2(){
		Class clazz = Person.class;
		Field[] fields1 = clazz.getDeclaredFields();
		for (Field field : fields1) {
			//1.获取每个属性的权限修饰符
			int i = field.getModifiers();
			String str = Modifier.toString(i);
			System.out.print(str + " ");
			//2.获取属性的类型
			Class type = field.getType();
			System.out.print(type.getName() + " ");
			//3.获取属性名
			System.out.print(field.getName());
			System.out.println();
		}
	}
}
