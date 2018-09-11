package com.chang.test.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*     
 * 题目: 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。   
 * 但是要保证汉字不被截半个，如“我ABC”4，应该截为“我AB”，输入“我ABC汉DEF”，6，应该输出为“我ABC”而不是“我ABC+汉的半个”。
* @author sheepmu 
*/
public class StringCut {
	public static void main(String[] args) {
		String s = "我AB";
		byte[] bs0;
		byte[] bs1;
		byte[] bs2;
		byte[] bs3;
		byte[] bs4;
		byte[] bs5;
		try {
			bs0 = s.getBytes("GBK");
			System.out.println("GBK---我AB--->" + Arrays.toString(bs0));
			bs1 = s.getBytes("UTF-8");
			System.out.println("UTF-8----我AB------>" + Arrays.toString(bs1));
			bs2 = s.getBytes("UNICODE");
			System.out.println("UNICODE---我AB----->" + Arrays.toString(bs2));
			bs3 = "我".getBytes("UNICODE");
			System.out.println("UNICODE---我----->" + Arrays.toString(bs3));
			bs4 = "A".getBytes("UNICODE");
			System.out.println("UNICODE---A----->" + Arrays.toString(bs4));
			bs5 = "AB".getBytes("UNICODE");
			System.out.println("UNICODE---AB----->" + Arrays.toString(bs5));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
