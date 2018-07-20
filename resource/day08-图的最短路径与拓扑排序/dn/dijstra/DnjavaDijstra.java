package com.dn.dijstra;

public class DnjavaDijstra {
	private final static int MAXVEX = 9;
	private final static int MAXWEIGHT = 65535;
	private int shortTablePath[] = new int[MAXVEX];// ��¼����v0��ĳ��������·����

	/**
	 * ��ȡһ��ͼ�����·��
	 */
	public void shortestPathDijstra(Graph graph) {
		int min;
		int k = 0;// ��¼�±�
		boolean isgetPath[] = new boolean[MAXVEX];
		for (int v = 0; v < graph.getVertexSize(); v++) {
			shortTablePath[v] = graph.getMatrix()[0][v];// ��ȡv0��һ�е�Ȩֵ����
		}
		shortTablePath[0] = 0;
		isgetPath[0] = true;
		for (int v = 1; v < graph.getVertexSize(); v++) {
			min = MAXWEIGHT;
			for (int w = 0; w < graph.getVertexSize(); w++) {
				if (!isgetPath[w] && shortTablePath[w] < min) {
					k = w;
					min = shortTablePath[w];
				}
			}
			isgetPath[k] = true;
			for (int j = 0; j < graph.getVertexSize(); j++) {
				if(!isgetPath[j]&&(min+graph.getMatrix()[k][j]<shortTablePath[j])){
					shortTablePath[j] = min + graph.getMatrix()[k][j];
				}
			}
		}
		for(int i = 0;i<shortTablePath.length;i++){
			System.out.println("V0��V"+i+"�����·��Ϊ:"+shortTablePath[i]+"\n");
		}
		
	}
	
	public static void main(String[] args){
		Graph graph = new Graph(MAXVEX);
		graph.createGraph();
		DnjavaDijstra dijstra = new DnjavaDijstra();
		dijstra.shortestPathDijstra(graph);
	}
}