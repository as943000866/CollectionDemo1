package lmg.thread;
/*
 * 创建一个子线程,完成1-100之间自然数的输出。同样地,主线程执行同样的操作
 * 创建多线程的第一种方式:继承java.lang.Thread类
 */
//1.创建一个继承于Thread的子类
class SubThread extends Thread{
	//2.重写Thread类的run方法,方法内实现此子线程要完成的功能
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":"+ i);
		}
	}
}

public class TestThread {
	public static void main(String[] args) {
		//3.创建子类对象
		SubThread subThread1 = new SubThread();
		SubThread subThread2 = new SubThread();
		//4.调用start() 方法启动子线程 ;并调用run方法
		//一个线程只能执行一次strat()
		//不能通过Thread实现类对象的run()去启动一个线程
		subThread1.start();
//		subThread1.start();
//		subThread1.run();
		subThread2.start();
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":"+ i);
		}
	}
	
}
