package com.dn.recursion;

public class HanNota {
	private int i = 1;
	public void hanNota(int n,char from,char dependOn,char to){
		if(n == 1){
			move(1,from,to);
		}else{
			hanNota(n-1,from,to,dependOn);//��һ�����Ƚ�n-1�����Ӵ�A����CŲ��B
			move(n, from, to);//��n������ӣ����̣���AŲ��C
			hanNota(n-1,dependOn,from,to);//��n-1�����Ӵ�B����AŲ��C
		}
	}

	private void move(int n, char from, char to) {
		System.out.println("��"+i+++"����"+from+"------>"+to);
	}
	
	public static void main(String [] args){
		HanNota hanNota = new HanNota();
		hanNota.hanNota(72, 'A', 'B', 'C');
	}
}
