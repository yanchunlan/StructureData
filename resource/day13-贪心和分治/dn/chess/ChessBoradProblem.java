package com.dn.chess;

public class ChessBoradProblem {
	private int[][] board;//棋盘
	private int specialRow;//特殊点的行下标
	private int specialCol;//特殊点的列下标
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
	 * @param specialRow   特殊点的行下标
	 * @param specialCol   特殊点的列下标
	 * @param leftRow      矩阵的左边起点行下标
	 * @param leftCol      矩阵左边起点的列下标
	 * @param size         矩阵的宽或者高
	 */
	private void ChessBoard(int specialRow,int specialCol,int leftRow,int leftCol,int size){
		if(size == 1){
			return;
		}
		int subSize = size/2;
		type = type%4 + 1;
		int n = type;
		//假设特殊点在左上角区域
		if(specialRow<leftRow+subSize&&specialCol<leftCol+subSize){
			ChessBoard(specialRow, specialCol, leftRow, leftCol, subSize);
		}else{
			//不在左上角，左上角矩阵的右下角就是特殊点
			board[leftRow+subSize-1][leftCol+subSize-1] = n;
			ChessBoard(leftRow+subSize-1, leftCol+subSize-1, leftRow, leftCol, subSize);
		}
		//特殊点在右上方
		if(specialRow<leftRow+subSize&&specialCol>=leftCol+subSize){
			ChessBoard(specialRow, specialCol, leftRow, leftCol+subSize, subSize);
		}else{
			board[leftRow+subSize-1][leftCol+subSize] = n;
			ChessBoard(leftRow+subSize-1, leftCol+subSize, leftRow, leftCol+subSize, subSize);
		}
		//特殊点在左下方
		if(specialRow>=leftRow+subSize&&specialCol<leftCol+subSize){
			ChessBoard(specialRow, specialCol, leftRow+subSize, leftCol, subSize);
		}else{
			board[leftRow+subSize][leftCol+subSize-1] = n;
			ChessBoard(leftRow+subSize, leftCol+subSize-1, leftRow+subSize, leftCol, subSize);
		}
		
		//特殊点在右下角
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
