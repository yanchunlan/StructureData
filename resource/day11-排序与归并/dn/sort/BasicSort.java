package com.dn.sort;

import java.util.ArrayList;
import java.util.List;

public class BasicSort {
	public void sort(int [] array){
		int max = 0;//获取最大值
		for(int i = 0;i<array.length;i++){
			if(max<array[i]){
				max = array[i];
			}
		}
		int times = 0;//获取最大值位数
		while(max>0){
			max = max/10;
			times++;
		}
		List<ArrayList> queue = new ArrayList<ArrayList>();//多维数组
		for(int i = 0;i<10;i++){
			ArrayList q = new ArrayList<>();
			queue.add(q);
		}
		for(int i = 0;i<times;i++){
			for(int j = 0;j<array.length;j++){
				//获取对应的位的值（i为0是各位，1是10位，2是百位）
				int x = array[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);
				ArrayList q = queue.get(x);
				q.add(array[j]);//把元素添加进对应下标数组
//				queue.set(x,q);//待定
			}
			//开始收集
			int count = 0;
			for(int j = 0;j<10;j++){
				while(queue.get(j).size()>0){
					ArrayList<Integer> q = queue.get(j);//拿到每一个数组
					array[count] = q.get(0);
					q.remove(0);
					count++;
				}
			}
		}
	}
	
	public static void main(String[] args){
		BasicSort basicSort = new BasicSort();
		int [] a = {136,2,6,8,9,2,8,11,23,56,34,90,89,29,145,209,320,78,3};
		basicSort.sort(a);
		for(int n:a){
			System.out.print(" "+n);
		}
	}
}
