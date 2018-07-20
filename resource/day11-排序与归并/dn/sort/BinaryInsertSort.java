package com.dn.sort;

public class BinaryInsertSort {
	private void sort(int [] a){
		for(int i = 0;i<a.length;i++){
			int temp = a[i];//待插入到前面有序序列的值
			int left  = 0;
			int right = i - 1;
			int mid = 0;
			while(left<=right){
				mid = (left+right)/2;
				if(temp<a[mid]){
					right = mid -1;
				}else{
					left  = mid + 1;
				}
			}
			for(int j = i-1;j>=left;j--){
				//比left右边大的值往后移一位，等待temp插入
				a[j+1] = a[j];
			}
			if(left!=i){
				a[left] = temp;
			}
		}
		for(int i= 0;i<a.length;i++){
			System.out.println(" "+a[i]);
		}
	}
	
	public static void main(String[] args){
		BinaryInsertSort binaryInsertSort = new BinaryInsertSort();
		int [] a = {10,8,11,3,4,6,7,11,2,90,18,33,28,-1,0,7};
		binaryInsertSort.sort(a);
	}
}
