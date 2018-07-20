package com.dn.sort;

public class QuickSort {
	public void quick(int [] a){
		if(a.length>0){
			quickSort(a,0,a.length-1);
		}
	}
/**
 * 快速排序
 * @param a
 * @param i
 * @param j
 */
	private void quickSort(int[] a, int low, int high) {
		if(low<high){
			int middle = getMiddle(a,low,high);
			quickSort(a, 0, middle-1);
			quickSort(a,middle+1,high);
		}
	}
	
/**
 * 获取中间下标
 * @param a
 * @param low
 * @param high
 * @return
 */
private int getMiddle(int[] a, int low, int high) {
	int temp = a[low];//基准元素
	while(low<high){
		while(low<high&&a[high]>=temp){
			high--;
		}
		a[low] = a[high];
		while(low<high&&a[low]<=temp){
			low++;
		}
		a[high] = a[low];
	}
	a[low] = temp;//插入到排序后正确的位置
	return low;
}

public static void main(String[] args){
	QuickSort quickSort = new QuickSort();
	int [] a = {19,2,3,90,67,33,-7,24,3,56,34,5};
	quickSort.quick(a);
	for(int num :a){
		System.out.println(" "+num);
	}
}
}
