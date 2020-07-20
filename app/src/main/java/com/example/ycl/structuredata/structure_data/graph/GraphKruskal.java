package com.example.ycl.structuredata.structure_data.graph;

/**
 * author: ycl
 * date: 2018-07-18 23:22
 * desc: 图 - 克鲁斯卡尔算法 查找最小生成树
 */
public class GraphKruskal {
    private Edge[] edges;
    private int edgeSize; // 边数

    public GraphKruskal(int edgeSize) {
        this.edgeSize = edgeSize;
        this.edges = new Edge[edgeSize];
    }

    public void miniSpanTreeKruskal() {
        int m, n, sum = 0;
        int[] parent = new int[edgeSize]; // 神奇的数组，下标为起点，值为终点
        for (int i = 0; i < edgeSize; i++) {
            parent[i] = 0;
        }
        for (int i = 0; i < edgeSize; i++) {
            n = find(parent, edges[i].begin);
            m = find(parent, edges[i].end);
            if (n != m) {
                parent[n] = m;
//                System.out.println("起始顶点：" + edges[i].begin + "---结束顶点：" + edges[i].end + "~权值：" + edges[i].weight);
                sum += edges[i].weight;
            } else {
                System.out.println("第" + i + "条边回环了");
            }
            System.out.println("sum:" + sum);
        }
    }

    /**
     * 将神奇数组进行查询获取非回环的值
     */
    private int find(int[] parent, int f) {
        while (parent[f] > 0) {
            System.out.println("找到起点" + f);
            f = parent[f];
            System.out.println("找到终点:" + f);
        }
        return f;
    }


    public void createEdgeArray() {
        Edge edge0 = new Edge(4, 7, 7);
        Edge edge1 = new Edge(2, 8, 8);
        Edge edge2 = new Edge(0, 1, 10);
        Edge edge3 = new Edge(0, 5, 11);
        Edge edge4 = new Edge(1, 8, 12);
        Edge edge5 = new Edge(3, 7, 16);
        Edge edge6 = new Edge(1, 6, 16);
        Edge edge7 = new Edge(5, 6, 17);
        Edge edge8 = new Edge(1, 2, 18);
        Edge edge9 = new Edge(6, 7, 19);
        Edge edge10 = new Edge(3, 4, 20);
        Edge edge11 = new Edge(3, 8, 21);
        Edge edge12 = new Edge(2, 3, 22);
        Edge edge13 = new Edge(3, 6, 24);
        Edge edge14 = new Edge(4, 5, 26);
        edges[0] = edge0;
        edges[1] = edge1;
        edges[2] = edge2;
        edges[3] = edge3;
        edges[4] = edge4;
        edges[5] = edge5;
        edges[6] = edge6;
        edges[7] = edge7;
        edges[8] = edge8;
        edges[9] = edge9;
        edges[10] = edge10;
        edges[11] = edge11;
        edges[12] = edge12;
        edges[13] = edge13;
        edges[14] = edge14;
    }

    /**
     * 边
     */
    class Edge {
        private int begin;
        private int end;
        private int weight;

        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

        public int getBegin() {
            return begin;
        }

        public void setBegin(int begin) {
            this.begin = begin;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }


    public static void test() {
        GraphKruskal graphKruskal = new GraphKruskal(15);
        graphKruskal.createEdgeArray();
        graphKruskal.miniSpanTreeKruskal();
    }

}
