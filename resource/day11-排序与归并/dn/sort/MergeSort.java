package com.dn.sort;

public class MergeSort {
	public void mergeSort(int[] a,int left,int right){
		if(left<right){
			int middle = (left+right)/2;
			mergeSort(a, left, middle);
			mergeSort(a,middle+1,right);
			merge(a,left,middle,right);//合并
		}
	}

	private void merge(int[] a, int left, int middle, int right) {
		int [] tmpArray = new int[a.length];
		int rightStart = middle+1;
		int tmp = left;
		int third = left;
		//比较两个小数组相应下标位置的数组大小，小的先放进新数组
		while(left<=middle&&rightStart<=right){
			if(a[left]<=a[rightStart]){
				tmpArray[third++] = a [left++];
			}else{
				tmpArray[third++] = a[rightStart++];
			}
		}
		//如果左边还有数据需要拷贝，把左边数组剩下的拷贝到新数组
		while(left<=middle){
			tmpArray[third++] = a[left++];
		}
		//如果右边还有数据......
		while(rightStart<=right){
			tmpArray[third++] = a[rightStart++];
		}
		while(tmp<=right){
			a[tmp] = tmpArray[tmp++];
		}
	}
	
	public static void main(String[] args){
		MergeSort mergeSort = new MergeSort();
		int [] a = new int[]{90,3,2,67,44,-9,87,65,11,9,2,8};
		mergeSort.mergeSort(a, 0, a.length-1);
		for(int n:a){
			System.out.print(" "+n);
		}
	}
}
