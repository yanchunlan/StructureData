package com.dn.recursion;

public class Gcd {
	// (m>n)m和n的最大公约数 = n 和m%n的最大公约数
	// 36 24  12 = 24和12 = 12和 0
	
	public int gcd(int m,int n){
		if(n == 0){
			return m;
		}else{
			return gcd(n,m%n);
		}
	}
	
	
	public static void main(String[] args){
		Gcd gcd = new Gcd();
		int x = gcd.gcd(99,55);
		System.out.println("x："+x);
	}
}
