package lmg.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//需要实现的接口
interface Human {
	void info();

	void fly();
}

// 被代理的类
class Superman implements Human {

	public void info() {
		System.out.println("我是超人");
	}

	public void fly() {
		System.out.println("我可以飞");
	}

}

// AOP插入的方法
class MethodUtil {
	public static void method1() {
		System.out.println("method1");
	}

	public static void method2() {
		System.out.println("method2");
	}
}

// 实现InvactionHandler接口的类
class MyInvacationHandler implements InvocationHandler {

	// 被代理类对象的声明
	Object obj;

	public void set(Object obj) {
		this.obj = obj;
	}

	public Object get() {
		return obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MethodUtil.method1();

		Object invoke = method.invoke(obj, args);
		MethodUtil.method2();
		return invoke;
	}

}

// 创建代理类
class ProxyFactory {
	//动态的创建一个代理类的对象
	public static Object creat(MyInvacationHandler handler) {
		Object obj = handler.get();
		Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
		return proxy;
	}
}

public class TestAop {
	public static void main(String[] args) {
		Superman suman = new Superman();//创建一个被代理类的对象
		MyInvacationHandler handler = new MyInvacationHandler();
		handler.set(suman);
		Object obj = ProxyFactory.creat(handler);//返回一个代理类的对象
		Human proxy = (Human) obj; 
		proxy.fly();//通过代理类对象调用重写的抽象方法
		proxy.info();
		
	}
}
