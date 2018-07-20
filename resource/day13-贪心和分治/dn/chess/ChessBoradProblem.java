package com.dn.chess;

public class ChessBoradProblem {
	private int[][] board;//����
	private int specialRow;//���������±�
	private int specialCol;//���������±�
	private int size;
	private int type = 0;
	public ChessBoradProblem(int specialRow, int specialCol, int size) {
		super();
		this.specialRow = specialRow;
		this.specialCol = specialCol;
		this.size = size;
		board = new int[size][size];
	}
	/**
	 * 
	 * @param specialRow   ���������±�
	 * @param specialCol   ���������±�
	 * @param leftRow      ��������������±�
	 * @param leftCol      ��������������±�
	 * @param size         ����Ŀ���߸�
	 */
	private void ChessBoard(int specialRow,int specialCol,int leftRow,int leftCol,int size){
		if(size == 1){
			return;
		}
		int subSize = size/2;
		type = type%4 + 1;
		int n = type;
		//��������������Ͻ�����
		if(specialRow<leftRow+subSize&&specialCol<leftCol+subSize){
			ChessBoard(specialRow, specialCol, leftRow, leftCol, subSize);
		}else{
			//�������Ͻǣ����ϽǾ�������½Ǿ��������
			board[leftRow+subSize-1][leftCol+subSize-1] = n;
			ChessBoard(leftRow+subSize-1, leftCol+subSize-1, leftRow, leftCol, subSize);
		}
		//����������Ϸ�
		if(specialRow<leftRow+subSize&&specialCol>=leftCol+subSize){
			ChessBoard(specialRow, specialCol, leftRow, leftCol+subSize, subSize);
		}else{
			board[leftRow+subSize-1][leftCol+subSize] = n;
			ChessBoard(leftRow+subSize-1, leftCol+subSize, leftRow, leftCol+subSize, subSize);
		}
		//����������·�
		if(specialRow>=leftRow+subSize&&specialCol<leftCol+subSize){
			ChessBoard(specialRow, specialCol, leftRow+subSize, leftCol, subSize);
		}else{
			board[leftRow+subSize][leftCol+subSize-1] = n;
			ChessBoard(leftRow+subSize, leftCol+subSize-1, leftRow+subSize, leftCol, subSize);
		}
		
		//����������½�
		if(specialRow>=leftRow+subSize&&specialCol>=leftCol+subSize){
			ChessBoard(specialRow, specialCol, leftRow+subSize, leftCol+subSize, subSize);
		}else{
			board[leftRow+subSize][leftCol+subSize] = n;
			ChessBoard(leftRow+subSize, leftCol+subSize, leftRow+subSize, leftCol+subSize, subSize);
		}
	}
	
	public void printBoard(int specialRow,int specialCol,int size){
		ChessBoard(specialRow, specialCol, 0, 0, size);
		printResult();
	}
	
	private void printResult() {
		for(int i = 0;i<size;i++){
			for(int j = 0;j<size;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		int N = 8;
		int specialRow = 0;
		int specialCol = 1;
		ChessBoradProblem boradProblem = new ChessBoradProblem(specialRow, specialCol, N);
		boradProblem.printBoard(specialRow, specialCol, N);
	}
}
