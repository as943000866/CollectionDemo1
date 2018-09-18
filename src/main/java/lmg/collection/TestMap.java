package lmg.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * Collection接口
 * 
 * Map接口
 * 		|----HashMap:map的主要实现类
 * 		|----LinkedHashMap
 * 		|----TreeMap
 * 		|----HashTable
 * 			|----Properties
 */
public class TestMap {
	/*
	 * Object put(Object key,Object value):向Map中添加一个元素
	 * Object remove(Object key)
	 * void putAll(Map t)
	 * void clear();
	 * Object get(Object key)
	 * boolean containsKey(Object key)
	 * boolean containValue(Object value)
	 * int size()
	 * boolean isEmpty()
	 * boolean equals(Object obj)
	 */
	@Test
	public void test(){
		Map map = new HashMap();
		map.put("AA", 123);
		map.put("bb", 456);
		map.put("DD", 789);
		map.put(123, 111);
		System.out.println(map.size());
	}
}
