package com.chang.test.character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将大写字母转换成其对应小写字母后的第五个字母，大于z的从头开始数;如果是小写则不变。 author SheepMu
 */
public class CharConvert {
	public static void main(String[] args) {
		String str0 = "ABcYZ";
		char[] c0 = str0.toCharArray();
		for (int i = 0; i < c0.length; i++) {
			if (c0[i] >= 'A' && c0[i] <= 'Z') {
				c0[i] = (char) (c0[i] + 32 + 5);
				if (c0[i] > 'z')
					c0[i] -= 26;
			}
		}
		System.out.println(Arrays.toString(c0));// [f, g, c, d, e]
	}

}
