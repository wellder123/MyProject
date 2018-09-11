package com.chang.test.character;

/**
 * 通过键盘输入一串小写字母(a~z)组成的字符串。请编写一个字符串压缩程序，将字符串中连续出席的重复字母进行压缩，并输出压缩后的字符串。 
 * 压缩规则： 
 * 1、仅压缩连续重复出现的字符。比如字符串”abcbc”由于无连续重复字符，压缩后的字符串还是”abcbc”。 
 * 2、压缩字段的格式为”字符重复的次数+字符”。例如：字符串”xxxyyyyyyz”压缩后就成为”3x6yz”。 
 * @author Administrator
 *
 */
public class Compress {

	public static void main(String[] args) {
		if(args.length < 1 ){
			System.out.println("没有要比较的单词！");
			System.exit(0);
		}
		
		System.out.println(charCompress(args[0]));
	}
	
	public static String charCompress(String str){
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        char last = arr[0];
        int count =1;
        for(int i=1;i<arr.length;i++){
            char b = arr[i];
            if(b == last){
                count++;
                continue;
            }
            if(count == 1){
                sb.append(last);
            } else {
                sb.append(count).append(last);
            }
            count = 1;
            last =b;
        }
        if(count ==1){
            sb.append(last);
        } else {
            sb.append(count).append(last);
        }

        return sb.toString();
    }

}
