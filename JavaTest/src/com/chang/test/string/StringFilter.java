package com.chang.test.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 通过键盘输入一串小写字母(a~z)组成的字符串。请编写一个字符串过滤程序，若字符串中出现多个相同的字符，将非首次出现的字符过滤掉。
 * 如字符串“abacacde”过滤结果为“abcde”。 要求实现函数： void stringFilter(const char *pInputStr,
 * long lInputLen, char *pOutputStr);
 * 
 * 【输入】 pInputStr： 输入字符串 lInputLen： 输入字符串长度 【输出】 pOutputStr：
 * 输出字符串，空间已经开辟好，与输入字符串等长； 【注意】只需要完成该函数功能算法，中间不需要有任何IO的输入输出 示例 输入：“deefd”
 * 输出：“def” 输入：“afafafaf” 输出：“af” 输入：“pppppppp” 输出：“p” author SheepMu
 */
public class StringFilter {
	public static void main(String[] args) {
		Scanner input0 = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		String str0 = input0.nextLine();
		long len = input1.nextLong();
		String output = "";
		StringFilter text = new StringFilter();
		text.stringFilter(str0, len, output);

	}

	public void stringFilter(String pInputStr, long len, String pOutputStr) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < len; i++)
			list.add(pInputStr.charAt(i) + "");// ！！！！双引号不要空开，不然就是一个空格了。

		for (int i = 0; i < list.size(); i++)
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					list.remove(j);
					j--;
				}
			}

		StringBuffer sb = new StringBuffer();
		for (String s : list)
			sb.append(s);
		System.out.println(sb.toString());
	}
}
