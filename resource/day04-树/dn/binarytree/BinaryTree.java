package com.dn.binarytree;

import java.util.Stack;

public class BinaryTree {
	private TreeNode  root = null;
	
	public BinaryTree(){
		root = new TreeNode(1, "A");
	}
	
	/**
	 * ����������
	 *         A
	 *     B       C
	 * D      E        F
	 */
	public void createBinaryTree(){
		TreeNode nodeB = new TreeNode(2, "B");
		TreeNode nodeC = new TreeNode(3, "C");
		TreeNode nodeD = new TreeNode(4, "D");
		TreeNode nodeE = new TreeNode(5, "E");
		TreeNode nodeF = new TreeNode(6, "F");
		root.leftChild = nodeB;
		root.rightChild = nodeC;
		nodeB.leftChild = nodeD;
		nodeB.rightChild = nodeE;
		nodeC.rightChild = nodeF;
	}
	
	/**
	 * ��������ĸ߶�
	 * @author Administrator
	 *
	 */
	public int getHeight(){
		return getHeight(root);
	}
	
	private int getHeight(TreeNode node) {
		if(node == null){
			return 0;
		}else{
			int i = getHeight(node.leftChild);
			int j = getHeight(node.rightChild);
			return (i<j)?j+1:i+1;
		}
	}

	/**
	 * ��ȡ�������Ľ����
	 * @author Administrator
	 *
	 */
	public int getSize(){
		return getSize(root);
	}
	
	
	private int getSize(TreeNode node) {
		if(node == null){
			return 0;
		}else{
			return 1+getSize(node.leftChild)+getSize(node.rightChild);
		}
	}

	/**
	 * ǰ�������������
	 * @author Administrator
	 *
	 */
	public void preOrder(TreeNode node){
		if(node == null){
			return;
		}else{
			System.out.println("preOrder data:"+node.getData());
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}
	
	/**
	 * ǰ����������ǵ���
	 */
	
	public void nonRecOrder(TreeNode node){
		if(node == null){
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while(!stack.isEmpty()){
			//��ջ�ͽ�ջ
			TreeNode n = stack.pop();//���������
			//ѹ���ӽ��
			System.out.println("nonRecOrder data"+n.getData());
			if(n.rightChild!=null){
				stack.push(n.rightChild);
				
			}
			if(n.leftChild!=null){
				stack.push(n.leftChild);
			}
		}
	}
	/**
	 * ���������������
	 * @author Administrator
	 *
	 */
	public void midOrder(TreeNode node){
		if(node == null){
			return;
		}else{
			midOrder(node.leftChild);
			System.out.println("midOrder data:"+node.getData());
			midOrder(node.rightChild);
		}
	}
	
	/**
	 * ���������������
	 * @author Administrator
	 *
	 */
	public void postOrder(TreeNode node){
		if(node == null){
			return;
		}else{
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			System.out.println("postOrder data:"+node.getData());
		}
	}
	public class TreeNode{
		private int index;
		private String data;
		private TreeNode leftChild;
		private TreeNode rightChild;
		
	
		public int getIndex() {
			return index;
		}


		public void setIndex(int index) {
			this.index = index;
		}


		public String getData() {
			return data;
		}


		public void setData(String data) {
			this.data = data;
		}


		public TreeNode(int index,String data){
			this.index = index;
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	
	
	public static void main(String[] args){
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
		int height = binaryTree.getHeight();
		System.out.println("treeHeihgt:"+height);
		int size = binaryTree.getSize();
		System.out.println("treeSize:"+size);
//		binaryTree.preOrder(binaryTree.root);
//		binaryTree.midOrder(binaryTree.root);
//		binaryTree.postOrder(binaryTree.root);
		binaryTree.nonRecOrder(binaryTree.root);
	}
}
