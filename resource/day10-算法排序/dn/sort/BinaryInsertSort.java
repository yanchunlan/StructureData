package com.dn.sort;


public class BinaryInsertSort {
    public static void main(String[] args) {
        int[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
        System.out.println("����֮ǰ��");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //���ֲ�������
        sort(a);
        System.out.println();
        System.out.println("����֮��");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
//���ַ�����
    private static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i-1;
            int mid = 0;
            //ȷ��Ҫ�����λ��
            while(left<=right){
            	//�Ȼ�ȡ�м�λ��
                mid = (left+right)/2;
                if(temp<a[mid]){
                	//���ֵ���м�ֵС����right���Ƶ��м��±�-1
                    right = mid-1;
                }else{
                	//���ֵ���м�ֵ��,��left���Ƶ��м��±�+1
                    left = mid+1;
                }
            }
            for (int j = i-1; j >= left; j--) {
            	//�����±�Ϊ��׼������λ��ǰ��������ݣ�������ȫ������
                a[j+1] = a[j];
            }
            if(left != i){
            	//��λ�ò��������
                a[left] = temp;
            }
        }
    }
}