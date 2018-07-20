package com.dn.recursion;

public class Haonoi {//汉诺塔
	int i = 1;
	public void haoNoi(int n,char from,char dependOn,char to){
		if(n == 1){
			System.out.println();
			move(1,from,to);
		}else{
			haoNoi(n-1,from,to,dependOn);
			move(n,from,to);
			haoNoi(n-1,dependOn,from,to);
		}
	}
	
	
	public void move(int n,char from,char to){
		System.out.println("第"+i+++"步,将盘子"+from+"------>"+to);
		
	}
	
	public static void main(String[] args){
		Haonoi haonoi = new Haonoi();
		haonoi.haoNoi(72, 'A','B', 'C');
	}
}
