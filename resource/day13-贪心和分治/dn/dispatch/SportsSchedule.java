package com.dn.dispatch;

public class SportsSchedule {
	public void scheduleTable(int[][] table,int n){
		if(n == 1){
			table[0][0] = 1;
		}else{
			//Ìî³ä×óÉÏÇøÓò¾ØÕó
			int m = n/2;
			scheduleTable(table, m);
			//Ìî³äÓÒÉÏÇøÓò¾ØÕó
			for(int i = 0;i<m;i++){
				for(int j = m;j<n;j++){
					table[i][j] = table[i][j-m]+m;
				}
			}
			
			//Ìî³ä×óÏÂÇøÓò¾ØÕó
			for(int i = m;i<n;i++){
				for(int j=0;j<m;j++){
					table[i][j] = table[i-m][j]+m;
				}
			}
			//Ìî³äÓÒÏÂÇøÓò¾ØÕó
			for(int i = m;i<n;i++){
				for(int j= m;j<n;j++){
					table[i][j] = table[i-m][j-m];
				}
			}
		}
	}
	
	public static void main(String[] args){
		int [][] table = new int[8][8];
		int n = 8;
		SportsSchedule schedule = new SportsSchedule();
		schedule.scheduleTable(table, n);
		int c = 0;
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				System.out.print(table[i][j]+" ");
				c++;
				if(c%n == 0){
					System.out.println();
				}
			}
		}
	}
}
