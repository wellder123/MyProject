package com.chang.test.digital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/****
 * 选秀节目打分，分为专家评委和大众评委，score[] 数组里面存储每个评委打的分数，judge_type[] 里存储与 score[]
 * 数组对应的评委类别，judge_type[i] == 1，表示专家 评委，judge_type[i] ==
 * 2，表示大众评委，n表示评委总数。打分规则如下：专家评委和大众评委的分数先分别取一个平均分（平均分取整），然后，总分 = 专家评委平均分 * 0.6 +
 * 大众评委 * 0.4，总分取整。如果没有大众评委，则 总分 = 专家评委平均分，总分取整。函数最终返回选手得分 函数接口 int
 * cal_score(int score[], int judge_type[], int n)
 * 
 * @author SheepMu
 */
public class ScoreCal {
	public static void main(String[] args) {
		int[] score = { 60, 70, 80, 70, 90, 60, 80 };
		int[] judge_type = { 1, 2, 1, 2, 2, 1, 2 };
		int n = 7;
		int result_core = cal_score(score, judge_type, n);
		System.out.println("最后结果：" + result_core);
	}

	@SuppressWarnings("unused")
	public static int cal_score(int score[], int judge_type[], int n) {
		double sum_all = 0;
		double sum_specilist = 0;
		double sum_common = 0;
		int specialist_size = 0;
		int average_specialist = 0;
		int average_common = 0;
		int result = 0;
		for (int i = 0; i < judge_type.length; i++) {
			if (judge_type[i] == 1) {
				specialist_size++;
				sum_specilist += score[i];
			}
		}
		System.out.println("专家总分" + sum_specilist + "专家人数" + specialist_size);
		// ....省略
		return result;
	}

}
