package lmg.thread;
//单线程
public class Test {
	public static void main(String[] args) {
		method1();
	}
	
	public static void method1(){
		System.out.println("method1");
		method2();
	}
	public static void method2(){
		System.out.println("method2");
	}
}
