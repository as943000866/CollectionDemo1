package lmg.thread;

/*
 * 生产者/消费者问题
 * 生产者(Productor)将产品交给店员(Clerk),而消费者(Customer)从店员处取走产品,
 * 店员一次只能持有固定数量的产品(比如:20),如果生产者试图生成更多的产品,店员会叫生产者停一下,
 * 如果店中有空位放产品了再通知生产者继续生产;如果店中没有产品了,店员会告诉消费者等一下,
 * 如果店中有产品了在通知消费者来取走产品。
 * 
 * 分析
 * 1.是否涉及到多线程的问题?是!生产者和消费者
 * 2.是否涉及到共享数据?有!考虑线程安全
 * 3.共享数据是谁?即为产品的数量
 * 4.是否涉及到线程的通信呢?存在着消费者和生产者的通信
 */
class Clerk {
	int product;
	
	public synchronized void consume(){
		if(product<=0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println(Thread.currentThread().getName() +":消费1个产品,还剩:"+product);
			product --;
			notify();
		}
	}
	
	public synchronized void production(){
		if(product >= 20){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println(Thread.currentThread().getName() +":生产1个产品,还剩:"+product);
			product ++;
			notify();
		}
	}
}

class Productor implements Runnable {
	Clerk clerk;

	public Productor(Clerk clerk) {
		this.clerk  = clerk;
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.production();
		}
	}

}

class Customer1 implements Runnable {
	
	Clerk clerk;

	public Customer1(Clerk clerk) {
		this.clerk = clerk;
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.consume();
		}
	}

}

public class TestProduceCunsumer {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Productor p = new Productor(clerk);
		Customer1 c = new Customer1(clerk);
		
		Thread t1 = new Thread(p);
		Thread t3 = new Thread(p);
		Thread t2 = new Thread(c);
		
		t1.setName("生产者1");
		t3.setName("生产者2");
		t2.setName("消费者1");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
