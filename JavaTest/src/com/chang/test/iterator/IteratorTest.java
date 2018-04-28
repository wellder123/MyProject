package com.chang.test.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 迭代器使用的测试
 * @author Administrator
 *
 */
public class IteratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> a = new ArrayList<String>();
		a.add("dog");
		a.add("cat");
		a.add("pig");
		a.add("chick");
		
		//List是有顺序的
		for(Iterator<String> t = a.listIterator();t.hasNext();){
			String s = t.next();
			System.out.println(s);
		}
		
		Map<String,String> m = new HashMap<String,String>();
		m.put("a", "dog");
		m.put("b", "cat");
		m.put("c", "pig");
		m.put("d", "chick");

		//set是无顺序的
		for(Iterator<Entry<String, String>> t = m.entrySet().iterator();t.hasNext();){
			@SuppressWarnings("rawtypes")
			Map.Entry element = t.next(); 
			String s1 = (String)element.getKey();
			String s2 = (String)element.getValue();
			System.out.println(s1+"==="+s2);
		}
		
		for(Map.Entry<String, String> t : m.entrySet()){
			String s1 = (String)t.getKey();
			String s2 = (String)t.getValue();
			System.out.println(s1+"============"+s2);
		}
	}

}
