package main;

import java.util.Scanner;
import java.util.Stack;
/**
 * 括号匹配
 * @author zhp
 *
 */
public class KH {
	Stack<Character> khs=new Stack<Character>();
	public static void main(String[] args) {
		KH kh=new KH();
		Scanner sc=new Scanner(System.in);
		while(true) {			
			System.out.print("请输入括号:");
			String tem=sc.next();
			if(tem.equalsIgnoreCase("exit")) {
				break;
			}
			kh.match(tem);
		}
		sc.close();
		System.out.println("程序退出");
	}
	/**
	 * 整体匹配
	 * @param str
	 */
	void match(String str) {
		int len=str.length();
		if(len<2||len%2!=0) {
			System.out.println("明显不匹配");
			return;
		}
		khs.push(str.charAt(0));
		for(int i=1;i<len;i++) {
			if(khs.isEmpty()) {
				khs.push(str.charAt(i));
				continue;
			}
			char a=khs.pop();
			char b=str.charAt(i);
			if(isDouble(a, b)) {
				continue;
			}else {
				khs.push(str.charAt(i));
			}
		}
		if(khs.isEmpty()) {
			System.out.println("匹配成功");
		}else {
			System.out.println("匹配失败");
		}
	}
	/**
	 * 支持中文括号的匹配
	 * @param a 前一个输入
	 * @param b 后一个输入
	 * @return
	 */
	boolean isDouble(char a,char b) {
		String Rights=")]}）】｝";
		String Lefts="([{（【｝";
		if(Rights.indexOf(a)==-1) {
			for(int i=0;i<Lefts.length();i++) {
				if(a==Lefts.charAt(i)&&b==Rights.charAt(i)) {
					return true;
				}
			}
		}
		return false;
	}
}
