package com.dn.sort;


public class HeapSort {
//堆排序
	public static void main(String[] args){
		int[] array = {39,44,1,0,8,66,23,67,9,15,100,70,22,3,6,54};
		HeapSort heapSort = new HeapSort();
		heapSort.heapSort(array);
		for(int i = 0;i<array.length;i++){
			System.out.println(" "+array[i]);
		}
	}
	
	public void heapSort(int [] a){
		if(a == null||a.length<=1){
			return;
		}
		//创建大堆
		buildMaxHeap(a);
		for(int i = a.length-1;i>=1;i--){
			//最大元素已经排在了下标为0的地方
			exchangeElements(a, 0, i);//每交换换一次，就沉淀一个大元素
			maxHeap(a, i, 0);
		}
	}

	
	private void buildMaxHeap(int[] a) {
		int half = (a.length -1)/2;//假设长度为9
		for(int i = half;i>=0;i--){
			//只需遍历43210
			maxHeap(a,a.length,i);
		}
	}

	//length表示用于构造大堆的数组长度元素数量
	private void maxHeap(int[] a, int length, int i) {
		int left = i*2+1;
		int right = i*2+2;
		int largest = i;
		if(left<length&&a[left]>a[i]){
			largest = left;
		}
		if(right<length&&a[right]>a[largest]){
			largest = right;
		}
		if(i!=largest){
			//进行数据交换
			exchangeElements(a,i,largest);
			maxHeap(a, length, largest);
		}
	}

	//在数组a里进行两个下标元素交换
	private void exchangeElements(int[] a, int i, int largest) {
		int temp = a[i];
		a[i] = a[largest];
		a[largest] = temp;
	}
}
