package com.dn.sort;

public class HeerSort {
	public static void main(String[] args){
		int [] a = {49,38,44,2,0,7,28,1,-9,7,2,3,8,20,14,88,56,-8,-33,5,23,12,99,76};
		int d = a.length;//默认增量是8
		while(true){
			d = d/2;
			System.out.println("d:"+d);
			for(int i = 0;i<d;i++){
				for(int j = i;j+d<a.length;j+=d){
						for(int n = i;n+d<a.length;n+=d){
							int tmp;
							if(a[n] > a[n+d]){
								tmp = a[n];
								a[n] = a[n+d];
								a[n+d] = tmp;
							}
						}
					
				}
			}
			if(d == 1){break;}
		}
		for(int i = 0;i<a.length;i++){
			System.out.println(" "+a[i]);
		}
	}
}
