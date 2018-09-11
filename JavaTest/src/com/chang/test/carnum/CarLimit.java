package com.chang.test.carnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 尾号限行：输入一串车牌号码，以逗号分割开，车牌号码有以下要求，只要取后五位,如：AD123，12101，中国 的车牌号不可能全是字母。
 * 现在对尾号进行限制：尾号为1,6则周一限行，尾号为2,7则周二限行，尾号为3,8则周三限行 尾号为4,9则周四限行,尾号为5,0的周五限行.
 * 周六周日不限行。尾号不为数字，则看第4位是否是数字，如果第4位还不是 数字，继续看第3位，以此下去，直到找到有数字的时候止.
 * 由于用户不熟悉系统，有可能输入错误车牌，如车牌不满5位或大于5位、车牌全是字母、没用逗号分割等，如有输入错误情况 一律返回error
 * 如输入没有问题则返回限行的车牌号,如没有，刚返回空. 例如： 输入：String theCarCard = "A1023,NB123,D12ZG",int
 * limitDate = 3; 输出：A1023,NB123 String limitedCarCard(String input)
 * 
 * @author sheepmu
 */
public class CarLimit {
	public static void main(String[] args) {
		CarLimit text = new CarLimit();
		Scanner input = new Scanner(System.in);
		String str0 = input.nextLine(); // 输入两个！！！时怎么办！！！！！！难道这种题只需要外面写实现函数？？？？

		int limitDay = input.nextInt();// limitDay表示周几的意思。1-7
		System.out.println("原字符串" + str0);
		System.out.println("限行日周 " + limitDay);
		String result = text.limitedCarCard(str0, limitDay);
		System.out.println(result);
	}

	public String limitedCarCard(String input, int limitDay) {
		String result = "";
		int[] limitNum = new int[2];// 除了周末每天有2种尾号的车被限行。
		switch (limitDay) {
		case 1:
			limitNum[0] = 1;
			limitNum[1] = 6;
			break;
		case 2:
			limitNum[0] = 2;
			limitNum[1] = 7;
			break;
		case 3:
			limitNum[0] = 3;
			limitNum[1] = 8;
			break;
		case 4:
			limitNum[0] = 4;
			limitNum[1] = 9;
			break;
		case 5:
			limitNum[0] = 5;
			limitNum[1] = 0;
			break;
		case 6:
		case 7:
			limitNum[0] = 10;// 周六周天没有限行的，所以设成不可能车牌数字等到的数字；
			limitNum[1] = 10;
			break;
		default:
			break;
		}

		String[] strs = input.split(",");
		if (strs.length == 1) {// API：如果表达式不匹配输入的任何部分，则结果数组只具有一个元素，即此字符串。 input 里面没有逗号
			System.out.println("input 里面没有逗号");
			result = "error";
		}

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() > 5 || strs[i].length() < 5) {// 长度错误
				System.out.println("input 长度错误");
				result = "error";
			} else if (strs[i].matches("[A-Z]{5}")) {// 全是字母
				System.out.println("input 全是字母");
				result = "error";
			} else if (!strs[i].matches("[A-Z0-9]+")) {// 出现了一个或一个以上非大写字母和数字的情况 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				System.out.println("input 出现了一个或一个以上非大写字母和数字的情况");
				result = "error";
			}

			else {
				for (int j = 4; j >= 0; j--) {// 在输入没错的情况下处理限行情况：
					if (!(strs[i].charAt(j) + "").matches("[A-Z]")) {
						String n = strs[i].charAt(j) + "";
						for (int k = 0; k < limitNum.length; k++) {
							if (limitNum[k] == Integer.parseInt(n))
								result += strs[i] + ",";
						}

						break;// 一旦找出最尾巴的数字，跳出循环。!!!!
					}

				}
			}
		}

		return result;
	}

}
