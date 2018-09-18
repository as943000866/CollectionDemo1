package lmg.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class TestEmployee {
	//自然排序
	@Test
	public void test1(){
		TreeSet set = new TreeSet();
		set.add(new Employee("AA", 10, new MyDate(10, 20, 2018)));
		set.add(new Employee("FF", 40, new MyDate(11, 20, 2018)));
		set.add(new Employee("CC", 50, new MyDate(12, 20, 2018)));
		set.add(new Employee("EE", 20, new MyDate(5, 20, 2018)));
		set.add(new Employee("BB", 30, new MyDate(9, 20, 2018)));
		set.add(new Employee("BB", 32, new MyDate(9, 20, 2018)));
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	//定制排序
	@Test
	public void test2(){
		//创建 Comparator对象
		Comparator com = new Comparator() {

			public int compare(Object o1, Object o2) {
				if(o1 instanceof Employee && o2 instanceof Employee){
					Employee e1 = (Employee) o1;
					Employee e2 = (Employee) o2;
					return e1.getBirthday().compareTo(e2.getBirthday());
				}
				return 0;
			}
			
		};
		//把Comparator对象传入TreeSet构造方法
		TreeSet set = new TreeSet(com);
		
		//给TreeSet中添加Comparator中涉及的对象
		
		set.add(new Employee("AA", 10, new MyDate(10, 20, 2018)));
		set.add(new Employee("FF", 40, new MyDate(11, 20, 2017)));
		set.add(new Employee("CC", 50, new MyDate(12, 20, 2018)));
		set.add(new Employee("EE", 20, new MyDate(5, 20, 2018)));
		set.add(new Employee("BB", 30, new MyDate(9, 20, 2018)));
		//set.add(new Employee("HH", 30, new MyDate(9, 20, 2018)));
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}	
