package com.chang.test.calulator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 模拟四则运算
 * @author Administrator
 *
 */
public class CalulatorRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length <= 0 ){
			System.out.println("没有要计算的列式！");
			System.exit(0);
		}

		System.out.println(args[0]+"="+calc(args[0]));
		//System.out.println(args[0]+"="+calcbra(args[0]));
	}
	
	
	/**
     *该方法完成表达式的计算（不带括弧）
     * @param oper
     *      计算表达式
     * @return
     *      返回运算结果
     */
	public static  String calc(String oper){
	        //1.将运算表达式分离
	            //1.1得到所有参与运算的运算符
	        List<Character> op = Oper2op(oper);
	        System.out.println(op);
	            //1.2得到所有的参与运算的数字
	        List<Double> cha = Oper2cha(oper);
	        System.out.println(cha);
	
	        //遍历运算符容器，完成乘除运算
	        for(int i=0;i<op.size();i++){
	            Character c = op.get(i);
	            if(c=='*'||c=='/'){
	                //取得运算符---->把存储的运算符从符号容器中拿出来
	                op.remove(i);//是乘除符号则将其从集合中移除出来
	                //取得运算数字--->从数字容器中获得对应索引的字符
	                Double opl = cha.remove(i);//拿到运算符左侧数字
	                Double opr = cha.remove(i);//拿到运算符右侧数字
	                //将运算结果放回--->将运算后的数放在数字容器索引出
	                if(c=='*'){
	                    cha.add(i, opl*opr);//将运算后的数字添加在i的位置，当前i位置的数向后瞬移
	                }else
	                    cha.add(i,opl/opr);
	                i--;//运算符容器的指针回到原来的位置,防止跳过下一个运算符
	            }
	        }
	        //遍历运算符容器，完成加减运算，当运算符容器为空时，运算结束
	        while(!op.isEmpty()){
	            //获取运算符
	            Character o = op.remove(0);
	            //获取左右运算数字
	            Double chal = cha.remove(0);
	            Double chara = cha.remove(0);
	            if(o=='-'){
	                chal = chal-chara;
	            }
	            if(o=='+'){
	                chal = chal+chara;
	            }
	            //将运算结果放回到数字容器中
	            cha.add(0,chal);
	        }
	        return cha.get(0).toString();
	    }
	
	/**
	 * 得到表达式中所有的运算符
	 * @param oper
	 *      运算表达式
	 * @return
	 *      符号的list集合
	 */
	private static List<Character> Oper2op(String oper) {
	    //将表达式中的符号替换为@符号
	    /*oper = changeMinus(oper);
	    //将字符串按照正则表达式分组
	    String regex = "@[0-9]|[0-9]";
	    Pattern pt = Pattern.compile(regex);
	    String[] split = pt.split(oper);
	    //将数组元素放在集合中
	    List<Character> list = new ArrayList<Character>();
	    for(int i=0;i<split.length;i++){
	        String temp = split[i].trim();
	        if(temp.equals("+")||temp.equals("-")||temp.equals("*")||temp.equals("/")){
	            list.add(temp.trim().charAt(0));
	        }
	    }*/
		List<Character> list = new ArrayList<Character>();
		for(char c : oper.toCharArray()){
			if("+".equals(String.valueOf(c))||"-".equals(String.valueOf(c))||"*".equals(String.valueOf(c))||"/".equals(String.valueOf(c)) ){
				list.add(c);
			}
		}
	    return list;
	} 
	
	
	/**
	 * 从表达式中获得所有参与运算的数字
	 * @param oper
	 *      运算表达式
	 * @return
	 *      数字的List集合
	 */
	private static List<Double> Oper2cha(String oper) {
	    /*oper = changeMinus(oper);
	    //将字符串按照运算符切割，得到字符串数组
	    Pattern pt = Pattern.compile("\\+|\\-|\\*|\\/");
	    String[] split = pt.split(oper);
	
	    //遍历数组，判断每个元素，将特殊符号转换成负数符号,并转换成double类型放在list集合中
	    List<Double> list = new ArrayList<Double>();
	    for(int i=0;i<split.length;i++){
	        String single = split[i];
	        if(single.charAt(0)=='@'){
	            single = "-"+single.substring(1);
	        }
	        list.add(Double.parseDouble(single));
	    }*/
		List<Double> list = new ArrayList<Double>();
		for(char c : oper.toCharArray()){
			if(!"+".equals(String.valueOf(c)) 
					&& !"-".equals(String.valueOf(c)) 
					&& !"*".equals(String.valueOf(c)) 
					&& !"/".equals(String.valueOf(c)) ){
				list.add(Double.valueOf(String.valueOf(c)));
			}
		}
		
	    return list;
	}
	
	/**
	 * 将表达式的负号‘-’用@符号代替
	 * @param oper
	 *      运算表达式
	 * @return
	 *      替换后的表达式
	 */
	private static String changeMinus(String oper) {
	    //将表达式中的负数符号使用特殊符号替代，获得没有负数字符串
	    for(int i=0;i<oper.length();i++){
	        char c = oper.charAt(i);
	        if(c=='-'){
	            //判断第一个字符是否是负数
	            if(i==0){
	                oper = "@"+oper.substring(1);
	            }else{
	                //判断前一个字符是否是+-*/中的一个
	                char cprev = oper.charAt(i-1);
	                if(cprev=='+'||cprev=='-'||cprev=='*'||cprev=='/'){
	                    oper = oper.substring(0, i)+"@"+oper.substring(i+1);
	                }
	            }
	        }
	    }
	    return oper;
	}
	
	/**
	 * 完成带括弧的算数表达式运算
	 * @param oper
	 *      表达式
	 * @return
	 *      运算结果
	 */
	public static String calcbra(String oper){
	    //从表达式中查找左括弧
	    int leftIndex = oper.lastIndexOf('(');
	    if(leftIndex==-1){//没有左括弧，调用calc直接运算
	        return calc(oper);
	    }else{//有括弧
	        //获取该括弧右侧的第一个右括弧
	        int rightIndex = oper.indexOf(')', leftIndex);
	        if(rightIndex==-1){
	            throw new RuntimeException("表达式语法错误");
	        }else{
	        //将两个括弧之间的表达式截取
	        String exp = oper.substring(leftIndex+1, rightIndex);
	        //将表达式计算
	        String result = calc(exp);
	        //将计算结果替换左右括弧包含的表达式，将表达式递归调用
	        oper = oper.substring(0,leftIndex)+result+oper.substring(rightIndex+1);
	        return calcbra(oper);
	        }
	    }
	}

}
