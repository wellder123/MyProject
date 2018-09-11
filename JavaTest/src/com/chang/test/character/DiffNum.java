package com.chang.test.character;

public class DiffNum {

	/**
	 * 输入字符串长度len1，字符串s1，字符串长度len2，字符串s2。从后向前比较，以最短字符串为标准，输出不同的元素的个数。 例如:
	 * 输入：s1="1,3,5" len1=3 s2="2,4,1,7,5" len2=5 输出：1
	 * 
	 * 函数原型 public int getDiffNum(int len1, String s1, int len2, String s2)
	 * 
	 * @author sheepmu
	 * 
	 */
	public static void main(String[] args){  
	     String s1="1,3,5";  
	     int len1=3;  
	     String s2="2,4,1,7,5";  
	     int len2=5;  
	     int diffNum= getDiffNum(s1,len1,s2,len2);  
	     System.out.println("不同的数目："+diffNum); 
	}

	public static int getDiffNum(String s1, int len1, String s2, int len2) {
		String[] str1 = s1.split(",");
		String[] str2 = s2.split(",");
		int len = len1 > len2 ? len2 : len1;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (!str1[len1 - 1 - i].equals(str2[len2 - 1 - i]))
				count++;
		}
		return count;
	}

}
