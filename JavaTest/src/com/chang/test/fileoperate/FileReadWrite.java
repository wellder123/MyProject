package com.chang.test.fileoperate;

import java.io.*;

/**
 * 文件读写的测试
 * @author Administrator
 *
 */
public class FileReadWrite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter out = null;  
		try {
			br = new BufferedReader(new FileReader("d:/aadev_lge/workspace/JavaTest/war/FileTest/test_file.txt"));
			String line;
			line = br.readLine(); 
			while(line != null){
				System.out.println(line);
				line = br.readLine(); 
			}
			
			File writename = new File("d:/aadev_lge/workspace/JavaTest/war/FileTest/test_file2.txt"); 
			if(!writename.exists()){
				writename.createNewFile();
			}
			
			out = new BufferedWriter(new FileWriter(writename,true));
			out.append("我会写入文件啦\r\n");   
			out.append("我会写入文件啦\r\n");
            out.flush(); 
            out.close(); 

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				br.close();
				br = null;
				out.close();
				out = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
