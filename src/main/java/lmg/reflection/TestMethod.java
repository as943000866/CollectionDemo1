package lmg.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestMethod {
	//1.获取运行时类的方法
	
	@Test
	public void test1(){
		Class clazz = Person.class;
		//1.getMethods():获取运行时类及其父类所有的声明为public的方法
		Method[] m1 = clazz.getMethods();
		for (Method method : m1) {
			System.out.println(method);
		}
		
		System.out.println();
		
		//2.getDeclaredMethods():获取运行时类本身声明的所有的方法
		Method[] m2 = clazz.getDeclaredMethods();
		for (Method method : m2) {
			System.out.println(method);
		}
	}
	//注解 权限修饰符 返回值类型 方法名 形参列表  异常
	@Test
	public void test2(){
		Class clazz = Person.class;
		Method[] m2 = clazz.getDeclaredMethods();
		for (Method method : m2) {
			//1.注解
			Annotation[] ann = method.getAnnotations();
			for (Annotation annotation : ann) {
				System.out.print(annotation);
			}
			//2.权限修饰符
			String str = Modifier.toString(method.getModifiers());
			System.out.print(str + " ");
			//3.返回值类型
			Class returnType = method.getReturnType();
			System.out.print(returnType.getName()+" ");
			//4.方法名
			System.out.print(method.getName() + " ");
			//5.形参列表
			System.out.print("(");
			Class[] params = method.getParameterTypes();
			for (int i = 0; i < params.length; i++) {
				System.out.print(params[i].getName() + " args-" + i + " ");
			}
			System.out.print(")");
			//6.异常类型
			Class[] exps = method.getExceptionTypes();
			if(exps.length != 0){
				System.out.print("throws ");
			}
			for (int i = 0; i < exps.length; i++) {
				System.out.print(exps[i].getName());
			}
			System.out.println();
		}
	}
}
