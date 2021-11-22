package com.example.ycl.structuredata.structure_data.graph;

import java.util.LinkedList;

/**
 * author: ycl
 * date: 2018-07-18 0:52
 * desc: 图 - 广度，深度遍历 - 普利姆算法
 */
public class Graph {
    private int vertexSize; // 顶点数量
    private int[] vertexs; // 顶点数组
    private int[][] matrix;
    private static final int MAX_WEIGHT = 1000;// 代表无穷大
    private boolean[] isVisited; // 遍历的flag


    public Graph(int vertexSize) {
        this.vertexSize = vertexSize;
        matrix = new int[vertexSize][vertexSize];
        vertexs = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            vertexs[i] = i;
        }
        isVisited = new boolean[vertexSize];
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


    // -----------------------------  遍历 start  ----------------------------
    // 算法一般是递归

    /**
     * 获取第一个顶点的邻接点
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexSize; i++) {
            if (matrix[index][i] != 0 && matrix[index][i] != MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接点的下标来取得下一个邻接点
     *
     * @param v     表示要找的顶点
     * @param index 表示该顶点相对于哪个邻接点去获取下一个邻接点
     * @return
     */
    public int getNextNeighbor(int v, int index) {
        for (int i = index + 1; i < vertexSize; i++) {
            if (matrix[v][i] != 0 && matrix[v][i] != MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 图的深度遍历算法
     */
    private void depthFirstSearch(int i) {
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) { // 解决没有访问到的也需要再次遍历
                // 需要遍历该顶点
                System.out.println("访问到了：" + w + " 顶点");
                depthFirstSearch(w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 对外公开的深度优先遍历
     */
    public void depthFirstSearch() {
        isVisited = new boolean[vertexSize];
        // 这个循环是解决没有遍历完的也要被遍历
        for (int i = 0; i < vertexSize; i++) {
            if (!isVisited[i]) {
                System.out.println("访问到了：" + i + "顶点");
                depthFirstSearch(i);
            }
        }
    }

    /**
     * 对外公开的广度优先遍历
     */
    public void broadFirstSearch() {
        isVisited = new boolean[vertexSize];
        // 这个循环是解决没有遍历完的也要被遍历
        for (int i = 0; i < vertexSize; i++) {
            if (!isVisited[i]) {
                broadFirstSearch(i);
            }
        }
    }

    /**
     * 图的广度优先遍历
     */
    private void broadFirstSearch(int i) {
        int u, w;
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.println("访问到了：" + i + "顶点");
        isVisited[i] = true;
        queue.add(i);//第一次把v0加到队列
        while (!queue.isEmpty()) {
            u = (Integer) (queue.removeFirst()).intValue();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.println("访问到了：" + w + "顶点");
                    isVisited[w] = true;
                    queue.add(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    /**
     * 普里姆算法
     */
    public void prim() {
        int[] lowcost = new int[vertexSize];//最小代价顶点权值的数组,为0表示已经获取最小权值
        int[] adjvex = new int[vertexSize];//放顶点权值
        int min, minId, sum = 0;
        for (int i = 1; i < vertexSize; i++) {
            lowcost[i] = matrix[0][i];
        }
        for (int i = 1; i < vertexSize; i++) {
            min = MAX_WEIGHT;
            minId = 0;
            for (int j = 1; j < vertexSize; j++) {
                // 取出最小的且大于0的数
                if (lowcost[j] < min && lowcost[j] > 0) {
                    min = lowcost[j];
                    minId = j;
                }
            }
            System.out.println("顶点：" + adjvex[minId] + "权值：" + min);
            sum += min;
            lowcost[minId] = 0;
            for (int j = 1; j < vertexSize; j++) {
                if (lowcost[j] != 0 && matrix[minId][j] < lowcost[j]) {
                    lowcost[j] = matrix[minId][j];
                    adjvex[j] = minId;
                }
            }
        }
        System.out.println("最小生成树权值和:" + sum);
    }


    // -----------------------------  遍历 end  ----------------------------


    public int[] getVertexs() {
        return vertexs;
    }

    public void setVertexs(int[] vertexs) {
        this.vertexs = vertexs;
    }


    public int[][] getMatrix() {
        return matrix;
    }

    public int getVertexSize() {
        return vertexSize;
    }

    /**
     * 创建图的过程
     */
    public void createGraph() {
        int[] a1 = new int[]{0, 1, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a2 = new int[]{1, 0, 3, 7, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a3 = new int[]{5, 3, 0, MAX_WEIGHT, 1, 7, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a4 = new int[]{MAX_WEIGHT, 7, MAX_WEIGHT, 0, 2, MAX_WEIGHT, 3, MAX_WEIGHT, MAX_WEIGHT};
        int[] a5 = new int[]{MAX_WEIGHT, 5, 1, 2, 0, 3, 6, 9, MAX_WEIGHT};
        int[] a6 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 7, MAX_WEIGHT, 3, 0, MAX_WEIGHT, 5, MAX_WEIGHT};
        int[] a7 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 3, 6, MAX_WEIGHT, 0, 2, 7};
        int[] a8 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 9, 5, 2, 0, 4};
        int[] a9 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 7, 4, 0};

        matrix[0] = a1;
        matrix[1] = a2;
        matrix[2] = a3;
        matrix[3] = a4;
        matrix[4] = a5;
        matrix[5] = a6;
        matrix[6] = a7;
        matrix[7] = a8;
        matrix[8] = a9;
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

        System.out.println("vo的出度:" + graph.getOutDegree(4));
        System.out.println("权值：" + graph.getWeight(2, 3));

        // 遍历
        graph.depthFirstSearch();
        graph.broadFirstSearch();

        // 最小生成树 - 普里姆算法
        graph.prim();
    }


}
