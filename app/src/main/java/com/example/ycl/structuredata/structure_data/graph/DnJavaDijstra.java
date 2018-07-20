package com.example.ycl.structuredata.structure_data.graph;

/**
 * @Author: Ycl
 * @Date: 2018/7/19 16:33
 * @Desc: 图-最短路径
 */
public class DnJavaDijstra {
    private static final int MAXVEX = 9;
    private static final int MAXWEIGHT = 65535;
    private int shortTablePath[] = new int[MAXVEX]; // 记录的是v0到某顶点的最短路径和

    /**
     * 获取一个图的最短路径
     */
    public void shortestPathDijstra(Graph graph) {
        int min;
        int k = 0; // 记录下标
        boolean isGetPath[] = new boolean[MAXVEX];
        for (int i = 0; i < graph.getVertexSize(); i++) {
            shortTablePath[i] = graph.getMatrix()[0][i]; // 获取v0这一行的权值数组
        }
        shortTablePath[0] = 0;
        isGetPath[0] = true;
        for (int v = 1; v < graph.getVertexSize(); v++) {
            min = MAXWEIGHT;
            for (int w = 0; w < graph.getVertexSize(); w++) {
                if (!isGetPath[w] && shortTablePath[w] < min) {
                    k = w;
                    min = shortTablePath[w];
                }
            }
            isGetPath[k] = true;
            for (int j = 0; j < graph.getVertexSize(); j++) {
                if (!isGetPath[j] && (min + graph.getMatrix()[k][j] < shortTablePath[j])) {
                    shortTablePath[j] = min + graph.getMatrix()[k][j];
                }
            }
        }
        for (int i = 0; i < shortTablePath.length; i++) {
            System.out.println("V0到V"+i+"的最短路径为:"+shortTablePath[i]+"\n");
        }
    }


    public static void test() {
        Graph graph = new Graph(MAXVEX);
        graph.createGraph();
        DnJavaDijstra dnJavaDijstra = new DnJavaDijstra();
        dnJavaDijstra.shortestPathDijstra(graph);
    }

}


