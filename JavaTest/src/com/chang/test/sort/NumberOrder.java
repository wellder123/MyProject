package com.chang.test.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序算法的测试
 * @author Administrator
 *
 */
public class NumberOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length <= 0 ){
			System.out.println("没有要排序的数字！");
			System.exit(0);
		}
		
		List<Integer> a = new ArrayList<Integer>();
		int x= 0;
        for(int i=0;i<args.length;i++){
        	for(int j=0;j<args[i].length();j++){
	        	if(!Character.isDigit(args[i].charAt(j))){
	        		System.out.println("非法数字！");
	        		x=1;
	        		break;
	        	}
        	}
        	
        	if(x==1){
        		System.exit(0);
        		break;
        	}
        	
        	a.add(Integer.valueOf(args[i]));
        }
        
        List<Integer> outStr1=SortNumber.selectSort(a);
        List<Integer> outStr2=SortNumber.bubbleSort(a);
        System.out.println(outStr1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        System.out.println(outStr2.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        //使用Collections对list进行排序
        Collections.sort(a);
        System.out.println(a);
	}

}

/**
 * 排序算法
 * @author Administrator
 *
 */
class SortNumber{
	//选择排序
	public static List<Integer> selectSort(List<Integer> num){
		int temp;
		for(int i=0;i<num.size();i++){
			for(int j=i+1;j<num.size();j++){
				if(num.get(j) < num.get(i)){
					temp = num.get(i);
					num.set(i, num.get(j));
					num.set(j, temp);
				}
			}
			
		}
		
		return num;
	}
	//冒泡排序
	public static List<Integer> bubbleSort(List<Integer> num){
		int temp;
		for(int i=num.size()-1;i>=1;i--){
			for(int j=0;j<=i-1;j++){
				if(num.get(j)>num.get(j+1)){
					temp = num.get(j);
					num.set(j,num.get(j+1));
					num.set(j+1,temp);
				}
			}
		}
		return num;
	}
}
