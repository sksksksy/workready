package main;

import code.zprocess.PrB;

public class processBar {
	public static void main(String[] args) {
		int num=100;
		PrB p=new PrB();
		p.setSize(num);
		int i=0;
		while(i<num) {
			p.dynamicNumber(i);
			i++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
