package com.dn.greedy;

import java.util.Arrays;

public class GreedyPackage {
	private int  MAX_WEIGHT = 20;
	private int[] weights = new int[]{35,30,60,50,40,10,25};
	private int[] values = new int[]{10,40,30,50,35,40,30};
	
	private void packageGreedy(int capacity,int weights[],int[] values){
		int n = weights.length;
		double[] r = new double[n];//�Լ۱�����
		int [] index = new int[n];//���Լ۱�������Ʒ���±�
		for(int i = 0;i<n;i++){
			r[i] = (double)values[i]/weights[i];
			index[i] = i;//Ĭ������
		}
		
		double temp = 0;//���Լ۱Ƚ�������
		for(int i = 0;i<n-1;i++){
			for(int j = i+1;j<n;j++){
				if(r[i]<r[j]){
					temp = r[i];
					r[i] = r[j];
					r[j] = temp;
					int x = index[i];
					index[i] = index[j];
					index[j] = x;
				}
			}
		}
		//����õ������ͼ�ֵ�ֱ�浽����
		int[] w1 = new int[n];
		int[] v1 = new int[n];
		for(int i = 0;i<n;i++){
			w1[i] = weights[index[i]];
			v1[i] = values[index[i]];
		}
		int[] x = new int[n];
		int maxValue = 0;
		for(int i = 0;i<n;i++){
			if(w1[i]<capacity){
				//������װ����
				x[i] = 1;//��ʾ����Ʒ��װ��
				maxValue+=v1[i];
				System.out.println("��Ʒ"+w1[i]+"���Ž�����");
				capacity = capacity - w1[i];
			}
		}
		System.out.println("�ܹ����µ���Ʒ������"+Arrays.toString(x));
		System.out.println("����ֵ��"+maxValue);
	}
	
	public static void main(String [] args){
		GreedyPackage greedyPackage = new GreedyPackage();
		greedyPackage.packageGreedy(greedyPackage.MAX_WEIGHT, greedyPackage.weights, greedyPackage.values);;
	}
}
