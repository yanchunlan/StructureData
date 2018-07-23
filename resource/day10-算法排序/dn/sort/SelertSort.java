package com.dn.sort;

public class SelertSort {

	public void selectSort(int[] array) {
		int min;
		int tmp = 0;
		for (int i = 0; i < array.length; i++) {
			min = array[i];
			for (int j = i; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];//×îÐ¡Öµ
					tmp = array[i];
					array[i] = min;
					array[j] = tmp;
				}
			}
		}
		for(int num:array){
			System.out.println(num);
		}
	}
	
	public static void main(String [] args){
		SelertSort selertSort = new SelertSort();
		selertSort.selectSort(new int[]{9,4,2,6,7,3,10,33,88,1,17});
	}
}
