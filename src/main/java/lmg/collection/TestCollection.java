package lmg.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

/**
 * 1.存储对象可以考虑	1.数组 2.集合
 * 2.数组存储对象的特点 Student[] stu = new Student[20]; stu[0] = new Student()...
 * 	>弊端 1.一旦创建,其长度不可变 2.真实的数组存放的对象的个数是不可知的֪
 * 3.集合
 * @author Lmg
 *
 */
public class TestCollection {
	
	@Test
	public void test1(){
		Collection coll = new ArrayList();
		//1.size():返回集合中元素的个数
		System.out.println(coll.size());
		//2.add(Object object):向集合中添加一个元素
		coll.add("AA");
		coll.add("BB");
		coll.add(new Date());
		coll.add(123);
		System.out.println(coll.size());
		//3.addAll(Collection coll):将形参coll中包含的所有元素添加到当前集合中
		Collection coll1 = Arrays.asList(1,2,3);
		coll.addAll(coll1);
		System.out.println(coll.size());
		//4.isEmpty():判断集合是否为空
		System.out.println(coll.isEmpty());
		//5.clear():清空集合元素
		coll.clear();
		System.out.println(coll.isEmpty());
	}
	
	@Test
	public void test2(){
		Collection coll = new ArrayList();
		coll.add("AA");
		coll.add("BB");
		coll.add(new Date());
		coll.add(123);
		//Person p1 = new Person("Lmg", 21);
		coll.add(new Person("Lmg", 21));
		System.out.println(coll);
		//6.contains(Object obj):判断集合中是否包含元素,如果包含返回ture,否则返回false
		boolean b1 = coll.contains(new Person("Lmg", 21));
		System.out.println(b1);
		boolean b2 = coll.contains(123);
		System.out.println(b2);
		//7.containAll(Collection coll):判断当前集合是否包含coll中所有的元素
		Collection coll1 = new ArrayList();
		coll1.add(123);
		coll1.add("AA");
		boolean b3 = coll.containsAll(coll1);
		System.out.println(b3);
		//8.retainAll():求当前集合中与coll1中共有的元素,返回给当前集合
		coll.retainAll(coll1);
		System.out.println(coll);
		//9.remove(Object obj):删除集合中的包含的元素，若有返回ture,否则返回false
		boolean b4 = coll.remove(88);
		System.out.println(b4);
	}
	
	@Test
	public void test3(){
		Collection coll = new ArrayList();
		coll.add("AA");
		coll.add("BB");
		coll.add(new Date());
		coll.add(123);
		coll.add(new Person("Lmg", 21));

		Collection coll1 = new ArrayList();
		coll1.add(123);
		coll1.add("AA");
		
		//10.removeAll(Collection coll):从当前集合中删除包含在coll中的元素
		coll.removeAll(coll1);
		System.out.println(coll);
		//11.equals(Object obj):判断集合中的元素是否完全相同
		Collection coll2 = new ArrayList();
		coll2.add("AA1");
		coll2.add("123");
		System.out.println(coll1.equals(coll2));
		//12.hashCode():
		System.out.println(coll.hashCode());
		System.out.println();
		//13.toArray():将集合转为数组
		Object[] array = coll.toArray();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		//14.iterator():返回一个Iterator的的实现类对象,进而实现集合的遍历
		Iterator it = coll.iterator();
		//方式1
	/*	System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());*/
		//方式2
		/*for (int i = 0; i < coll.size(); i++) {
			System.out.println(it.next());
		}*/
		//方式3
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
