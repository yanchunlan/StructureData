package com.example.ycl.structuredata.structure_data.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: Ycl
 * @Date: 2018/7/16 11:31
 * @Desc: 二叉树
 */
public class BinaryTree {
    private TreeNode<String> root = null;

    public BinaryTree() {
        root = new TreeNode<String>(1, "A");
    }

    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * 构建二叉树
     * A
     * B       C
     * D      E        F
     */
    public void createBinaryTree() {
        TreeNode<String> nodeB = new TreeNode<String>(2, "B");
        TreeNode<String> nodeC = new TreeNode<String>(3, "C");
        TreeNode<String> nodeD = new TreeNode<String>(4, "D");
        TreeNode<String> nodeE = new TreeNode<String>(5, "E");
        TreeNode<String> nodeF = new TreeNode<String>(6, "F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.rightChild = nodeF;
    }

    /**
     * 返回二叉树高度
     */
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode<String> node) {
        if (node == null) {
            return 0;
        }
        int i = getHeight(node.leftChild);
        int j = getHeight(node.rightChild);
        return (i < j) ? j + 1 : i + 1;  // 当最后都没有0<0 就取i+1 =1
    }


    /**
     * 获取二叉树节点
     */
    public int getSize() {
        return getSize(root);
    }

    private int getSize(TreeNode<String> node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSize(node.leftChild) + getSize(node.rightChild);
    }

    /**
     * 前序遍历——迭代
     * ABDECF
     */
    public <T> void preOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.println("preOrder data:" + node.getData());
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    /**
     * 中序遍历——迭代
     * DBEACF
     */
    public <T> void midOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        midOrder(node.leftChild);
        System.out.println("midOrder data:" + node.getData());
        midOrder(node.rightChild);
    }

    /**
     * 后序遍历——迭代
     * DEBFCA
     */
    public <T> void postOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.println("postOrder data:" + node.getData());

    }

    /**
     * 前序遍历——非迭代
     */
    public void nonRecOrder(TreeNode<String> node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode<String>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            //出栈和进栈
            TreeNode<String> n = stack.pop();//弹出根结点
            //压入子结点
            System.out.println("nonRecOrder data" + n.getData());
            if (n.rightChild != null) {
                stack.push(n.rightChild);
            }
            if (n.leftChild != null) {
                stack.push(n.leftChild);
            }
        }
    }

    /**
     * 中序遍历——非迭代
     */
    public void nonMidOrder(TreeNode<String> node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode<String>> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            if (!stack.empty()) {
                node = stack.pop();
                System.out.println(node.data + "   ");
                node = node.rightChild;
            }
        }
    }

    /**
     * 后序遍历--非递归
     */
    public void nonPosOrder(TreeNode<String> Node) {
        Stack<TreeNode<String>> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while (Node != null || !stack1.empty()) {
            while (Node != null) {
                stack1.push(Node);
                stack2.push(0);
                Node = Node.leftChild;
            }

            while (!stack1.empty() && stack2.peek() == i) {
                stack2.pop();
                System.out.println(stack1.pop().data + "   ");
            }

            if (!stack1.empty()) {
                stack2.pop();
                stack2.push(1);
                Node = stack1.peek();
                Node = Node.rightChild;
            }
        }
    }


    /**
     * 构建二叉树 前序遍历 反向生成
     * A
     * B       C
     * D      E        F
     */
    public TreeNode<String> createBinaryTree2(ArrayList<String> data) {
        return createBinaryTree2(data.size(), data);
    }

    // ABD##E##C#F##
    private TreeNode<String> createBinaryTree2(int size, ArrayList<String> data) {
        if (data.isEmpty()) {
            return null;
        }
        String d = data.get(0);
        if (d.equals("#")) {
            data.remove(0);
            return null;
        }
        // size 一直是初始值，data.size一直在减少
        int index = size - data.size();
        /* System.out.println("size = [" + size + "], index = [" + index + "]");*/
        TreeNode<String> node = new TreeNode<>(index, d);
        if (index == 0) {
            root = node;
        }
        data.remove(0);
        node.leftChild = createBinaryTree2(size, data);
        node.rightChild = createBinaryTree2(size, data);
        return node;
    }


    private TreeNode<Integer> root_Int = null;

    public TreeNode<Integer> getRoot_Int() {
        return root_Int;
    }

    /**
     * 查找二叉树 , 添加节点
     */
    public TreeNode<Integer> putTreeNode(int data) {
        TreeNode<Integer> node = null;
        TreeNode<Integer> parent = null;
        if (root_Int == null) {
            node = new TreeNode<>(0, data);
            root_Int = node;
            return node;
        }
        // 从根节点开始遍历，判断
        node = root_Int;
        while (node != null) {
            parent = node;
            if (data > node.data) {
                node = node.rightChild;
            } else if (data < node.data) {
                node = node.leftChild;
            } else { // == 仅仅是替换，没必要，所以退出
                return node;
            }
        }
        node = new TreeNode<>(0, data);
        if (data < parent.data) {
            parent.leftChild = node;
        } else if (data > parent.data) {
            parent.rightChild = node;
        }
        node.parent = parent;
        return node;
    }

    /**
     * 查找二叉树 , 删除节点
     */
    public void deleteTreeNode(int key) throws NullPointerException {
        TreeNode<Integer> node = searchNode(key);
        if (node == null) {
            throw new NullPointerException("deleteTreeNode not find node");
        } else {
            deleteNode(node);
        }
    }

    private void deleteNode(TreeNode<Integer> node) throws NullPointerException {
        if (node == null) {
            throw new NullPointerException("deleteNode not find node");
        } else { // 此处删除有三种情况
            TreeNode<Integer> parent = node.parent;
            // 1 . 被删除节点无左右孩子
            if (node.leftChild == null && node.rightChild == null) {
                if (parent.leftChild == node) {
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                }
            }
            // 2 . 被删除节点有左无右孩子
            else if (node.leftChild != null && node.rightChild == null) {
                if (parent.leftChild == node) {
                    parent.leftChild = node.leftChild;
                } else {
                    parent.rightChild = node.leftChild;
                }
            }
            // 3 . 被删除节点有右无左孩子
            else if (node.leftChild == null && node.rightChild != null) {
                if (parent.leftChild == node) {
                    parent.leftChild = node.rightChild;
                } else {
                    parent.rightChild = node.rightChild;
                }
            }
            // 4 . 被删除节点有右左孩子
            else if (node.leftChild != null && node.rightChild != null) {
                // 寻找后继节点，替换掉当前节点
                TreeNode<Integer> next = getNextNode(node);
                deleteNode(next);
                node.data = next.data;
            }
        }
    }

    /**
     * 后继分为2种情况
     */
    private TreeNode<Integer> getNextNode(TreeNode<Integer> node) throws NullPointerException {
        if (node == null) {
            throw new NullPointerException("getNextNode not find node");
        } else {
            //（比其大，在右边找最左的最后一个）
            // 后继
            // 找的过程中，当==null的时候，就说明已经找到了
            if (node.rightChild != null) {
                return getMinTreeNode(node.rightChild);
            } else {// 前驱
                // 当找的过程中 ，不是左边的时候，就说明已经找到了，
                TreeNode<Integer> parent = node.parent;
                while (parent != null && node == parent.rightChild) {
                    node = parent;
                    parent = parent.parent;
                }
                return parent;
            }
        }
    }

    private TreeNode<Integer> getMinTreeNode(TreeNode<Integer> node) {
        if (node == null) {
            throw new NullPointerException("getMinTreeNode not find node");
        } else {
            while (node.leftChild != null) {
                node = node.leftChild;
            }
        }
        return node;
    }

    private TreeNode<Integer> searchNode(int key) {
        TreeNode<Integer> node = root_Int;
        if (node == null) {
            return null;
        } else {
            while (node != null && key != node.data) {
                if (key < node.data) {
                    node = node.leftChild;
                } else if (key > node.data) {
                    node = node.rightChild;
                }
            }
            return node;
        }
    }


    //根据先序和中序遍历重建二叉树java实现
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        TreeNode<Integer> mm = reConstructBinaryTreeCore(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return mm;
    }

    //核心递归
    public TreeNode<Integer> reConstructBinaryTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        TreeNode<Integer> tree = new TreeNode<Integer>(0, pre[preStart]);
        tree.leftChild = null;
        tree.rightChild = null;
        if (preStart == preEnd && inStart == inEnd) {
            return tree;
        }
        int root = 0;
        for (root = inStart; root < inEnd; root++) {
            if (pre[preStart] == in[root]) {
                break;
            }
        }
        int leifLength = root - inStart;
        int rightLength = inEnd - root;
        if (leifLength > 0) {
            tree.leftChild = reConstructBinaryTreeCore(pre, in, preStart + 1, preStart + leifLength, inStart, root - 1);
        }
        if (rightLength > 0) {
            tree.rightChild = reConstructBinaryTreeCore(pre, in, preStart + 1 + leifLength, preEnd, root + 1, inEnd);
        }
        return tree;
    }


    public class TreeNode<T> {
        private int index;
        private T data;
        private TreeNode leftChild;
        private TreeNode rightChild;
        private TreeNode parent;

        public TreeNode(int index, T data) {
            this.index = index;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public T getData() {
            return data;
        }

        public void setData(T date) {
            this.data = date;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

    }


    public static void test() {
        BinaryTree binaryTree = new BinaryTree();
        /*binaryTree.createBinaryTree();

        int height = binaryTree.getHeight();
        System.out.println("tree Height:" + height);

        int size = binaryTree.getSize();
        System.out.println("tree Size:" + size);

        // 遍历
        binaryTree.preOrder(binaryTree.getRoot());
        binaryTree.midOrder(binaryTree.getRoot());
        binaryTree.postOrder(binaryTree.getRoot());

        // 遍历 非迭代
        binaryTree.nonRecOrder(binaryTree.getRoot());
        binaryTree.nonMidOrder(binaryTree.getRoot());
        binaryTree.nonPosOrder(binaryTree.getRoot());*/

        // ABD##E##C#F##
       /* String[] array = new String[]{"A", "B", "D", "#", "#", "E", "#", "#", "C", "#", "F", "#", "#"};
        ArrayList<String> list = new ArrayList<>();
        for (String it:array) {
            list.add(it);
        }
        binaryTree.createBinaryTree2(list);
        binaryTree.preOrder(binaryTree.getRoot());*/

        // 放入数据
        binaryTree.putTreeNode(50);
        binaryTree.putTreeNode(30);
        binaryTree.putTreeNode(49);
        binaryTree.putTreeNode(5);
        binaryTree.putTreeNode(88);

        // 中序遍历 是从小到大
        binaryTree.midOrder(binaryTree.getRoot_Int());

        binaryTree.deleteTreeNode(88);
        binaryTree.midOrder(binaryTree.getRoot_Int());

        /*int pre[] = {1, 2, 4, 7, 3, 5, 8, 9, 6};
        int in[] = {4, 7, 2, 1, 8, 5, 9, 3, 6};
        BinaryTree.TreeNode<Integer> tree = binaryTree.reConstructBinaryTree(pre, in);
        System.out.print("先序遍历结果:  {");
        binaryTree.preOrder(tree);
        System.out.println("}");
        System.out.print("中序遍历结果:  {");
        binaryTree.midOrder(tree);
        System.out.println("}");
        System.out.print("后序遍历结果:  {");
        binaryTree.postOrder(tree);
        System.out.println("}");*/
    }
}
