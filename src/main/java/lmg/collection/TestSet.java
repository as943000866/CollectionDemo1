package lmg.collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestSet {
	
	
	
	@Test
	public void testTreeSet2(){

		TreeSet set = new TreeSet(new Comparator() {
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				if(o1 instanceof Customer && o2 instanceof Customer){
					Customer c1 = (Customer) o1;
					Customer c2 = (Customer) o2;
					int i = c1.getId().compareTo(c2.getId());
					if(i == 0){
						return c1.getName().compareTo(c2.getName());
					}
					return i;
				}
				return 0;
			}
		});
		
		set.add(new Customer("BB", 1001));
		set.add(new Customer("DD", 1005));
		set.add(new Customer("AA", 1002));
		set.add(new Customer("FF", 1003));
		set.add(new Customer("CC", 1001));
		
		for (Object object : set) {
			System.out.println(object);
		}
	}
	
	/*
	 * TreeSet的定制排序
	 * 
	 * >compare()与hashCode以及equals()三者保持一致
	 */
	@Test
	public void testTreeSet1(){
		//1.创建一个实现了Comparator接口的类对象
		Comparator com = new Comparator() {
			
			//向TreeSet中添加Customer类的对象,在此compare()方法中,指明是按照Customer
			//的哪个属性进行排序的。
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				if(o1 instanceof Customer && o2 instanceof Customer){
					Customer c1 = (Customer) o1;
					Customer c2 = (Customer) o2;
					int i = c1.getId().compareTo(c2.getId());
					if(i == 0){
						return c1.getName().compareTo(c2.getName());
					}
					return i;
				}
				return 0;
			}
			
		};
		//2.将此对象作为形参传递给TreeSet的构造器中
		TreeSet set = new TreeSet(com);
		//3.向TreeSet中添加Comparator接口中的compare方法中涉及的类的对象
		set.add(new Customer("BB", 1001));
		set.add(new Customer("DD", 1005));
		set.add(new Customer("AA", 1002));
		set.add(new Customer("FF", 1003));
		set.add(new Customer("CC", 1001));
		
		for (Object object : set) {
			System.out.println(object);
		}
	}
	/*
	 * TreeSet:
	 * 1.向TreeSet中添加的元素必需是同一个类的
	 * 2.可以按照添加进集合中的元素的指定顺序进行遍历。
	 * 像String,包装类等默认按照从小到大的顺序遍历
	 * 3.当向TreeSet中添加自定义的类对象时,有两种排序方法
	 * 1).自然排序 2).自定义排序
	 * 4.在自然排序中,要求自定义的类实现java.lang.Comparable
	 * 接口并重写其compareTo(Object obj)方法。在此方法中,指明
	 * 按照自定义类的那种属性进行排序。
	 * 
	 * 5.向TreeSet中添加元素时,首先按照compareTo()进行比较,
	 * 一旦返回0,虽然仅是两个对象的属性相同,但是程序会认为这两个对象
	 * 是相同的,进而后一个对象就不能添加进来
	 * 
	 * >compareTo()与hashCode以及equals()三者保持一致
	 */
	@Test
	public void testTreeSet(){
		Set set = new TreeSet();
//		set.add("BB");
//		set.add("AA");
//		set.add("DD");
//		set.add("CC");
//		set.add("EE");
		
		
		//当Person类没有实现Comparable接口时,当向TreeSet中添加Person对象时,报ClasssCastException
	    set.add(new Person("BB", 20));
	    set.add(new Person("AA", 22));
	    set.add(new Person("DD", 25));
	    set.add(new Person("CC", 24));
	    set.add(new Person("EE", 23));
	    set.add(new Person("FF", 23));
	    
	    
		for (Object object : set) {
			System.out.println(object);
		}
	}
}
