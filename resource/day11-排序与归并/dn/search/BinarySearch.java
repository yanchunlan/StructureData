package com.dn.search;

import com.dn.sort.BasicSort;

public class BinarySearch {
	
	/**
	 * 递归的方式
	 * @param elem
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public int binarySearch(int elem,int [] array,int low,int high){
		if(low>high){
			return -1;
		}
		int middle = (low+high)/2;
		if(array[middle] == elem){
			System.out.println("找到对应元素值，下标为："+middle);
			return middle;
		}
		if(array[middle]<elem){
			//找右边
			return binarySearch(elem, array, middle+1, high);
		}
		if(array[middle]>elem){
			//找左边
			return binarySearch(elem, array, low, middle-1);
		}
		return -1;
	}
	
	/**
	 * 非递归
	 * @param args
	 */
	public int directBinarySearch(int[] array,int elem){
		int low = 0;
		int high = array.length-1;
		while(low<=high){
			int middle = (low+high)/2;
			if(elem>array[middle]){
				//右边找
				low = middle+1;
			}else  if(elem<array[middle]){
				high = middle - 1;
			}else{
				System.out.println("找到相应元素，下标为："+middle);
				return middle;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args){
		BinarySearch binarySearch = new BinarySearch();
		int [] array = {10,23,4,3,2,5,1,2,623,92,23,23,234,2,34,234,234,2,10};
		BasicSort basicSort = new BasicSort();
		basicSort.sort(array);
		for(int n:array){
			System.out.print(" "+n);
		}
//		binarySearch.binarySearch(5, array, 0, array.length-1);
		binarySearch.directBinarySearch(array, 2);
	}
}
