package com.chang.test.anagram;

import java.util.HashMap;

/**
 * Anagram的判断
 * @author Administrator
 *
 */
public class AnagramRun {

	public static void main(String[] args) {  
		
		if(args.length <= 1 ){
			System.out.println("没有要比较的单词！");
			System.exit(0);
		}

		
	       String a = args[0];  
	       String b = args[1];  
	        boolean x = isAnagram(a, b);  
	        System.out.println(x);  
	    }  
	  	  
	  
	    public static boolean isAnagram(String a, String b) {  
	        HashMap<Character, Integer> x = new HashMap<Character, Integer>();  
	        for (char c1 : a.toLowerCase().toCharArray()) {  
	            if (!x.containsKey(c1)) {  
	                x.put(c1, 1);  
	            } else {  
	                x.put(c1, x.get(c1) + 1);  
	            }  
	        }  
	  
	        for (char c2 : b.toLowerCase().toCharArray()) {  
	            if (!x.containsKey(c2)) {  
	               return false;  
	            } else {  
	                x.put(c2, x.get(c2) - 1);  
	                if (x.get(c2) == 0) {  
	                    x.remove(c2);  
	                }  
	            }  
	        }  
	        if (x.isEmpty()) {  
	            return true;  
	        } else {  
	            return false;  
	        }  
	    }  
	  

}
