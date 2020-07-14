package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * 解析算术表达式
 * @author zhp
 *
 */
public class cacluate {
	Stack<Object> middle=new Stack<Object>();
	List<List<String>> vals=new LinkedList<>();
//	private final String PLUS="+";
//	private final String SUB="-";
	private final String MUTIL="*";
	private final String DIVD="/";
	public static void main(String[] args) {
		cacluate c=new cacluate();
		c.parser("3*((1+2)*2+1)");
	}
	void parser(String str) {
		int len=str.length();
		List<String> l=split(str, len);//分割
		moveKh(l);//根据优先级计算值
	}
	/**
	 * 去括号
	 * @param list
	 */
	void moveKh(List<String> list) {
		Stack<String> org=new Stack<String>();
		int size=list.size();
		int i=0;
		List<String> tp=new ArrayList<String>();
		int hasLeft=0;
		while(i<size) {
			String e=list.get(i);
			if("(".equals(e)) {
				hasLeft++;
				org.push(e);
			}else if(")".equals(e)&&hasLeft!=0) {
				while(!org.isEmpty()) {
					String te=org.pop();
					if("(".equals(te)) {
						break;
					}
					tp.add(te);
				}
				double a=caculateNoSign(reverser(tp));
				org.push(String.valueOf(a));
				tp.clear();
				hasLeft--;
			} else {
				org.push(e);
			}
			i++;
		}
		show(org);
		double r=caculateNoSign(org);
		System.out.println("答案是:"+r);
	}
	/**
	 * 计算不含括号的表达式的值
	 * @param expressList
	 * @return
	 */
	double caculateNoSign(List<String> expressList) {
		int count=0;
		int size=expressList.size();
		Stack<String> temp=new Stack<String>();
		Deque<String> mid=new LinkedList<String>();
		for(int i=0;i<size;i++){			
			String e=expressList.get(i);
			if(MUTIL.equals(e)||DIVD.equals(e)) {
				count++;
			}
		}
		int i=0;
		while(i<size) {
			String e=expressList.get(i);
			if(MUTIL.equals(e)||DIVD.equals(e)) {
				String b=expressList.get(i+1);
				String a=mid.pollLast();
				double t=value(a, b, e.charAt(0));
				mid.offerLast(String.valueOf(t));
				i=i+2;
				count--;
			}else {					
				mid.offerLast(e);
				i++;
			}
		
		}
		while(!mid.isEmpty()) {
			temp.push(mid.pollFirst());
		}
		double m=0;
		while(!temp.isEmpty()) {
			if(temp.size()==1) {
				String a=temp.pop();
				m=new BigDecimal(a).doubleValue();
				continue;
			}
			String a=temp.pop();
			String f=temp.pop();
			String b=temp.pop();
			m=value(a, b, f.charAt(0));
			if(temp.isEmpty()) {
				break;
			}else {				
				temp.push(String.valueOf(m));
			}
		}
		System.out.println(m+"\t||\t*/的个数:"+count);
		return m;
	}
	/**
	 * 按符号分割，支持小括号
	 * @param str
	 * @param len
	 * @return
	 */
	List<String> split(String str,int len){
		String flag="+-*/()";
		List<String> list=new ArrayList<String>();
		int i=0;
		String temp="";
		while(i<len) {
			char c=str.charAt(i);
			int a=flag.indexOf(c);
			if(a>-1) {
				if(!"".equals(temp)) list.add(temp);
				list.add(String.valueOf(c));
				temp="";
			}else {
				temp=temp+c;
			}
			if(i==len-1) {
				if(!"".equals(temp)) list.add(temp);
			}
			i++;
		}
		return list;
	}
	/**
	 * 根据提供的flag来计算a,b运算之后的值
	 * @param a
	 * @param b
	 * @param flag
	 * @return
	 */
	double value(double a,double b,char flag) {
		BigDecimal result = null;
		BigDecimal ba=new BigDecimal(a);
		BigDecimal bb=new BigDecimal(b);
		switch (flag) {
		case '+':
			result=ba.add(bb);
			break;
		case '-':
			result=ba.subtract(bb);
			break;
		case '*':
			result=ba.multiply(bb);
			break;
		case '/':
			result=ba.divide(bb);
			break;
		default:
			break;
		}
		return result.doubleValue();	
	}
	/**
	 * 根据提供的flag来计算a,b运算之后的值
	 * @param a
	 * @param b
	 * @param flag
	 * @return
	 */
	double value(String a,String b,char flag) {
		BigDecimal result = null;
		BigDecimal ba=new BigDecimal(a);
		BigDecimal bb=new BigDecimal(b);
		switch (flag) {
		case '+':
			result=ba.add(bb);
			break;
		case '-':
			result=ba.subtract(bb);
			break;
		case '*':
			result=ba.multiply(bb);
			break;
		case '/':
			result=ba.divide(bb);
			break;
		default:
			break;
		}
		return result.doubleValue();	
	}
	void show(List<?> list) {
		System.out.println(list.toString());
		list.forEach(s->{
			System.out.println(s.toString());
		});
	}
	/**
	 * 反转list
	 * @param target
	 * @return
	 */
	List<String> reverser(List<String> target){
		List<String> m=new ArrayList<>();
		for(int i=target.size()-1;i>=0;i--) {
			m.add(target.get(i));
		}
		return m;
	} 
}
