package lmg.thread;

//拓展:实现二者交替打印,使用线程的通信
class Account {
	private int balance;

	public synchronized void save() {
		notify();
		for (int i = 0; i < 3; i++) {

			balance = balance + 1000;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":当前余额" + balance);
		}
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Customer extends Thread {
	Account account;

	public Customer(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		account.save();
	}
}

public class TestAccount {
	public static void main(String[] args) {
		Account account = new Account();
		Customer c1 = new Customer(account);
		Customer c2 = new Customer(account);

		c1.setName("甲");
		c2.setName("乙");

		c1.start();
		c2.start();
	}
}
