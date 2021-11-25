# StructureData
数据结构与算法

1.[线性表](./resource/day01-线性表)

	顺序存储方式：ArrayList
	链式存储方式：LinkedList
2.[栈和队列](./resource/day02-栈和队列)

	栈：Vector ,Stack  先进后出，先进后出，插入删除都是栈顶操作
		案列： 波兰表达式：中缀->后缀表达式
	队列：Queue , LinkedList 双向链式存储结构
3.[HashMap与LinkedHashMap](./resource/day03-HashMap和LinkedHashMap)

	区别在于：linkedHashMap内部维护了一个双向链表
4.[树](./resource/day04-树)

    满二叉树，完全二叉树
	二叉树遍历：
	前序遍历：根->左->右
	中序遍历：左—>根->右
	后序遍历：左—>右->根
		赫夫曼树原理
	二叉树的put，delete操作
5.[图](./resource/day06-图)

	图的出度入读，广度遍历、深度遍历
	图的最小生成树、普利姆算法，克鲁斯卡尔算法
	图的最短路径、迪杰斯特拉算法
	拓扑排序
6.[算法](./resource/day09-算法简介)

	排序：选择排序
		直接插入排序，二分法排序，希尔排序，堆排序
		快速排序，归并排序，奇数排序
	查找：二分法查找（递归，非递归）
	递归：汉诺塔，欧几里得（最大公约数），阶乘
	穷举：泊松分酒
	贪心算法，分治算法（球队划分，棋盘覆盖）
	回溯算法：寻找相似字符，棋盘排列，约瑟夫杀人法，大数相乘

7.  算法练习 - 高频面试系列 [fucking-algorithm](https://github.com/labuladong/fucking-algorithm)

```
如何实现LRU算法
如何高效寻找素数
如何计算编辑距离
如何运用二分查找算法
如何高效解决接雨水问题
如何去除有序数组的重复元素
    2指针，快指针！=慢指针，就慢指针+1，且快指针赋值给慢指针+1后的值【有序链表同理】
如何寻找最长回文子串（回文子串：对称/正反一致）
    2指针，左右指针分别加减，value[left]=[right],palindrome(s, i, i)/palindrome(s, i, i + 1)
    string palindrome(string& s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.size()
                && s[l] == s[r]) {
            // 向两边展开
            l--; r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substr(l + 1, r - l - 1);
    }
如何k个一组反转链表
如何判定括号合法性
如何寻找消失的元素
如何寻找缺失和重复的元素
如何判断回文链表
如何在无限序列中随机抽取元素
如何调度考生的座位
Union-Find算法详解
Union-Find算法应用
一行代码就能解决的算法题
二分查找高效判定子序列
```