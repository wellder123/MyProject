package com.chang.test.digital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 将一个十进制（byte型）转换为二进制，讲二进制数前后颠倒，再算出颠倒后对于的十进制数
 * 
 * @author Administrator
 *
 */
public class HexConvert {
	public static void main(String[] args) {
		HexConvert text = new HexConvert();
		text.change((char) 10);
	}

	public void change(char c) {
		int ic = c;
		String sc = Integer.toBinaryString(ic);// 十进制---->二进制 !!!!!!!!!!!!!!!!!!
		System.out.println("二进制为--->" + sc);// 二进制为--->1010
		char[] scc = sc.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = scc.length - 1; i >= 0; i--) {
			sb.append(scc[i]);
		}
		System.out.println("二进制前后颠倒后--->" + sb.toString());// 二进制前后颠倒后--->0101
		Integer it = Integer.valueOf(sb.toString(), 2);// 二进制----->十进制 !!!!!!!!!!!!!!
		System.out.println(" 颠倒后的二进制对应的十进制--->" + it);// 颠倒后的二进制对应的十进制--->5

	}

}
