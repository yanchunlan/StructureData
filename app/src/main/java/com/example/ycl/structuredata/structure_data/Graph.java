package com.example.ycl.structuredata.structure_data;

/**
 * author: ycl
 * date: 2018-07-18 0:52
 * desc: 图
 */
public class Graph {
    private int vertexSize; // 顶点数量
    private int[] vertexs; // 顶点数组
    private int[][] matrix;
    private static final int MAX_WEIGHT = 1000;// 代表无穷大

    public Graph(int vertexSize) {
        this.vertexSize = vertexSize;
        matrix = new int[vertexSize][vertexSize];
        vertexs = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            vertexs[i] = i;
        }
    }

    /**
     * 获取某个顶点的出度
     */
    public int getOutDegree(int index) {
        int degree = 0;
        for (int ele : matrix[index]) {
            if (ele != 0 && ele != MAX_WEIGHT) {
                degree++;
            }
        }
        return degree;
    }

    /**
     * 获取两个顶点之间的权值
     */
    public int getWeight(int v1, int v2) {
        int weight = matrix[v1][v2];
        return weight == MAX_WEIGHT ? -1 : weight;
    }


    public int[] getVertexs() {
        return vertexs;
    }

    public void setVertexs(int[] vertexs) {
        this.vertexs = vertexs;
    }

    public static void test() {
        Graph graph = new Graph(9);

        int[] a0 = new int[]{0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a1 = new int[]{10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12};
        int[] a2 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8};
        int[] a3 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, MAX_WEIGHT, 16, 21};
        int[] a4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT};
        int[] a5 = new int[]{11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT};
        int[] a6 = new int[]{MAX_WEIGHT, 16, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT};
        int[] a7 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT};
        int[] a8 = new int[]{MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};

        graph.matrix[0] = a0;
        graph.matrix[1] = a1;
        graph.matrix[2] = a2;
        graph.matrix[3] = a3;
        graph.matrix[4] = a4;
        graph.matrix[5] = a5;
        graph.matrix[6] = a6;
        graph.matrix[7] = a7;
        graph.matrix[8] = a8;

        System.out.println("vo的出度:"+graph.getOutDegree(4));
		System.out.println("权值："+graph.getWeight(2,3));
    }
}
