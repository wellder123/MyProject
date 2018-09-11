package com.chang.test.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 通过键盘输入一串小写字母(a~z)组成的字符串。请编写一个字符串压缩程序，将字符串中连续出席的重复字母进行压缩，并输出压缩后的字符串。 压缩规则：
 * 1、仅压缩连续重复出现的字符。比如字符串"abcbc"由于无连续重复字符，压缩后的字符串还是"abcbc"。
 * 2、压缩字段的格式为"字符重复的次数+字符"。例如：字符串"xxxyyyyyyz"压缩后就成为"3x6yz"。 要求实现函数： void
 * stringZip(const char *pInputStr, long lInputLen, char *pOutputStr);
 * 输入pInputStr： 输入字符串lInputLen： 输入字符串长度 输出 pOutputStr： 输出字符串，空间已经开辟好，与输入字符串等长；
 * 注意：只需要完成该函数功能算法，中间不需要有任何IO的输入输出 示例 输入：“cccddecc” 输出：“3c2de2c” 输入：“adef”
 * 输出：“adef” 输入：“pppppppp” 输出：“8p” author SheepMu
 */
public class StringZip {
	public static void main(String[] args) {
		Scanner input0 = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		String str0 = input0.nextLine();
		long len = input1.nextLong();
		String output = "";
		StringZip text = new StringZip();
		text.stringZip(str0, len, output);

	}

	public void stringZip(String pInputStr, long len, String pOutputStr) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < len; i++)
			list.add(pInputStr.charAt(i) + "");// ！！！！双引号不要空开，不然就是一个空格了。

		int[] count = new int[(int) len];// 定义一个数组，装每个字母出现的次数，然后初始定义没个出现的次数为1；
		for (int i = 0; i < len; i++)
			count[i] = 1;
		StringBuffer sb = new StringBuffer();// 来装新的string
		for (int i = 0; i < list.size(); i++) { // !!!!
			for (int j = i + 1; j < list.size(); j++) {// !!!
				if (list.get(i).equals(list.get(j))) {
					count[i]++;
					list.remove(j);
					j--;
				} else {
					break;
				} // !!!!一旦list.get(i).equals(list.get(j))为false，即某个j时为false,即一旦出现不等的字母，就跳出里面这个循环！！！
			}
			if (count[i] != 1) // 内循环结束后把数目和该字母append进sb,如果数量只是1，不加“1”
				sb.append(count[i]);
			sb.append(list.get(i));
			System.out.println("count[" + i + "]" + count[i]);
		}

		System.out.println("最后结果---->" + sb.toString());
	}
}
