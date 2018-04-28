package com.chang.test.recursion;

import java.io.File;

/**
 * 递归调用测试
 * @author Administrator
 *
 */
public class RecursionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if(args.length <= 0 ){
			System.out.println("没有要计算的数字！");
			System.exit(0);
		}
		
		//System.out.println(RabbitQueue.calSum(Integer.valueOf(args[0])));
		
		/*File f = new File("d:/aadev_lge/workspace/JavaTest/war");
		System.out.println(f.getName());
		FileList.list(f,1);*/
		
		System.out.println(factorial.multi(Integer.valueOf(args[0])));
	}
	
}


/**
 * 兔子队列
 * @author Administrator
 *
 */
class RabbitQueue{
	
	public static int calSum(int len){
		if(len == 1 || len ==2){
			return 1;
		}
		
		return calSum(len-1) + calSum(len -2);
	}
}

/**
 * 阶乘的计算
 */
class factorial{
	public static int multi(int i){
		if(i == 1){
			return 1;
		}else{
			return i * multi(i-1);
		}
	}
}

/**
 * 列出文件夹目录及文件
 * @author Administrator
 *
 */
class FileList{
	public static void list(File dir,int level){
		String preStr= "";
		for(int i=0;i<level;i++){
			preStr += "-";
		}
		for(File child : dir.listFiles()){
			
			
			if(!child.isDirectory()){
				System.out.println(preStr+child.getName());
			}else{
				System.out.println(preStr.replaceAll("-", "+")+child.getName());
				list(child,level+1);
			}
		}
	}
}
