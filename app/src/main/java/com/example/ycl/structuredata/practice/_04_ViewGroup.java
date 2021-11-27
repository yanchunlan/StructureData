package com.example.ycl.structuredata.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import android.content.Context;

/**
 * author:  ycl
 * date:  2021/11/27 11:07
 * desc:  给定一个 RootView，打印其内 View Tree 的每个 View。
 */
class _04_ViewGroup {
  public static void main(String[] args) {
    ViewGroup view = createViewGroup();

    /*
      树的遍历，可以使用递归，迭代
      其中迭代可以有深度遍历，广度遍历
     */
    dispatchView(view);
    depthDispatchView(view);
    broadDispatchView(view);
  }

  /**
   *        A
   *    B       C
   * D      E        F
   */
  private static ViewGroup createViewGroup() {
    ViewGroup view = new ViewGroup(null);
    view.setId("A");
    {
      ViewGroup vb = new ViewGroup(null);
      vb.setId("B");
      {
        View vd = new View(null);
        vd.setId("D");
        vb.addView(vd);
        View ve = new View(null);
        ve.setId("E");
        vb.addView(ve);
      }
      view.addView(vb);
    }
    {
      ViewGroup vc = new ViewGroup(null);
      vc.setId("C");
      {
        View vf = new View(null);
        vf.setId("F");
        vc.addView(vf);
      }
      view.addView(vc);
    }
    return view;
  }

  /**
   * 深度
   * ACFBED ,考虑到结果是先进后出，所以使用栈处理
   * 如果顺序不是倒序，那就直接遍历处理，需要用一个记录状态的数组判断每个数据的状态是否被遍历到
   */
  private static void depthDispatchView(View rootView) {
    Stack<View> stack = new Stack<>();
    stack.push(rootView);
    while (!stack.isEmpty()) {
      View view = stack.pop();
      if (!(view instanceof ViewGroup)) {
        System.out.println("find view id" + view.getId());
        continue;
      }
      System.out.println("find ViewGroup id" + view.getId());
      int count = ((ViewGroup) view).getChildCount();
      if (count == 0) {
        continue;
      }
      for (int i = 0; i < count; i++) {
        View childView = ((ViewGroup) view).getChildAt(i);
        stack.push(childView);
      }
    }
  }

  /**
   * 广度
   * ABCDEF ,考虑到结果是先进先出，所以使用队列处理
   */
  private static void broadDispatchView(View rootView) {
    Queue<View> queue = new LinkedList<>();
    queue.offer(rootView);
    while (!queue.isEmpty()) {
      View view = queue.poll();
      if (!(view instanceof ViewGroup)) {
        System.out.println("find view id" + view.getId());
        continue;
      }
      System.out.println("find ViewGroup id" + view.getId());
      int count = ((ViewGroup) view).getChildCount();
      if (count == 0) {
        continue;
      }
      for (int i = 0; i < count; i++) {
        View childView = ((ViewGroup) view).getChildAt(i);
        queue.offer(childView);
      }
    }

  }

  /**
   * 递归
   * ABDECF
   */
  private static void dispatchView(View view) {
    if (view == null) {
      return;
    }
    if (!(view instanceof ViewGroup)) {
      System.out.println("find view id" + view.getId());
      return;
    }
    System.out.println("find ViewGroup id" + view.getId());
    int count = ((ViewGroup) view).getChildCount();
    if (count == 0) {
      return;
    }
    for (int i = 0; i < count; i++) {
      View childView = ((ViewGroup) view).getChildAt(i);
      dispatchView(childView);
    }
  }


  static class ViewGroup extends View {
    List<View> childView = new ArrayList<>();

    public ViewGroup(Context context) {
      super(context);
    }

    public boolean addView(View v) {
      return childView.add(v);
    }

    public View getChildAt(int i) {
      return childView.get(i);
    }

    public int getChildCount() {
      return childView.size();
    }


  }

  static class View {
    Context context;
    String id;

    public View(Context context) {
      this.context = context;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }
  }

}
